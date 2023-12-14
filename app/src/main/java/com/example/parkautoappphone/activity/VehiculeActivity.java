package com.example.parkautoappphone.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parkautoappphone.R;
import com.example.parkautoappphone.adapter.VehiculeAdapter;
import com.example.parkautoappphone.entity.Vehicule;
import com.example.parkautoappphone.repository.VehiculeRepository;
import com.example.parkautoappphone.retrofit.RetrofitVehicule;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VehiculeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_list);

        recyclerView = findViewById(R.id.vehiculeList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadVehicules();
    }

    private void loadVehicules() {
        Vehicule vehicule = new Vehicule();
        //Injection des données à partir du retrofit
        RetrofitVehicule retrofitVehicule = new RetrofitVehicule();
        VehiculeRepository vehiculeRepository = retrofitVehicule.getRetrofit().create(VehiculeRepository.class);
        vehiculeRepository.getAllVehicules()
                .enqueue(new Callback<List<Vehicule>>() {
            @Override
            public void onResponse(Call<List<Vehicule>> call, Response<List<Vehicule>> response) {
                populateListView(response.body());
            }

            @Override
            public void onFailure(Call<List<Vehicule>> call, Throwable t) {
                Toast.makeText(VehiculeActivity.this, "Failed to load Vehicule!!! ", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private void populateListView(List<Vehicule> vehiculeList) {
        VehiculeAdapter vehiculeAdapter = new VehiculeAdapter(vehiculeList);
        recyclerView.setAdapter(vehiculeAdapter);
    }
}