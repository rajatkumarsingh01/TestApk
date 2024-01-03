package com.example.putatoeproject;

import java.util.List;

public class Product {
    private int imageResId;
    private String name;
    private String brandCategory;
    private String price;
    private String stockStatus;
    private float rating;
    private List<String> quantityOptions;
    private int selectedQuantityIndex;

    public Product(int imageResId, String name, String brandCategory, String price, String stockStatus, float rating, int selectedQuantityIndex) {
        this.imageResId = imageResId;
        this.name = name;
        this.brandCategory = brandCategory;
        this.price = price;
        this.stockStatus = stockStatus;
        this.rating = rating;
        this.quantityOptions = quantityOptions;
        this.selectedQuantityIndex = selectedQuantityIndex;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getName() {
        return name;
    }

    public String getBrandCategory() {
        return brandCategory;
    }

    public String getPrice() {
        return price;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public float getRating() {
        return rating;
    }

    public List<String> getQuantityOptions() {
        return quantityOptions;
    }

    public int getSelectedQuantityIndex() {
        return selectedQuantityIndex;
    }
}
