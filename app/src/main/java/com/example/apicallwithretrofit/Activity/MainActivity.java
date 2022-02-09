package com.example.apicallwithretrofit.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.apicallwithretrofit.ApiService.ApiService;
import com.example.apicallwithretrofit.ApiService.AppConfig;
import com.example.apicallwithretrofit.Model.Getposts;
import com.example.apicallwithretrofit.R;
import com.example.apicallwithretrofit.Utils.CheckNetwork;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private CheckNetwork checkNetwork;
    private boolean temp = false;
    private ArrayList<Getposts> getposts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = AppConfig.getRetrofit().create(ApiService.class);

        getallPosts();

    }

    public void getallPosts(){

        if (checkNetwork.isNetworkConnected(this)){
            apiService.getPosts().enqueue(new Callback<ArrayList<Getposts>>() {
                @Override
                public void onResponse(@NonNull Call<ArrayList<Getposts>> call, @NonNull Response<ArrayList<Getposts>> response) {

                    getposts = response.body();

                    for (int i=0;i<getposts.size();i++){
                        System.out.println(getposts.get(i).getTitle());
                    }

                }

                @Override
                public void onFailure(@NonNull Call<ArrayList<Getposts>> call, @NonNull Throwable t) {
                    Log.e("Retrofit Api Call ", "onFailure: ", t);
                    call.cancel();
                }
            });
        }else {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_SHORT).show();
        }

    }


}