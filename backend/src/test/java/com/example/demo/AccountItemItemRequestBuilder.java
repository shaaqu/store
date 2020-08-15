package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.demo.JsonFactory.JsonEnum.*;
import static com.example.demo.JsonFactory.jsonFactory;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class AccountItemItemRequestBuilder implements ItemRequestBuilder {

    private MockMvc mockMvc;


    public AccountItemItemRequestBuilder(MockMvc mockMvc) throws JSONException {
        this.mockMvc = mockMvc;
    }

    public ResultActions postItem() throws Exception {
        return mockMvc.perform(post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonFactory(ACCOUNT))
                .accept(MediaType.APPLICATION_JSON));
    }

    public ResultActions getItem() throws Exception {
        return mockMvc.perform(get("/account"));
    }

    
}
