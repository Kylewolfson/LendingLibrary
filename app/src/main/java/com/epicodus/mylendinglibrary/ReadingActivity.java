package com.epicodus.mylendinglibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ReadingActivity extends AppCompatActivity {
    public static final String TAG = ReadingActivity.class.getSimpleName();

    @Bind(R.id.restaurantList) ListView mRestaurantListView;

    public ArrayList<Restaurant> mRestaurants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        getRestaurants("97212");
    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService();

        yelpService.findRestaurants(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mRestaurants = yelpService.processResults(response);

                ReadingActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String[] restaurantNames = new String[mRestaurants.size()];
                        for (int i = 0; i < restaurantNames.length; i++) {
                            restaurantNames[i] = mRestaurants.get(i).getName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(ReadingActivity.this,
                                android.R.layout.simple_list_item_1, restaurantNames);
                        mRestaurantListView.setAdapter(adapter);

                        for (Restaurant restaurant : mRestaurants) {
                            Log.d(TAG, "Name: " + restaurant.getName());
                            Log.d(TAG, "Phone: " + restaurant.getPhone());
                            Log.d(TAG, "Website: " + restaurant.getWebsite());
                            Log.d(TAG, "Image url: " + restaurant.getImageUrl());
                            Log.d(TAG, "Rating: " + Double.toString(restaurant.getRating()));
                            Log.d(TAG, "Address: " + android.text.TextUtils.join(", ", restaurant.getAddress()));
                            Log.d(TAG, "Categories: " + restaurant.getCategories().toString());
                        }
                    }
                });
            }
        });
    }
}