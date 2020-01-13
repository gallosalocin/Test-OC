package com.gallosalocin.testoc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class AnimalsList extends AppCompatActivity {
    private ArrayList<AnimalsCardView> mAnimalsArrayList;
    private RecyclerView mRecyclerView;
    private AnimalsAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private AnimalsList mAnimalsListActivity;
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_list);

        createAnimalsList();
        buildRecyclerView();
        configFab();

    }

    public void configFab() {
        mFab = findViewById(R.id.activity_animals_list_fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addRandomItem();
            }
        });
    }

    public void addRandomItem() {
        mAnimalsArrayList.add(mAnimalsArrayList.get(new Random().nextInt(mAnimalsArrayList.size())));
        mAdapter.notifyDataSetChanged();
        sortList();
    }

    public void removeItem(int position) {
        mAnimalsArrayList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void createAnimalsList() {
        mAnimalsArrayList = new ArrayList<>();
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.butterfly_icon, "Papillon"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.dolphin_icon, "Dauphin"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.fish_icon, "Poisson"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.lion_icon, "Lion"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.rabbit_icon, "Lapin"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.snake_icon, "Serpent"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.zebra_icon, "Zèbre"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.bird_icon, "Oiseau"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.cat_face_icon, "Chat"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.dog_russel_grin_icon, "Chien"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.elephant_icon, "Eléphant"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.hippopotamus_icon, "Hippopotame"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.horse_icon, "Cheval"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.ladybird_icon, "Coccinelle"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.snail_icon, "Escargot"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.panda_icon, "Panda"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.guepard_icon, "Guépard"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.loup_icon, "Loup"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.renard_icon, "Renard"));
        mAnimalsArrayList.add(new AnimalsCardView(R.drawable.koala_icon, "Koala"));

        sortList();
    }

    public void sortList() {
        Collections.sort(mAnimalsArrayList, new Comparator<AnimalsCardView>() {
            @Override
            public int compare(AnimalsCardView o1, AnimalsCardView o2) {
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
        this.mAnimalsListActivity = this;

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AnimalsAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(final int position) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(mAnimalsListActivity);
                myDialog.setTitle("Supprimer");
                myDialog.setMessage("Supprimer cet animal de la liste ?");
                myDialog.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removeItem(position);
                    }
                });
                myDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                myDialog.show();
            }

            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(AnimalsList.this, AnimalsDetails.class);
                intent.putExtra("Animal Detail", mAnimalsArrayList.get(position));
                startActivity(intent);
            }
        });
    }
}


