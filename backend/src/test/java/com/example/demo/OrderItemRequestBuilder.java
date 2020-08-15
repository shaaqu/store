package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

public class OrderItemRequestBuilder implements ItemRequestBuilder {

    private MockMvc mockMvc;

    public OrderItemRequestBuilder(MockMvc mockMvc) {
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
