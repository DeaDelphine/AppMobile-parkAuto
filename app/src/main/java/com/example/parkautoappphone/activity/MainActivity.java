package com.example.parkautoappphone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.parkautoappphone.R;
import com.example.parkautoappphone.entity.Vehicule;
import com.example.parkautoappphone.repository.VehiculeRepository;
import com.example.parkautoappphone.retrofit.RetrofitVehicule;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponent();
    }

    private void initializeComponent() {

        TextInputEditText inputEditTextModelVehicule = findViewById(R.id.form_textFieldModelVehicule);
        TextInputEditText inputEditTextAnneeModel = findViewById(R.id.form_textFieldAnneeModel);
        TextInputEditText inputEditTextDescription = findViewById(R.id.form_textFieldDescription);
        TextInputEditText inputEditTextPrix =  findViewById(R.id.form_textFieldPrix);
        TextInputEditText inputEditTextImage = findViewById(R.id.form_textFieldImage);

        //Injection des données à partir du retrofit
        RetrofitVehicule retrofitVehicule = new RetrofitVehicule();
        VehiculeRepository vehiculeRepository = retrofitVehicule.getRetrofit().create(VehiculeRepository.class);

        MaterialButton buttonSave = findViewById(R.id.form_button_save_vehicules);
        buttonSave.setOnClickListener(
                view -> {
                    String modelVehicule = String.valueOf(inputEditTextModelVehicule.getText());
                    int anneeModel = Integer.parseInt(inputEditTextAnneeModel.getText().toString());
                    String description = String.valueOf(inputEditTextDescription.getText());
                    double prix = Double.parseDouble(inputEditTextPrix.getText().toString());
                    String image = String.valueOf(inputEditTextImage.getText());

                    Vehicule vehicule = new Vehicule();
                    vehicule.setModelvehicule(modelVehicule);
                    vehicule.setAnneeModel(anneeModel);
                    vehicule.setDescriptif(description);
                    vehicule.setPrix(prix);
                    vehicule.setImageVehicule(image);

                    vehiculeRepository.createVehicule(vehicule)
                            .enqueue(
                                    new Callback<Vehicule>() {
                                        @Override
                                        public void onResponse(Call<Vehicule> call, Response<Vehicule> response) {
                                            Toast.makeText(MainActivity.this, "Save succed !! ", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onFailure(Call<Vehicule> call, Throwable t) {
                                            Toast.makeText(MainActivity.this, "Save failed !!! ", Toast.LENGTH_SHORT).show();
                                            Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "Error occured", t);

                                        }
                                    }
                            );

                }
        );
    }
}