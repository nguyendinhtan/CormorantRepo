import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddPersonGUI extends Application {

	Collections personList;

	public static void main(String[] args) {
		launch(args);

	}

	public AddPersonGUI() {
		personList = new Collections();
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
		ComboBox<String> gender = new ComboBox<String>();
		gender.getItems().addAll("Male", "Female", "Unknown");
		gender.setMinSize(300, 10);
		System.setProperty("glass.accessible.force", "false");// Fixes bug of
																// combobox
																// crashing when
																// running on
																// certain
																// computers
		grid.add(gender, 1, 1);
		Label cultureLabel = new Label("Culture Identity:");
		grid.add(cultureLabel, 0, 2);
		TextField cultureTextField = new TextField();
		grid.add(cultureTextField, 1, 2);
		Label occupationLabel = new Label("Occupation:");
		grid.add(occupationLabel, 0, 3);
		TextField occupationTextField = new TextField();
		grid.add(occupationTextField, 1, 3);
		HBox hbNotesLb = new HBox();
		Label notesLabel = new Label("Notes:");
		hbNotesLb.getChildren().add(notesLabel);
		hbNotesLb.setAlignment(Pos.TOP_LEFT);
		grid.add(hbNotesLb, 0, 4);
		TextArea notesTextArea = new TextArea();
		notesTextArea.setMaxSize(300, 100);
		grid.add(notesTextArea, 1, 4);
		Button btnAddPerson = new Button("Add Person");
		btnAddPerson.setTextFill(Color.BLACK);
		btnAddPerson.setTextFill(Color.WHITE);
		btnAddPerson.setStyle("-fx-base: #FF0000");
		grid.add(btnAddPerson, 0, 6);
		btnAddPerson.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				int id = personList.getPersonCollection().size() + 1;
				if (nameTextField.getText().isEmpty() && gender.getValue() == null
						&& cultureTextField.getText().isEmpty() && occupationTextField.getText().isEmpty()
						&& notesTextArea.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("No data entered.");
					alert.setContentText("Please enter data first.");
					alert.showAndWait();
				} else {
					if (nameTextField.getText().isEmpty()) {

						nameTextField.setText("Anonymous");
					}
					if (gender.getValue() == null) {
						gender.setValue("Unknown");
					}

					Person person = new Person(id, nameTextField.getText(), gender.getValue(),
							cultureTextField.getText(), occupationTextField.getText(), notesTextArea.getText());
					if (person.checkForUnallowedInput(person.getName(), person.getCulture(), person.getCulture()) < 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText("Invalid characters entered.");
						alert.setContentText(
								"Make sure no numbers or special characters are entered in the Name, Culture or Occupation fields");
						alert.showAndWait();
					} else if (personList.checkForPersonDuplicates(person) > 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText("That person has already been entered.");
						alert.setContentText("Person already exists. (ID number:"
								+ personList.checkForPersonDuplicates(person) + ")");
						alert.showAndWait();
					} else {
						personList.addPerson(person);
						// Testing method to check list
						for (int i = 0; i < personList.getPersonCollection().size(); i++) {
							System.out.println(personList.getPersonCollection().get(i).toString());
						}
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Person Added");
						alert.setHeaderText("Person was added to list");
						alert.showAndWait();

						nameTextField.clear();
						gender.setValue(null);
						cultureTextField.clear();
						occupationTextField.clear();
						notesTextArea.clear();
					}
				}
			}
		});
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		HBox hbBtn = new HBox();
		hbBtn.getChildren().add(btnBack);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbBtn, 1, 6);
		btnBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				HomeGUI Homegui = new HomeGUI();
				Homegui.start(primaryStage);
			}
		});
		Scene scene = new Scene(grid, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	

}
