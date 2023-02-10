package com.example.oblig1dat153.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.oblig1dat153.R;
import com.example.oblig1dat153.adapters.MyAdapter;
import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;
import com.example.oblig1dat153.model.ImageItem;

public class ExampleDialog extends AppCompatDialogFragment {
    Uri imageUri;
    ImageView image;
    EditText name_txt;
    MyAdapter adapter;

    public ExampleDialog(MyAdapter adapter) {
        this.adapter = adapter;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public EditText getName_txt() {
        return name_txt;
    }

    public void setName_txt(EditText name_txt) {
        this.name_txt = name_txt;
    }

    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK
                        && result.getData() != null) {
                    imageUri = result.getData().getData();
                    image.setImageURI(imageUri);
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());

                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());
                    Log.d("uri",imageUri.getEncodedPath());










                }
            }
    );


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View view = layoutInflater.inflate(R.layout.name_window, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);

        image = view.findViewById(R.id.image);
        name_txt = view.findViewById(R.id.name);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                launcher.launch(intent);
            }
        });


        builder.setTitle("Add Animals")
                .setMessage("This is a Dialog")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Animal animal = new Animal(new ImageItem(getImageUri()), getName_txt().getText().toString(), "", "");
                        AnimalList.getInstance().addAnimal(animal);
//                        dialogInterface.cancel();
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