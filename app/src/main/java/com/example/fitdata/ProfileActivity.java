package com.example.fitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);


        ImageView databaseView = findViewById(R.id.databaseView);
        ImageView settingsView = findViewById(R.id.settingsView);


        databaseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the target activity (replace 'AnotherActivity' with the actual one)
                Intent intent = new Intent(ProfileActivity.this, WorkoutActivity.class);
                startActivity(intent); // Start the activity
            }
        });
        settingsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the target activity (replace 'AnotherActivity' with the actual one)
                Intent intent = new Intent(ProfileActivity.this, SetupActivity.class);
                startActivity(intent); // Start the activity
            }
        });
    }
}
