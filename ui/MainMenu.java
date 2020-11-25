package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import actions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


/**
 * A class which represents the main menu of an encounter tracker,
 * @author Connor Henderson (chenderson1190@gmail.com)
 */
public class MainMenu extends Application {
    
    public static void main(String[] args) {
        Application.launch(MainMenu.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_mainmenu.fxml"));

        stage.setTitle("5e Encounter Tracker");
        stage.setScene(new Scene(root));
        stage.show();
    }
    
}
