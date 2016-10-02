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

/**
 * 
 * Add Person GUI view class.
 */

public class AddPersonGUI extends Application {

	Collections personList;

	public static void main(String[] args) {
		launch(args);
	}

	public AddPersonGUI() {
		personList = new Collections();
	}

	public void start(Stage primaryStage) {
		System.setProperty("glass.accessible.force", "false"); // Fixes bug of
																// combobox
																// crashing when
																// running on
																// certain
																// computers

		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 500, 400);
		Label nameLabel = new Label("Name:");
		Label genderLabel = new Label("Gender:");
		Label cultureLabel = new Label("Culture Identity:");
		Label occupationLabel = new Label("Occupation:");
		Label notesLabel = new Label("Notes:");
		TextField nameTextField = new TextField();
		TextField cultureTextField = new TextField();
		TextArea notesTextArea = new TextArea();
		TextField occupationTextField = new TextField();
		ComboBox<String> genderDropDown = new ComboBox<String>();
		Button addPersonButton = new Button("Add Person");
		Button backButton = new Button("Back");
		HBox notesLabelBox = new HBox();
		HBox buttonBox = new HBox();

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(nameLabel, 0, 0);
		grid.add(nameTextField, 1, 0);
		grid.add(genderLabel, 0, 1);
		grid.add(genderDropDown, 1, 1);
		grid.add(cultureLabel, 0, 2);
		grid.add(cultureTextField, 1, 2);
		grid.add(occupationLabel, 0, 3);
		grid.add(occupationTextField, 1, 3);
		grid.add(notesLabelBox, 0, 4);
		grid.add(notesTextArea, 1, 4);
		grid.add(addPersonButton, 0, 6);
		grid.add(buttonBox, 1, 6);

		// Gender Methods
		genderDropDown.getItems().addAll("Male", "Female", "Unknown");
		genderDropDown.setMinSize(300, 10);

		// Notes Label Box
		notesLabelBox.getChildren().add(notesLabel);
		notesLabelBox.setAlignment(Pos.TOP_LEFT);
		notesTextArea.setMaxSize(300, 100);

		// Add Person Buttons
		addPersonButton.setTextFill(Color.BLACK);
		addPersonButton.setTextFill(Color.WHITE);
		addPersonButton.setStyle("-fx-base: #FF0000");
		addPersonButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int id = personList.getPersonCollection().size() + 1;
				if (nameTextField.getText().isEmpty() && genderDropDown.getValue() == null
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
					if (genderDropDown.getValue() == null) {
						genderDropDown.setValue("Unknown");
					}

					Person person = new Person(id, nameTextField.getText(), genderDropDown.getValue(),
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
						genderDropDown.setValue(null);
						cultureTextField.clear();
						occupationTextField.clear();
						notesTextArea.clear();
					}
				}
			}
		});

		// Back Button Methods
		backButton.setTextFill(Color.WHITE);
		backButton.setStyle("-fx-base: #FF0000");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				HomeGUI Homegui = new HomeGUI();
				Homegui.start(primaryStage);
			}
		});

		// Button Box
		buttonBox.getChildren().add(backButton);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);

		// Primary Stage Methods
		primaryStage.setTitle("Insert Person");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
