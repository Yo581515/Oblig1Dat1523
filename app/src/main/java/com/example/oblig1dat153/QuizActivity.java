package com.example.oblig1dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;
import com.example.oblig1dat153.utils.QuizUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    TextView score;
    TextView tries;
    ImageView q_image;
    RadioGroup radioGroup;
    RadioButton radio_1;
    RadioButton radio_2;
    RadioButton radio_3;
    List<Animal> animals = AnimalList.getInstance().getAnimals();
    int currentAnimalIndex = 0;

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

        Collections.shuffle(animals);
        if (animals.size() != 0) {
            setUpQuestions(animals.get(currentAnimalIndex));
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Boolean isCorrectName = false;
                RadioButton radio_checked = findViewById(checkedId);

                if (radio_checked != null) {
                    isCorrectName = animals.get(currentAnimalIndex).isCorrectName(radio_checked.getText().toString());
                    radio_checked.setChecked(false);
                }

                if (isCorrectName) {
                    int mScore = Integer.parseInt(score.getText().toString());
                    mScore++;
                    score.setText("" + mScore);

                    int mTries = Integer.parseInt(tries.getText().toString());
                    mTries++;
                    tries.setText("" + mTries);
                    Toast.makeText(QuizActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();

                } else {
                    int mTries = Integer.parseInt(tries.getText().toString());
                    mTries++;
                    tries.setText("" + mTries);

                    Toast.makeText(QuizActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }

                currentAnimalIndex = (currentAnimalIndex + 1) % animals.size();
                setUpQuestions(animals.get(currentAnimalIndex));
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
        q_image = findViewById(R.id.q_image);
        QuizUtils.insertToImageView(
                animal.getImage(),
                q_image
        );
    }

}