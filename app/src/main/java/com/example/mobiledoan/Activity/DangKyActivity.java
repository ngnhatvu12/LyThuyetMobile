package com.example.mobiledoan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobiledoan.R;

public class DangKyActivity extends AppCompatActivity {
private boolean passwordShowing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        final EditText usernameET = findViewById(R.id.usernameET);
        final EditText PassET = findViewById(R.id.PassET);
        final ImageView PassIcon = findViewById(R.id.PassIcon);
        final TextView signupBtn = findViewById(R.id.signupBtn);

PassIcon.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(passwordShowing){
            passwordShowing = false;
            PassET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            PassIcon.setImageResource(R.drawable.passshow);
        }
        else {
            passwordShowing = true;
            PassET.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            PassIcon.setImageResource(R.drawable.passhide);
        }
        PassET.setSelection(PassET.length());
    }
});

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangKyActivity.this, RegisterActivity2.class));
            }
        });
    }
}