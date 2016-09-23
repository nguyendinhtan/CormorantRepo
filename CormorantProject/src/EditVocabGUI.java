import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.collections.*;

public class EditVocabGUI extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Edit Controable Vocabulary");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		ComboBox vocab = new ComboBox(); 
		vocab.getItems().addAll(
				"Location",
				"Interaction Type",
				"Bibliographical Citation"
		);
		grid.add(vocab, 1, 0);
		TextField addVocabTextField = new TextField();
	       grid.add(addVocabTextField, 1, 1);
	       
		Button btnAdd = new Button("Add");
		btnAdd.setTextFill(Color.BLACK);
		btnAdd.setTextFill(Color.WHITE);
		btnAdd.setStyle("-fx-base: #FF0000");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		hbBtn.getChildren().add(btnAdd);

		
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnBack);
		grid.add(hbBtn, 1, 4);

		Scene scene = new Scene(grid, 1000, 1000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
