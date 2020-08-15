package com.example.demo;

import org.json.JSONException;
import org.springframework.test.web.servlet.MockMvc;

public class ItemRequestBuilderFactory {

    private MockMvc mockMvc;

    public enum Items{
        ACCOUNT_ITEM,
        ORDER_ITEM,
        PRODUCT_ITEM;
    }

    public ItemRequestBuilderFactory(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    public ItemRequestBuilder createRequestBuilder(Items item) throws JSONException {
        switch (item){
            case ACCOUNT_ITEM:
                return new AccountItemItemRequestBuilder(mockMvc);
            case ORDER_ITEM:
                return new OrderItemRequestBuilder(mockMvc);
            case PRODUCT_ITEM:
                return new ProductItemRequestBuilder(mockMvc);
            default:
                throw new IllegalArgumentException("Unknown Request Builder");
        }
    }
}
