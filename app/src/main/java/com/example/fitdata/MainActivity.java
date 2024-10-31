package com.example.fitdata;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fitdata.model.Exercise;
import com.example.fitdata.model.Workout;
import com.example.fitdata.model.WorkoutLibrary;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private WorkoutLibrary lib;
    int curLibraryIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //for testing purposes
        Workout workout1 = new Workout("Leg Day", "Monday, Wednesday");
        workout1.addExercise(new Exercise("Squats", "Put weight on your shoulders and bring your butt down", "Medium", "img", 4, 10));
        workout1.addExercise(new Exercise("Lunges", "Step forward and lower your body", "Hard", "img", 3, 12));
        workout1.addExercise(new Exercise("hey", "Step forward and lower your body", "easy", "img", 3, 12));

        Workout workout2 = new Workout("Arm Day", "Monday, Wednesday");
        workout2.addExercise(new Exercise("Arm Curls", "Put weight on your shoulders and bring your butt down", "Medium", "img", 4, 10));
        workout2.addExercise(new Exercise("Triceps", "Step forward and lower your body", "Hard", "img", 3, 12));
        workout2.addExercise(new Exercise("Triceps Dips", "Step forward and lower your body", "easy", "img", 3, 12));
        workout2.addExercise(new Exercise("Triceps Dips", "Step forward and lower your body", "easy", "img", 3, 12));

        Workout workout3 = new Workout("Hello Day", "Monday, Tuesday, Wednesday");
        workout3.addExercise(new Exercise("Arm Curls", "Put weight on your shoulders and bring your butt down", "Medium", "img", 4, 10));
        workout3.addExercise(new Exercise("Triceps", "Step forward and lower your body", "Hard", "img", 3, 12));
        workout3.addExercise(new Exercise("Triceps Dips", "Step forward and lower your body", "easy", "img", 3, 12));
        workout3.addExercise(new Exercise("Triceps Dips", "Step forward and lower your body", "easy", "img", 3, 12));


        lib = new WorkoutLibrary("Bulking");
        lib.addWorkout(workout1);
        lib.addWorkout(workout2);
        lib.addWorkout(workout3);

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

           });

        //load the first workout
        loadWorkout(curLibraryIndex);

        Button prev, next;

        prev = findViewById(R.id.prevBtn);
        next = findViewById(R.id.nextBtn);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevWorkout(curLibraryIndex);
                String message = "prev Index: " + curLibraryIndex;
                Log.v(TAG, "prev Index: " + curLibraryIndex);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextWorkout(curLibraryIndex);
                Log.v(TAG, "next Index: " + curLibraryIndex);
            }
        });

    }


// figure out the prev and the next button ----------------------------------------------------------------
    public void prevWorkout(int index) {

        if (curLibraryIndex <= 0) {
            curLibraryIndex = lib.getLibrary().size()-1;
        } else {
            curLibraryIndex -= 1;
        }

        loadWorkout(curLibraryIndex);
    }

    public void nextWorkout(int index) {

        if (curLibraryIndex >= lib.getLibrary().size()-1) {
            curLibraryIndex = 0;
        } else {
            curLibraryIndex += 1;
        }

        loadWorkout((curLibraryIndex));

    }

    public void loadWorkout(int index) {

        //get the library of all the workouts
        ArrayList<Workout> Library = lib.getLibrary();

        Workout workout = Library.get(index);

        //get the list of all the exercises of the workout
        ArrayList<Exercise> curWorkout = workout.getWorkout();

        LinearLayout layout = findViewById(R.id.exerciseBtns);

        //clear all the button that were on the screen before.
        layout.removeAllViews();

        //loop through all the exercises on the workout
        for (int i = 0; i < curWorkout.size(); i++) {
            // Get the exercise at position i
            Exercise exercise = curWorkout.get(i);

            // Display title of the workout
            TextView workoutName = findViewById(R.id.titleText);
            workoutName.setText(workout.getName());

            // Display days of workout
            TextView workoutDays = findViewById(R.id.daysText);
            workoutDays.setText(workout.getDays());

            // Create a new button and set its text to the exercise name and some styling
            Button btn = new Button(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, // Width
                    LinearLayout.LayoutParams.WRAP_CONTENT  // Height
            );

            params.setMargins(0, 0, 0, 50);
            btn.setText(exercise.getName());

            // Set btn color according to its difficulty.
            if (exercise.getDifficulty().equalsIgnoreCase("hard")) {

                btn.setBackgroundResource(R.color.red);

            } else if (exercise.getDifficulty().equalsIgnoreCase("medium")) {

                btn.setBackgroundResource(R.color.yellow);

            } else if (exercise.getDifficulty().equalsIgnoreCase("easy")){

                btn.setBackgroundResource(R.color.green);

            }

            // Add the button to the layout
            layout.addView(btn, params);

            // Set OnClickListener for the button
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show a toast when the button is clicked
                    Toast.makeText(v.getContext(), "It works: " + exercise.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    // make the login button work and move to the next activity_main.xml screen
    // when the app opens, it needs to go to the login screen
}