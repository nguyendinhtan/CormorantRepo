import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * Search Result GUI view class.
 */
public class SearchResultGUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 600, 400);
		ListView<String> searchResultsView = new ListView<String>();
		Button btnEdit = new Button("Edit");
		Button btnDelete = new Button("Delete");
		Button btnBack = new Button("Back");
		HBox hbBtn = new HBox(120);

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// sets size of list view
		searchResultsView.setMinSize(400, 300);

		// Styling of Buttons
		btnEdit.setTextFill(Color.BLACK);
		btnEdit.setTextFill(Color.WHITE);
		btnEdit.setStyle("-fx-base: #FF0000");

		btnDelete.setTextFill(Color.WHITE);
		btnDelete.setStyle("-fx-base: #FF0000");
		btnDelete.setTextFill(Color.WHITE);

		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");

		// Action for back button to return program to the home screen
		btnBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				HomeGUI Homegui = new HomeGUI();
				Homegui.start(primaryStage);
			}
		});

		// adds buttons to box
		hbBtn.getChildren().add(btnEdit);
		hbBtn.getChildren().add(btnDelete);
		hbBtn.getChildren().add(btnBack);

		// adds box and list view to grid for display
		grid.add(searchResultsView, 1, 0);
		grid.add(hbBtn, 1, 1);

		// primaryStage methods
		primaryStage.setTitle("Search Results");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
