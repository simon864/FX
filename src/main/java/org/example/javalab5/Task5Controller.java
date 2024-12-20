package org.example.javalab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Task5Controller {
    @FXML
    private RadioButton red1, green1, blue1, white1;
    @FXML
    private RadioButton red2, green2, blue2, white2;
    @FXML
    private RadioButton red3, green3, blue3, white3;
    @FXML
    private Label flagLabel;
    @FXML
    private ToggleGroup group1, group2, group3;

    @FXML
    public void drawFlag() {
        String color1 = getSelectedColor(group1);
        String color2 = getSelectedColor(group2);
        String color3 = getSelectedColor(group3);

        if (color1 == null || color2 == null || color3 == null){
            showAlert("Ошибка", "Выберите цвет для каждой полосы!");
        }
        else {
            flagLabel.setText(color1 + ", " + color2 + ", " + color3);
        }

        Stage stage = (Stage) flagLabel.getScene().getWindow();
        stage.setResizable(false);

    }

    private String getSelectedColor(ToggleGroup group) {
        if (group.getSelectedToggle() == null) return null;
        return ((RadioButton) group.getSelectedToggle()).getText();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}