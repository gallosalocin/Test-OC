package com.gallosalocin.testoc;

public class AnimalsCardView {

    private int mImageResource;
    private String mName;

    public AnimalsCardView(int imageResource, String name) {
        mImageResource = imageResource;
        mName = name;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getName() {
        return mName;
    }
}


