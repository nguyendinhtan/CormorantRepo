package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.io.IOException;
import java.util.Optional;

import edu.augustana.csc285.cormorant.ordertracker.datamodel.CSVUtil;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.DataCollections;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.Interaction;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.Person;
import edu.augustana.csc285.cormorant.ordertracker.datamodel.SearchUtil;
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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Search Result GUI view class.
 */
public class SearchResultGUI extends Application {
	private ObservableList<Person> oListPersonResults;
	private ObservableList<Interaction> oListInteractionResults;
	private static Person selectedPerson;
	private static Interaction selectedInteraction;

	@Override
	public void start(Stage primaryStage) {

		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid);
		TableView<Person> personResultsView = new TableView<Person>();
		TableView<Interaction> interactionResultsView = new TableView<Interaction>();
		Image imageEdit = new Image("edit_icon.png");
		Image imageDelete = new Image("delete_icon.png");
		ImageView imageEditView = new ImageView(imageEdit);
		ImageView imageDeleteView = new ImageView(imageDelete);
		Button btnEdit = new Button("Edit", imageEditView);
		Button btnDelete = new Button("Delete", imageDeleteView);
		Button exportButton = new Button("Export");
		imageEditView.setFitHeight(15);
		imageEditView.setFitWidth(15);
		imageDeleteView.setFitHeight(15);
		imageDeleteView.setFitWidth(15);
		Button btnBack = new Button("Back");
		HBox hbBtn = new HBox(113);

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Styling of Buttons
		btnEdit.setTextFill(Color.BLACK);
		btnEdit.setStyle("-fx-base: #FFFFFF");

		btnDelete.setTextFill(Color.BLACK);
		btnDelete.setStyle("-fx-base: #FFFFFF");

		btnBack.setTextFill(Color.BLACK);
		btnBack.setStyle("-fx-base: #FFFFFF");

		exportButton.setTextFill(Color.BLACK);
		exportButton.setStyle("-fx-base: #FFFFFF");

