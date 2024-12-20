package org.example.javalab5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Task2Controller {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private TextField textField;
    @FXML
    private CheckBox buttonCheckBox;
    @FXML
    private CheckBox labelCheckBox;
    @FXML
    private CheckBox textFieldCheckBox;

    @FXML
    public void initialize() {
        buttonCheckBox.setOnAction(e -> button.setVisible(!buttonCheckBox.isSelected()));
        labelCheckBox.setOnAction(e -> label.setVisible(!labelCheckBox.isSelected()));
        textFieldCheckBox.setOnAction(e -> textField.setVisible(!textFieldCheckBox.isSelected()));
    }
}