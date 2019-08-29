package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Pair;
import sample.solver.SolverLR1;

import java.net.URL;
import java.util.Map;
import java.util.Observable;
import java.util.ResourceBundle;

public class Task1Controller extends BaseTaskController implements ViewController {

    public Task1Controller() {
        super("t1");
    }

    public TableView<SolverLR1.LR1Result> tableView;
    private static final String ERROR_INVALIDATE_VALUE = "error.invalidate.value";
    public ProgressIndicator progressIndicator;
    public TableColumn valueColumnId;
    public TableColumn numberColumnId;
    ResourceBundle resources;
    public TextField b;
    public TextField t;
    public TextField m;


    public void onCalculate(ActionEvent actionEvent) {
        tableView.getItems().clear();
        tableView.refresh();
        if (!validateRange(b, 2d, 10d)) {
            viewErrorMessage(resources.getString(ERROR_INVALIDATE_VALUE).replace("{0}", "b"));
            return;
        }
        if (!validateRange(t, 1d, null)) {
            viewErrorMessage(resources.getString(ERROR_INVALIDATE_VALUE).replace("{0}", "t"));
            return;
        }
        if (!validateRange(m, 1d, null)) {
            viewErrorMessage(resources.getString(ERROR_INVALIDATE_VALUE).replace("{0}", "m"));
            return;
        }
        SolverLR1 s = new SolverLR1(getInt(b), getInt(t), getInt(m));
        s.calculate();
        valueColumnId.setCellValueFactory(new PropertyValueFactory<>("valueColumn"));
        numberColumnId.setCellValueFactory(new PropertyValueFactory<>("numberColumn"));
        setResult(s.getViewResultList());
        ObservableList res = FXCollections.observableArrayList(s.getTableResult());
        tableView.setItems(res);
        tableView.refresh();
    }

    @Override
    public void inactive() {
        super.inactive();
        tableView.getItems().clear();
        tableView.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
    }
}
