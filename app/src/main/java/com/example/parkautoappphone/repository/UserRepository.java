package com.example.parkautoappphone.repository;

import com.example.parkautoappphone.entity.LoginResponse;
import com.example.parkautoappphone.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserRepository {
    @POST("/api/auth/signin")
    Call<LoginResponse> userLogin(@Body User user);

    @POST("/api/auth/signup")
    Call<LoginResponse> userRegister(@Body User user);
}
