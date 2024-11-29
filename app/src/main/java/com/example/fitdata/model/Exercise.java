package com.example.fitdata.model;

/**
 * This class is responsible for creating exercises.
 *
 * @author Jose Jimenez
 */
public class Exercise {

    private String name;
    private String description;
    private int difficulty;
    private String img;
    private int sets;
    private int repetitions;

    /**
     * Constructor for Exercise.
     *
     * @param name name of exercise
     * @param description description of how to do the exercise
     * @param difficulty how hard is to execute the exercise
     * @param img possible image for the exercise
     * @param sets number of sets for the exercise
     * @param repetitions number of repetitions for the exercise
     */
    public Exercise (String name, String description, int difficulty, String img, int sets, int repetitions) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.img = img;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    /**
     * Getter for name
     *
     * @return name name of exercise
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for description
     *
     * @return the description of the exercise
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Getter for difficulty
     *
     * @return the difficulty of the exercise
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * Getter for img
     *
     * @return the image of the exercise
     */
    public String getImg() {
        return this.img;
    }

    /**
     * Getter for sets
     *
     * @return the sets for the exercise
     */
    public int getSets() {
        return this.sets;
    }

    /**
     * Getter for repetitions
     *
     * @return the repetitions for the exercise
     */
    public int getRepetitions() {
        return this.repetitions;
    }

    /**
     * Setter for name
     *
     * @param name new name of exercise
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for description
     *
     * @param description new description of exercise
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter for difficulty
     *
     * @param difficulty new difficulty of exercise
     */
    public void setDifficulty(String difficulty) {
        this.name = difficulty;
    }

    /**
     * Setter for img
     *
     * @param img new name of exercise
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * Setter for sets
     *
     * @param sets new number of sets for exercise
     */
    public void setSets(int sets) {
        this.sets = sets;
    }

    /**
     * Setter for repetitions
     *
     * @param repetitions new number of repetitions for exercise
     */
    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

}
