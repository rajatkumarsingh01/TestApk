package com.example.putatoeproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {




        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
        // Initialize the list of products


    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        // Set product details to views
        holder.productImageView.setImageResource(product.getImageResId());
        holder.productNameTextView.setText(product.getName());
        holder.brandCategoryTextView.setText(product.getBrandCategory());
        holder.priceTextView.setText(product.getPrice());
        holder.stockStatusTextView.setText(product.getStockStatus());
        holder.ratingBar.setRating(product.getRating());
        holder.quantitySpinner.setSelection(product.getSelectedQuantityIndex());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImageView;
        TextView productNameTextView;
        TextView brandCategoryTextView;
        TextView priceTextView;
        TextView stockStatusTextView;
        ImageButton shareButton;
        RatingBar ratingBar;
        Spinner quantitySpinner;
        Button addToCartButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            productImageView = itemView.findViewById(R.id.productImageView);
            productNameTextView = itemView.findViewById(R.id.productNameTextView);
            brandCategoryTextView = itemView.findViewById(R.id.brandCategoryTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            stockStatusTextView = itemView.findViewById(R.id.stockStatusTextView);
            shareButton = itemView.findViewById(R.id.shareButton);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            quantitySpinner = itemView.findViewById(R.id.quantitySpinner);
            addToCartButton = itemView.findViewById(R.id.addToCartButton);
        }
    }
}
