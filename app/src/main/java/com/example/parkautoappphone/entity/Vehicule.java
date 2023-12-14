package com.example.parkautoappphone.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//@Data
//@RequiredArgsConstructor
public class Vehicule {

    private long id;
    private String modelvehicule;
    private int anneeModel;
    private double prix;
    private String imageVehicule;
    private String descriptif;

    public Vehicule() {
    }

    public Vehicule(long id, String modelvehicule, int anneeModel, double prix, String imageVehicule, String descriptif) {
        this.id = id;
        this.modelvehicule = modelvehicule;
        this.anneeModel = anneeModel;
        this.prix = prix;
        this.imageVehicule = imageVehicule;
        this.descriptif = descriptif;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelvehicule() {
        return modelvehicule;
    }

    public void setModelvehicule(String modelvehicule) {
        this.modelvehicule = modelvehicule;
    }

    public int getAnneeModel() {
        return anneeModel;
    }

    public void setAnneeModel(int anneeModel) {
        this.anneeModel = anneeModel;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImageVehicule() {
        return imageVehicule;
    }

    public void setImageVehicule(String imageVehicule) {
        this.imageVehicule = imageVehicule;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
}
