package com.example.todoapp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private String description;

    public Task(String description) {
        this.description = description;

    }

    public Task(){}//no arg constructor for JSON objects

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
