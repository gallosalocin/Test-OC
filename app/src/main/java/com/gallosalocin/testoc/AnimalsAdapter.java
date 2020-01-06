package com.gallosalocin.testoc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder> {
    private ArrayList<Animals> mAnimalsArrayList;

    public static class AnimalsViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView;

        public AnimalsViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.animals_imageView);
            mTextView = itemView.findViewById(R.id.animals_nom_txt);
        }
    }

    public AnimalsAdapter(ArrayList<Animals> animalsArrayList) {
        mAnimalsArrayList = animalsArrayList;
    }

    @Override
    public AnimalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.animals, parent, false);
        AnimalsViewHolder animalsViewHolder = new AnimalsViewHolder(v);
        return animalsViewHolder;
    }

    @Override
    public void onBindViewHolder(AnimalsViewHolder holder, int position) {
        Animals currentAnimals = mAnimalsArrayList.get(position);

        holder.mImageView.setImageResource(currentAnimals.getImageResource());
        holder.mTextView.setText(currentAnimals.getName());
    }

    @Override
    public int getItemCount() {

        return mAnimalsArrayList.size();
    }
}


