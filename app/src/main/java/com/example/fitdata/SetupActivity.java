package com.example.fitdata;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

/**
 * This class is responsible for handling the setup activity.
 */
public class SetupActivity extends AppCompatActivity {

    private EditText etHeight, etWeight, etIdealWeight;
    private String experienceLevel = "";
    private String muscleGroup = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_activity);

        // Find UI elements
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_height2);
        etIdealWeight = findViewById(R.id.et_height3);

        Button beginnerButton = findViewById(R.id.button);
        Button intermediateButton = findViewById(R.id.button3);
        Button expertButton = findViewById(R.id.button4);

        Button armsButton = findViewById(R.id.button15);
        Button lowerBodyButton = findViewById(R.id.button16);
        Button upperBodyButton = findViewById(R.id.button17);
        Button allButton = findViewById(R.id.button13);

        ImageView backView = findViewById(R.id.backView);

        // Handle workout experience selection
        beginnerButton.setOnClickListener(v -> {
            experienceLevel = "Beginner";
            Toast.makeText(this, "Beginner Selected", Toast.LENGTH_SHORT).show();
        });

        intermediateButton.setOnClickListener(v -> {
            experienceLevel = "Intermediate";
            Toast.makeText(this, "Intermediate Selected", Toast.LENGTH_SHORT).show();
        });

        expertButton.setOnClickListener(v -> {
            experienceLevel = "Expert";
            Toast.makeText(this, "Expert Selected", Toast.LENGTH_SHORT).show();
        });

        // Handle muscle group selection
        armsButton.setOnClickListener(v -> {
            muscleGroup = "Arms";
            Toast.makeText(this, "Arms Selected", Toast.LENGTH_SHORT).show();
        });

        lowerBodyButton.setOnClickListener(v -> {
            muscleGroup = "Lower Body";
            Toast.makeText(this, "Lower Body Selected", Toast.LENGTH_SHORT).show();
        });

        upperBodyButton.setOnClickListener(v -> {
            muscleGroup = "Upper Body";
            Toast.makeText(this, "Upper Body Selected", Toast.LENGTH_SHORT).show();
        });

        allButton.setOnClickListener(v -> {
            muscleGroup = "All";
            Toast.makeText(this, "All Selected", Toast.LENGTH_SHORT).show();
        });

        backView.setOnClickListener(v -> {
            // Save data to SharedPreferences (to make the data persist after app changes)
            SharedPreferences sharedPreferences = getSharedPreferences("FitDataPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("height", etHeight.getText().toString());
            editor.putString("weight", etWeight.getText().toString());
            editor.putString("idealWeight", etIdealWeight.getText().toString());
            editor.putString("experienceLevel", experienceLevel);
            editor.putString("muscleGroup", muscleGroup);
            editor.apply(); // Save changes

            // Handle back button click
            Intent intent = new Intent(SetupActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

    }
}