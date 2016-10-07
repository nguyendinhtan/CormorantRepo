import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EditInteractionGUI extends Application {
	ObservableList<String> oListLocation;
	ObservableList<String> oListCitation;
	ObservableList<String> oListInteractionType;
	ObservableList<Person> oListPersonDropDown;
	ObservableList<Person> oListPerson1Selected;
	ObservableList<Person> oListPerson2Selected;
	List<Person> editedPersonDropDown;

	public EditInteractionGUI() {
		editedPersonDropDown = new ArrayList<Person>();
	}

	public void start(Stage primaryStage, Interaction editInteraction, String query) {

		System.setProperty("glass.accessible.force", "false"); // Fixes bug of
																// combobox
																// crashing when
																// running on
																// certain
																// computers
		DataCollections.getInteractionCollection().remove(editInteraction);
		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 700, 700);
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
		ComboBox<String> locationDropDown = new ComboBox<String>();
		ComboBox<String> citationDropDown = new ComboBox<String>();
		ListView<Person> person1List = new ListView<Person>();

		ListView<Person> person2List = new ListView<Person>();
		TextArea notesTextArea = new TextArea();
		TextField dateTextField = new TextField();
		editedPersonDropDown.addAll(DataCollections.getPersonCollection());
		editedPersonDropDown.removeAll(editInteraction.getPeople1());
		editedPersonDropDown.removeAll(editInteraction.getPeople2());
		oListPersonDropDown = FXCollections.observableArrayList(editedPersonDropDown);
		oListLocation = FXCollections.observableArrayList(ControlledVocab.getLocationVocab());
		oListInteractionType = FXCollections.observableArrayList(ControlledVocab.getInteractionTypeVocab());
		oListCitation = FXCollections.observableArrayList(ControlledVocab.getCitationVocab());
		oListPerson1Selected = FXCollections.observableArrayList(editInteraction.getPeople1());
		oListPerson2Selected = FXCollections.observableArrayList(editInteraction.getPeople2());
		person1List.setItems(oListPerson1Selected);
		person2List.setItems(oListPerson2Selected);
		dateTextField.setText(editInteraction.getDate());
		notesTextArea.setText(editInteraction.getNotes());
		if (editInteraction.getLocation().equals("Unknown")) {
			locationDropDown.setValue(null);
		}
		locationDropDown.setValue(editInteraction.getLocation());
		if (editInteraction.getCitation().equals("none")) {
			citationDropDown.setValue(null);
		}
		citationDropDown.setValue(editInteraction.getCitation());
		if (editInteraction.getInteractionType().equals("Unknown")) {
			interactionTypeDropDown.setValue(null);
		}
		interactionTypeDropDown.setValue(editInteraction.getInteractionType());

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
		grid.add(locationDropDown, 1, 4);
		grid.add(dateLabel, 0, 5);
		grid.add(dateTextField, 1, 5);
		grid.add(interactionTypeLabel, 0, 6);
		grid.add(interactionTypeDropDown, 1, 6);
		grid.add(citationLabel, 0, 7);
		grid.add(citationDropDown, 1, 7);
		grid.add(notesLabelBox, 0, 8);
		grid.add(notesTextArea, 1, 8);
		grid.add(addInteractionButton, 0, 9);
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
		addPerson1Button.setTextFill(Color.WHITE);
		addPerson1Button.setStyle("-fx-base: #FF0000");
		addPerson1Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (person1DropDown.getValue() == null) {

				} else {
					oListPerson1Selected.add(person1DropDown.getValue());
					Collections.sort(oListPerson1Selected, Person.personNameComparator);
					person1List.setItems(oListPerson1Selected);
					oListPersonDropDown.remove(person1DropDown.getValue());
					person1DropDown.setValue(null);

				}
			}
		});

		// Add Person 2 Button Methods
		addPerson2Button.setTextFill(Color.WHITE);
		addPerson2Button.setStyle("-fx-base: #FF0000");
		addPerson2Button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (person2DropDown.getValue() == null) {

				} else {
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
				if (person1List.getSelectionModel().getSelectedIndex() < 0) {

				} else {
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
				if (person2List.getSelectionModel().getSelectedIndex() < 0) {

				} else {
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
		dateTextField.setMaxSize(450, 20);

		// Remove Buttons Box Methods
		removeButtonsBox.getChildren().add(removePerson1Button);
		removeButtonsBox.getChildren().add(removePerson2Button);

		// Location Drop Down Methods
		locationDropDown.setItems(oListLocation);
		locationDropDown.setMinSize(450, 10);

		// Interaction Type Drop Down Methods
		interactionTypeDropDown.setItems(oListInteractionType);
		interactionTypeDropDown.setMinSize(450, 10);

		// Citation Drop Down Methods
		citationDropDown.setItems(oListCitation);
		citationDropDown.setMinSize(450, 10);

		// Notes Label Box Methods
		notesLabelBox.getChildren().add(notesLabel);
		notesLabelBox.setAlignment(Pos.TOP_LEFT);

		// Notes Text Area Methods
		notesTextArea.setMaxSize(450, 100);

		// Add Interaction Button Methods
		addInteractionButton.setTextFill(Color.WHITE);
		addInteractionButton.setStyle("-fx-base: #FF0000");
		addInteractionButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (!(oListPerson1Selected.isEmpty() && oListPerson2Selected.isEmpty())) {
					String location = locationDropDown.getValue();
					String date = dateTextField.getText();
					String citation = citationDropDown.getValue();
					String interactionType = interactionTypeDropDown.getValue();
					String notes = notesTextArea.getText();

					Interaction interaction = new Interaction(oListPerson1Selected, oListPerson2Selected, location,
							date, interactionType, citation, notes, false);
					if (DataCollections.checkForInteractionDuplicates(interaction) >= 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText("That interaction has already been entered.");
						alert.setContentText("Interaction already exists.");
						alert.showAndWait();
					} else {
						DataCollections.addInteraction(interaction);
						SearchResultGUI searchGUI = new SearchResultGUI();
						searchGUI.start(primaryStage, "Interaction", query);
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
				DataCollections.addInteraction(editInteraction);
				SearchResultGUI searchGUI = new SearchResultGUI();
				searchGUI.start(primaryStage, "Interaction", query);
			}
		});

		// Button Box Methods
		buttonBox.getChildren().add(backButton);
		buttonBox.setAlignment(Pos.CENTER_RIGHT);

		// Primary Stage Methods
		primaryStage.setTitle("Edit Interaction");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	}
}
