package com.gallosalocin.testoc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalsDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_details);


        Intent intent = getIntent();
        AnimalsCardView animalsList = intent.getParcelableExtra("Animal Detail");

        int imageRes = animalsList.getImageResource();
        String name = animalsList.getName();

        ImageView imageView = findViewById(R.id.animals_details_imageView);
        imageView.setImageResource(imageRes);

        TextView textView = findViewById(R.id.animals_details_nom_txt);
        textView.setText(name);

    }
}
