package com.example.fitdata.controller;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.util.Log;

import com.example.fitdata.WorkoutActivity;
import com.example.fitdata.model.Exercise;
import com.example.fitdata.model.Workout;
import com.example.fitdata.model.WorkoutLibrary;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class RequestController {
    private static RequestController instance;
    private WorkoutLibrary lib = new WorkoutLibrary("Library");;
    private int curLibraryIndex = 0;
    private Context context;

    // Private constructor with context (WorkoutActivity)
    private RequestController(Context context) {
        this.context = context;
//        lib = new WorkoutLibrary("Library"); // Initialize the WorkoutLibrary
    }

    // Singleton pattern for accessing the RequestController instance
    public static RequestController getInstance(Context context) {
        if (instance == null) {
            instance = new RequestController(context);
        }
        return instance;
    }

    public void fetchWorkoutsFromServer() {
        String url = "https://mental-shaylynn-cucumbershavings-af8874e9.koyeb.app/exercises/exercises";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Failed to fetch data: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    Log.d(TAG, "Fetched data: " + responseData);
                    parseAndDisplayWorkouts(responseData);
                } else {
                    Log.e(TAG, "Server responded with code: " + response.code());
                }
            }
        });
    }

    private void parseAndDisplayWorkouts(String jsonData) {
        // Parse JSON and add data to the model
        try {
            JSONObject rootObject = new JSONObject(jsonData);
            JSONArray contentArray = rootObject.getJSONArray("content");

            // Ensure that lib (WorkoutLibrary) is not null
            if (lib == null) {
                Log.e(TAG, "Workout Library is null!");
                return;
            }

            Workout workout = new Workout("Upper Body", "Mon, Wed");

            for (int i = 0; i < contentArray.length(); i++) {
                JSONObject exerciseObj = contentArray.getJSONObject(i);
                String exerciseName = exerciseObj.getString("name");
                String description = exerciseObj.getString("description");
                int difficulty = exerciseObj.getInt("difficulty");

                Exercise exercise = new Exercise(exerciseName, description, difficulty, "img", 3, 10);
                workout.addExercise(exercise);
                // After every 6 exercises, add the workout to the library and reset
                if ((i + 1) % 6 == 0 || i == contentArray.length() - 1) {
                    lib.addWorkout(workout);
                    Log.d(TAG, "Workout added with " + workout.getWorkout().size() + " exercises.");

                    if(lib.getLibrary().size() == 1) {
                        workout = new Workout("Lower Body", "Tue, Thur");  // Start a new workout for the next set

                    } else if (lib.getLibrary().size() == 2) {
                        workout = new Workout("Arms", "Fri, Sat");  // Start a new workout for the next set
                    }
                }
            }

            // After fetching workouts, update the UI
            if (context instanceof WorkoutActivity) {
                WorkoutActivity activity = (WorkoutActivity) context;
                // Ensure loadWorkout is executed on the main thread
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.loadWorkout(lib.getLibrary().get(0));  // Assuming loadWorkout method exists
                    }
                });
            }

        } catch (Exception e) {
            Log.e(TAG, "Failed to parse JSON: " + e.getMessage());
        }
    }

    public void prevWorkout() {


        if (lib != null && lib.getLibrary() != null) {

            curLibraryIndex--;

            if (curLibraryIndex < 0) {
                curLibraryIndex = lib.getLibrary().size() - 1;
            }

            // Update the View with the new workout
            if (context instanceof WorkoutActivity) {
                WorkoutActivity activity = (WorkoutActivity) context;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.loadWorkout(lib.getLibrary().get(curLibraryIndex));  // Assuming loadWorkout method exists
                    }
                });
            }
        }
    }

    public void nextWorkout() {
        if (lib != null && lib.getLibrary() != null) {

            curLibraryIndex++;

            if (curLibraryIndex >= lib.getLibrary().size()) {
                curLibraryIndex = 0;
            }

            // Update the View with the new workout
            if (context instanceof WorkoutActivity) {
                WorkoutActivity activity = (WorkoutActivity) context;

                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        activity.loadWorkout(lib.getLibrary().get(curLibraryIndex));  // Assuming loadWorkout method exists
                    }
                });

            }
        }
    }
}