package com.tashteam.reqres.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tashteam.reqres.R;
import com.tashteam.reqres.model.ProductModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private List<ProductModel> productModelList;

    public ProductAdapter(Context context, List<ProductModel> productModelList) {
        this.context = context;
        this.productModelList = productModelList;
    }

    public void setProductModelList( List<ProductModel> productModelList) {
        this.productModelList = productModelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        holder.titleTextView.setText(this.productModelList.get(position).getTitle().toString());
        holder.categoryTextView.setText(this.productModelList.get(position).getCategory().toString());
        holder.descriptionTextView.setText(this.productModelList.get(position).getDescription().toString());
        Glide.with(context)
                .load(this.productModelList.get(position).getImage().toString())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        if (this.productModelList != null) {
            return productModelList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView categoryTextView;
        TextView descriptionTextView;
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            productImage = itemView.findViewById(R.id.imageViewProduct);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
