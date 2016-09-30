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

public class EditVocabGUI extends Application {
	ControlledVocab vocabLists;
	ObservableList<String> observableListVocab;
	public EditVocabGUI(){
		vocabLists=new ControlledVocab();
	}
	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Edit Controlled Vocabulary");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		Label vocabLb=new Label("Controlled Vocabulary Type:");
		grid.add(vocabLb, 0, 0);
		ComboBox<String> vocabType = new ComboBox<String>(); 
		vocabType.getItems().addAll(
				"Location",
				"Interaction Type",
				"Bibliographical Citation"
		);
		vocabType.setMinSize(300, 30);
		System.setProperty("glass.accessible.force", "false");//Fixes bug of crashing combobox
		grid.add(vocabType, 1, 0);
		ListView<String> listView=new ListView<String>();
		
		listView.setMinSize(100, 100);
		grid.add(listView, 1, 2);
		vocabType.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	if (vocabType.getValue().equals("Location")){
            		observableListVocab=FXCollections.observableArrayList(vocabLists.getLocationVocab());
            		
            	}else if (vocabType.getValue().equals("Interaction Type")){
            		observableListVocab=FXCollections.observableArrayList(vocabLists.getInteractionTypeVocab());
            	
            	}else if (vocabType.getValue().equals("Bibliographical Citation")){
            		observableListVocab=FXCollections.observableArrayList(vocabLists.getCitationVocab());
            		
            	}
            	
            	listView.setItems(observableListVocab);
            }
        });
		Label queryLb=new Label("Query:");
		grid.add(queryLb, 0, 1);
		TextField addVocabTextField = new TextField();
	    grid.add(addVocabTextField, 1, 1);
	    Label listLb=new Label("Vocabulary List:");
	    grid.add(listLb, 0, 2);
	    Button btnAdd = new Button("Add");
		btnAdd.setTextFill(Color.BLACK);
		btnAdd.setTextFill(Color.WHITE);
		btnAdd.setStyle("-fx-base: #FF0000");
		grid.add(btnAdd, 0, 4);
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	if (vocabType.getValue()==null || addVocabTextField.getText().isEmpty()){
            		Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Error");
					alert.setHeaderText("No data entered.");
					alert.setContentText("Please select a vocabulary type and enter new vocabulary into the query.");
					alert.showAndWait();
            	}else{
            	String vocab=addVocabTextField.getText();
            	if (vocabLists.checkForUnallowedInput(vocab)<0){
            			Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText("Invalid characters entered.");
						alert.setContentText(
								"Make sure no numbers or special characters are entered");
						alert.showAndWait();
            	}else{
            		if (vocabLists.checkForDuplicates(vocab, vocabType.getValue())>=0){
            			Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Error");
						alert.setHeaderText("List already contains that vocabulary.");
						alert.showAndWait();
            		}else{
            		if (vocabType.getValue().equals("Location")){
            			Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Vocabulary Added");
						alert.setHeaderText("Vocabulary added to location.");
						alert.showAndWait();
						vocabLists.addLocationVocab(vocab);
            			observableListVocab=FXCollections.observableArrayList(vocabLists.getLocationVocab());
            			
						//For Testing
						for (int i = 0; i < vocabLists.getLocationVocab().size(); i++) {
							System.out.println(vocabLists.getLocationVocab().get(i));
						}
                	}else if (vocabType.getValue().equals("Interaction Type")){
                		Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Vocabulary Added");
						alert.setHeaderText("Vocabulary added to interaction type.");
						alert.showAndWait();
                		vocabLists.addInteractionTypeVocab(vocab);
                		observableListVocab=FXCollections.observableArrayList(vocabLists.getInteractionTypeVocab());
                		//For Testing
						for (int i = 0; i < vocabLists.getInteractionTypeVocab().size(); i++) {
							System.out.println(vocabLists.getInteractionTypeVocab().get(i));
						}
                	}else if (vocabType.getValue().equals("Bibliographical Citation")){
                		Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Vocabulary Added");
						alert.setHeaderText("Vocabulary added to bibliographical citation.");
						alert.showAndWait();
                		vocabLists.addCitationVocab(vocab);
                		observableListVocab=FXCollections.observableArrayList(vocabLists.getCitationVocab());
                		//For Testing
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
		HBox hbBtn=new HBox(175);
		Button btnRemove=new Button("Remove");
		btnRemove.setTextFill(Color.WHITE);
		btnRemove.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnRemove);
		btnRemove.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	if (listView.getSelectionModel().getSelectedItem()==null){
            	
            	}else{
            	int deletedIndex=listView.getSelectionModel().getSelectedIndex();
            	observableListVocab.remove(deletedIndex);
            	vocabLists.remove(deletedIndex, vocabType.getValue());
            	listView.setItems(observableListVocab);
            	}
            		
            }
        });
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnBack);
		grid.add(hbBtn, 1, 4);
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage);
            }
        });
		
		Scene scene = new Scene(grid, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
