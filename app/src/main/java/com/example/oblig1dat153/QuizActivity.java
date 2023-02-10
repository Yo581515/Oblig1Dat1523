package com.example.oblig1dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;

import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    int number_of_tries;
    int number_of_correct_answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        int size = AnimalList.getInstance().getSize();
        int random = new Random().nextInt(size);
        Animal animal = AnimalList.getInstance().getAnimals().get(random);




    }

}