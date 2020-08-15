package com.example.demo;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

public interface RequestBuilder {

    ResultActions post();
    ResultActions get();

}
