package com.refeed_ppb1.jobcourse;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity {
    Button btn_signin, btn_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);

        btn_signin = findViewById(R.id.btn_signin);
        btn_signup = findViewById(R.id.btn_signup);

        btn_signin.setOnClickListener((l) -> {
            Intent goToSignIn = new Intent(GetStartedActivity.this, SignInActivity.class);
            startActivity(goToSignIn);
        });

        btn_signup.setOnClickListener((l) -> {
            Intent goToRegisterOne = new Intent(GetStartedActivity.this, RegisterOneActivity.class);
            startActivity(goToRegisterOne);
        });
    }
}
