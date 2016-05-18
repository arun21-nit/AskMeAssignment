package com.askme.arun.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("bins/3l6fq")
    Call<PriceList> getJSON();
}
