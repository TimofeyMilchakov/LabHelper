package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main extends Application {

    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setResources(ResourceBundle.getBundle("properties.title", Locale.ENGLISH));
        fxmlLoader.setCharset(Charset.forName("CP1251"));
        Parent root = fxmlLoader.load(getClass().getResource("view/MainWindow.fxml").openStream());
        primaryStage.setTitle("Лабораторная работа №1");
        primaryStage.setScene(new Scene(root, 800, 600));
        stage = primaryStage;
        primaryStage.show();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
