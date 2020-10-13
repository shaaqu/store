package com.example.demo.controllers;

import com.example.demo.ItemRequestBuilder;
import com.example.demo.ItemRequestBuilderFactory;
import com.example.demo.services.AccountService;
import com.example.demo.services.OrderService;
import com.example.demo.services.ProductService;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.example.demo.ItemRequestBuilderFactory.Items.*;
import static com.example.demo.WebTestConfig.exceptionResolver;
import static com.example.demo.WebTestConfig.fixedLocaleResolver;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class OrderControllerTest {

    private ItemRequestBuilder itemRequestBuilder;
    private OrderService service;
    private ItemRequestBuilderFactory itemRequestBuilderFactory;
    private AccountService accountService;

    @BeforeEach
    void configureSystemUnderTest() throws JSONException {
        service = mock(OrderService.class);
        OrderController orderController = new OrderController(service);
        MockMvc mockMvc = MockMvcBuilders
                .standaloneSetup(orderController)
                .setHandlerExceptionResolvers(exceptionResolver())
                .setLocaleResolver(fixedLocaleResolver())
                .build();
        itemRequestBuilderFactory = new ItemRequestBuilderFactory(mockMvc);
        itemRequestBuilder = itemRequestBuilderFactory.createRequestBuilder(ORDER_ITEM);

    }

    void postAccount() throws Exception {
        accountService = mock(AccountService.class);
        AccountController accountController = new AccountController(accountService);
    }

    @Test
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