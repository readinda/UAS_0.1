package com.natania.uas_01.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.natania.uas_01.R;
import com.natania.uas_01.network.InterfaceClient;
import com.natania.uas_01.network.RetrofitConfig;

public class DetailActivity extends AppCompatActivity {
   String txtTitle;
   TextView tvDetailTitle;
   ImageView ivDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvDetailTitle = findViewById(R.id.tv_detail_name);
        ivDetail = findViewById(R.id.img_detail_photo);

        txtTitle = getIntent().getStringExtra("title");

        Glide.with(this).load(getIntent().getStringExtra("thumb")).into(ivDetail);

        tvDetailTitle.setText(txtTitle);




    }
}
