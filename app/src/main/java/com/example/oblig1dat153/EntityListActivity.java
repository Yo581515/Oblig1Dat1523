package com.example.oblig1dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.oblig1dat153.adapters.MyAdapter;
import com.example.oblig1dat153.fragments.ExampleDialog;
import com.example.oblig1dat153.model.AnimalList;

public class EntityListActivity extends AppCompatActivity {
    int RESULT_LOAD_IMAGE = 200;

    // 1- AdapterView: RecyclerView
    RecyclerView recyclerView;

    // 3- Adapter
    MyAdapter adapter;

    Button add_entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_list);


        recyclerView = findViewById(R.id.recyclerView);
        add_entity = findViewById(R.id.add_entity);

        add_entity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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