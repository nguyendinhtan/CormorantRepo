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

public class SearchResultGUI extends Application {
	ObservableList<Person> oListResults;
	public static void main(String[] args) {
		launch(args);
	}
	public SearchResultGUI(){
		
		
	}
	//@override
	public void start(Stage primaryStage, String type) {
		//Dummy Data for testing
		Person jared=new Person(1, "Jared", "Male", "American", "Student", "CSC Major");
		Person juan=new Person(2, "Juan", "Male", "Spanish","Teacher", "test person" );
		Person anaon=new Person(3, "Anonymous","Unknown", "Unknown", "Unknown", " ");
		DataCollections personList=new DataCollections();
		personList.addPerson(jared);
		personList.addPerson(juan);
		personList.addPerson(anaon);
		
		//GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 600, 400);
		ListView<Person> searchResultsView=new ListView<Person>();
		Button btnEdit = new Button("Edit");
		Button btnDelete = new Button("Delete");
		Button btnBack = new Button("Back");
		HBox hbBtn=new HBox(120);
		
		//Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//sets size of list view
		searchResultsView.setMinSize(400, 300);
		
		//Styling of Buttons
		btnEdit.setTextFill(Color.BLACK);
		btnEdit.setTextFill(Color.WHITE);
		btnEdit.setStyle("-fx-base: #FF0000");
		
		btnDelete.setTextFill(Color.WHITE);
		btnDelete.setStyle("-fx-base: #FF0000");
		btnDelete.setTextFill(Color.WHITE);
		
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		
		//Action for back button to return program to the home screen
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage, personList);
            }
        });
		
		//adds buttons to box
		hbBtn.getChildren().add(btnEdit);
		hbBtn.getChildren().add(btnDelete);
		hbBtn.getChildren().add(btnBack);
		
		//adds box and list view to grid for display
		grid.add(searchResultsView, 1, 0);
		grid.add(hbBtn, 1,1);
		
		
		if (type.equals("Person")){
			oListResults=FXCollections.observableArrayList(personList.getPersonCollection());
			searchResultsView.setItems(oListResults);
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
