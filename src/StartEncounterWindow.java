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

public class StartEncounterWindow extends Application {

    public void start(Stage stage){
        Encounter encounter = new Encounter();
        TextField characterName = new TextField("Character Name");
        TextField initiative = new TextField("Initiative");
        Button submitButton = new Button("Submit");
        Button doneButton = new Button("Finished");
        HBox textFields = new HBox(10);
        VBox mainBox = new VBox(20);
        Pane mainPane = new Pane();

        initiative.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                initiative.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        submitButton.setOnAction((event) -> {
            Integer initiativeValue = Integer.parseInt(initiative.getText());
            encounter.add(characterName.getText(), initiativeValue);
            System.out.println(encounter);
        });

        doneButton.setOnAction((event) -> {
            SaveEncounter save = new SaveEncounter();
            save.saveEncounter(encounter);
            stage.close();
            EncounterWindow encounterWindow = new EncounterWindow();
            encounterWindow.start(stage);
        });

        textFields.getChildren().addAll(characterName, initiative);
        mainBox.getChildren().addAll(textFields, submitButton, doneButton);
        mainPane.getChildren().add(mainBox);

        stage.setScene(new Scene(mainPane));
        stage.show();
    }

}
