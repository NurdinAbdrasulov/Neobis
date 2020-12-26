package com.example.demo.controller;

import com.example.demo.entity.CarBrands;
import com.example.demo.entity.enums.BodyStyle;
import com.example.demo.model.CarModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("admin")
public class CarsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public CarsControllerTest(){
        mapper = new ObjectMapper();
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform( get("/cars/getAll"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform( get("/cars/get/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addNewCar() throws Exception{
        CarModel carModel = new CarModel(1, new CarBrands(2, "brand2"), null, BodyStyle.SEDAN, null, "red",null, 122.15 );
        String jsonRequest = mapper.writeValueAsString(carModel);

        mockMvc.perform( post("/cars/add")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteById() throws Exception{
        MvcResult mvcResult = mockMvc.perform(delete("/cars/delete/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
