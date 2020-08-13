package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private String jsonAccount;

    public AccountItemRequestBuilder(MockMvc mockMvc) throws JSONException {
        this.mockMvc = mockMvc;
        this.jsonAccount = new JSONObject()
                .put("email", "mail@test.com")
                .put("name", "Test")
                .put("password", "psswd")
                .toString();
    }

    public ResultActions createAccountTest() throws Exception {
        return mockMvc.perform(post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonAccount)
                .accept(MediaType.APPLICATION_JSON));
    }

    public ResultActions listAllTest() throws Exception {
        return mockMvc.perform(get("/account"));
    }

    
}
