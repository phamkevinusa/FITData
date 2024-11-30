package com.example.fitdata.model;

import android.util.Log;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;


/**
 * This class is responsible for fetching workout data from a server.
 *
 * @author Jose Jimenez
 */
public class FetchService {
    private static final String TAG = "WorkoutFetchService";

    // The URL of the server to fetch workout data from.
    private static final String URL = "https://mental-shaylynn-cucumbershavings-af8874e9.koyeb.app/exercises/exercises";


    // Callback interface for handling the fetch result.
    public interface FetchCallback {
        void onSuccess(WorkoutLibrary workoutLibrary);
        void onError(String errorMessage);
    }

    /**
     * Fetches workout data from the server and invokes the callback with the result.
     * @param callback call back function
     */
    public void fetchWorkouts(FetchCallback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .get()
                .build();


        // Enqueues the request and handles the response.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Failed to fetch data: " + e.getMessage());
                callback.onError("Failed to fetch data: " + e.getMessage());
            }

            /**
             * Check if the response was successful or if it failed
             *
             * @param call the call that was made
             * @param response the response that the call got
             */
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    try {
                        String responseData = response.body().string();
                        WorkoutLibrary library = parseWorkouts(responseData);
                        callback.onSuccess(library);
                    } catch (Exception e) {
                        Log.e(TAG, "Failed to parse JSON: " + e.getMessage());
                        callback.onError("Failed to parse JSON: " + e.getMessage());
                    }
                } else {
                    Log.e(TAG, "Server responded with code: " + response.code());
                    callback.onError("Server error: " + response.code());
                }
            }
        });
    }

    /**
     * Parses the JSON data and creates a WorkoutLibrary object.
     * @param jsonData the JSON data to parse
     * @return Library we return a library object that contains all the workouts and exercises.
     */
    private WorkoutLibrary parseWorkouts(String jsonData) throws Exception {
        JSONObject rootObject = new JSONObject(jsonData);
        JSONArray contentArray = rootObject.getJSONArray("content");

        // Initialize the first workout
        WorkoutLibrary library = new WorkoutLibrary("Library");
        Workout workout = new Workout("Upper Body", "Mon, Wed");

        for (int i = 0; i < contentArray.length(); i++) {
            // Get the data from the obj
            JSONObject exerciseObj = contentArray.getJSONObject(i);
            String exerciseName = exerciseObj.getString("name");
            String description = exerciseObj.getString("description");
            int difficulty = exerciseObj.getInt("difficulty");

            Exercise exercise = new Exercise(exerciseName, description, difficulty, "img", 3, 10);
            workout.addExercise(exercise);

            // This for loop checks if we have added 6 exercises to the workout. If so, we add the workout to the library and create a new workout.
            if ((i + 1) % 6 == 0 || i == contentArray.length() - 1) {
                library.addWorkout(workout);

                if (library.getLibrary().size() == 1) {
                    workout = new Workout("Lower Body", "Tue, Thur");
                } else if (library.getLibrary().size() == 2) {
                    workout = new Workout("Arms", "Fri, Sat");
                }
            }
        }
        return library;
    }
}
