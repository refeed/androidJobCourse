package com.refeed_ppb1.jobcourse;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

public class RegisterTwoActivity extends Activity {
    EditText et_bio, et_nama_lengkap;
    ImageView pic_photo_register_user;
    Button btn_add_photo, btn_continue;
    LinearLayout btn_back;

    Uri photo_location;

    final int MAX_PHOTO = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);

        et_bio = findViewById(R.id.bio);
        et_nama_lengkap = findViewById(R.id.nama_lengkap);
        btn_add_photo = findViewById(R.id.btn_add_photo);
        btn_back = findViewById(R.id.btn_back);
        pic_photo_register_user = findViewById(R.id.pic_photo_register_user);
        btn_continue = findViewById(R.id.btn_continue);


        btn_add_photo.setOnClickListener((l) -> {
            findPhoto();
        });

        btn_continue.setOnClickListener((l) -> {
            Intent goToSuccessRegister = new Intent(this, SuccessRegisterActivity.class);
            startActivity(goToSuccessRegister);
        });

        btn_back.setOnClickListener((l) -> {
            Intent goToRegisterOne = new Intent(this, RegisterOneActivity.class);
            startActivity(goToRegisterOne);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAX_PHOTO &&
                resultCode == RESULT_OK &&
                data != null &&
                data.getData() != null) {
            photo_location = data.getData();

            Picasso.with(this).load(photo_location)
                    .centerCrop()
                    .fit()
                    .into(pic_photo_register_user);
        }

    }

    public void findPhoto() {
        Intent pic = new Intent();
        pic.setType("image/*");
        pic.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(pic, MAX_PHOTO);
    }

    public String getUsernameLocal() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                RegisterOneActivity.USERNAME_KEY, MODE_PRIVATE);
        return sharedPreferences.getString("username", "");
    }
}
