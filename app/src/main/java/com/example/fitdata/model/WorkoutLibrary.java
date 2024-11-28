package com.example.fitdata.model;

import java.util.ArrayList;

public class WorkoutLibrary {

    private String name;
    private ArrayList<Workout> workoutLibrary;

    public WorkoutLibrary (String name) {
        this.name = name;
        workoutLibrary = new ArrayList<Workout>();
    }

    public void addWorkout(Workout workout) {
        workoutLibrary.add(workout);
    }

    public ArrayList<Workout> getLibrary() {
        return workoutLibrary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
