package com.example.chris.beerme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

/**
 * Created by Matt on 4/10/2018.
 */

public class HomeActiviy extends AppCompatActivity {


    private BottomNavigationView mMainNav;
    private Context mContext;
    private FrameLayout mMainFrame;
    private HomeFragment homeFragment;
    private NearMeFragment nearMeFragment;
    private SearchFragment searchFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mContext = this;
        mMainFrame = findViewById(R.id.main_frame);
        mMainNav = findViewById(R.id.main_nav);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {

                    case R.id.nav_home:
                        Intent intent1 = new Intent(HomeActiviy.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_nearme:
                        Intent intent2 = new Intent(HomeActiviy.this, HomeActiviy.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_search:
                        Intent intent3 = new Intent(HomeActiviy.this, SearchActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });



        /*
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mMainNav.postDelayed(() -> {
                    int itemId = item.getItemId();
                    if (itemId == R.id.nav_home) {
                        //startActivity(new Intent(this, BeerResultList.class));
                        launchBeerResultList();
                    } *//*else if (itemId == R.id.nav_nearme) {
                        startActivity(new Intent(this, BeerResultList.class));
                    }*//*
                    finish();
                }, 300);
                return true;
            }
        });
        */

    }
    private void launchBeerResultList (){
        Intent intent = new Intent(mContext, BeerResultList.class);
        startActivityForResult(intent, 1);
    }
}

