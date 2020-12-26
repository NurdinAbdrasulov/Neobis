package com.example.demo.controller;

import com.example.demo.model.CarBrandModel;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("admin")
public class CarBrandsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;


    public CarBrandsControllerTest(){
        mapper = new ObjectMapper();
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform( get("/carBrand/getAll"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("/carBrand/get/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        CarBrandModel carBrandModel = new CarBrandModel(100, "brandTest");

        String jsonRequest = mapper.writeValueAsString(carBrandModel);

        mockMvc.perform( post("/carBrand/add")//.param("brand" ,"TestBrand"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception{
        CarBrandModel carBrandModel = new CarBrandModel(100, "updatedBrandTest");
        String jsonRequest = mapper.writeValueAsString((carBrandModel));

        mockMvc.perform(put("/carBrand/update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
