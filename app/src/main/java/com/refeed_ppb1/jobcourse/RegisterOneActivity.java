package com.refeed_ppb1.jobcourse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class RegisterOneActivity extends Activity {
    Button btn_continue;
    LinearLayout btn_back;
    EditText et_username, et_password, et_email_address;

    final static String USERNAME_KEY = "usernamekey";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_one);

        et_username = findViewById(R.id.username);
        et_password = findViewById(R.id.password);
        et_email_address = findViewById(R.id.email_address);

        btn_continue = findViewById(R.id.btn_continue);

        btn_continue.setOnClickListener((l) -> {
            SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("username", et_username.getText().toString());
            editor.apply();

            Intent goToNextRegister = new Intent(RegisterOneActivity.this, RegisterTwoActivity.class);
            startActivity(goToNextRegister);
        });


        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener((l) -> {
            Intent goToGetStarted = new Intent(RegisterOneActivity.this, GetStartedActivity.class);
            startActivity(goToGetStarted);
        });
    }
}
