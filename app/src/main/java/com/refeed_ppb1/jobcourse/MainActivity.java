package com.refeed_ppb1.jobcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Animation app_splash, bottom_to_top;
    ImageView app_logo;
    TextView app_tagline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        bottom_to_top = AnimationUtils.loadAnimation(this, R.anim.bottom_totop);
        app_logo = findViewById(R.id.app_logo);
        app_tagline = findViewById(R.id.app_tagline);

        app_logo.startAnimation(app_splash);
        app_tagline.startAnimation(bottom_to_top);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Merubah activity
            }
        }, 1000L);
    }
}