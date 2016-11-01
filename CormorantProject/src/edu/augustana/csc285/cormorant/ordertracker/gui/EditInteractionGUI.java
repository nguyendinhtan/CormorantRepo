package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.augustana.csc285.cormorant.ordertracker.datamodel.CSVUtil;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.ControlledVocab;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.DataCollections;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.Interaction;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class EditInteractionGUI extends Application {
	private ObservableList<String> oListInteractionType;
	private ObservableList<Person> oListPersonDropDown;
	private ObservableList<Person> oListPerson1Selected;
	private ObservableList<Person> oListPerson2Selected;
	private List<Person> editedPersonDropDown;

	public EditInteractionGUI() {
		editedPersonDropDown = new ArrayList<Person>();
	}

	public void start(Stage primaryStage) {
		// Fixes bug of combobox crashing when running on certain computers
		System.setProperty("glass.accessible.force", "false");

		DataCollections.getInteractionCollection().remove(SearchResultGUI.getSelectedInteraction());
		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		HBox personLabelBox = new HBox(185);
		HBox buttonList1Box = new HBox();
		HBox buttonList2Box = new HBox();
		HBox removeButtonsBox = new HBox(50);
		HBox personAreaBox = new HBox(50);
		HBox personListsBox = new HBox(50);
		HBox notesLabelBox = new HBox();
		HBox buttonBox = new HBox(10);
		Label person1Label = new Label("Person(s):");
		Label person2Label = new Label("Person(s) Interacted With:");
		Label locactionLabel = new Label("Location:");
		Label dateLabel = new Label("Date:");
		Label interactionTypeLabel = new Label("Interaction Type:");
		Label citationLabel = new Label("Bibliographical Citation:");
		Label notesLabel = new Label("Notes:");
		Button addPerson1Button = new Button("Add");
		Button addPerson2Button = new Button("Add");
		Button removePerson1Button = new Button("Remove");
		Button removePerson2Button = new Button("Remove");
		Button addInteractionButton = new Button("Done");
		Button backButton = new Button("Back");
		ComboBox<Person> person1DropDown = new ComboBox<Person>();
		ComboBox<Person> person2DropDown = new ComboBox<Person>();
		ComboBox<String> interactionTypeDropDown = new ComboBox<String>();
		TextField locationTextField = new TextField();
		TextField citationTextField = new TextField();
		ListView<Person> person1List = new ListView<Person>();
		ListView<Person> person2List = new ListView<Person>();
		TextArea notesTextArea = new TextArea();
		DatePicker datePicker = new DatePicker();
		editedPersonDropDown.addAll(DataCollections.getPersonCollection());
		editedPersonDropDown.removeAll(SearchResultGUI.getSelectedInteraction().getPeople1());
		editedPersonDropDown.removeAll(SearchResultGUI.getSelectedInteraction().getPeople2());
		oListPersonDropDown = FXCollections.observableArrayList(editedPersonDropDown);
		oListInteractionType = FXCollections.observableArrayList(ControlledVocab.getInteractionTypeVocab());
		oListPerson1Selected = FXCollections.observableArrayList(SearchResultGUI.getSelectedInteraction().getPeople1());
		oListPerson2Selected = FXCollections.observableArrayList(SearchResultGUI.getSelectedInteraction().getPeople2());
		person1List.setItems(oListPerson1Selected);
		person2List.setItems(oListPerson2Selected);
		datePicker.setValue(SearchResultGUI.getSelectedInteraction().getDate());
		notesTextArea.setText(SearchResultGUI.getSelectedInteraction().getNotes());
		locationTextField.setText(SearchResultGUI.getSelectedInteraction().getLocation());
		citationTextField.setText(SearchResultGUI.getSelectedInteraction().getCitation());
		if (SearchResultGUI.getSelectedInteraction().getInteractionType().equals("Unknown")) {
			interactionTypeDropDown.setValue(null);
		}
		interactionTypeDropDown.setValue(SearchResultGUI.getSelectedInteraction().getInteractionType());

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(personLabelBox, 1, 0);
		grid.add(personListsBox, 1, 1);
		grid.add(personAreaBox, 1, 2);
		grid.add(removeButtonsBox, 1, 3);
		grid.add(locactionLabel, 0, 4);
		grid.add(locationTextField, 1, 4);
		grid.add(dateLabel, 0, 5);
		grid.add(datePicker, 1, 5);
		grid.add(interactionTypeLabel, 0, 6);
		grid.add(interactionTypeDropDown, 1, 6);
		grid.add(citationLabel, 0, 7);
		grid.add(citationTextField, 1, 7);
		grid.add(notesLabelBox, 0, 8);
		grid.add(notesTextArea, 1, 8);
		grid.add(backButton, 0, 9);
		grid.add(buttonBox, 1, 9);

		// Person Label Box Methods
		personLabelBox.getChildren().add(person1Label);
		personLabelBox.getChildren().add(person2Label);

		// Person 1 Drop Down Methods
		person1DropDown.setMinSize(150, 20);
		person1DropDown.setMaxSize(150, 50);
		person1DropDown.setItems(oListPersonDropDown);

		// Person 2 Drop Down Methods
		person2DropDown.setMinSize(150, 20);
		person2DropDown.setMaxSize(150, 50);
		person2DropDown.setItems(oListPersonDropDown);

		// Person 1 List Methods
		person1List.setMaxSize(200, 100);

		// Person 2 List Methods
		person2List.setMaxSize(200, 100);

		// Button List 1 Box Method
		buttonList1Box.getChildren().add(person1DropDown);
		buttonList1Box.getChildren().add(addPerson1Button);

		// Button List 2 Box Methods
		buttonList2Box.getChildren().add(person2DropDown);
		buttonList2Box.getChildren().add(addPerson2Button);

		// Add Person 1 Button Methods
		addPerson1Button.setTextFill(Color.BLACK);
		addPerson1Button.setStyle("-fx-base: #FFFFFF");
		addPerson1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (person1DropDown.getValue() != null) {
					oListPerson1Selected.add(person1DropDown.getValue());
					Collections.sort(oListPerson1Selected, Person.personNameComparator);
					person1List.setItems(oListPerson1Selected);
					oListPersonDropDown.remove(person1DropDown.getValue());
					person1DropDown.setValue(null);
				}
			}
		});

		// Add Person 2 Button Methods
		addPerson2Button.setTextFill(Color.BLACK);
		addPerson2Button.setStyle("-fx-base: #FFFFFF");
		addPerson2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (person2DropDown.getValue() != null) {
					oListPerson2Selected.add(person2DropDown.getValue());
					Collections.sort(oListPerson2Selected, Person.personNameComparator);
					person2List.setItems(oListPerson2Selected);
					oListPersonDropDown.remove(person2DropDown.getValue());
					person2DropDown.setValue(null);
				}
			}
		});

		// Remove Person 1 Button Methods
		removePerson1Button.setTextFill(Color.WHITE);
		removePerson1Button.setStyle("-fx-base: #FF0000");
		removePerson1Button.setMinSize(200, 20);
		removePerson1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (person1List.getSelectionModel().getSelectedIndex() >= 0) {
					oListPersonDropDown.add(person1List.getSelectionModel().getSelectedItem());
					Collections.sort(oListPersonDropDown, Person.personNameComparator);
					oListPerson1Selected.remove(person1List.getSelectionModel().getSelectedIndex());
				}
			}
		});

		// Remove Person 2 Button Methods
		removePerson2Button.setTextFill(Color.WHITE);
		removePerson2Button.setStyle("-fx-base: #FF0000");
		removePerson2Button.setMinSize(200, 20);
		removePerson2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (person2List.getSelectionModel().getSelectedIndex() >= 0) {
					oListPersonDropDown.add(person2List.getSelectionModel().getSelectedItem());
					Collections.sort(oListPersonDropDown, Person.personNameComparator);
					oListPerson2Selected.remove(person2List.getSelectionModel().getSelectedIndex());
				}
			}
		});

		// Person List Box Methods
		personListsBox.getChildren().add(buttonList1Box);
		personListsBox.getChildren().add(buttonList2Box);

		// Person Area Box Methods
		personAreaBox.getChildren().add(person1List);
		personAreaBox.getChildren().add(person2List);

		// Date Text Field Methods
		datePicker.setMaxSize(450, 20);
		datePicker.setPromptText("MM/dd/yyyy");

		// Remove Buttons Box Methods
		removeButtonsBox.getChildren().add(removePerson1Button);
		removeButtonsBox.getChildren().add(removePerson2Button);

		// Location Drop Down Methods
		locationTextField.setMinSize(450, 10);
		locationTextField.setPromptText("ex. Paris");

		// Interaction Type Drop Down Methods
		interactionTypeDropDown.setItems(oListInteractionType);
		interactionTypeDropDown.setMinSize(450, 10);

		// Citation Text Field Methods
		citationTextField.setMinSize(450, 10);
		citationTextField.setPromptText("ex. Encyclopedia of Art");

		// Notes Label Box Methods
		notesLabelBox.getChildren().add(notesLabel);
		notesLabelBox.setAlignment(Pos.TOP_LEFT);

		// Notes Text Area Methods
		notesTextArea.setMaxSize(450, 100);
		notesTextArea.setPromptText("Brief description of the interaction...");

		// Add Interaction Button Methods
		addInteractionButton.setTextFill(Color.BLACK);
		addInteractionButton.setStyle("-fx-base: #FFFFFF");
		addInteractionButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				String location = (locationTextField.getText().matches(".*[a-zA-Z]+.*")) ? locationTextField.getText()
						: "Unknown";
				String date = (datePicker.getValue() != null)
						? datePicker.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")).toString()
						: "no date";
				String citation = (citationTextField.getText().matches(".*[a-zA-Z]+.*")) ? citationTextField.getText()
						: "none";
				String interactionType = (interactionTypeDropDown.getValue() != null)
						? interactionTypeDropDown.getValue() : "Unknown";
				String notes = (notesTextArea.getText().matches(".*[a-zA-Z]+.*")) ? notesTextArea.getText() : "none";
				if (!(oListPerson1Selected.isEmpty() && oListPerson2Selected.isEmpty())) {
					Interaction interaction = new Interaction(oListPerson1Selected, oListPerson2Selected, location,
							date, interactionType, citation, notes, false);
					if (DataCollections.checkForInteractionDuplicates(interaction) >= 0) {
						DialogGUI.showError("Duplicate Interaction Entered",
								"Interaction already exists." + interaction.toString());
					} else {
						DataCollections.addInteraction(interaction);
						SearchResultGUI searchGUI = new SearchResultGUI();
						searchGUI.start(primaryStage);
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
				DataCollections.addInteraction(SearchResultGUI.getSelectedInteraction());
				SearchResultGUI searchGUI = new SearchResultGUI();
				searchGUI.start(primaryStage);
			}
		});

		// Button Box Methods
		buttonBox.getChildren().add(addInteractionButton);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);

		// Primary Stage Methods
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				String saveDialog = DialogGUI.saveConfirmation();
				if(saveDialog == "Save"){
					HomeGUI.savePerson();
					HomeGUI.saveInteractions();
					HomeGUI.saveCultureVocab();
					HomeGUI.saveOccupationVocab();
					HomeGUI.saveInteractionsType();
				}
				else if(saveDialog=="Cancel"){
					we.consume();
				}
			}
		});
		primaryStage.setTitle("Edit Interaction");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
