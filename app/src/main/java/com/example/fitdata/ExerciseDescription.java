package com.example.fitdata;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * This class is responsible for displaying the description of an exercise.
 *
 * @author Michael Barreto
 */
public class ExerciseDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise_description);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Declaring the back button
        Button back_btn;

        back_btn = findViewById(R.id.backButton);

        // Retrieving data from Intent
        String exerciseName = getIntent().getStringExtra("exerciseName");
        int exerciseDifficulty = getIntent().getIntExtra("exerciseDifficulty", 1);
        String exerciseDescription = getIntent().getStringExtra("exerciseDescription");
        int exerciseReps = getIntent().getIntExtra("exerciseReps", 1);
        int exerciseSets = getIntent().getIntExtra("exerciseSets", 1);

        // Setting TextView content
        TextView name = findViewById(R.id.exerciseName);

        TextView difficulty = findViewById(R.id.exerciseDifficulty);
        difficulty.setText(String.valueOf(exerciseDifficulty));

        TextView description = findViewById(R.id.exerciseDescription);
        description.setText(exerciseDescription);

        TextView reps = findViewById(R.id.reps);
        reps.setText(exerciseReps + " reps" + " x " + exerciseSets + " sets");

        // Setting text for each field (name, difficulty, description)
        if (exerciseName != null){
            name.setText(exerciseName);
        }
        if (exerciseDifficulty !=  0){

            if (exerciseDifficulty >= 8) {

                difficulty.setBackgroundColor(Color.parseColor("#c30010"));
                difficulty.setText("HARD");

            } else if (exerciseDifficulty >= 4) {

                difficulty.setBackgroundColor(Color.parseColor("#FEE12B"));
                difficulty.setText("MEDIUM");


            } else if (exerciseDifficulty >= 1){

                difficulty.setBackgroundColor(Color.parseColor("#008000"));
                difficulty.setText("EASY");


            }
        }
        // If description is not null (not set), display it.
        if (exerciseDescription != null){
            description.setText(exerciseDescription);
        }

        // Setting up the back button
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  finish();
            }


        });
    }
}