package com.example.parkautoappphone.retrofit;

import com.example.parkautoappphone.repository.UserRepository;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitLogin {

    private static Retrofit getretrofit(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.224:8085")
                .client(okHttpClient)
                .build();
        return retrofit;
    }


    public static UserRepository getUserRepository() {
        UserRepository userRepository = getretrofit().create(UserRepository.class);
        return userRepository;
    }
}
