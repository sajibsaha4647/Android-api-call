package com.example.apicallwithretrofit.ApiService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppConfig {

    static String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static Retrofit  getRetrofit() {

        OkHttpClient.Builder httpClient  = new OkHttpClient.Builder()
                .callTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(20,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());


        builder.client(httpClient.build());
        Retrofit retrofit = builder.build();
        return retrofit;


    }

}
