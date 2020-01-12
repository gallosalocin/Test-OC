package com.gallosalocin.testoc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalsAdapter extends RecyclerView.Adapter<AnimalsAdapter.AnimalsViewHolder> {

    private ArrayList<AnimalsCardView> mAnimalsArrayList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }

    public void setOnItemClickLister(OnItemClickListener listener) {
        mListener = listener;
    }

    public static class AnimalsViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextView;
        public ImageView mDeleteImage;

        public AnimalsViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.animals_cardview_imageView);
            mTextView = itemView.findViewById(R.id.animals_cardview_nom_txt);
            mDeleteImage = itemView.findViewById(R.id.animals_cardview_delete_btn);

            mDeleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public AnimalsAdapter(ArrayList<AnimalsCardView> animalsArrayList) {
        mAnimalsArrayList = animalsArrayList;
    }

    @Override
    public AnimalsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animals_cardview, parent, false);
        AnimalsViewHolder animalsViewHolder = new AnimalsViewHolder(view, mListener);
        return animalsViewHolder;
    }

    @Override
    public void onBindViewHolder(AnimalsViewHolder holder, int position) {
        AnimalsCardView currentAnimals = mAnimalsArrayList.get(position);

        holder.mImageView.setImageResource(currentAnimals.getImageResource());
        holder.mTextView.setText(currentAnimals.getName());
    }

    @Override
    public int getItemCount() {

        return mAnimalsArrayList.size();
    }
}


