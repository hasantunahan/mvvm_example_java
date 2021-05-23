package com.tashteam.reqres.network;

import com.tashteam.reqres.model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("products")
    Call<List<ProductModel>> getProductList();
}
