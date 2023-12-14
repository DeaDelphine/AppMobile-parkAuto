package com.example.parkautoappphone.repository;

import com.example.parkautoappphone.entity.Vehicule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface VehiculeRepository {

    @GET("/vehicules")
    Call<List <Vehicule>> getAllVehicules();
    @POST("/vehicule")
    Call<Vehicule> createVehicule(@Body Vehicule vehicule);

    @GET("/vehicules/{idVehicule}")
    Call<Vehicule> getVehiculebyId(@Body Vehicule vehicule);
}
