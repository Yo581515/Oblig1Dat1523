package com.example.oblig1dat153.model;

import android.net.Uri;

public class ImageItem {

    private Integer intImage;
    private Uri uriImage;


    public ImageItem(Integer intImage) {
        this.intImage = intImage;
    }

    public ImageItem(Uri uriImage) {
        this.uriImage = uriImage;
    }

    public Integer getIntImage() {
        return intImage;
    }

    public void setIntImage(Integer intImage) {
        this.intImage = intImage;
    }

    public Uri getUriImage() {
        return uriImage;
    }

    public void setUriImage(Uri uriImage) {
        this.uriImage = uriImage;
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "intImage=" + intImage +
                ", uriImage=" + uriImage +
                '}';
    }
}
