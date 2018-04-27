package com.example.chris.beerme;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Chris on 4/22/18.
 */

public class SearchActivity extends AppCompatActivity {

    private Context mContext;
    private Button searchButton;
    private TextView gridTextView;
    private ListView mListView;
    private GridView mainGrid;
    private ArrayList<String> clickedStyleArray;
    GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_view);

        ArrayList<String> styleList = new ArrayList<String>();
        final ArrayList<Beer> beerList = Beer.getbeersFromFile("beers.json", this);
        for(int i = 0; i<beerList.size(); i++) {
            String newStyleLabel = beerList.get(i).style;

            //if the array doesn't already contain this style, add it
            if(!styleList.contains(newStyleLabel)) {
                styleList.add(newStyleLabel);
            }
        }

        mContext = this;
        //arraylists for restrictions
        //final ArrayList<Beer> recipeList = Beer.getbeersFromFile("beers.json", this);
        ArrayList<String> dietRestrictionLabel = new ArrayList<>();

        gridTextView = findViewById(R.id.grid_text_view);
        mainGrid = findViewById(R.id.search_grid);

        //setSingleEvent(mainGrid);

        gridAdapter = new GridAdapter(this, styleList);

        mainGrid.setAdapter(gridAdapter);

        mContext=this;
        //final ArrayList<Beer> beerList = Beer.getbeersFromFile("beers.json", this);
       // mListView.setAdapter(gridAdapter);

        clickedStyleArray = new ArrayList<String>();

        //set onClick listener
//        mainGrid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String selectedStyle =
//            }
//        });

    }

    private void setSingleEvent(GridView mainGrid) {
        //parse through grid items
        for(int i=0; i<mainGrid.getChildCount(); i++){
            CardView cardView = (CardView)mainGrid.getChildAt(i);
//            cardView.setOnClickListener(new AdapterView.OnClickListener(){
//                @Override
//                public void onClick(View view){
//                    Beer selectedBeer = beerList.get(position);
//
//                    // create my intent package
//                    // add all the information needed for detail page
//                    // startActivity with that intent
//
//                    //explicit
//                    // from, to
//                    Intent detailIntent = new Intent(mContext, BeerDetailActivity.class);
//                    //put title and instruction URL
//                    detailIntent.putExtra("name", selectedBeer.name);
//                    // detailIntent.putExtra("beerImage", selectedBeer.imageUrl);
//                    detailIntent.putExtra("description",selectedBeer.description);
//                    detailIntent.putExtra("style",selectedBeer.style);
//                    detailIntent.putExtra("category",selectedBeer.category);
//
//                    launchActivity(detailIntent);
//                }
//            });
        }

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
