package com.example.apicallwithretrofit.ApiService;

import com.example.apicallwithretrofit.Model.Getposts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET("todos")
    Call<Getposts> getallPosts();
}
