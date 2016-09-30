import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        primaryStage.setTitle("Home Screen");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        TextField searchTextField = new TextField();
        searchTextField.setMinSize(400, 10);
        HBox hbTopRow = new HBox();
        hbTopRow.setAlignment(Pos.CENTER_RIGHT);
        hbTopRow.getChildren().add(searchTextField);

        Button btnSearch = new Button("Search");
        btnSearch.setTextFill(Color.WHITE);
        btnSearch.setStyle("-fx-base: #FF0000"); 
        hbTopRow.getChildren().add(btnSearch);
        grid.add(hbTopRow, 1, 0);
        
        
        
        Button btnInsertPerson = new Button("Insert Person");
        btnInsertPerson.setTextFill(Color.BLACK); 
        HBox hbBtnBottomRow = new HBox(10);
        hbBtnBottomRow.getChildren().add(btnInsertPerson);
        btnInsertPerson.setOnAction(new EventHandler<ActionEvent>() {
       	 
            @Override
            public void handle(ActionEvent e) {
            	AddPersonGUI gui=new AddPersonGUI();
            	gui.start(primaryStage);
            }
        });
        
        Button btnInsertInteraction = new Button("Insert Interaction");
        btnInsertPerson.setTextFill(Color.BLACK); 
        hbBtnBottomRow.getChildren().add(btnInsertInteraction);
        grid.add(hbBtnBottomRow, 1, 1);
        btnInsertInteraction.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent e) {
            	AddInteractionGUI gui=new AddInteractionGUI();
            	gui.start(primaryStage);
            }
        });
        Button btnEditVocab = new Button("Edit Controlled Vocabulary");
        btnEditVocab.setTextFill(Color.BLACK);
        hbBtnBottomRow.getChildren().add(btnEditVocab);
        
        
        btnEditVocab.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent e) {
            	EditVocabGUI gui=new EditVocabGUI();
            	gui.start(primaryStage);
            }
        });
        Scene scene = new Scene(grid, 700, 300);
        primaryStage.setScene(scene);	
        primaryStage.show();
    }
    
}
	