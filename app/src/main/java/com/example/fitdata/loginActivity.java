// Main2BackendActivity.java
package com.example.fitdata;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    // Hardcoded credentials
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize views
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
        loginButton = findViewById(R.id.login_button);

        // Set up login button logic
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (isUserValid(username, password)) {
                    // If credentials match, go to MainActivity
                    Intent intent = new Intent(loginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Show toast for incorrect credentials
                    Toast.makeText(loginActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to check if the username and password are correct
    private boolean isUserValid(String username, String password) {
        return CORRECT_USERNAME.equals(username) && CORRECT_PASSWORD.equals(password);
    }
}