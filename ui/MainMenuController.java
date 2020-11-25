package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class MainMenuController {
    @FXML private Button newEncounterButton; 

    @FXML protected void handleNewEncounterButton(ActionEvent event) throws Exception{
        Stage menuStage = (Stage) newEncounterButton.getScene().getWindow();
        Stage stage = new Stage();
        Parent startWindow = FXMLLoader.load(getClass().getResource("fxml_startencounter.fxml"));
        Scene scene = new Scene(startWindow);

        menuStage.close();
        stage.setScene(scene);
        stage.show();

    }

    @FXML protected void handleLoadLastButton(ActionEvent event) throws Exception{
        Stage menuStage = (Stage) newEncounterButton.getScene().getWindow();
        Stage stage = new Stage();
        Parent startWindow = FXMLLoader.load(getClass().getResource("fxml_encounter.fxml"));
        Scene scene = new Scene(startWindow);

        menuStage.close();
        stage.setScene(scene);
        stage.show();
    }
}