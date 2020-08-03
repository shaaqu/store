package com.example.demo.controllers;

import com.example.demo.AccountItemRequestBuilder;
import com.example.demo.services.AccountServiceIf;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.mockito.Mockito.mock;

@RunWith(SpringJUnit4ClassRunner.class)
class AccountControllerTest {

    private AccountItemRequestBuilder requestBuilder;
    private AccountServiceIf service;

    @BeforeEach
    void configureSystemUnderTest(){
        service = mock(AccountServiceIf.class);
        AccountController accountController = new AccountController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();

        requestBuilder = new AccountItemRequestBuilder(mockMvc);
    }

    @Test
    void createTest(){

        requestBuilder.perform()
    }

}

/**
 * Why if test class is public there is initializationError "java.lang.Exception: No runnable methods"?
 */