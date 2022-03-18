package com.hadiabbasi.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    private Button login_btn, first_signin_btn, second_signon_btn;
    private RelativeLayout login_form, signin_form;
    private ImageView forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initViews
        initViews();


        //set on click listener
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        first_signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_form.setVisibility(View.GONE);
                signin_form.setVisibility(View.VISIBLE);
            }
        });

        second_signon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_form.setVisibility(View.VISIBLE);
                signin_form.setVisibility(View.GONE);
            }
        });



    }

    private void initViews(){
        login_btn = findViewById(R.id.login_btn);
        first_signin_btn = findViewById(R.id.first_signin_btn);
        second_signon_btn = findViewById(R.id.second_signin_btn);
        login_form = findViewById(R.id.login_form);
        signin_form = findViewById(R.id.signin_form);
        forward = findViewById(R.id.forward);
    }
}