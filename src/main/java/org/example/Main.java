package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.dao.AlunoDao;
import org.example.model.Aluno;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class Main extends Application{

    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("AlunoGUI.fxml"))));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}