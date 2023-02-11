package com.example.oblig1dat153.utils;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.oblig1dat153.model.ImageItem;

public class QuizUtils {


    public static void insertToImageView(ImageItem image, ImageView imageView, Context context) {
        Uri uriImage = image.getUriImage();
        Integer intImage = image.getIntImage();

        if (uriImage != null) {
            Glide.with(context)
                    .load(uriImage)
                    .centerCrop()
                    .into(imageView);


        } else if (intImage != null) {
            imageView.setImageResource(intImage);
        }
    }


}
