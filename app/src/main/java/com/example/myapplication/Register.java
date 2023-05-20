package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register;
        TextView email,pass;
        register=findViewById(R.id.button);
        email=findViewById(R.id.editTextTextEmailAddress);
        pass=findViewById(R.id.editTextTextPassword);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(Register.this,Login.class));
            }
        });
    }
}