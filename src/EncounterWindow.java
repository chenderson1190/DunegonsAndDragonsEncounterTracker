import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class EncounterWindow extends Application {
    public void start(Stage stage){
        Button loadButton = new Button("Test me!");
        Pane pane = new Pane();
        pane.getChildren().add(loadButton);

        loadButton.setOnAction((event) -> {
           LoadEncounter load = new LoadEncounter();
           Encounter encounter = load.loadEncounter();
           System.out.println(encounter);
        });

        stage.setScene(new Scene(pane));
        stage.show();
    }

}

