package com.example.oblig1dat153;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.oblig1dat153.adapters.MyAdapter;
import com.example.oblig1dat153.fragments.ExampleDialog;
import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;
import com.example.oblig1dat153.model.ImageItem;

public class EntityListActivity extends AppCompatActivity {
    int RESULT_LOAD_IMAGE = 200;

    // 1- AdapterView: RecyclerView
    RecyclerView recyclerView;

    // 2- Data Source:
//    List<Animal> animals;

    // 3- Adapter
    MyAdapter adapter;

    Button add_entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_list);


        recyclerView = findViewById(R.id.recyclerView);
        add_entity = findViewById(R.id.add_entity);

//        AnimalList.getInstance().addAnimal(new Animal(R.drawable.pluto, "name", "wrongName1", "wrongName2"));


        add_entity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///storage/self/primary/Download/doge_meme.png
                // add image from gallery
//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                ExampleDialog exampleDialog = new ExampleDialog(adapter);
                exampleDialog.show(getSupportFragmentManager(), "example dialog");
            }
        });

        adapter = new MyAdapter(AnimalList.getInstance().getAnimals());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adapter);
    }


}