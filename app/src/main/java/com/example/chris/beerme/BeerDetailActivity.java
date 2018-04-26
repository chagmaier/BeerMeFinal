package com.example.chris.beerme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Chris on 4/25/18.
 */

public class BeerDetailActivity extends AppCompatActivity {
    private Context myContext;
    private TextView nameText;
    private ImageView beerImage;
    private TextView descriptionText;
    private TextView styleText;
    private TextView ABVText;



    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beer_detail_activity);

        myContext = this;
        nameText = findViewById(R.id.name_detail);
        beerImage= findViewById(R.id.image_detail);
        descriptionText= findViewById(R.id.description_detail);
        styleText = findViewById(R.id.style_detail);
        ABVText = findViewById(R.id.abv_detail);

        String name = this.getIntent().getExtras().getString("name");
        String description = this.getIntent().getExtras().getString("description");
        String abv = this.getIntent().getExtras().getString("abv");
        String style = this.getIntent().getExtras().getString("style");
        beerImage.setImageDrawable(getDrawable(R.drawable.beerimage));
        final int position = this.getIntent().getExtras().getInt("position");
        setTitle(name);
        descriptionText.setText(description);
        nameText.setText(name);
        styleText.setText(style);
        ABVText.setText(abv + "% Alcohol");

    }
}
