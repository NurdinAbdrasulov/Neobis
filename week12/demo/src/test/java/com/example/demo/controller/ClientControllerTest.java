package com.example.demo.controller;

import com.example.demo.entity.enums.Gender;
import com.example.demo.entity.enums.Position;
import com.example.demo.model.ClientModel;
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

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails("admin")
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public ClientControllerTest(){
        mapper = new ObjectMapper();
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform(get("/clients/getAll"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById() throws Exception{
        mockMvc.perform(get("/clients/get/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        ClientModel model = new ClientModel(1,"updatedTestFio", Gender.MALE, "updatedTestAddress",new Date(123456789), "123456789",null);
        String jsonRequest = mapper.writeValueAsString(model);

        mockMvc.perform(post("/clients/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTest() throws Exception{

        mockMvc.perform(delete("/clients/delete/{id}", 2))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
