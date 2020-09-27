import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;


public class EncounterWindow extends Application {
    public void start(Stage stage){
        ArrayList<String> testList = new ArrayList<>();
        LoadEncounter load = new LoadEncounter();
        Encounter encounter = load.loadEncounter();
        Label testLabel = new Label(encounter.toString());
        VBox mainColumn = new VBox(10);
        Pane pane = new Pane();
        mainColumn.getChildren().add(testLabel);
        pane.getChildren().add(mainColumn);
        Collection<String> ah = encounter.getInitiativeOrder().values();
        testList.addAll(ah);
        for(String i : testList){
        }
        System.out.println(ah);

        stage.setScene(new Scene(pane));
        stage.show();
    }

}

