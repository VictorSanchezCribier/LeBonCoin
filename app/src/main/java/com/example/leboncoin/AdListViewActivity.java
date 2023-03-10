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
    AdModel modele1 = new AdModel("Tuiles", "Rue du grand bail",R.drawable.toiture1, "6€");
    AdModel modele2 = new AdModel("Tuiles2", "Rue du grand bail",R.drawable.toiture1, "10€");
    AdModel modele3 = new AdModel("Tuiles3", "Rue du grand bail",R.drawable.toiture1, "9€");
    AdModel modele4 = new AdModel("Tuiles4", "Rue du grand bail",R.drawable.toiture1, "9€");
    AdModel modele5 = new AdModel("Tuiles5", "Rue du grand bail",R.drawable.toiture1, "9,90€");
    AdModel modele6 = new AdModel("Tuiles6", "Rue du grand bail",R.drawable.toiture1, "9€");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_list_view);
        modeles.add(modele1);
        modeles.add(modele2);
        modeles.add(modele3);
        modeles.add(modele4);
        modeles.add(modele5);
        modeles.add(modele6);


        RecyclerViewAdAdapter adapter = new RecyclerViewAdAdapter(this, modeles);
        RecyclerView recyclerView = findViewById(R.id.adRecyclerView);
        GridLayoutManager grid = new GridLayoutManager(this, 2);
        grid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }

            @Override
            public int getSpanIndex(int position, int spanCount) {
                int column = position % 2; // nombre de colonnes = 2
                return column * 8;
            }

            @Override
            public int getSpanGroupIndex(int adapterPosition, int spanCount) {
                return adapterPosition / 2; // nombre de colonnes = 2
            }
        });

        recyclerView.setLayoutManager(grid);
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