package com.example.mobiledoan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobiledoan.R;

public class RegisterActivity2 extends AppCompatActivity {
    private boolean passwordShowing = false;
    private boolean conpasswordShowing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        final EditText Email = findViewById(R.id.emailET);
        final EditText Mobile = findViewById(R.id.mobileET);
        final EditText Password = findViewById(R.id.PassET);
        final EditText ConPass = findViewById(R.id.conPassET);

        final ImageView PasswordIcon = findViewById(R.id.PassIcon);
        final ImageView ConPassIcon = findViewById(R.id.conPassIcon);

        final AppCompatButton SignupBtn = findViewById(R.id.SignupBtn);
        final TextView signinBtn = findViewById(R.id.signinBtn);

        PasswordIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passwordShowing){
                    passwordShowing = false;
                    Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    PasswordIcon.setImageResource(R.drawable.passshow);
                }
                else {
                    passwordShowing = true;
                    Password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    PasswordIcon.setImageResource(R.drawable.passhide);
                }
                Password.setSelection(Password.length());

            }
        });
        ConPassIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(conpasswordShowing){
                    conpasswordShowing = false;
                    ConPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    ConPassIcon.setImageResource(R.drawable.passshow);
                }
                else {
                    conpasswordShowing = true;
                    ConPass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    ConPassIcon.setImageResource(R.drawable.passhide);
                }
                ConPass.setSelection(ConPass.length());

            }
        });
        SignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

            }
        });
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}