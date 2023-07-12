package com.nebclass12organicchemistrynotes.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.nebclass12organicchemistrynotes.app.Admob.Admob;
import com.nebclass12organicchemistrynotes.app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CategoryModel> list;
    CategoryAdapter adapter;
    RecyclerView recyclerView;

    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageView menu;
    View header;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        recyclerView = findViewById(R.id.recyclerView);

        Admob.loadBannerAd(findViewById(R.id.bannerAd),MainActivity.this);

        menu = findViewById(R.id.menu);
        navigationView = (NavigationView)findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);


        list = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        list.add(new CategoryModel("Haloalkane",R.drawable.grad3,R.drawable.vertical_back, R.color.black));
        list.add(new CategoryModel("Chloroform",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));
        list.add(new CategoryModel("Alcohol",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("Haloarene",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));
        list.add(new CategoryModel("Phenol",R.drawable.grad5,R.drawable.ver5,R.color.black));

        list.add(new CategoryModel("Ether",R.drawable.grad3,R.drawable.vertical_back, R.color.black));
        list.add(new CategoryModel("Aldehyde and Ketone",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));
        list.add(new CategoryModel("Aromatic Aldehyde and Ketone",R.drawable.grad2,R.drawable.vertical_view2, R.color.black));
        list.add(new CategoryModel("Carboxylic Acid and It's Deri...",R.drawable.grad4,R.drawable.ver4, R.color.teal_200));
        list.add(new CategoryModel("Nitro Compound",R.drawable.grad3,R.drawable.vertical_back, R.color.black));
        list.add(new CategoryModel("Amino Compound",R.drawable.grad1,R.drawable.vertical_view1, R.color.teal_200));


        adapter = new CategoryAdapter(list,this);       recyclerView.setAdapter(adapter);

        header = navigationView.getHeaderView(0);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else {

                    drawerLayout.openDrawer(GravityCompat.START);
                }


            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){


                    case R.id.home:

                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.share:

                        String shareBody = "Hey, I am using best Class 12 Organic Chemistry Notes App";
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        startActivity(intent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.rate:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/games?pli=1")));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }


                return true;
            }
        });


    }
}