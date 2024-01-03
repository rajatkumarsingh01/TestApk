package com.example.putatoeproject;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ImageView gifImageView;
    private Handler handler = new Handler();

    private ProductAdapter productAdapter;
    private List<Product> productList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int[] iconList = {
                R.drawable.mobile_recharge_icon,
                R.drawable.credit_card_icon,
                R.drawable.house_hand_mortgage_icon,
                R.drawable.newspaper_icon,
                R.drawable.blog_icon,
                R.drawable.find_jobs_on_newspaper_icon,
        };

        // Set up RecyclerView for icons
        RecyclerView recyclerView = findViewById(R.id.iconsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Set up the adapter for icons
        IconsAdapter iconsAdapter = new IconsAdapter(this, iconList);
        recyclerView.setAdapter(iconsAdapter);

        // Initialize the gifImageView
        gifImageView = findViewById(R.id.gifImageView);
        // Start fetching banners and updating gifImageView
        fetchBannersAndStartRotation();


        // Set up RecyclerView for products
        RecyclerView productsRecyclerView = findViewById(R.id.fruitsandvegetableRecyclerView);
        productsRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // Initialize the list of products


         productList = generateSampleProductList();

        // Set up the adapter for products
        productAdapter = new ProductAdapter(this, productList);
        productsRecyclerView.setAdapter(productAdapter);

    }

    private List<Product> generateSampleProductList() {
        List<Product> productList = new ArrayList<>();
        // Add your product data here
        // Example:
        productList.add(new Product(
                R.drawable.tomato,
                "Product Name",
                "Brand | Category",
                "₹999.99",
                "Out of Stock",
                4.5f,
                0 // Index of selected quantity in the spinner
        ));
        productList.add(new Product(
                R.drawable.apple,
                "Apple",
                "Orchard Delights | Fruits",
                "₹49.99",
                "In Stock",
                4.7f,
                0 // Index of selected quantity in the spinner
        ));


        // Add more products as needed...
        return productList;
    }


    private void fetchBannersAndStartRotation() {

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<BannerResponse> call = apiService.getBanners();
        call.enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                Log.d("Hello", response.toString());
                if (response.isSuccessful()) {
                    BannerResponse bannerResponse = response.body();
                    if (bannerResponse != null && bannerResponse.getStatus()) {
                        List<Banner> banners = bannerResponse.getBanners();
                        Log.d("Main",banners.toString());
                        updateGifImages(banners);
                        startBannerRotation(banners);
                    } else {
                        // Handle error from the response
                        Log.d("Hello", bannerResponse.toString());
                        handleError("Error in API response: " + bannerResponse.getError());
                    }
                }
                else {
                    // Handle error from the HTTP response
                    Log.d("Hello", response.toString());
                    handleError("HTTP error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {

                handleError("Network error: " + t.getMessage());
                // Handle failure

            }

            private void handleError(String errorMessage) {
                // Customize this method based on how you want to handle errors
                Log.e("ApiError", errorMessage);

                // You might want to display an error message to the user, log the error, or take other actions.
                // For now, you can log the error using Log.e().
            }


            private void updateGifImages(List<Banner> banners) {
                // Load the first banner image initially
                if (!banners.isEmpty()) {
                    String imageUrl = banners.get(0).getImageUrl();
                    // Use an image loading library like Glide or Picasso


                    Glide.with(MainActivity.this)
                            .load(imageUrl)
                            .into(gifImageView);
                }
            }

            private void startBannerRotation(final List<Banner> banners) {
                // Start a timer for changing the gifImageView
                handler.postDelayed(new Runnable() {
                    int currentBannerIndex = 0;

                    @Override
                    public void run() {
                        if (currentBannerIndex < banners.size() - 1) {
                            currentBannerIndex++;
                        } else {
                            currentBannerIndex = 0; // Start from the first banner if reached the end
                        }
                        // Load the next banner image
                        String nextBannerImageUrl = banners.get(currentBannerIndex).getImageUrl();
                        // Use an image loading library like Glide or Picasso
                        Glide.with(MainActivity.this)
                                .load(nextBannerImageUrl)
                                .into(gifImageView);

                        handler.postDelayed(this, 5000); // Run every 5 seconds
                    }
                }, 5000); // Start after 5 seconds
            }
});


    }
}