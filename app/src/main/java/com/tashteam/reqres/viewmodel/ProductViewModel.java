package com.tashteam.reqres.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tashteam.reqres.model.ProductModel;
import com.tashteam.reqres.network.APIService;
import com.tashteam.reqres.network.RetroIntance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<List<ProductModel>> productList;

    public ProductViewModel(){
        productList= new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductModel>> getProductListObserver() {

        return productList;
    }

    public void makeApiCall(){
        APIService apiService= RetroIntance.getRetrofitClient().create(APIService.class);
        Call<List<ProductModel>> call = apiService.getProductList();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                productList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                productList.postValue(null);

            }
        });
    }
}
