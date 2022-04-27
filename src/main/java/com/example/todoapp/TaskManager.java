package com.example.todoapp;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskManager {

    ArrayList<Task> tasks;
    ObjectMapper objectMapper;
    File file;
    public TaskManager(){
        file = new File("target\\tasks.json");
        tasks = new ArrayList<>();
        objectMapper = new ObjectMapper();
    }

    public void createTask(String description){
        tasks.add(new Task(description));
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void saveToJson(){
        try {
            objectMapper.writeValue(file, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
