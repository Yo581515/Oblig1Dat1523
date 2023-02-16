package com.example.oblig1dat153.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.bumptech.glide.Glide;
import com.example.oblig1dat153.R;
import com.example.oblig1dat153.adapters.MyAdapter;
import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;
import com.example.oblig1dat153.utils.QuizUtils;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ExampleDialog extends AppCompatDialogFragment {

    ImageView imageView;
    MyAdapter adapter;

    // constructor
    public ExampleDialog(MyAdapter adapter) {
        this.adapter = adapter;
    }


    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK
                        && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    try {
                        Bitmap bitmapImage = MediaStore.Images.Media.getBitmap(
                                getActivity().getContentResolver(),
                                imageUri);
                        QuizUtils.insertToImageView(bitmapImage, imageView);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    );


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater.inflate(R.layout.name_window, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        imageView = view.findViewById(R.id.image);
        TextView name_txt = view.findViewById(R.id.name);
        TextView wrong_name_1_txt = view.findViewById(R.id.wrong_name_1);
        TextView wrong_name_2_txt = view.findViewById(R.id.wrong_name_2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                );
                launcher.launch(intent);
            }
        });


        builder
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (TextUtils.isEmpty(name_txt.getText().toString())) {
                            Toast.makeText(getActivity().getApplication(), "Please Enter a Name", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            getDialog().dismiss();
                        }

                        Bitmap bitmapImage = ((BitmapDrawable) imageView.getDrawable()).getBitmap();


                        Animal animal = new Animal(
                                bitmapImage,
                                name_txt.getText().toString(),
                                wrong_name_1_txt.getText().toString(),
                                wrong_name_2_txt.getText().toString()
                        );

                        AnimalList.getInstance().addAnimal(animal);
                        adapter.notifyDataSetChanged();

                    }
                }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        final AlertDialog alertDialog = builder.create();

        return alertDialog;
    }
}