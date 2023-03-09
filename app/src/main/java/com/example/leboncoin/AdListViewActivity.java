package com.example.leboncoin;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);



       Intent intentAdAdd = getIntent();
        if (intentAdAdd.hasExtra("nouvelleAnnonce")) {
            AdModel nouvelleAnnonce = (AdModel) intentAdAdd.getSerializableExtra("nouvelleAnnonce");
            modeles.add(nouvelleAnnonce);
        }

    }

   /* @Override
    public void onItemClick(AdModel ad) {
        Intent intent = new Intent(this, AdViewActivity.class);
        intent.putExtra("ad", ad);
        startActivity(intent);
    }
*/

}