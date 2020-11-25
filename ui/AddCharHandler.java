package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import actions.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class AddCharHandler {
    @FXML private TextField name;
    @FXML private TextField initiative;
    @FXML private Button finishedButton;
    private Encounter encounter = LoadEncounter.loadEncounter();


    @FXML protected void handleCharacterAddButton(ActionEvent event){
        String nameString = name.getText();
        int initiativeInt = Integer.parseInt(initiative.getText());

        name.clear();
        initiative.clear();
        encounter.add(nameString, initiativeInt);
        SaveEncounter.saveEncounter(encounter);
    }
    @FXML protected void handleFinishedButton(ActionEvent event){
        Stage addCharStage = (Stage) finishedButton.getScene().getWindow();
        addCharStage.close();
    }
    
}