package com.example.fitdata;

import android.content.Intent;
import androidx.core.content.ContextCompat;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

/**
 * This class is responsible for displaying the profile activity.
 *
 * @author Americo Silva
 */
public class ProfileActivity extends AppCompatActivity {

    // Declaring variables for text views
    private TextView tvHeight, tvWeight, tvIdealWeight, tvExperienceLevel, tvMuscleGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Sets the correct layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        // Find UI elements
        tvHeight = findViewById(R.id.textView5);
        tvWeight = findViewById(R.id.textView6);
        tvIdealWeight = findViewById(R.id.textView4);
        tvExperienceLevel = findViewById(R.id.button2);
        tvMuscleGroup = findViewById(R.id.button6);

        // Retrieve data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("FitDataPrefs", MODE_PRIVATE);
        String height = sharedPreferences.getString("height", "N/A");
        String weight = sharedPreferences.getString("weight", "N/A");
        String idealWeight = sharedPreferences.getString("idealWeight", "N/A");
        String experienceLevel = sharedPreferences.getString("experienceLevel", "None");
        String muscleGroup = sharedPreferences.getString("muscleGroup", "None");

        // Set button colors based on experience level
        Button button2 = findViewById(R.id.button2);
        if ("Beginner".equalsIgnoreCase(experienceLevel)) {
            button2.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        } else if ("Intermediate".equalsIgnoreCase(experienceLevel)) {
            button2.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
        } else if ("Expert".equalsIgnoreCase(experienceLevel)) {
            button2.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        } else {
            button2.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        }

        // Set button colors based on muscle group
        Button button6 = findViewById(R.id.button6);
        if ("Arms".equalsIgnoreCase(muscleGroup)) {
            button6.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200));
        } else if ("Lower Body".equalsIgnoreCase(muscleGroup)) {
            button6.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_500));
        } else if ("Upper Body".equalsIgnoreCase(muscleGroup)) {
            button6.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700));
        } else if ("All".equalsIgnoreCase(muscleGroup)) {
            button6.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200));
        } else {
            button6.setBackgroundColor(ContextCompat.getColor(this, R.color.black));
        }

        // Update UI with retrieved data
        tvHeight.setText(height);
        tvWeight.setText(weight + "Lbs");
        tvIdealWeight.setText(idealWeight + "Lbs");
        tvExperienceLevel.setText(experienceLevel);
        tvMuscleGroup.setText(muscleGroup);

        // Set click listeners for databaseView and settingsView to navigate through screens
        ImageView databaseView = findViewById(R.id.databaseView);
        ImageView settingsView = findViewById(R.id.settingsView);
        databaseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the target activity
                Intent intent = new Intent(ProfileActivity.this, WorkoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent); // Start the activity
            }
        });
        settingsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the target activity
                Intent intent = new Intent(ProfileActivity.this, SetupActivity.class);
                startActivity(intent); // Start the activity
            }
        });
    }
}
