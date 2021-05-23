package com.tashteam.reqres.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroIntance {

    public static String baseURL = "https://fakestoreapi.com/";

    private static Retrofit retrofit;
    public static Retrofit getRetrofitClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

}


