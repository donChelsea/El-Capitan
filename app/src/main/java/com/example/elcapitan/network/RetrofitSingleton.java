package com.example.elcapitan.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit instance;

    private RetrofitSingleton() {
    }

    public static Retrofit getInstance(String baseUrl) {
        if (instance == null) {
           instance = new Retrofit.Builder()
                   .baseUrl(baseUrl)
                   .addConverterFactory(GsonConverterFactory.create())
                   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                   .build();
        }
        return instance;
    }
}
