package com.example.parkautoappphone.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkautoappphone.R;

public class VehiculeHolder extends RecyclerView.ViewHolder {
    TextView modelVehicule, anneeModel, descriptif, prix, imageVehicule;
    public VehiculeHolder(@NonNull View itemView) {
        super(itemView);
        modelVehicule =  itemView.findViewById(R.id.vehiculeList_modelVehicule);
        anneeModel = itemView.findViewById(R.id.vehiculeList_anneeModel);
        descriptif = itemView.findViewById(R.id.vehiculeList_descriptif);
        prix = itemView.findViewById(R.id.vehiculeList_prix);
        imageVehicule = itemView.findViewById(R.id.vehiculeList_imageVehicule);

    }


}
