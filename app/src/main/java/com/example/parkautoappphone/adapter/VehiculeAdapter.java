package com.example.parkautoappphone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkautoappphone.R;
import com.example.parkautoappphone.entity.Vehicule;

import java.util.List;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeHolder> {

    private List<Vehicule> vehiculeList;

    public VehiculeAdapter(List<Vehicule> vehiculeList) {
        this.vehiculeList = vehiculeList;
    }

    public VehiculeAdapter() {
    }

    @NonNull
    @Override
    public VehiculeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_vehicules_item, parent, false);
        return new VehiculeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculeHolder holder, int position) {
        Vehicule vehicule = vehiculeList.get(position);
        holder.modelVehicule.setText(vehicule.getModelvehicule());
        holder.anneeModel.setText(Integer.toString(vehicule.getAnneeModel()));
        holder.descriptif.setText(vehicule.getDescriptif());
        holder.prix.setText(String.format(Double.toString(vehicule.getPrix())));
        holder.imageVehicule.setText(vehicule.getImageVehicule());
    }

    @Override
    public int getItemCount() {
        return vehiculeList.size();
    }
}
