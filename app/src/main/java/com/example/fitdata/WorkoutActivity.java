package com.example.fitdata;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitdata.controller.WorkoutActivityController;
import com.example.fitdata.model.Exercise;
import com.example.fitdata.model.Workout;
import com.example.fitdata.model.WorkoutLibrary;

import java.util.ArrayList;

/**
 * This class is responsible for displaying workouts in the WorkoutActivity.
 * @author Jose Jimenez
 */
public class WorkoutActivity extends AppCompatActivity {

    private WorkoutLibrary lib;
    int curLibraryIndex = 0;
    private WorkoutActivityController requestController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.workout_activity);

        // Initialize RequestController with the current context
        requestController = WorkoutActivityController.getInstance(this);  // Pass context here

        Button prev, next;
        prev = findViewById(R.id.prevBtn);
        next = findViewById(R.id.nextBtn);

        // Set OnClickListener for the previous and next buttons.

        prev.setOnClickListener(v -> {
            requestController.prevWorkout();  // Use the controller to handle previous workout
            Log.v(TAG, "prev Index: " + curLibraryIndex);
        });

        next.setOnClickListener(v -> {
            requestController.nextWorkout();  // Use the controller to handle next workout
            Log.v(TAG, "next Index: " + curLibraryIndex);
        });

        // Trying to make functionality of profile button redirecting to the profile activity
        ImageView imageViewArms = findViewById(R.id.imageView2);
        imageViewArms.setOnClickListener(v -> {
            Intent intent = new Intent(WorkoutActivity.this, ProfileActivity.class);
            startActivity(intent);
        });


        // Fetch workouts from the server using the controller.
        requestController.fetchWorkoutsFromServer();  // Use controller to fetch workouts

    }

    /**
     * This function loads the workout into the WorkoutActivity and displays it.
     * @param Workout a list of exercises that make up the workout
     */
    public void loadWorkout(Workout Workout) {


        Workout workout = Workout;

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
            if (exercise.getDifficulty() >= 8) {

                btn.setBackgroundResource(R.color.red);

            } else if (exercise.getDifficulty() >= 4) {

                btn.setBackgroundResource(R.color.yellow);

            } else if (exercise.getDifficulty() >= 1){

                btn.setBackgroundResource(R.color.green);

            }

            // Add the button to the layout
            layout.addView(btn, params);

            // Set OnClickListener for the button
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Show a toast when the button is clicked
                    Intent intent = new Intent(WorkoutActivity.this, ExerciseDescription.class);

                    // Passing Exercise data to ExerciseDescription
                    intent.putExtra("exerciseName", exercise.getName());
                    intent.putExtra("exerciseDifficulty", exercise.getDifficulty());
                    intent.putExtra("exerciseDescription", exercise.getDescription());
                    intent.putExtra("exerciseSets", exercise.getSets());
                    intent.putExtra("exerciseReps", exercise.getRepetitions());

                    // start the activity
                    startActivity(intent);
                }
            });
        }
    }
}