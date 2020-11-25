package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collection;
import actions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import java.net.URL;
import javafx.scene.Node;
import java.util.ArrayList;

public class EncounterHandler {
    //private VBox charSubContainer;
    //private HBox actionContainer;
    private ArrayList<Button> buttons = new ArrayList<Button>();
    private int turnCounter = 1;
    private Stage addCharStage = new Stage();
    private Encounter encounter;
    @FXML private Text turnTracker;
    @FXML private VBox characterContainer;
    

    @FXML protected void handleNextTurnButton(ActionEvent event){
        turnCounter++;
        turnTracker.setText("Turn " + turnCounter);
        for(Button b : buttons){
            b.setDisable(false);
        }
    }

    @FXML protected void handleAddToInitButtton(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fxml_addcharactermenu.fxml"));

        addCharStage.setTitle("5e Encounter Tracker");
        addCharStage.setScene(new Scene(root));
        addCharStage.showAndWait();
        initialize();
    }
    
    public void initialize(){
        encounter = LoadEncounter.loadEncounter();
        characterContainer.getChildren().clear();
        Collection<String> nameList = encounter.getInitiativeOrder().values();
        for(String i : nameList) {
            VBox charSubContainer = new VBox(10);
            //charSubContainer = new VBox(10);
            Label actionLabel = new Label(i + "'s actions:");
            HBox actionContainer = new HBox(10);
            Button attackButton = new Button("Attack");
            Button reactionButton = new Button("Reaction");
            Button moveButton = new Button("Move");
            Button bonusButton = new Button("Bonus");

            attackButton.setOnAction((event) -> {
                attackButton.setDisable(true);
            });
            reactionButton.setOnAction((event) -> {
                reactionButton.setDisable(true);
            });
            moveButton.setOnAction((event) -> {
                moveButton.setDisable(true);
            });
            bonusButton.setOnAction((event) -> {
                bonusButton.setDisable(true);
            });

            buttons.add(attackButton);
            buttons.add(reactionButton);
            buttons.add(moveButton);
            buttons.add(bonusButton);
            actionContainer.getChildren().addAll(attackButton, reactionButton, moveButton, bonusButton);
            charSubContainer.getChildren().addAll(actionLabel, actionContainer);
            characterContainer.getChildren().add(charSubContainer);
        }
    }

    public void start(Stage stage){
        LoadEncounter load = new LoadEncounter();
        Encounter encounter = load.loadEncounter();
        Button nextTurnButton = new Button("Next Turn");
        Button addCharacterButton = new Button("Add a Character\nto the Initiative Order");
        Label turnLabel = new Label("Turn " + turnCounter);
        VBox mainColumn = new VBox(10);
        Pane pane = new Pane(mainColumn);
        

        addCharacterButton.setOnAction((event) -> {
            TextField characterName = new TextField("Character Name");
            TextField initiativeValue = new TextField("Initiative");
            Button addButton = new Button("Add and close");
            HBox mainBox = new HBox(10);
            VBox mainColumn1 = new VBox(10);
            Stage stage1 = new Stage();

            mainBox.getChildren().addAll(characterName, initiativeValue);
            mainColumn1.getChildren().addAll(mainBox, addButton);
            stage1.setScene(new Scene(mainColumn1));
            stage1.show();
            addButton.setOnAction((event1) -> {
                SaveEncounter save = new SaveEncounter();
                encounter.add(characterName.getText(), Integer.parseInt(initiativeValue.getText()));
                save.saveEncounter(encounter);
                stage1.close();
                start(stage);
            });

        });

        mainColumn.getChildren().add(turnLabel);


        mainColumn.getChildren().add(new HBox(nextTurnButton, addCharacterButton));
        stage.setScene(new Scene(pane));
        stage.setTitle("Fight!");
        stage.show();
    }

    private static Button setButton(Button button){
        button.setOnAction((event) -> {
            button.setDisable(true);
        });
        return button;
    }

}

