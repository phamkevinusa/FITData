package com.example.fitdata.model;

import java.util.ArrayList;

public class Workout {

    private String name;
    private ArrayList<Exercise> Exercises;
    private String days;

    public Workout (String name, String days) {
        this.name = name;
        this.days = days;
        Exercises = new ArrayList<Exercise>();
    }


    public void addExercise(Exercise exercise) {
        Exercises.add(exercise);
    }

    public ArrayList<Exercise> getWorkout() {
        return Exercises;
    }

    public String getName() {
        return this.name;
    }

    public String getDays() {
        return this.days;
    }

    public void setName() {
        this.name = name;
    }

    public void setDays() {
        this.days = days;
    }

}
