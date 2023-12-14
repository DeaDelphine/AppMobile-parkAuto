package com.example.parkautoappphone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.parkautoappphone.R;
import com.example.parkautoappphone.entity.LoginResponse;
import com.example.parkautoappphone.entity.User;
import com.example.parkautoappphone.retrofit.RetrofitLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText etlastname, etfirstname, etemail, etpassword;
    Button etbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Register credentials to connect
        etlastname = findViewById(R.id.etlastname);
        etfirstname = findViewById(R.id.etfirstname);
        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        etbutton = findViewById(R.id.etbutton);

        // User registered
        etbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(etlastname.getText().toString()) ||
                        TextUtils.isEmpty(etfirstname.getText().toString()) ||
                        TextUtils.isEmpty(etemail.getText().toString()) ||
                        TextUtils.isEmpty(etpassword.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Please enter your information !", Toast.LENGTH_LONG)
                            .show();
                }else{
                    //Proceed to register
                    register();
                }
            }
        });

    }

    private void register() {
        User user = new User();
        user.setLastName(etlastname.getText().toString());
        user.setFirstName(etfirstname.getText().toString());
        user.setEmail(etemail.getText().toString());
        user.setPassword(etpassword.getText().toString());

        Call<LoginResponse> registerResponseCall = RetrofitLogin.getUserRepository().userRegister(user);
        registerResponseCall.enqueue(
                new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Register successful !", Toast.LENGTH_LONG)
                                    .show();
                            //Redirect to Login Activity
                            LoginResponse loginResponse = response.body();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class)
                                            .putExtra("data", loginResponse.getFirstName()));
                                }
                            },700000000);
                        }else{
                            Toast.makeText(RegisterActivity.this, "Register failed !", Toast.LENGTH_LONG)
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, "Throwable  !"+t.getLocalizedMessage(), Toast.LENGTH_LONG)
                                .show();
                    }
                }
        );
    }
}