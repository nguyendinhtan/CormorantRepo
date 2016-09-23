import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.collections.*;
public class AddInteractionGUI extends Application {
	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Home Screen");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		TextField person1TextField = new TextField();
	       grid.add(person1TextField, 1, 0);
	    TextField person2TextField = new TextField();
	       grid.add(person2TextField, 2, 0);
		ComboBox location = new ComboBox(); 
		location.getItems().addAll(
				
		);
		grid.add(location, 1, 1);
		ComboBox citation= new ComboBox(); 
		citation.getItems().addAll(
				
		);
		grid.add(citation, 1, 5);
		ComboBox interactionType = new ComboBox(); 
		interactionType.getItems().addAll(
				
		);
		grid.add(interactionType, 1,4 );
	       TextField dateTextField = new TextField();
	       grid.add(dateTextField, 1, 3);
	       TextField notesTextField = new TextField();
	       grid.add(notesTextField, 1, 6);
		Button btnAddPerson = new Button("Add Interation");
		btnAddPerson.setTextFill(Color.BLACK);
		btnAddPerson.setTextFill(Color.WHITE);
		btnAddPerson.setStyle("-fx-base: #FF0000");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		hbBtn.getChildren().add(btnAddPerson);

		
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnBack);
		grid.add(hbBtn, 1, 7);

		Scene scene = new Scene(grid, 1000, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
