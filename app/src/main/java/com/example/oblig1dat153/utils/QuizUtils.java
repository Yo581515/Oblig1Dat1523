package com.example.oblig1dat153.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class QuizUtils {

    public static void insertToImageView(Bitmap image, ImageView imageView, Context context) {

        Glide
                .with(context)
                        .load(image)
                                .into(imageView);
//        imageView.setImageBitmap(image);
    }


}
