package com.example.demo.controllers;

import com.example.demo.AccountItemRequestBuilder;
import com.example.demo.services.AccountService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
class AccountControllerTest {

    private AccountItemRequestBuilder requestBuilder;
    private AccountService service;

    @BeforeEach
    void configureSystemUnderTest() throws JSONException {
        service = mock(AccountService.class);
        AccountController accountController = new AccountController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();

        requestBuilder = new AccountItemRequestBuilder(mockMvc);
    }

    @Test
    public void createTest() throws Exception {
        requestBuilder.createAccountTest().andExpect(status().isCreated());
    }

    @Test
    public void listAllTest() throws Exception {
        requestBuilder.listAllTest().andExpect(status().isOk());
    }

}

/**
 * Why if test class is public there is initializationError "java.lang.Exception: No runnable methods"?
 */