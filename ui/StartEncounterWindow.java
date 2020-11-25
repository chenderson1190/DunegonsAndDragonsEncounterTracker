package ui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import actions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class StartEncounterWindow {
    @FXML private Button finishedButton; 
    @FXML private TextField name;
    @FXML private TextField initiative;
    private Encounter encounter;

    @FXML protected void handleSubmitButton(ActionEvent event){
        encounter = new Encounter();
        String nameString = name.getText();
        int initiativeInt = Integer.parseInt(initiative.getText());

        name.clear();
        initiative.clear();
        encounter.add(nameString, initiativeInt);
    }
    
    @FXML protected void handleFinishedButton(ActionEvent event) throws Exception{
        Stage newEncounterStage = (Stage) finishedButton.getScene().getWindow();
        Stage stage = new Stage();
        Parent encounterWindow = FXMLLoader.load(getClass().getResource("fxml_encounter.fxml"));
        Scene scene = new Scene(encounterWindow);

        newEncounterStage.close();
        stage.setScene(scene);
        stage.show();
    }

    public Encounter getEncounter(){
        return this.encounter;
    }

}