		// Action for back button to return program to the home screen
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				HomeGUI homeGUI = new HomeGUI();
				try {
					homeGUI.start(primaryStage);
				} catch (Exception error) {
					DialogGUI.showError("Error Changing to Home View", error.toString());
				}
			}
		});

		// adds buttons to box
		hbBtn.getChildren().add(btnBack);
		hbBtn.getChildren().add(btnDelete);
		hbBtn.getChildren().add(btnEdit);
		hbBtn.getChildren().add(exportButton);

		// adds box and list view to grid for display
		grid.add(hbBtn, 1, 1);

		if (HomeGUI.getType().equals("Person")) {
			// sets size of list view
			personResultsView.setMinSize(600, 300);
			personResultsView.setMaxSize(600, 300);
			TableColumn<Person, String> nameCol = new TableColumn<Person, String>("Name");
			nameCol.setMinWidth(75);
			nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
			TableColumn<Person, String> nicknameCol = new TableColumn<Person, String>("Nickname");
			nicknameCol.setMinWidth(75);
			nicknameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("nickname"));
			TableColumn<Person, String> genderCol = new TableColumn<Person, String>("Gender");
			genderCol.setMinWidth(75);
			genderCol.setCellValueFactory(new PropertyValueFactory<Person, String>("gender"));
			TableColumn<Person, String> cultureCol = new TableColumn<Person, String>("Culture");
			cultureCol.setMinWidth(75);
			cultureCol.setCellValueFactory(new PropertyValueFactory<Person, String>("culture"));
			TableColumn<Person, String> occupationCol = new TableColumn<Person, String>("Occupation");
			occupationCol.setMinWidth(100);
			occupationCol.setCellValueFactory(new PropertyValueFactory<Person, String>("occupation"));
			TableColumn<Person, String> notesCol = new TableColumn<Person, String>("Notes");
			notesCol.setMinWidth(185);
			notesCol.setCellValueFactory(new PropertyValueFactory<Person, String>("notes"));
			personResultsView.getColumns().addAll(nameCol, nicknameCol, genderCol, cultureCol, occupationCol, notesCol);
			grid.add(personResultsView, 1, 0);
			if (HomeGUI.getSearchKey().isEmpty() || HomeGUI.getSearchKey().equals(" ")) {
				oListPersonResults = FXCollections.observableArrayList(DataCollections.getPersonCollection());
			} else {
				oListPersonResults = FXCollections.observableArrayList(SearchUtil.searchPeople(HomeGUI.getSearchKey()));
			}
			personResultsView.setItems(oListPersonResults);

			exportButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					DialogGUI.confirmation("Export Confirmation" , "Do you want to export this people list to Gephi file?"); 
					try {
						CSVUtil.gephiExportNodes("data/GephiExportNodes.csv", oListPersonResults);
					} catch (IOException error) {
						DialogGUI.showError("Error Exporting Nodes to Gephi", error.toString());
					}
				}
			});

			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = personResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						if (DialogGUI.confirmation("Deleting Person From List",
								"Are you sure you want to delete this person?")) {
							for (int i = 0; i < DataCollections.getInteractionCollection().size(); i++) {
								for (int j = 0; j < DataCollections.getInteractionCollection().get(i).getPeople1()
										.size(); j++) {
									if (DataCollections.getInteractionCollection().get(i).getPeople1().get(j)
											.equals(personResultsView.getSelectionModel().getSelectedItem())) {
										DataCollections.getInteractionCollection().get(i).getPeople1().remove(j);
									}
								}
								for (int j = 0; j < DataCollections.getInteractionCollection().get(i).getPeople2()
										.size(); j++) {
									if (DataCollections.getInteractionCollection().get(i).getPeople2().get(j)
											.equals(personResultsView.getSelectionModel().getSelectedItem())) {
										DataCollections.getInteractionCollection().get(i).getPeople2().remove(j);
									}
								}
							}
							DataCollections.getPersonCollection()
									.remove(personResultsView.getSelectionModel().getSelectedItem());
							oListPersonResults.remove(selectedIndex);
							System.out.println(DataCollections.getPersonCollection().size());
						}
					}
				}
			});

			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = personResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						selectedPerson = personResultsView.getSelectionModel().getSelectedItem();
						EditPersonGUI editPerson = new EditPersonGUI();
						editPerson.start(primaryStage);
					}

				}
			});
		}
		if (HomeGUI.getType().equals("Interaction")) {
			interactionResultsView.setMinSize(600, 300);
			interactionResultsView.setMaxSize(600, 300);
			TableColumn<Interaction, String[]> people1Col = new TableColumn<Interaction, String[]>("People");
			people1Col.setMinWidth(75);
			people1Col.setCellValueFactory(new PropertyValueFactory<Interaction, String[]>("people1"));
			TableColumn<Interaction, String[]> people2Col = new TableColumn<Interaction, String[]>(
					"People Interacted With");
			people2Col.setMinWidth(75);
			people2Col.setCellValueFactory(new PropertyValueFactory<Interaction, String[]>("people2"));
			TableColumn<Interaction, String> locationCol = new TableColumn<Interaction, String>("Location");
			locationCol.setMinWidth(75);
			locationCol.setCellValueFactory(new PropertyValueFactory<Interaction, String>("location"));
			TableColumn<Interaction, String> dateCol = new TableColumn<Interaction, String>("Date");
			dateCol.setMinWidth(75);
			dateCol.setCellValueFactory(new PropertyValueFactory<Interaction, String>("date"));
			TableColumn<Interaction, String> interactionTypeCol = new TableColumn<Interaction, String>(
					"Interaction Type");
			interactionTypeCol.setMinWidth(75);
			interactionTypeCol.setCellValueFactory(new PropertyValueFactory<Interaction, String>("interactionType"));
			TableColumn<Interaction, String> citationCol = new TableColumn<Interaction, String>(
					"Bibliographical Citation");
			citationCol.setMinWidth(75);
			citationCol.setCellValueFactory(new PropertyValueFactory<Interaction, String>("citation"));
			TableColumn<Interaction, String> notesCol = new TableColumn<Interaction, String>("Notes");
			notesCol.setMinWidth(125);
			notesCol.setCellValueFactory(new PropertyValueFactory<Interaction, String>("notes"));
			grid.add(interactionResultsView, 1, 0);
			interactionResultsView.getColumns().addAll(people1Col, people2Col, locationCol, dateCol, interactionTypeCol,
					citationCol, notesCol);
			if (HomeGUI.getSearchKey().isEmpty() || HomeGUI.getSearchKey().equals(" ")) {
				oListInteractionResults = FXCollections.observableArrayList(DataCollections.getInteractionCollection());
			} else {
				oListInteractionResults = FXCollections
						.observableArrayList(SearchUtil.searchInteractions(HomeGUI.getSearchKey()));
			}

			interactionResultsView.setItems(oListInteractionResults);
			exportButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Export Chooser");
					alert.setHeaderText("Choose the Export File");
					alert.setContentText("Choose your option.");

					ButtonType buttonTypePalladio = new ButtonType("Palladio");
					ButtonType buttonTypeGephi = new ButtonType("Gephi");
					ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

					alert.getButtonTypes().setAll(buttonTypePalladio, buttonTypeGephi, buttonTypeCancel);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == buttonTypePalladio){
						try {
							CSVUtil.palladioExport("data/PalladioExport.csv", oListInteractionResults);
						} catch (IOException error) {
							DialogGUI.showError("Error Exporting Palladio CSV File", error.toString());
						}
					} else if (result.get() == buttonTypeGephi) {
						try {
							CSVUtil.gephiExportEdges("data/GephyExportEdges.csv", oListInteractionResults);
						} catch (IOException error) {
							DialogGUI.showError("Error Exporting to Gephi CSV File", error.toString());
						}
					}
					
				}
			});

			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = interactionResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						if (DialogGUI.confirmation("Deleteing Interaction",
								"Are you sure you want to delete this interaction?")) {
							DataCollections.getInteractionCollection()
									.remove(interactionResultsView.getSelectionModel().getSelectedItem());
							oListInteractionResults.remove(selectedIndex);
						}
					}
				}
			});

			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = interactionResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						selectedInteraction = interactionResultsView.getSelectionModel().getSelectedItem();
						EditInteractionGUI interactionEdit = new EditInteractionGUI();
						interactionEdit.start(primaryStage);
					}

				}
			});
		}

		// primaryStage methods
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				CSVUtil.savePerson();
				CSVUtil.saveInteractions();
			}
		});
		
		primaryStage.setTitle("Search Results");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static Person getSelectedPerson() {
		return selectedPerson;
	}

	public static Interaction getSelectedInteraction() {
		return selectedInteraction;
	}

}

