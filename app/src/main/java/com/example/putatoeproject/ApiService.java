package com.example.putatoeproject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/v1/api/banners")
    Call<BannerResponse> getBanners(); // Change BannerResponse to your actual response model class
}

