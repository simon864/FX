package org.example.javalab5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private Button switchButton;

    private boolean isForward = true;

    @FXML
    public void initialize() {
        switchButton.setOnAction(event -> switchText());
    }

    private void switchText() {
        if (isForward) {
            textField2.setText(textField1.getText());
            textField1.clear();
            switchButton.setText("<-");
        } else {
            textField1.setText(textField2.getText());
            textField2.clear();
            switchButton.setText("->");
        }
        isForward = !isForward;
    }
}