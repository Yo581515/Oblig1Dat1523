package com.example.oblig1dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;
import com.example.oblig1dat153.utils.QuizUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    TextView score;
    TextView tries;
    ImageView q_image;
    RadioGroup radioGroup;
    RadioButton radio_1;
    RadioButton radio_2;
    RadioButton radio_3;
    Button submit_btn;


    Random randomer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        score = findViewById(R.id.score_number);
        tries = findViewById(R.id.tries_number);
        q_image = findViewById(R.id.q_image);
        radioGroup = findViewById(R.id.radio_group);
        radio_1 = findViewById(R.id.radio_1);
        radio_2 = findViewById(R.id.radio_2);
        radio_3 = findViewById(R.id.radio_3);
        submit_btn = findViewById(R.id.submit_btn);


        List<Animal> animals = AnimalList.getInstance().getAnimals();
        Collections.shuffle(animals);

        Animal animal = animals.get(0);
        setUpQuestions(animal);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




            }
        });


    }


    public void setUpQuestions(Animal animal) {

        List<String> names = new ArrayList<>();
        names.add(animal.getName());
        names.add(animal.getWrongName1());
        names.add(animal.getWrongName2());

        Collections.shuffle(names);

        radio_1.setText(names.get(0));
        radio_2.setText(names.get(1));
        radio_3.setText(names.get(2));
        QuizUtils.insertToImageView(
                animal.getImage(),
                q_image,
                getApplicationContext()
        );
    }

}