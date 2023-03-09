package com.example.leboncoin;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class AdAddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_add);
        EditText titre = (EditText) findViewById(R.id.editTextTitre);
        EditText adresse = (EditText) findViewById(R.id.editTextAdresse);
        ImageView image = (ImageView) findViewById(R.id.imageViewAnnonce);

        Button valider = (Button) findViewById(R.id.buttonValider);
        String contenuTitre = String.valueOf(titre.getText());
        String contenuAdresse = String.valueOf(adresse.getText());



        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdAdd = new Intent(AdAddActivity.this, AdListViewActivity.class);
                AdModel ad = new AdModel(titre.getText().toString(), adresse.getText().toString(), R.drawable.toiture1);
                intentAdAdd.putExtra("nouvelleAnnonce", ad);
                startActivity(intentAdAdd);
            }
        });
    }
}