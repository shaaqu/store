package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static com.example.demo.JsonFactory.JsonEnum.ACCOUNT;
import static com.example.demo.JsonFactory.JsonEnum.PRODUCT;
import static com.example.demo.JsonFactory.jsonFactory;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class ProductItemRequestBuilder implements ItemRequestBuilder {

    private MockMvc mockMvc;
    public ProductItemRequestBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public ResultActions postItem() throws Exception {
        return mockMvc.perform(post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonFactory(PRODUCT))
                .accept(MediaType.APPLICATION_JSON));
    }

    public ResultActions getItem() throws Exception {
        return mockMvc.perform(get("/product"));
    }
}
