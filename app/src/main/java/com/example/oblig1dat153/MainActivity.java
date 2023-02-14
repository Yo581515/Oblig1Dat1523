package com.example.oblig1dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.example.oblig1dat153.model.Animal;
import com.example.oblig1dat153.model.AnimalList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Animal> animals;

    private static final String EASY_MODE = "EASY MODE";
    private static final String HARD_MODE = "HARD MODE";


    private static final int EASY_MODE_COLOR = Color.BLUE;
    private static final int HARD_MODE_COLOR = Color.RED;


    Button play_quiz_btn, entity_list_btn;
    //    AnimalList animalListClass;
    Switch mode_switcher;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play_quiz_btn = findViewById(R.id.play_quiz_btn);
        entity_list_btn = findViewById(R.id.entity_list_btn);
        mode_switcher = findViewById(R.id.mode_switcher);

        AnimalList.getInstance().addAnimal(new Animal(createBitmapFromDrawable(R.drawable.clifford), "Clifford", "Sander", "Yosafe"));
        AnimalList.getInstance().addAnimal(new Animal(createBitmapFromDrawable(R.drawable.pluto), "Pluto", "OOrjan", "Hitler"));
        AnimalList.getInstance().addAnimal(new Animal(createBitmapFromDrawable(R.drawable.scooby_doo_pido), "Scoopy Doo Pido", "John Cena", "Your MOM"));
        AnimalList.getInstance().addAnimal(new Animal(createBitmapFromDrawable(R.drawable.brian_griffin), "Brian Griffin", "haakon", "espen"));

        play_quiz_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(intent);
            }
        });


        entity_list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EntityListActivity.class);
                startActivity(intent);
            }
        });

        // switch handling
        DisplaySavedText();
        mode_switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayAndSaveText();
            }
        });


    }


    // handling mode state
    private void DisplaySavedText() {
        // Retrieving the value from SharedPref
        SharedPreferences sharedPreferences =
                getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sharedPreferences.getString("mode_switcher", " ");
        System.out.print(s1);
        boolean isTextEmpty = s1 != null && !s1.trim().equals("");
        if (isTextEmpty) {
            if (s1.equals(MainActivity.HARD_MODE)) {
                mode_switcher.setTextColor(HARD_MODE_COLOR);
                mode_switcher.setText(MainActivity.HARD_MODE);
                mode_switcher.setChecked(true);
            } else {
                mode_switcher.setTextColor(EASY_MODE_COLOR);
                mode_switcher.setText(MainActivity.EASY_MODE);
                mode_switcher.setChecked(false);
            }
        } else {
            mode_switcher.setTextColor(EASY_MODE_COLOR);
            mode_switcher.setText(MainActivity.EASY_MODE);
            mode_switcher.setChecked(false);
        }
    }

    private void DisplayAndSaveText() {
        if (mode_switcher.isChecked()) {
            mode_switcher.setTextColor(HARD_MODE_COLOR);
            mode_switcher.setText(MainActivity.HARD_MODE);
        } else {
            mode_switcher.setTextColor(EASY_MODE_COLOR);
            mode_switcher.setText(MainActivity.EASY_MODE);
        }
        // Saving the Text into SharedPref
        SharedPreferences sharedPreferences =
                getSharedPreferences("MySharedPref", MODE_PRIVATE);
        // Writing data to shared pref
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("mode_switcher", mode_switcher.getText().toString());
        editor.commit();
    }

    private Bitmap createBitmapFromDrawable(int drawableId) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), drawableId);
        return bitmap;
    }
}