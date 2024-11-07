package com.example.fitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button back_btn;

        back_btn = findViewById(R.id.backButton);

        // Retrieving data from Intent
        String exerciseName = getIntent().getStringExtra("exerciseName");
        String exerciseDifficulty = getIntent().getStringExtra("exerciseDifficulty");
        String exerciseDescription = getIntent().getStringExtra("exerciseDescription");

        // Setting TextView content
        TextView name = findViewById(R.id.exerciseName);

        TextView difficulty = findViewById(R.id.exerciseDifficulty);
        difficulty.setText(exerciseDifficulty);

        TextView description = findViewById(R.id.exerciseDescription);
        description.setText(exerciseDescription);

        // Setting text for each field (name, difficulty, description)
        if (exerciseName != null){
            name.setText(exerciseName);
        }
        if (exerciseDifficulty != null){
            difficulty.setText("Difficulty: " + exerciseDifficulty);
        }
        if (exerciseDescription != null){
            description.setText("Description: " + exerciseDescription);
        }

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ExerciseDescription.this, MainActivity.class));

            }


        });
    }
}