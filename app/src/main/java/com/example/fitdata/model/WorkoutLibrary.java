package com.example.fitdata.model;

import java.util.ArrayList;

public class WorkoutLibrary {

    private String name;
    private ArrayList<Workout> workoutLibray;

    public WorkoutLibrary (String Name) {
        this.name = name;
        workoutLibray = new ArrayList<Workout>();
    }

    public void addWorkout(Workout workout) {
        workoutLibray.add(workout);
    }

    public ArrayList<Workout> getLibrary() {
        return workoutLibray;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return this.name;
    }
}
