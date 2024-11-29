package com.example.fitdata.controller;

import android.content.Context;
import android.util.Log;

import com.example.fitdata.WorkoutActivity;
import com.example.fitdata.model.WorkoutLibrary;
import com.example.fitdata.model.FetchService;

/**
 * This class is responsible for controlling the WorkoutActivity.
 *
 * @ author Jose Jimenez
 */
public class WorkoutActivityController {
    private static final String TAG = "WorkoutActivityController";
    private static WorkoutActivityController instance;

    private WorkoutLibrary lib;
    private int curLibraryIndex = 0;
    private Context context;
    private FetchService fetchService;

    /**
     * Constructor for WorkoutActivityController.
     * @param context received the context for the activity (WorkoutActivity)
     */
    private WorkoutActivityController(Context context) {
        this.context = context;
        this.lib = new WorkoutLibrary("Library");
        this.fetchService = new FetchService();
    }

    /**
     * Gets the instance of the WorkoutActivityController.
     * @param context received the context for the activity (WorkoutActivity)
     * @return instance of the controller
     */
    public static WorkoutActivityController getInstance(Context context) {
        if (instance == null) {
            instance = new WorkoutActivityController(context);
        }
        return instance;
    }

    /**
     * This function calls fetchWorkoutsFromServer() to fetch workouts from the server.
     * Afterwards, it loads the first workout into the WorkoutActivity.
     */
    public void fetchWorkoutsFromServer() {
        fetchService.fetchWorkouts(new FetchService.FetchCallback() {
            @Override
            public void onSuccess(WorkoutLibrary workoutLibrary) {
                lib = workoutLibrary;

                if (context instanceof WorkoutActivity) {
                    WorkoutActivity activity = (WorkoutActivity) context;
                    activity.runOnUiThread(() -> activity.loadWorkout(lib.getLibrary().get(0)));
                }
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, "Error fetching workouts: " + errorMessage);
            }
        });
    }

    /**
     * This function loads the previous workout into the WorkoutActivity.
     */
    public void prevWorkout() {
        if (lib != null && lib.getLibrary() != null) {
            curLibraryIndex--;
            if (curLibraryIndex < 0) {
                curLibraryIndex = lib.getLibrary().size() - 1;
            }

            if (context instanceof WorkoutActivity) {
                WorkoutActivity activity = (WorkoutActivity) context;
                activity.runOnUiThread(() -> activity.loadWorkout(lib.getLibrary().get(curLibraryIndex)));
            }
        }
    }

    /**
     * This function loads the next workout into the WorkoutActivity.
     */
    public void nextWorkout() {
        if (lib != null && lib.getLibrary() != null) {
            curLibraryIndex++;
            if (curLibraryIndex >= lib.getLibrary().size()) {
                curLibraryIndex = 0;
            }

            if (context instanceof WorkoutActivity) {
                WorkoutActivity activity = (WorkoutActivity) context;
                activity.runOnUiThread(() -> activity.loadWorkout(lib.getLibrary().get(curLibraryIndex)));
            }
        }
    }
}
