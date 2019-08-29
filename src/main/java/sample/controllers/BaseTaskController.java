package sample.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import sample.validators.ValueValidator;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseTaskController extends ValueValidator implements Initializable, ControllerClear {

    private static List<String> result;

    public BaseTaskController(String id) {
        MainController.registerBean(id, this);
    }

    protected int getInt(TextField f) {
        return Integer.valueOf(f.getText());
    }

    public static List<String> getResult() {
        return result == null ? new LinkedList<>() : new LinkedList<>(result);
    }

    protected void setResult(List<String> res) {
        result = new LinkedList<>(res);
    }

    @Override
    public void inactive() {
        setResult(Collections.EMPTY_LIST);
    }
}
