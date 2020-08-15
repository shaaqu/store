package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public interface ItemRequestBuilder {

    void setMockMvc();
    ResultActions postItem() throws Exception;
    ResultActions getItem() throws Exception;

}
