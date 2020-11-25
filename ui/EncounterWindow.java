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


public class EncounterWindow extends Application {
    private int turnCounter = 1;
    public void start(Stage stage){
        LoadEncounter load = new LoadEncounter();
        Encounter encounter = load.loadEncounter();
        Button nextTurnButton = new Button("Next Turn");
        Button addCharacterButton = new Button("Add a Character\nto the Initiative Order");
        Label turnLabel = new Label("Turn " + turnCounter);
        VBox mainColumn = new VBox(10);
        Pane pane = new Pane(mainColumn);
        
        Collection<String> nameList = encounter.getInitiativeOrder().values();

        nextTurnButton.setOnAction((event) -> {
            turnCounter++;
            start(stage);
        });
        addCharacterButton.setOnAction((event) -> {
            TextField characterName = new TextField("Character Name");
            TextField initiativeValue = new TextField("Initiative");
            Button addButton = new Button("Add and close");
            HBox mainBox = new HBox(10);
            VBox mainColumn1 = new VBox(10);
            mainBox.getChildren().addAll(characterName, initiativeValue);
            mainColumn1.getChildren().addAll(mainBox, addButton);
            Stage stage1 = new Stage();
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

        for(String i : nameList) {
            mainColumn.getChildren().add(
                    new VBox(10,
                            new Label(i + "'s actions:"),
                            new HBox(10,
                                    setButton(new Button("Attack")),
                                    setButton(new Button("Reaction")),
                                    setButton(new Button("Move")),
                                    setButton(new Button("Bonus")))));
        }

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

