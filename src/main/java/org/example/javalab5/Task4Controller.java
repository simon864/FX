package org.example.javalab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Task4Controller {

    @FXML
    private TextField num1Field;
    @FXML
    private TextField num2Field;
    @FXML
    private Label resultLabel;

    @FXML
    public void add() {
        calculate((a, b) -> a + b);
    }

    @FXML
    public void subtract() {
        calculate((a, b) -> a - b);
    }

    @FXML
    public void multiply() {
        calculate((a, b) -> a * b);
    }

    @FXML
    public void divide() {
        calculate((a, b) -> {
            if (b == 0) {
                showAlert("Ошибка", "Деление на ноль!");
                return null;
            }
            return a / b;
        });
    }

    private void calculate(CalculatorOperation operation) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());
            Double result = operation.calculate(num1, num2);

            if (result != null) {
                resultLabel.setText("Результат: " + String.format("%.2f", result));
            }
        } catch (NumberFormatException e) {
            showAlert("Ошибка", "Введите корректные числа!");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FunctionalInterface
    private interface CalculatorOperation {
        Double calculate(double a, double b);
    }
}