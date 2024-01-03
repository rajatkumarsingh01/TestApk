package com.example.putatoeproject;

import java.util.List;

public class BannerResponse {
    private boolean status;
    private String error; // New field for error messages
    private List<Banner> banners;
    // Constructor, getter and setter methods

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }
}
