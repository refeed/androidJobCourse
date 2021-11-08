package com.refeed_ppb1.jobcourse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;

public class SuccessRegisterActivity extends Activity {
    Button btn_explore_now;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        btn_explore_now = findViewById(R.id.btn_explore);

//        btn_explore_now.setOnClickListener((l) -> {
//            Intent goToHome = new Intent(this, HomeActivity);
//            startActivity(goToHome);
//        });
    }
}
