package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonFactory{
    public enum JsonEnum {
        ACCOUNT,
        PRODUCT,
        ORDER;
    }

    public static String jsonFactory(JsonEnum aJsonEnum) throws JSONException {
        switch (aJsonEnum){
            case ACCOUNT:
                return new JSONObject()
                        .put("email", "mail@test.com")
                        .put("name", "Test")
                        .put("password", "psswd")
                        .toString();
            case ORDER:
                return new JSONObject()
                        .put("account", jsonFactory(JsonEnum.ACCOUNT))
                        .put("productId", 1)
                        .put("productQuantity", 1)
                        .toString();
            case PRODUCT:
                return new JSONObject()
                        .put("name", "test")
                        .put("price", 20.00)
                        .put("quantity", 5)
                        .toString();
            default:
                throw new IllegalArgumentException("Unknown JSON type.");

        }
    }
}
