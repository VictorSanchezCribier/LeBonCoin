package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);
        ImageView image = (ImageView) findViewById(R.id.imageViewAd);
        TextView titre = (TextView) findViewById(R.id.textViewAd);
        TextView adresse = (TextView) findViewById(R.id.textViewAd2);
        Intent intentAdView = getIntent();
        AdModel selectedModel = (AdModel) intentAdView.getSerializableExtra("selectedModel");
        titre.setText(selectedModel.getTitle());
        adresse.setText(selectedModel.getAddress());
        image.setImageResource(selectedModel.getImage());
    }
}