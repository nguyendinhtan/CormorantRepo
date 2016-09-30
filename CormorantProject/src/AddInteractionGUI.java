import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddInteractionGUI extends Application {
	Collections lists;
	ControlledVocab vocabList;
	ObservableList<String> oListLocation;
	ObservableList<String> oListCitation;
	ObservableList<String> oListInteractionType;
	ObservableList<Person> oListPerson1;
	ObservableList<Person> oListPerson2;
	public static void main(String[] args) {
		launch(args);

	}
	public AddInteractionGUI(){
		lists=new Collections();
		vocabList=new ControlledVocab();
		
	}
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Insert Interaction");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		HBox hbPersonLb=new HBox(185);
		Label person1Lb=new Label("Person(s):");
	    hbPersonLb.getChildren().add(person1Lb);
	    Label person2Lb=new Label("Person(s) Interacted With:");
	    hbPersonLb.getChildren().add(person2Lb);
		grid.add(hbPersonLb, 1, 0);
	    HBox hbBtnList1=new HBox();
		HBox hbPersonLists=new HBox(50);
	    ComboBox<Person> person1=new ComboBox<Person>();
	    person1.setMinSize(150, 20);
	    hbBtnList1.getChildren().add(person1);
	    Button btnAdd1=new Button("Add");
	    btnAdd1.setTextFill(Color.WHITE);
		btnAdd1.setStyle("-fx-base: #FF0000");
		hbBtnList1.getChildren().add(btnAdd1);
	    oListPerson1=FXCollections.observableArrayList(lists.getPersonCollection());
	    person1.setItems(oListPerson1);
	    hbPersonLists.getChildren().add(hbBtnList1);
	    HBox hbBtnList2=new HBox();
	    ComboBox<Person> person2=new ComboBox<Person>();
	    person2.setMinSize(150, 20);
	    oListPerson2=FXCollections.observableArrayList(lists.getPersonCollection());
	    hbBtnList2.getChildren().add(person2);
	    Button btnAdd2=new Button("Add");
	    btnAdd2.setTextFill(Color.WHITE);
		btnAdd2.setStyle("-fx-base: #FF0000");
		hbBtnList2.getChildren().add(btnAdd2);
	    hbPersonLists.getChildren().add(hbBtnList2);
	    grid.add(hbPersonLists, 1, 1);
	    person2.setItems(oListPerson2);
		HBox hbPersonArea=new HBox(50);
		ListView<Person> person1List = new ListView<Person>();
		person1List.setMaxSize(200, 100);
		hbPersonArea.getChildren().add(person1List);
	    ListView<Person> person2List = new ListView<Person>();
	    person2List.setMaxSize(200, 100);
	    hbPersonArea.getChildren().add(person2List);
	    grid.add(hbPersonArea, 1, 2);
	    HBox hbRemoveBtns=new HBox(50);
	    Button btnRemove1=new Button("Remove");
	    btnRemove1.setTextFill(Color.WHITE);
		btnRemove1.setStyle("-fx-base: #FF0000");
		btnRemove1.setMinSize(200, 20);
		hbRemoveBtns.getChildren().add(btnRemove1);
		Button btnRemove2=new Button("Remove");
	    btnRemove2.setTextFill(Color.WHITE);
		btnRemove2.setStyle("-fx-base: #FF0000");
		btnRemove2.setMinSize(200, 20);
		hbRemoveBtns.getChildren().add(btnRemove2);
		grid.add(hbRemoveBtns, 1, 3);
		Label locactionLb=new Label("Location:");
		grid.add(locactionLb, 0, 4);
		ComboBox<String> location = new ComboBox<String>(); 
		oListLocation=FXCollections.observableArrayList(vocabList.getLocationVocab());
		location.setItems(oListLocation);
		location.setMinSize(450, 10);
		grid.add(location, 1, 4);
		Label dateLb=new Label("Date:");
		grid.add(dateLb, 0, 5);
		TextField dateTextField = new TextField();
	    grid.add(dateTextField, 1, 5);
	    Label interactionTypeLb=new Label("Interaction Type:");
		grid.add(interactionTypeLb, 0, 6);
		ComboBox<String> interactionType = new ComboBox<String>(); 
		oListInteractionType=FXCollections.observableArrayList(vocabList.getInteractionTypeVocab());
		interactionType.setItems(oListInteractionType);
		interactionType.setMinSize(450, 10);
		grid.add(interactionType, 1,6);
	    Label citationLb=new Label("Bibliographical Citation:");
		grid.add(citationLb, 0, 7);
		ComboBox<String> citation= new ComboBox<String>(); 
		oListCitation=FXCollections.observableArrayList(vocabList.getCitationVocab());
		citation.setItems(oListCitation);
		grid.add(citation, 1, 7);
		citation.setMinSize(450, 10);
		HBox hbNotesLb=new HBox();
		Label notesLb=new Label("Notes:");
		hbNotesLb.getChildren().add(notesLb);
		hbNotesLb.setAlignment(Pos.TOP_LEFT);
		grid.add(hbNotesLb, 0, 8);
	    TextArea notesTextArea = new TextArea();
	    notesTextArea.setMaxSize(450, 100);
	    grid.add(notesTextArea, 1, 8);
		Button btnAddInteraction = new Button("Add Interation");
		btnAddInteraction.setTextFill(Color.WHITE);
		btnAddInteraction.setStyle("-fx-base: #FF0000");
		grid.add(btnAddInteraction,0,9);
		btnAddInteraction.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	//if (){
            		Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("No data entered.");
					alert.setContentText("Please enter persons.");
					alert.showAndWait();
            	//}
            }
        });
		HBox hbBtn = new HBox(10);
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnBack);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbBtn, 1, 9);
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage);
            }
        });

		Scene scene = new Scene(grid, 700, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
