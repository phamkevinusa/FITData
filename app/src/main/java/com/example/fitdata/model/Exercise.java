package com.example.fitdata.model;

public class Exercise {

    private String name;
    private String description;
    private int difficulty;
    private String img;
    private int sets;
    private int repetitions;


    public Exercise (String name, String description, int difficulty, String img, int sets, int repetitions) {
        this.name = name;
        this.description = description;
        this.difficulty = difficulty;
        this.img = img;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public String getImg() {
        return this.img;
    }

    public int getSets() {
        return this.sets;
    }

    public int getRepetitions() {
        return this.repetitions;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDifficulty(String difficulty) {
        this.name = difficulty;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

}
