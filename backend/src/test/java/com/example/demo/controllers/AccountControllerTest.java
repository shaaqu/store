package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountServiceIf;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

    @MockBean
    AccountServiceIf accountServiceIf;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturnCreatedAccount() throws Exception{

        String email = "test@email.com";
        String name = "Tester Test";
        String password = "test123";
        Account account = new Account();
        account.setEmail(email);
        account.setName(name);
        account.setPassword(password);

        when(accountServiceIf.saveNewAccount(any(Account.class))).thenReturn(account);

        mockMvc.perform(post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(account))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value(email))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.password").value(password));
        
        

    }

}

/**
 * Why if test class is public there is initializationError "java.lang.Exception: No runnable methods"?
 */