package com.example.fitdata.model;

import java.util.ArrayList;

/**
 * This class is responsible for creating libraries of workouts.
 *
 * @author Jose Jimenez
 */
public class WorkoutLibrary {

    private String name;
    private ArrayList<Workout> workoutLibrary;

    /**
     * Constructor for WorkoutLibrary.
     *
     * @param name name of the library
     */
    public WorkoutLibrary (String name) {
        this.name = name;
        workoutLibrary = new ArrayList<Workout>();
    }

    /**
     * Adds a workout to the library.
     *
     * @param workout to add to the library
     */
    public void addWorkout(Workout workout) {
        workoutLibrary.add(workout);
    }

    /**
     * Getter for the list of workouts.
     *
     * @return workoutLibrary a list of workouts
     */
    public ArrayList<Workout> getLibrary() {
        return workoutLibrary;
    }

    /**
     * Getter for the name of the library.
     *
     * @return name name of the library
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter for the name of the library.
     *
     * @param name new name of the library
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the list of workouts.\
     *
     * @param workoutLibrary new list of workouts
     */
    public void setLibrary(ArrayList<Workout> workoutLibrary) {
        this.workoutLibrary = workoutLibrary;
    }
}
