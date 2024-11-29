package com.example.fitdata.model;

import java.util.ArrayList;

/**
 * This class is responsible for creating workouts. Which are made of a list of exercises.
 *
 * @author Jose Jimenez
 */
public class Workout {

    private String name;
    private ArrayList<Exercise> Exercises;
    private String days;

    /**
     * Constructor for Workout.
     *
     * @param name of the workout
     * @param days to apply the workout
     */
    public Workout (String name, String days) {
        this.name = name;
        this.days = days;
        Exercises = new ArrayList<Exercise>();
    }


    /**
     * Adds an exercise to the workout.
     *
     * @param exercise to add to the workout
     */
    public void addExercise(Exercise exercise) {
        Exercises.add(exercise);
    }

    /**
     * Getter for the list of exercises.
     *
     * @return Exercises a list of exercises
     */
    public ArrayList<Exercise> getWorkout() {
        return Exercises;
    }

    /**
     * Getter for the name of the workout.
     *
     * @return name name of the workout
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the days of the workout.
     *
     * @return days days of the workout
     */
    public String getDays() {
        return this.days;
    }

    /**
     * Setter for the name of the workout.
     *
     * @param name new name of the workout
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for the days of the workout.
     *
     * @param days new days of the workout
     */
    public void setDays( String days) {
        this.days = days;
    }

    /**
     * Setter for the list of exercises.
     *
     * @param Exercises new list of exercises
     */
    public void getWorkout(ArrayList<Exercise> Exercises) {
        this.Exercises = Exercises;
    }


}
