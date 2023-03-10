package com.example.leboncoin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;


public class AdViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_view);
        ImageView image = (ImageView) findViewById(R.id.imageViewAd);
        TextView titre = (TextView) findViewById(R.id.textViewAd);
        TextView adresse = (TextView) findViewById(R.id.textViewAd2);
        TextView prix = (TextView) findViewById(R.id.textViewPrixDetail);

        Intent intentAdView = getIntent();
        AdModel selectedModel = (AdModel) intentAdView.getSerializableExtra("model");
        String contenuTitre = "     produit : "+selectedModel.getTitle();
        String contenuAdresse = "     adresse : "+selectedModel.getAddress();
        String contenuPrix = "      prix : "+selectedModel.getPrix();
        titre.setText(contenuTitre);
        adresse.setText(contenuAdresse);
        image.setImageResource(selectedModel.getImage());
        prix.setText(contenuPrix);
    }
}