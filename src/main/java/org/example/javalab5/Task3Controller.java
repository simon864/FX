package org.example.javalab5;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.geometry.Insets;

import java.util.HashMap;
import java.util.Map;

public class Task3Controller {

    @FXML
    private CheckBox pizzaCheckBox;
    @FXML
    private Spinner<Integer> pizzaSpinner;
    @FXML
    private CheckBox burgerCheckBox;
    @FXML
    private Spinner<Integer> burgerSpinner;
    @FXML
    private CheckBox sushiCheckBox;
    @FXML
    private Spinner<Integer> sushiSpinner;
    @FXML
    private Label resultLabel;

    @FXML
    public void generateCheck() {
        Map<String, Integer> order = new HashMap<>();

        if (pizzaCheckBox.isSelected()) {
            order.put("Пицца", pizzaSpinner.getValue() * 300);
        }
        if (burgerCheckBox.isSelected()) {
            order.put("Бургер", burgerSpinner.getValue() * 250);
        }
        if (sushiCheckBox.isSelected()) {
            order.put("Суши", sushiSpinner.getValue() * 400);
        }
        int total = order.values().stream().reduce(0, Integer::sum);

        StringBuilder checkText = new StringBuilder("Чек:\n");
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            checkText.append(entry.getKey()).append(" - ").append(entry.getValue()).append(" руб.\n");
        }
        checkText.append("\nИтого: ").append(total).append(" руб.");

        showModalWindow(checkText.toString());
    }
    private void showModalWindow(String text) {
        Label label = new Label(text);
        VBox layout = new VBox(20,label);
        layout.setPadding(new Insets(10));

        Scene scene = new Scene(layout);
        Stage modalStage = new Stage();
        modalStage.setTitle("Чек заказа");
        modalStage.setScene(scene);
        modalStage.showAndWait();
    }
}