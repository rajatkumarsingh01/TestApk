package com.example.putatoeproject;

import com.google.gson.annotations.SerializedName;

public class Banner {
    @SerializedName("banner id")
    private int bannerId;

    @SerializedName("decription")
    private String description;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("is banner")
    private boolean isBanner;

    @SerializedName("is_mainpage")
    private boolean isMainPage;

    @SerializedName("service id")
    private int serviceId;

    @SerializedName("sub service id")
    private Integer subServiceId;

    public String getImageUrl() {

        return imageUrl;
    }

    // Add getters and setters as needed
}
