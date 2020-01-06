package com.gallosalocin.testoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnimalsList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        ArrayList<Animals> animalsArrayList = new ArrayList<>();
        animalsArrayList.add(new Animals(R.drawable.butterfly_icon, "Papillon"));
        animalsArrayList.add(new Animals(R.drawable.dolphin_icon, "Dauphin"));
        animalsArrayList.add(new Animals(R.drawable.fish_icon, "Poisson"));
        animalsArrayList.add(new Animals(R.drawable.lion_icon, "Lion"));
        animalsArrayList.add(new Animals(R.drawable.rabbit_icon, "Lapin"));
        animalsArrayList.add(new Animals(R.drawable.snake_icon, "Serpent"));
        animalsArrayList.add(new Animals(R.drawable.zebra_icon, "Zèbre"));
        animalsArrayList.add(new Animals(R.drawable.bird_icon, "Oiseau"));
        animalsArrayList.add(new Animals(R.drawable.cat_face_icon, "Chat"));
        animalsArrayList.add(new Animals(R.drawable.dog_russel_grin_icon, "Chien"));
        animalsArrayList.add(new Animals(R.drawable.elephant_icon, "Eléphant"));
        animalsArrayList.add(new Animals(R.drawable.hippopotamus_icon, "Hippopotame"));
        animalsArrayList.add(new Animals(R.drawable.horse_icon, "Cheval"));
        animalsArrayList.add(new Animals(R.drawable.ladybird_icon, "Coccinelle"));
        animalsArrayList.add(new Animals(R.drawable.snail_icon, "Escargot"));
        animalsArrayList.add(new Animals(R.drawable.panda_icon, "Panda"));
        animalsArrayList.add(new Animals(R.drawable.guepard_icon, "Guépard"));
        animalsArrayList.add(new Animals(R.drawable.loup_icon, "Loup"));
        animalsArrayList.add(new Animals(R.drawable.renard_icon, "Renard"));
        animalsArrayList.add(new Animals(R.drawable.koala_icon, "Koala"));

        Collections.sort(animalsArrayList, new Comparator<Animals>() {
            @Override
            public int compare(Animals o1, Animals o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        mRecyclerView = findViewById(R.id.activity_animals_list_recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AnimalsAdapter(animalsArrayList);
        mAdapter.notifyDataSetChanged();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}


