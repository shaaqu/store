package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountServiceIf;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AccountControllerTest {

//    @MockBean
//    AccountServiceIf accountServiceIf;
//
//    ObjectMapper mapper = new ObjectMapper();
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @Test
//    public void shouldReturnCreatedAccount() throws Exception{
//
//        Account account = new Account("test@email.com", "Tester Test", "test123");
//
//        when(accountServiceIf.saveNewAccount(account));
//
//        mockMvc.
//
//    }

}