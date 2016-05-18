package com.askme.arun.myapplication.controler;

import com.askme.arun.myapplication.model.PriceList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("bins/3l6fq")
    Call<PriceList> getJSON();
}
