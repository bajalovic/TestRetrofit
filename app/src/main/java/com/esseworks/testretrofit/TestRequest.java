package com.esseworks.testretrofit;

import java.util.HashMap;

/**
 * Created by ivan on 2.2.15..
 */
public class TestRequest {
    HashMap<String, String> params;

    public TestRequest setParam(String key, String value) {
        if(params == null) {
            params = new HashMap<>();
        }
        params.put(key, value);

        return this;
    }
}
