package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public interface ItemRequestBuilder {

    ResultActions postItem() throws Exception;
    ResultActions getItem() throws Exception;

}
