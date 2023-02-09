package com.example.oblig1dat153.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Animal implements Serializable {
    int image;
    String name;
    String wrongName1;
    String wrongName2;

    public Animal(int image, String name, String wrongName1, String wrongName2) {
        this.image = image;
        this.name = name;
        this.wrongName1 = wrongName1;
        this.wrongName2 = wrongName2;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWrongName1() {
        return wrongName1;
    }

    public void setWrongName1(String wrongName1) {
        this.wrongName1 = wrongName1;
    }

    public String getWrongName2() {
        return wrongName2;
    }

    public void setWrongName2(String wrongName2) {
        this.wrongName2 = wrongName2;
    }

/*    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);
        dest.writeString(wrongName1);
        dest.writeString(wrongName2);
    }

    public Animal(Parcel in) {
        image = in.readInt();
        name = in.readString();
        wrongName1 = in.readString();
        wrongName2 = in.readString();
    }

    public static final Parcelable.Creator<Animal> CREATOR = new Parcelable.Creator<Animal>() {
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };*/
}
