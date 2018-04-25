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


    }

}

