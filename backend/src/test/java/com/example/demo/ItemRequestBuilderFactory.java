package com.example.demo;

import org.json.JSONException;

public class ItemRequestBuilderFactory {
    public enum Items{
        ACCOUNT_ITEM,
        ORDER_ITEM,
        PRODUCT_ITEM;
    }

    public static ItemRequestBuilder createRequestBuilder(Items item) throws JSONException {
        switch (item){
            case ACCOUNT_ITEM:
                return new AccountItemItemRequestBuilder();
            case ORDER_ITEM:
                return new OrderItemRequestBuilder();
            case PRODUCT_ITEM:
                return new ProductItemRequestBuilder();
            default:
                throw new IllegalArgumentException("Unknown Request Builder");
        }
    }
}
