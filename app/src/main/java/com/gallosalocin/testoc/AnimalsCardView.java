package com.gallosalocin.testoc;

import android.os.Parcel;
import android.os.Parcelable;

public class AnimalsCardView implements Parcelable {

    private int mImageResource;
    private String mName;

    public AnimalsCardView(int imageResource, String name) {
        mImageResource = imageResource;
        mName = name;
    }

    protected AnimalsCardView(Parcel in) {
        mImageResource = in.readInt();
        mName = in.readString();
    }

    public static final Creator<AnimalsCardView> CREATOR = new Creator<AnimalsCardView>() {
        @Override
        public AnimalsCardView createFromParcel(Parcel in) {
            return new AnimalsCardView(in);
        }

        @Override
        public AnimalsCardView[] newArray(int size) {
            return new AnimalsCardView[size];
        }
    };

    public int getImageResource() {
        return mImageResource;
    }

    public String getName() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mName);
    }
}


