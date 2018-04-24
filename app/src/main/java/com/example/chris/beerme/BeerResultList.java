package com.example.chris.beerme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

/**
 * Created by Matt on 4/10/2018.
 */

public class BeerResultList extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private Context mContext;
    private ListView mListView;
    BeerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_result_view);

        mContext = this;


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {

                    case R.id.nav_home:
                        Intent intent1 = new Intent(BeerResultList.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_nearme:
                        Intent intent2 = new Intent(BeerResultList.this, HomeActiviy.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_search:
                        Intent intent3 = new Intent(BeerResultList.this, SearchActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

    }

}

