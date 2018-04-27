package com.example.chris.beerme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Matt on 4/10/2018.
 */

public class BeerResultList extends AppCompatActivity {
    private Context mContext;
    private ListView mListView;
    EditText searchBar;
    BeerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_result_view);

        searchBar = findViewById(R.id.search_bar);
        mContext = this;
        // abvSpinner = findViewById(R.id.abv_dropdown);
        //beerTypeSpinner = findViewById(R.id.beer_type_dropdown);

        final ArrayList<Beer> beerList = Beer.getbeersFromFile("beers.json",this);

        adapter = new BeerAdapter(this, beerList);

        mListView = findViewById(R.id.beer_list_view);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener( new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){
                Beer selectedBeer = beerList.get(position);

                // create my intent package
                // add all the information needed for detail page
                // startActivity with that intent

                //explicit
                // from, to
                Intent detailIntent = new Intent(mContext, BeerDetailActivity.class);
                 //put title and instruction URL
                detailIntent.putExtra("name", selectedBeer.name);
               // detailIntent.putExtra("beerImage", selectedBeer.imageUrl);
                detailIntent.putExtra("description",selectedBeer.description);
                detailIntent.putExtra("style",selectedBeer.style);
                detailIntent.putExtra("category",selectedBeer.category);
                detailIntent.putExtra("abv",selectedBeer.abv);

                launchActivity(detailIntent);

            }
        });

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                BeerResultList.this.adapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {

            case R.id.action_camera:
                startActivity(new Intent(this, CameraActivity.class));
                return true;

            case R.id.action_title:
                startActivity(new Intent(this, SearchActivity.class));
                return true;


            case R.id.action_near_me:
                //startActivity(new Intent(this, NearMeActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    public void launchActivity(Intent intent){
        startActivityForResult(intent,1);
    }
}

