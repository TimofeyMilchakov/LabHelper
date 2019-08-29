package sample.validators;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public abstract class ValueValidator {

    protected boolean validateDouble(TextField field) {
        if (field == null) {
            return false;
        }
        String s = field.getText();
        try {
            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean validateRange(TextField field, Double start, Double finish) {
        if (validateDouble(field)) {
            Double val = Double.valueOf(field.getText());
            if (start != null && start > val) {
                return false;
            }
            return finish == null || finish >= val;
        }
        return false;
    }



}
