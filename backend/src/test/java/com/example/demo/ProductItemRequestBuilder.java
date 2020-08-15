package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

public class ProductItemRequestBuilder implements ItemRequestBuilder {

    private MockMvc mockMvc;
    public ProductItemRequestBuilder(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Override
    public ResultActions postItem() throws Exception {
        return null;
    }

    @Override
    public ResultActions getItem() throws Exception {
        return null;
    }
}
