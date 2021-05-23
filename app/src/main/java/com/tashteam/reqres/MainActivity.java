package com.tashteam.reqres;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.tashteam.reqres.adapter.ProductAdapter;
import com.tashteam.reqres.model.ProductModel;
import com.tashteam.reqres.viewmodel.ProductViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProductAdapter productAdapter;
    private ProductViewModel productViewModel;
    private List<ProductModel> productModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productAdapter = new ProductAdapter(this, productModelList);

        RecyclerView recyclerView = findViewById(R.id.productRecylerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productAdapter);

        productViewModel= ViewModelProviders.of(this).get(ProductViewModel.class);

        productViewModel.getProductListObserver().observe(this, new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> productModels) {
                    if(productModels!=null){
                        productModelList=productModels;
                        productAdapter.setProductModelList(productModels);
                    }
            }
        });
        productViewModel.makeApiCall();

    }
}