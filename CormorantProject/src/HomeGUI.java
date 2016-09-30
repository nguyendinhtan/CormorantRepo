import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HomeGUI extends Application{
	
	public static void main(String[] args){
		launch(args);
	}
	
    public void start(Stage primaryStage) {
        //GUI Variables
        GridPane grid = new GridPane();
        Scene scene = new Scene(grid, 700, 300);
        ComboBox<String> searchType=new ComboBox<String>();
        TextField searchTextField = new TextField();
        Button searchButton = new Button("Search");
        Button insertPersonButton = new Button("Insert Person");
        Button insertInteractionButton = new Button("Insert Interaction");
        Button editVocabButton = new Button("Edit Controlled Vocabulary");
        HBox topRowBox = new HBox();
        HBox bottomButtonRowBox = new HBox(10);
        
        //Grid Methods
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //DropDown list for choosing search type
        searchType.getItems().addAll(
				"Person",
				"Interaction"
		);
		System.setProperty("glass.accessible.force", "false");//Fixes bug of crashing combobox
		       
        //Search Text Field Methods
        searchTextField.setMinSize(275, 10);
        
        //Search Button Methods
        searchButton.setTextFill(Color.WHITE);
        searchButton.setStyle("-fx-base: #FF0000"); 
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	SearchResultGUI searchGUI=new SearchResultGUI();
            	searchGUI.start(primaryStage);
            }
        });
        
        //Top Row Box Methods
        topRowBox.setAlignment(Pos.CENTER_RIGHT);
        topRowBox.getChildren().add(searchType);
        topRowBox.getChildren().add(searchTextField);
        topRowBox.getChildren().add(searchButton);
 
        //Insert Person Button Methods
        insertPersonButton.setTextFill(Color.BLACK);
        insertPersonButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	AddPersonGUI gui = new AddPersonGUI();
            	gui.start(primaryStage);
            }
        });
        
        //Insert Interaction Button Methods
        insertInteractionButton.setOnAction(new EventHandler<ActionEvent>() {  	 
            @Override
            public void handle(ActionEvent e) {
            	AddInteractionGUI gui = new AddInteractionGUI();
            	gui.start(primaryStage);
            }
        });
              
        //Edit Vocab Button Methods
        editVocabButton.setTextFill(Color.BLACK);
        editVocabButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	EditVocabGUI gui = new EditVocabGUI();
            	gui.start(primaryStage);
            }
        });
        
        //Bottom Button Row Box
        bottomButtonRowBox.getChildren().add(insertPersonButton);
        bottomButtonRowBox.getChildren().add(insertInteractionButton);
        bottomButtonRowBox.getChildren().add(editVocabButton);
        
        //Adds Boxes to grid for display
        grid.add(topRowBox, 1, 0);
        grid.add(bottomButtonRowBox, 1, 1);
  
        //Primary Stage Methods
        primaryStage.setTitle("Home Screen");
        primaryStage.setScene(scene);	
        primaryStage.show();
    }
    
}
	