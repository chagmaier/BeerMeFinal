package com.example.chris.beerme;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Chris on 4/22/18.
 */

public class SearchActivity extends AppCompatActivity {

    private Context mContext;
    private TextView gridTextView;
    private ListView mListView;
    private Button searchButton;
    private GridView mainGrid;
    private ArrayList<String> clickedStyleArray;
    GridAdapter gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity_view);

        final ArrayList<String> styleList = new ArrayList<String>();
        final ArrayList<Beer> beerList = Beer.getbeersFromFile("beers.json", this);
        for(int i = 0; i<beerList.size(); i++) {
            String newStyleLabel = beerList.get(i).style;

            //if the array doesn't already contain this style, add it
            if(!styleList.contains(newStyleLabel)) {
                styleList.add(newStyleLabel);
            }
        }

        final ArrayList<String> styleLabelList = new ArrayList<String>();
        for(int i = 0; i<beerList.size(); i++) {
            String newStyleLabel = beerList.get(i).styleLabel;

            //if the array doesn't already contain this style, add it
            if(!styleLabelList.contains(newStyleLabel)) {
                styleLabelList.add(newStyleLabel);
            }
        }


        mContext = this;
        //arraylists for restrictions

        gridTextView = findViewById(R.id.grid_text_view);
        mainGrid = findViewById(R.id.search_grid);

        gridAdapter = new GridAdapter(this, styleLabelList);
        searchButton = findViewById(R.id.search_button);
        mainGrid.setAdapter(gridAdapter);

        mContext=this;
        //final ArrayList<Beer> beerList = Beer.getbeersFromFile("beers.json", this);
       // mListView.setAdapter(gridAdapter);

        clickedStyleArray = new ArrayList<String>();

        mainGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int originalbgcolor = getResources().getColor(R.color.lightBlue);
                int changedbgcolor = getResources().getColor(R.color.styleClickedBG);
                int test2 = getResources().getColor(R.color.colorWhite);
                int test = view.getSolidColor();
                //getResources().getIdentifier("grid_row_border","drawable","com.example.chris.beerme");





//                int origbgint = R.drawable.grid_row_border;
//                Drawable origbackground = getDrawable(origbgint);
//                int changedbgint = R.drawable.grid_row_border_changed;
//                Drawable changedbackground = getDrawable(changedbgint);
//                if(view.getBackground() == origbackground) {
//                    view.setBackground(changedbackground);
//                }
//                else{
//                    view.setBackground(origbackground);
//                }

                if (view.getSolidColor() != changedbgcolor) {
                    view.setBackgroundColor(changedbgcolor);
                } if(view.getSolidColor()==changedbgcolor){
                    view.setBackgroundColor(originalbgcolor);
                }

                //System.out.println(view.getSolidColor());
                //view.setBackgroundColor(Color.parseColor("#fc9c0c"));
                String selectedStyle = styleLabelList.get(position);
                for(int i = 0; i<beerList.size(); i++) {
                    //if the array doesn't already contain this style, add it
                    if(!clickedStyleArray.contains(selectedStyle)) {
                        clickedStyleArray.add(selectedStyle);
                    }
                }

                System.out.println(clickedStyleArray.get(clickedStyleArray.size()-1));
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent resultIntent = new Intent(mContext, SearchResultsActivity.class);
                resultIntent.putExtra("beerStylesList", clickedStyleArray);
                startActivity(resultIntent);
            }
        });


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
