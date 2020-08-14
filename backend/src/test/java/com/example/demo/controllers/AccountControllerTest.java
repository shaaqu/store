package com.example.demo.controllers;

import com.example.demo.AccountItemRequestBuilder;
import com.example.demo.services.AcountService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
class AccountControllerTest {

    private AccountItemRequestBuilder requestBuilder;
    private AcountService service;

    @BeforeEach
    void configureSystemUnderTest() throws JSONException {
        service = mock(AcountService.class);
        AccountController accountController = new AccountController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();

        requestBuilder = new AccountItemRequestBuilder(mockMvc);
    }

    @Test
    public void shouldReturnCreatedStatus() throws Exception {
        requestBuilder.postAccount().andExpect(
                status().isCreated()
        );
    }

    @Test
    public void httpGetTest() throws Exception {
        requestBuilder.getAccount().andExpect(status().isOk())
                .andExpect(
                        content().json()
                );
    }

}

/**
 * Why if test class is public there is initializationError "java.lang.Exception: No runnable methods"?
 */