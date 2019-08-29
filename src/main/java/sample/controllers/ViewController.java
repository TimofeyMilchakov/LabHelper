package sample.controllers;

import javafx.scene.control.Alert;

public interface ViewController {
    default void viewErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Предупреждение");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
