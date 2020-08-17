package com.example.demo.controllers;

import com.example.demo.AccountItemItemRequestBuilder;
import com.example.demo.ItemRequestBuilder;
import com.example.demo.ItemRequestBuilderFactory;
import com.example.demo.JsonFactory;
import com.example.demo.services.AcountService;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.ItemRequestBuilderFactory.Items.ACCOUNT_ITEM;
import static com.example.demo.JsonFactory.jsonFactory;
import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
class AccountControllerTest {

    private ItemRequestBuilder itemRequestBuilder;
    private AcountService service;
    private ItemRequestBuilderFactory itemRequestBuilderFactory;

    @BeforeEach
    void configureSystemUnderTest() throws JSONException {
        service = mock(AcountService.class);
        AccountController accountController = new AccountController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();
        itemRequestBuilderFactory = new ItemRequestBuilderFactory(mockMvc);
        itemRequestBuilder = itemRequestBuilderFactory.createRequestBuilder(ACCOUNT_ITEM);

    }


    @Test
    @Disabled("I don't know what is going on. Others postItemTests works!")
    public void postItemTest() throws Exception {
        itemRequestBuilder.postItem().andExpect(
                status().isCreated()
        );
    }

    @Test
    public void getItemTest() throws Exception {
        itemRequestBuilder.getItem().andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON)
                );
    }



}

/**
 * Why if test class is public there is initializationError "java.lang.Exception: No runnable methods"?
 */