package com.example.apicallwithretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.apicallwithretrofit.ApiService.ApiService;
import com.example.apicallwithretrofit.ApiService.AppConfig;
import com.example.apicallwithretrofit.R;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = AppConfig.getRetrofit().create(ApiService.class);

        getallPosts();

    }

    public void getallPosts(){



    }


}