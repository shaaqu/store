package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AccountItemRequestBuilder {


    /**
     * Klaska ma miec metody do wysylania zadan, zeby wywaolywac tylko metody, a nie pisac to samo pare razy przy rozbudowanych testach.
     */
    private MockMvc mockMvc;

    public AccountItemRequestBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public ResultActions createAccountTest() throws Exception {
        return mockMvc.perform(post("/account")/*.param("email", "test@mail.com").param("name", "test name").param("password", "psswd")*/);
    }

    public ResultActions listAllTest() throws Exception {
        return mockMvc.perform(get("/account"));
    }

    
}
