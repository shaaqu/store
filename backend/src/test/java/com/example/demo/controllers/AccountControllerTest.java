package com.example.demo.controllers;

import com.example.demo.AccountItemItemRequestBuilder;
import com.example.demo.ItemRequestBuilder;
import com.example.demo.services.AcountService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
class AccountControllerTest {

    private ItemRequestBuilder itemRequestBuilder;
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

        itemRequestBuilder = new AccountItemItemRequestBuilder();

    }

    @Test
    public void shouldReturnCreatedStatus() throws Exception {
        itemRequestBuilder.postItem().andExpect(
                status().isCreated()
        );
    }

    @Test
    public void shouldReturnOkStatusAndJSONType() throws Exception {
        itemRequestBuilder.getItem().andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON)
                );
    }



}

/**
 * Why if test class is public there is initializationError "java.lang.Exception: No runnable methods"?
 */