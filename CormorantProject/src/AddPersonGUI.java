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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
public class AddPersonGUI extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) {
		primaryStage.setTitle("Insert Person");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Label nameLabel = new Label("Name:");
		grid.add(nameLabel, 0, 0);
		TextField nameTextField = new TextField();
		grid.add(nameTextField, 1, 0);
		Label genderLabel = new Label("Gender:");
		grid.add(genderLabel, 0, 1);
		ComboBox gender=new ComboBox();
		gender.getItems().addAll("Male", "Female", "Unknown");
		gender.setMinSize(300, 10);
		System.setProperty("glass.accessible.force", "false");//Fixes bug of combobox crashing when running on certain computers
		grid.add(gender, 1, 1);
		Label cultureLabel = new Label("Culture Identity:");
		grid.add(cultureLabel, 0, 2);
		TextField cultureTextField = new TextField();
		grid.add(cultureTextField, 1, 2);
		Label occupationLabel = new Label("Occupation:");
		grid.add(occupationLabel, 0, 3);
		TextField occupationTextField = new TextField();
		grid.add(occupationTextField, 1, 3);
		Label notesLabel = new Label("Notes:");
		grid.add(notesLabel, 0, 4);
		TextField notesTextField = new TextField();
		notesTextField.setMinSize(300, 100);
		grid.add(notesTextField, 1, 4);
		Button btnAddPerson = new Button("Add Person");
		btnAddPerson.setTextFill(Color.BLACK);
		btnAddPerson.setTextFill(Color.WHITE);
		btnAddPerson.setStyle("-fx-base: #FF0000");
		grid.add(btnAddPerson, 0, 6);

		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		HBox hbBtn=new HBox();
		hbBtn.getChildren().add(btnBack);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbBtn, 1, 6);
		Scene scene = new Scene(grid, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		btnAddPerson.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
                nameTextField.clear();
                cultureTextField.clear();
                occupationTextField.clear();
                notesTextField.clear();
            }
        });
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage);
            }
        });
	}

}


