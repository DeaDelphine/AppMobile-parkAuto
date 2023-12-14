package com.example.parkautoappphone.activity;

import static com.example.parkautoappphone.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkautoappphone.R;
import com.example.parkautoappphone.entity.LoginResponse;
import com.example.parkautoappphone.entity.User;
import com.example.parkautoappphone.repository.UserRepository;
import com.example.parkautoappphone.retrofit.RetrofitLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText emailAdress, passwordtext;
    Button button_SignIn;
    UserRepository userRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_login);

        //Login credentials connect
        emailAdress = findViewById(R.id.emailAdress);
        passwordtext = findViewById(R.id.passwordtext);
        button_SignIn = findViewById(R.id.button_SignIn);

        button_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(emailAdress.getText().toString()) || TextUtils.isEmpty(passwordtext.getText().toString()) ){
                    Toast.makeText(LoginActivity.this, "Email and Password Required  !", Toast.LENGTH_LONG)
                            .show();
                }else{
                    //Proceed to login
                    login();
                    //startActivity(new Intent(LoginActivity.this, VehiculeActivity.class));
                }
            }
        });

        //Got to register
        TextView btn = findViewById(R.id.noAcountSignUp);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                    }
                }
        );
    }

    private void login() {
        User user = new User();
        user.setEmail(emailAdress.getText().toString());
        user.setPassword(passwordtext.getText().toString());

        Call<LoginResponse> loginResponseCall = RetrofitLogin.getUserRepository().userLogin(user);
        loginResponseCall.enqueue(
                new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login successful !", Toast.LENGTH_LONG)
                                    .show();
                            //Redirect to Dashbord Activity
                            LoginResponse loginResponse = response.body();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    startActivity(new Intent(LoginActivity.this, DashboardActivity.class)
                                            .putExtra("data", loginResponse.getFirstName()));
                                }
                            }, 700);
                        }else{
                            Toast.makeText(LoginActivity.this, "Login failed !", Toast.LENGTH_LONG)
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Throwable  !"+t.getLocalizedMessage(), Toast.LENGTH_LONG)
                                .show();
                    }
                }
        );
    }
}