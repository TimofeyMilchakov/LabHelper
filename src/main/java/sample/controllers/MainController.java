package sample.controllers;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import sample.Main;
import sample.exception.NotResultException;
import sample.validators.ValueValidator;

import java.io.*;
import java.net.URL;
import java.util.*;

public class MainController implements Initializable, ViewController {
    private static String ERROR_NOT_RESULT = "error.not.result";
    private static String ERROR_UNKNOWN_ERROR = "error.unknown.error";
    private static Map<String, ControllerClear> beans = new HashMap<>();
    public VBox mainContent;
    public ToggleGroup menuEditPartSelector;
    private ResourceBundle bundle;

    public void onSettings(ActionEvent actionEvent) {
    }


    public void onPartChanged(ActionEvent actionEvent) {
        ObservableList<Node> l = mainContent.getChildren();
        for (ControllerClear c : beans.values()) {
            c.inactive();
        }
        String id = ((RadioMenuItem) actionEvent.getTarget()).getId().split("_")[1];
        for (Node n : l) {
            n.setVisible(false);
            if (n.getId().equals(id)) {
                n.setVisible(true);
            }
        }
    }

    public void onHelp(ActionEvent actionEvent) {
    }

    public void onAbout(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bundle = resources;
    }

    public void saveFile(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        File file = fileChooser.showSaveDialog(Main.getStage());
        List<String> result = BaseTaskController.getResult();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(file));
            if (result == null || result.isEmpty()) {
                throw new NotResultException();
            }
            for (String line : result) {
                writer.println(line);
            }

        } catch (NotResultException e) {
            viewErrorMessage(bundle.getString(ERROR_NOT_RESULT));
        } catch (Exception e) {
            viewErrorMessage(bundle.getString(ERROR_UNKNOWN_ERROR));
        } finally {
            writer.close();
        }
    }


    public void onExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public static void registerBean(String id, ControllerClear bean) {
        beans.put(id, bean);
    }
}
