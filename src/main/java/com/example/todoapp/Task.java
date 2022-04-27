package com.example.todoapp;

public class Task {
    private String description;
    private int ID;
    private static int IDCounter; //get from json file when opening

    public Task(String description) {
        this.description = description;
        this.ID = IDCounter;
        IDCounter++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getIDCounter() {
        return IDCounter;
    }

    public static void setIDCounter(int IDCounter) {
        Task.IDCounter = IDCounter;
    }
}
