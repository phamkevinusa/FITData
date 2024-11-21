package com.example.fitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_activity);


        ImageView backView = findViewById(R.id.backView);


        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the target activity (replace 'AnotherActivity' with the actual one)
                Intent intent = new Intent(SetupActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}