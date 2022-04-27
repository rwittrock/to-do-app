package com.example.todoapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ApplicationController {
    @FXML
    Button addTaskButton;
    @FXML
    ListView tasksListView;
    @FXML
    TextField descriptionTextField;

    TaskManager taskManager;
    public ApplicationController() {
        taskManager = new TaskManager();
    }

    @FXML
    public void addTask(){
        taskManager.createTask(descriptionTextField.getText());
        descriptionTextField.clear();
        addToTasksListView(taskManager.getTasks().get(taskManager.getTasks().size()-1));
        taskManager.saveToJson();
    }

    @FXML
    public void addToTasksListView(Task task){
        tasksListView.getItems().add(task.getDescription());
    }

    @FXML
    public void removeTaskFromListView(){
            int index = tasksListView.getSelectionModel().getSelectedIndex();
            if(index!=-1){
                tasksListView.getItems().remove(index);
                taskManager.getTasks().remove(index);
                taskManager.saveToJson();
            }

    }
}