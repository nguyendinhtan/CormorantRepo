import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * The edit vocabulary GUI view class.
 *
 */
public class EditVocabGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		//GUI Variables
		GridPane grid = new GridPane();
		HBox queryGroup = new HBox();
		HBox controlledVocabGroup = new HBox();
		Label queryLabel = new Label("Query:");
		Label vocabLabel = new Label("Controlled Vocabulary Type:");
		Scene scene = new Scene(grid, 500, 300);
		ComboBox<String> vocabDropDown = new ComboBox<String>();
		TextField addVocabTextField = new TextField();
		Button addButton = new Button("Add");
		Button backButton = new Button("Back");

		//Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(vocabLabel, 0, 0);
		grid.add(vocabDropDown, 1, 0);
		grid.add(queryGroup, 0, 1);
	    grid.add(addVocabTextField, 1, 1);
		grid.add(addButton, 0, 4);
		grid.add(controlledVocabGroup, 1, 4);

		//Vocab Drop Down Methods
		vocabDropDown.getItems().addAll(
				"Location",
				"Interaction Type",
				"Bibliographical Citation"
		);
		
		//Query Group Methods
		queryGroup.getChildren().add(queryLabel);
		queryGroup.setAlignment(Pos.CENTER_RIGHT);
				
		//Controlled Vocab Group
		controlledVocabGroup.setAlignment(Pos.CENTER_RIGHT);
		controlledVocabGroup.getChildren().add(backButton);
		
		//Add Button Methods
		addButton.setTextFill(Color.BLACK);
		addButton.setTextFill(Color.WHITE);
		addButton.setStyle("-fx-base: #FF0000");
		
		//Back Button Methods
		backButton.setTextFill(Color.WHITE);
		backButton.setStyle("-fx-base: #FF0000");
		backButton.setOnAction(new EventHandler<ActionEvent>() { 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage);
            }
        });
		
		//Primary Stage Methods
		primaryStage.setTitle("Edit Controlled Vocabulary");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
