package com.example.oblig1dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oblig1dat153.adapters.MyAdapter;
import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;

public class EntityListActivity extends AppCompatActivity {

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
            }
        });

        adapter = new MyAdapter(AnimalList.getInstance().getAnimals());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adapter);


    }



}