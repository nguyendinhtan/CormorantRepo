package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.io.IOException;

import edu.augustana.csc285.cormorant.ordertracker.datamodel.CSVUtil;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.ControlledVocab;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.DataCollections;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 
 * Add Person GUI view class.
 */

public class AddPersonGUI extends Application {
	private ObservableList<String> oListCulture;
	private ObservableList<String> oListOccupation;

	public void start(Stage primaryStage) throws Exception {
		System.setProperty("glass.accessible.force", "false"); // Fixes bug of
																// combobox
																// crashing when
																// running on
																// certain
																// computers

		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		Label nameLabel = new Label("Name:");
		Label genderLabel = new Label("Gender:");
		Label nicknameLabel = new Label("Nickname:");
		Label cultureLabel = new Label("Culture Identity:");
		Label occupationLabel = new Label("Occupation:");
		Label notesLabel = new Label("Notes:");
		TextField nameTextField = new TextField();
		TextField nicknameTextField = new TextField();
		ComboBox<String> cultureDropDown = new ComboBox<String>();
		TextArea notesTextArea = new TextArea();
		ComboBox<String> occupationDropDown = new ComboBox<String>();
		ComboBox<String> genderDropDown = new ComboBox<String>();
		Button addPersonButton = new Button("Add Person");
		Button backButton = new Button("Back");
		HBox notesLabelBox = new HBox();
		HBox buttonBox = new HBox();
		oListCulture = FXCollections.observableArrayList(ControlledVocab.getCultureVocab());
		oListOccupation = FXCollections.observableArrayList(ControlledVocab.getOccupationVocab());
		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(nameLabel, 0, 0);
		grid.add(nameTextField, 1, 0);
		grid.add(nicknameLabel, 0, 1);
		grid.add(nicknameTextField, 1, 1);
		grid.add(genderLabel, 0, 2);
		grid.add(genderDropDown, 1, 2);
		grid.add(cultureLabel, 0, 3);
		grid.add(cultureDropDown, 1, 3);
		grid.add(occupationLabel, 0, 4);
		grid.add(occupationDropDown, 1, 4);
		grid.add(notesLabelBox, 0, 5);
		grid.add(notesTextArea, 1, 5);
		grid.add(backButton, 0, 6);
		grid.add(buttonBox, 1, 6);

		// Gender Methods
		genderDropDown.getItems().addAll("Male", "Female", "Unknown");
		genderDropDown.setMinSize(300, 10);

		// Culture Methods
		cultureDropDown.getItems().addAll(oListCulture);
		cultureDropDown.setMinSize(300, 10);
		// Occupation Methods
		occupationDropDown.getItems().addAll(oListOccupation);
		occupationDropDown.setMinSize(300, 10);

		// Notes Label Box
		notesLabelBox.getChildren().add(notesLabel);
		notesLabelBox.setAlignment(Pos.TOP_LEFT);
		notesTextArea.setMaxSize(300, 100);

		// Add Person Buttons
		addPersonButton.setTextFill(Color.BLACK);
		addPersonButton.setStyle("-fx-base: #FFFFFF");
		addPersonButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				int id = DataCollections.getPersonCollection().size() + 1;
				String name = nameTextField.getText();
				String nickname = nicknameTextField.getText();
				String gender = genderDropDown.getValue();
				String culture = cultureDropDown.getValue();
				String occupation = occupationDropDown.getValue();
				String notes = notesTextArea.getText();
				if (name.matches(".*[a-zA-Z]+.*")){
					if (!nickname.matches(".*[a-zA-Z]+.*")) {
						nickname = "No Nickname";
					}
					if (gender == null) {
						gender = "Unknown";
					}
					if (culture == null) {
						culture = "Unknown";
					}
					if (occupation == null) {
						occupation = "Unknown";
					}
					if (!notes.matches(".*[a-zA-Z]+.*")) {
						notes = "none";
					}
					Person person = new Person(id, name,nickname, gender, culture, occupation, notes);
					if (person.checkForUnallowedInput(person.getName(),person.getNickname(), person.getCulture(),
							person.getOccupation()) < 0) {
						DialogGUI.showError("Invalid Characters Entered",
								"Make sure no numbers or special characters are entered in the Name, Culture or Occupation fields");
						/*
						 * Alert alert = new Alert(AlertType.ERROR);
						 * alert.setTitle("Error");
						 * alert.setHeaderText("Invalid characters entered.");
						 * alert.setContentText(
						 * "Make sure no numbers or special characters are entered in the Name, Culture or Occupation fields"
						 * ); alert.showAndWait();
						 */
					} else if (DataCollections.checkForPersonDuplicates(person) > 0) {
						DialogGUI.showError("Duplicate Person Entered", "Person already exists." + person.toString());
						/*
						 * Alert alert = new Alert(AlertType.ERROR);
						 * alert.setTitle("Error"); alert.
						 * setHeaderText("That person has already been entered."
						 * ); alert.
						 * setContentText("Person already exists. (ID number:" +
						 * DataCollections.checkForPersonDuplicates(person) +
						 * ")"); alert.showAndWait();
						 */
					} else {
						DataCollections.addPerson(person);
						DialogGUI.showInfo("Person Added", "Person was added to list.");
		
						nameTextField.clear();
						nicknameTextField.clear();
						genderDropDown.setValue(null);
						cultureDropDown.setValue(null);
						occupationDropDown.setValue(null);
						notesTextArea.clear();

					}
				}
			}
		});

		// Back Button Methods
		backButton.setTextFill(Color.BLACK);
		backButton.setStyle("-fx-base: #FFFFFF");
		backButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				HomeGUI Homegui = new HomeGUI();
				try {
					Homegui.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Button Box
		buttonBox.getChildren().add(addPersonButton);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);

		// Primary Stage Methods
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		      public void handle(WindowEvent we) {
		    	  try {
						CSVUtil.savePerson("data/People.csv");
					} catch (IOException error) {
						DialogGUI.showError("Couldn't save Person object.", error.toString());
					}
		    	  try {
		  			CSVUtil.saveInteractions("data/Interaction.csv");
		  		} catch (IOException error) {
		  			DialogGUI.showError("Couldn't Save Interaction to CSV", error.toString());
		  			
		  		}
		      }
		  }); 
		primaryStage.setTitle("Insert Person");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
