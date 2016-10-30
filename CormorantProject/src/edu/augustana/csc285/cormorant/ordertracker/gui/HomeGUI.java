
package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.logging.Level;
import java.util.logging.Logger;
>>>>>>> 7823146da2bec74bf0eabb88dc419c92c545155b

import edu.augustana.csc285.cormorant.ordertracker.datamodel.CSVUtil;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class HomeGUI extends Application {
	private ComboBox<String> searchType;
	private static String typeOfSearch;
	private static String searchKey;
	private static String pathFileOpen;
	private static String pathFileSave;
	private Desktop desktop = Desktop.getDesktop();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// GUI Variables
		
		BorderPane layout=new BorderPane();
		Scene scene = new Scene(layout);
		searchType = new ComboBox<String>();
		TextField searchTextField = new TextField();
		Image imageSearch = new Image("search_icon.png");
		Image imagePerson = new Image("person_icon.png");
		Image imageInteraction = new Image("interaction_icon.png");
		Image imageEdit = new Image("edit_icon.png");
		ImageView imageSearchView = new ImageView(imageSearch);
		ImageView imagePersonView = new ImageView(imagePerson);
		ImageView imageInteractionView = new ImageView(imageInteraction);
		ImageView imageEditView = new ImageView(imageEdit);
		Button searchButton = new Button("Search", imageSearchView);
		imageSearchView.setFitHeight(15);
		imageSearchView.setFitWidth(15);
		Button insertPersonButton = new Button("Insert Person", imagePersonView);
		imagePersonView.setFitHeight(20);
		imagePersonView.setFitWidth(20);
		Button insertInteractionButton = new Button("Insert Interaction", imageInteractionView);
		imageInteractionView.setFitHeight(20);
		imageInteractionView.setFitWidth(20);
		Button editVocabButton = new Button("Edit Controlled Vocabulary", imageEditView);
		imageEditView.setFitHeight(20);
		imageEditView.setFitWidth(20);
		HBox topRowBox = new HBox();
		HBox bottomButtonRowBox = new HBox(30);
		VBox centerBox=new VBox(10);
		MenuBar menuBar=new MenuBar();
		Menu menuFile=new Menu("File");
		Menu menuHelp=new Menu("Help");
		MenuItem newProjectMenu=new MenuItem("New Project");
		MenuItem openProjectMenu=new MenuItem("Open Existing Project");
		MenuItem aboutMenu=new MenuItem("About");
		aboutMenu.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent ae) {
				DialogGUI.showInfo("Help File", "Here is help.");
				 if (Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
			            try {
							Desktop.getDesktop().open(new File("../Readme.md"));
						} catch (IOException e) {
							DialogGUI.showError("Error Opening README", e.toString());
						}
			        }
			}
		});
		menuFile.getItems().addAll(newProjectMenu, openProjectMenu);
		menuHelp.getItems().addAll(aboutMenu);
		menuBar.getMenus().addAll(menuFile, menuHelp);
		
		newProjectMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				final FileChooser fileChooser = new FileChooser(); 
				fileChooser.setTitle("Create New Project");
	            File file = fileChooser.showSaveDialog(primaryStage);
	            if (file != null) {
	            	pathFileSave = file.getAbsolutePath();
	            }
			}
		});
		
		openProjectMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				final FileChooser fileChooser = new FileChooser(); 
				fileChooser.setTitle("Open Existing Project");
	            File file = fileChooser.showOpenDialog(primaryStage);
	            if (file != null) {
	            	pathFileOpen = file.getAbsolutePath();
	            }
			}
		});

		aboutMenu.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		// Grid Methods

		// DropDown list for choosing search type
		searchType.getItems().addAll("Person", "Interaction");
		searchType.setPromptText("Search Category");
		System.setProperty("glass.accessible.force", "false");// Fixes bug of
																// crashing
																// combobox

		// Search Text Field Methods
		searchTextField.setMinSize(325, 10);
		searchTextField.setMaxSize(325, 50);
		searchTextField.setPromptText("Search Query");

		// Search Button Methods
		searchButton.setTextFill(Color.WHITE);
		searchButton.setStyle("-fx-base: #FF0000");
		searchButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (searchType.getValue() != null) {
					SearchResultGUI searchGUI = new SearchResultGUI();
					typeOfSearch = searchType.getValue();
					searchKey = searchTextField.getText();
					searchGUI.start(primaryStage);
				}
			}
		});

		// Top Row Box Methods
		topRowBox.setAlignment(Pos.CENTER_RIGHT);
		topRowBox.getChildren().add(searchType);
		topRowBox.getChildren().add(searchTextField);
		topRowBox.getChildren().add(searchButton);

		// Insert Person Button Methods
		insertPersonButton.setTextFill(Color.BLACK);
		insertPersonButton.setAlignment(Pos.CENTER_LEFT);
		insertPersonButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AddPersonGUI gui = new AddPersonGUI();
				try {
					gui.start(primaryStage);
				} catch (Exception error) {
					DialogGUI.showError("Error Changing to Add Person View", error.toString());
				}
			}
		});

		// Insert Interaction Button Methods
		insertInteractionButton.setAlignment(Pos.CENTER);
		insertInteractionButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				AddInteractionGUI gui = new AddInteractionGUI();
				try {
					gui.start(primaryStage);
				} catch (Exception error) {
					DialogGUI.showError("Error Changing to Add Interaction View", error.toString());
				}
			}
		});

		// Edit Vocab Button Methods
		editVocabButton.setTextFill(Color.BLACK);
		editVocabButton.setAlignment(Pos.CENTER_RIGHT);
		editVocabButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				EditVocabGUI gui = new EditVocabGUI();
				gui.start(primaryStage);
			}
		});

		// Bottom Button Row Box
		bottomButtonRowBox.getChildren().add(insertPersonButton);
		bottomButtonRowBox.getChildren().add(insertInteractionButton);
		bottomButtonRowBox.getChildren().add(editVocabButton);

		// Adds Boxes to grid for display
		centerBox.setPadding(new Insets(10, 20, 10, 20));
		centerBox.getChildren().addAll(topRowBox, bottomButtonRowBox);
		layout.setTop(menuBar);
		layout.setCenter(centerBox);

		// Primary Stage Methods
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				CSVUtil.savePerson();
				CSVUtil.saveInteractions();
			}
		});
		primaryStage.setTitle("Home Screen");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static String getType() {
		return typeOfSearch;
	}

	public static String getSearchKey() {
		return searchKey;
	}
	
	private void openFile(File file) {
	    try {
	    	desktop.open(file);
	    } catch (IOException ex) {
	        Logger.getLogger(
	            FileChooser.class.getName()).log(
	                Level.SEVERE, null, ex
	            );
	    }
	}
}

