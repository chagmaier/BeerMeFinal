package com.example.chris.beerme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Chris on 4/22/18.
 */

public class SearchActivity extends AppCompatActivity {

    private SearchActivity mContext;
    private Spinner abvSpinner;
    private Spinner beerTypeSpinner;
    private BottomNavigationView mMainNav;
    private EditText searchBar;
    private TextView searchBelowTextView;
    private ListView mListView;
    BeerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_view);

        searchBar = findViewById(R.id.search_bar);
        mContext = this;
       // abvSpinner = findViewById(R.id.abv_dropdown);
        //beerTypeSpinner = findViewById(R.id.beer_type_dropdown);

        final ArrayList<Beer> beerList = Beer.getbeersFromFile("beers.json", this);

        adapter = new BeerAdapter(this, beerList);
        mListView = findViewById(R.id.search_recipe_list_view);
        mListView.setAdapter(adapter);

        mMainNav = findViewById(R.id.main_nav);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {

                    case R.id.nav_home:
                        Intent intent1 = new Intent(SearchActivity.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_nearme:
                        Intent intent2 = new Intent(SearchActivity.this, HomeActiviy.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_search:
                        Intent intent3 = new Intent(SearchActivity.this, SearchActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                SearchActivity.this.adapter.getFilter().filter(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
