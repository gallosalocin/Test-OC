package com.gallosalocin.testoc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnimalsList extends AppCompatActivity {
    private ArrayList<Animals> mAnimalsArrayList;
    private RecyclerView mRecyclerView;
    private AnimalsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        createAnimalsList();
        buildRecyclerView();

    }


    public void removeItem(int position) {
        mAnimalsArrayList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void createAnimalsList() {
        mAnimalsArrayList = new ArrayList<>();
        mAnimalsArrayList.add(new Animals(R.drawable.butterfly_icon, "Papillon"));
        mAnimalsArrayList.add(new Animals(R.drawable.dolphin_icon, "Dauphin"));
        mAnimalsArrayList.add(new Animals(R.drawable.fish_icon, "Poisson"));
        mAnimalsArrayList.add(new Animals(R.drawable.lion_icon, "Lion"));
        mAnimalsArrayList.add(new Animals(R.drawable.rabbit_icon, "Lapin"));
        mAnimalsArrayList.add(new Animals(R.drawable.snake_icon, "Serpent"));
        mAnimalsArrayList.add(new Animals(R.drawable.zebra_icon, "Zèbre"));
        mAnimalsArrayList.add(new Animals(R.drawable.bird_icon, "Oiseau"));
        mAnimalsArrayList.add(new Animals(R.drawable.cat_face_icon, "Chat"));
        mAnimalsArrayList.add(new Animals(R.drawable.dog_russel_grin_icon, "Chien"));
        mAnimalsArrayList.add(new Animals(R.drawable.elephant_icon, "Eléphant"));
        mAnimalsArrayList.add(new Animals(R.drawable.hippopotamus_icon, "Hippopotame"));
        mAnimalsArrayList.add(new Animals(R.drawable.horse_icon, "Cheval"));
        mAnimalsArrayList.add(new Animals(R.drawable.ladybird_icon, "Coccinelle"));
        mAnimalsArrayList.add(new Animals(R.drawable.snail_icon, "Escargot"));
        mAnimalsArrayList.add(new Animals(R.drawable.panda_icon, "Panda"));
        mAnimalsArrayList.add(new Animals(R.drawable.guepard_icon, "Guépard"));
        mAnimalsArrayList.add(new Animals(R.drawable.loup_icon, "Loup"));
        mAnimalsArrayList.add(new Animals(R.drawable.renard_icon, "Renard"));
        mAnimalsArrayList.add(new Animals(R.drawable.koala_icon, "Koala"));

        Collections.sort(mAnimalsArrayList, new Comparator<Animals>() {
            @Override
            public int compare(Animals o1, Animals o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.activity_animals_list_recycleView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AnimalsAdapter(mAnimalsArrayList);
        mAdapter.notifyDataSetChanged();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickLister(new AnimalsAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });

    }
}


