package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class TodoController {
    @FXML
    private ListView<String> taskListView;
    @FXML
    private TextField newTaskField;
    @FXML
    private Button addButton;

    @FXML
    public void initialize(){

    }

    @FXML
    private void handleAddButtonAction(ActionEvent event){
        String task = newTaskField.getText();
        taskListView.getItems().add(task);
        newTaskField.clear();
    }

    @FXML
    private void handleDeleteButtonAction(ActionEvent event){
        final int selectedIndex = taskListView.getSelectionModel().getSelectedIndex();
        if(selectedIndex != -1){
            String itemToRemove = taskListView.getSelectionModel().getSelectedItem();
            // get the idx of the next item to set it to selected after the old one is removed
            final int newSelectedIndex = (selectedIndex == taskListView.getItems().size() - 1) ? selectedIndex - 1 : selectedIndex;
            taskListView.getItems().remove(selectedIndex);
            taskListView.getSelectionModel().select(newSelectedIndex);
        }

    }
}
