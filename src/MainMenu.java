import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application {

    public void start(Stage stage){
        Label welcomeLabel = new Label("Hello and Welcome to the encounter tracker\n version 0.0.1!");
        Button newEncounterButton = new Button("Create a new Encounter");
        HBox firstRow = new HBox(10);
        VBox firstColumn = new VBox(10);
        Pane mainPane = new Pane();
        Scene mainScene = new Scene(mainPane);

        firstRow.getChildren().add(welcomeLabel);
        firstColumn.getChildren().addAll(firstRow, newEncounterButton);
        mainPane.getChildren().add(firstColumn);

        newEncounterButton.setOnAction((event) -> {
            //TODO: Make Encounter and EncounterWindow classes.
            });

        stage.setScene(mainScene);
        stage.setTitle("Encounter Tracker 0.0.1");
        stage.setHeight(200);
        stage.setWidth(300);
        stage.show();
    }
}
