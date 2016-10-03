import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * Search Result GUI view class.
 */
public class SearchResultGUI extends Application {

	ObservableList<Person> oListPersonResults;
	ObservableList<Interaction> oListInteractionResults;
	
	//@override
	public void start(Stage primaryStage, String type, DataCollections list) {
		
		//GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 600, 400);
		ListView<Person> personResultsView=new ListView<Person>();
		ListView<Interaction> interactionResultsView=new ListView<Interaction>();
		Button btnEdit = new Button("Edit");
		Button btnDelete = new Button("Delete");
		Button btnBack = new Button("Back");
		HBox hbBtn = new HBox(120);

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//Styling of Buttons
		btnEdit.setTextFill(Color.BLACK);
		btnEdit.setTextFill(Color.WHITE);
		btnEdit.setStyle("-fx-base: #FF0000");

		btnDelete.setTextFill(Color.WHITE);
		btnDelete.setStyle("-fx-base: #FF0000");
		btnDelete.setTextFill(Color.WHITE);

		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");

		// Action for back button to return program to the home screen
		btnBack.setOnAction(new EventHandler<ActionEvent>() {

	       	 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage, list);
            }
        });
		
		//adds buttons to box

		hbBtn.getChildren().add(btnEdit);
		hbBtn.getChildren().add(btnDelete);
		hbBtn.getChildren().add(btnBack);
		
		//adds box and list view to grid for display
		
		grid.add(hbBtn, 1,1);
		
		
		if (type.equals("Person")){
			//sets size of list view
			personResultsView.setMinSize(400, 300);
			personResultsView.setMaxSize(400, 300);
			grid.add(personResultsView, 1, 0);
			oListPersonResults=FXCollections.observableList(list.getPersonCollection());
			personResultsView.setItems(oListPersonResults);
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	int selectedIndex=personResultsView.getSelectionModel().getSelectedIndex();
	            	if (selectedIndex>=0){
	            	oListPersonResults.remove(selectedIndex);
	            	}
	            }
	        });
			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	int selectedIndex=personResultsView.getSelectionModel().getSelectedIndex();
	            	if (selectedIndex>=0){
	            		EditPersonGUI editPerson=new EditPersonGUI();
	            		editPerson.start(primaryStage, list, personResultsView.getSelectionModel().getSelectedItem());
	            	}
	            	
	            }
	        });
		}
		if (type.equals("Interaction")){
			interactionResultsView.setMinSize(400, 300);
			interactionResultsView.setMaxSize(400, 300);
			grid.add(interactionResultsView, 1, 0);
			oListInteractionResults=FXCollections.observableList(list.getInteractionCollection());
			interactionResultsView.setItems(oListInteractionResults);
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	int selectedIndex=interactionResultsView.getSelectionModel().getSelectedIndex();
	            	if (selectedIndex>=0){
	            	oListInteractionResults.remove(selectedIndex);
	            	}
	            }
	        });
			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent e) {
	            	int selectedIndex=interactionResultsView.getSelectionModel().getSelectedIndex();
	            	if (selectedIndex>=0){
	            		EditInteractionGUI interactionEdit=new EditInteractionGUI();
	            		interactionEdit.start(primaryStage, list, interactionResultsView.getSelectionModel().getSelectedItem());
	            	}
	            	
	            }
	        });
		}
		//primaryStage methods

		primaryStage.setTitle("Search Results");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
