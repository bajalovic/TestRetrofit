package com.esseworks.testretrofit;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PATCH;
import retrofit.http.PUT;

/**
 * Created by ivan on 2.2.15..
 */
public interface TestService {

    @GET("/welcome/index")
    void listWelcome(Callback<TestResponse> cb);

    @PATCH("/welcome/update.json")
    void updateWelcome(@Body TestRequest request, Callback<TestResponse> cb);

    @PUT("/welcome/update2.json")
    void updateWelcome2(@Body TestRequest request, Callback<TestResponse> cb);
}
