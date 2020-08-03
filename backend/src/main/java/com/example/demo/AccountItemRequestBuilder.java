package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;

public class AccountItemRequestBuilder {


    /**
     * Klaska ma miec metody do wysylania zadan, zeby wywaolywac tylko metody, a nie pisac to samo pare razy przy rozbudowanych testach.
     */
    private MockMvc mockMvc;

    public AccountItemRequestBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    
}
