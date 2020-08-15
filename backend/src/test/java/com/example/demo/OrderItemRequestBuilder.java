package com.example.demo;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

public class OrderItemRequestBuilder implements ItemRequestBuilder {
    @Override
    public ResultActions postItem() throws Exception {
        return null;
    }

    @Override
    public ResultActions getItem() throws Exception {
        return null;
    }
}
