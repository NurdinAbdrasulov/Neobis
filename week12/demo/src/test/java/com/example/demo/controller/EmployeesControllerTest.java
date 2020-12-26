package com.example.demo.controller;


import com.example.demo.entity.enums.Gender;
import com.example.demo.entity.enums.Position;
import com.example.demo.model.EmployeeModel;
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
public class EmployeesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper;

    public EmployeesControllerTest(){
        mapper = new ObjectMapper();
    }

    @Test
    public void getAll() throws Exception{
        mockMvc.perform(get("/employees/getAll"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getById()throws Exception{
        mockMvc.perform(get("/employees/get/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void add() throws Exception{
        EmployeeModel model = new EmployeeModel(1,"TestFio", Position.CEO, Gender.MALE, "TestAddress", "123456789", "testLogin","testPassword");
        String jsonRequest = mapper.writeValueAsString(model);

        mockMvc.perform(post("/employees/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void update() throws Exception{
        EmployeeModel model = new EmployeeModel(1,"updatedTestFio", Position.CEO, Gender.MALE, "updatedTestAddress", "123456789", "updated" +
                "testLogin","testPassword");
        String jsonRequest = mapper.writeValueAsString(model);

        mockMvc.perform(put("/employees/update/{id}", 5)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void deleteTest() throws Exception{
        mockMvc.perform(delete("/employees/delete/{id}", 5))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
