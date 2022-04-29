package com.example.todoapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ApplicationController {
    @FXML
    Button addTaskButton = new Button();
    @FXML
    ListView tasksListView = new ListView();
    @FXML
    TextField descriptionTextField = new TextField();
    @FXML
    Button loadButton = new Button();

    TaskManager taskManager;

    public ApplicationController() {
        taskManager = new TaskManager();
        loadTasksOnStartup();
    }

    @FXML
    public void addTask(){
        if(!loadButton.isDisabled()){
            loadTasksOnStartup();
        }
        if(descriptionTextField.getText()!=""){
            taskManager.createTask(descriptionTextField.getText());
            descriptionTextField.clear();
            addToTasksListView(taskManager.getTasks().get(taskManager.getTasks().size()-1));
            taskManager.saveToJson();
        }
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

    public void loadTasksOnStartup(){
        taskManager.loadFromJson();
        for(Task task: taskManager.getTasks()){
            addToTasksListView(task);
        }
        loadButton.setDisable(true);
        loadButton.setVisible(false);
    }
}