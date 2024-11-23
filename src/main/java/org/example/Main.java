package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AlunoGUI.fxml"))));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}