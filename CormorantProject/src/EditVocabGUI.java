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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Edit vocabulary GUI view class.
 *
 */
public class EditVocabGUI extends Application {

	ControlledVocab vocabLists;
	ObservableList<String> observableListVocab;

	public EditVocabGUI() {
		vocabLists = new ControlledVocab();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		System.setProperty("glass.accessible.force", "false"); // Fixes bug of
																// crashing
																// ComboBox

		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 600, 400);
		HBox queryBox = new HBox();
		HBox controlledVocabBox = new HBox();
		HBox buttonGroup = new HBox(175);
		Label queryLabel = new Label("Query:");
		Label vocabLabel = new Label("Controlled Vocabulary Type:");
		Label vocabListLabel = new Label("Vocabulary List:");
		ComboBox<String> vocabDropDown = new ComboBox<String>();
		TextField addVocabTextField = new TextField();
		Button addButton = new Button("Add");
		Button backButton = new Button("Back");
		Button removeButton = new Button("Remove");
		ListView<String> listView = new ListView<String>();

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(vocabLabel, 0, 0);
		grid.add(vocabDropDown, 1, 0);
		grid.add(addVocabTextField, 1, 1);
		grid.add(queryBox, 0, 1);
		grid.add(listView, 1, 2);
		grid.add(vocabListLabel, 0, 2);
		grid.add(addButton, 0, 4);
		grid.add(controlledVocabBox, 1, 4);
		grid.add(buttonGroup, 1, 4);

		// Vocab Drop Down Methods
		vocabDropDown.setMinSize(300, 30);
		vocabDropDown.getItems().addAll("Location", "Interaction Type", "Bibliographical Citation");
		vocabDropDown.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (vocabDropDown.getValue().equals("Location")) {
					observableListVocab = FXCollections.observableArrayList(vocabLists.getLocationVocab());

				} else if (vocabDropDown.getValue().equals("Interaction Type")) {
					observableListVocab = FXCollections.observableArrayList(vocabLists.getInteractionTypeVocab());

				} else if (vocabDropDown.getValue().equals("Bibliographical Citation")) {
					observableListVocab = FXCollections.observableArrayList(vocabLists.getCitationVocab());

				}
				listView.setItems(observableListVocab);
			}
		});

		// Query Group Methods
		queryBox.getChildren().add(queryLabel);
		queryBox.setAlignment(Pos.CENTER_RIGHT);

		// Controlled Vocab Group Methods
		controlledVocabBox.setAlignment(Pos.CENTER_RIGHT);
		controlledVocabBox.getChildren().add(backButton);

		// Add Button Methods
		addButton.setTextFill(Color.BLACK);
		addButton.setTextFill(Color.WHITE);
		addButton.setStyle("-fx-base: #FF0000");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (vocabDropDown.getValue() == null || addVocabTextField.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("No data entered.");
					alert.setContentText("Please select a vocabulary type and enter new vocabulary into the query.");
					alert.showAndWait();
				} else {
					String vocab = addVocabTextField.getText();
					if (vocabLists.checkForUnallowedInput(vocab) < 0) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText("Invalid characters entered.");
						alert.setContentText("Make sure no numbers or special characters are entered");
						alert.showAndWait();
					} else {
						if (vocabLists.checkForDuplicates(vocab, vocabDropDown.getValue()) >= 0) {
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Error");
							alert.setHeaderText("List already contains that vocabulary.");
							alert.showAndWait();
						} else {
							if (vocabDropDown.getValue().equals("Location")) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Vocabulary Added");
								alert.setHeaderText("Vocabulary added to location.");
								alert.showAndWait();
								vocabLists.addLocationVocab(vocab);
								observableListVocab = FXCollections.observableArrayList(vocabLists.getLocationVocab());

								// For Testing
								for (int i = 0; i < vocabLists.getLocationVocab().size(); i++) {
									System.out.println(vocabLists.getLocationVocab().get(i));
								}
							} else if (vocabDropDown.getValue().equals("Interaction Type")) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Vocabulary Added");
								alert.setHeaderText("Vocabulary added to interaction type.");
								alert.showAndWait();
								vocabLists.addInteractionTypeVocab(vocab);
								observableListVocab = FXCollections
										.observableArrayList(vocabLists.getInteractionTypeVocab());
								// For Testing
								for (int i = 0; i < vocabLists.getInteractionTypeVocab().size(); i++) {
									System.out.println(vocabLists.getInteractionTypeVocab().get(i));
								}
							} else if (vocabDropDown.getValue().equals("Bibliographical Citation")) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Vocabulary Added");
								alert.setHeaderText("Vocabulary added to bibliographical citation.");
								alert.showAndWait();
								vocabLists.addCitationVocab(vocab);
								observableListVocab = FXCollections.observableArrayList(vocabLists.getCitationVocab());
								// For Testing
								for (int i = 0; i < vocabLists.getCitationVocab().size(); i++) {
									System.out.println(vocabLists.getCitationVocab().get(i));
								}
							}
						}
					}
				}
				listView.setItems(observableListVocab);
				addVocabTextField.clear();
			}
		});

		// Remove Button Methods
		removeButton.setTextFill(Color.WHITE);
		removeButton.setStyle("-fx-base: #FF0000");
		removeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (listView.getSelectionModel().getSelectedItem() == null) {

				} else {
					int deletedIndex = listView.getSelectionModel().getSelectedIndex();
					observableListVocab.remove(deletedIndex);
					vocabLists.remove(deletedIndex, vocabDropDown.getValue());
					listView.setItems(observableListVocab);
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

		// Button Group Methods
		buttonGroup.getChildren().add(removeButton);
		buttonGroup.getChildren().add(backButton);

		// List View Methods
		listView.setMinSize(100, 100);

		// Primary Stage Methods
		primaryStage.setTitle("Edit Controlled Vocabulary");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
