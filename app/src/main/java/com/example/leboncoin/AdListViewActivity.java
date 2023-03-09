package com.example.leboncoin;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import androidx.cardview.widget.CardView;



public class AdListViewActivity extends AppCompatActivity {
    ArrayList<AdModel> modeles = new ArrayList();
    AdModel modele1 = new AdModel("Tuiles", "Rue du grand bail",R.drawable.toiture1);
    AdModel modele2 = new AdModel("Tuiles2", "Rue du grand bail",R.drawable.toiture1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        modeles.add(modele1);
        modeles.add(modele2);

        RecyclerViewAdAdapter adapter = new RecyclerViewAdAdapter(this, modeles);
        RecyclerView recyclerView = findViewById(R.id.adRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
       /* recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View vue, int position, long l) {
                AdModel selectedModel = (AdModel) adapter.getItemAtPosition(position);
                Intent intentAdView = new Intent(AdListViewActivity.this, AdViewActivity.class);
                intentAdView.putExtra("selectedModel", selectedModel);
                startActivity(intentAdView);
            }
        });
*/
        Intent intentAdAdd = getIntent();
        if (intentAdAdd.hasExtra("nouvelleAnnonce")) {
            AdModel nouvelleAnnonce = (AdModel) intentAdAdd.getSerializableExtra("nouvelleAnnonce");
            modeles.add(nouvelleAnnonce);
        }

    }
}