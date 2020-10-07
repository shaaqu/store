package com.example.demo;

import com.example.demo.entities.Order;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
                        .put("name", "TestName")
                        .put("surname", "TestSurname")
                        .put("nickname", "testNick")
                        .put("password", "psswd")
                        .toString();
            case ORDER:
                return new JSONObject()
                        .put("date", new Date(2020, 2, 1, 12, 21, 1))
                        .put("account", jsonFactory(JsonEnum.ACCOUNT))
                        .put("orders", jsonFactory(JsonEnum.PRODUCT))
                        .toString();
            case PRODUCT:
                return new JSONObject()
                        .put("name", "testProduct")
                        .put("price", 20.00)
                        .put("amount", 5)
                        .toString();
            default:
                throw new IllegalArgumentException("Unknown JSON type.");

        }
    }
}
