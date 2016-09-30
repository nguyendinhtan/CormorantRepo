import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AddInteractionGUI extends Application {
	public static void main(String[] args) {
		launch(args);

	}
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Insert Interaction");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		HBox hbPersonLb=new HBox(165);
		Label person1Lb=new Label("Person(s):");
	    hbPersonLb.getChildren().add(person1Lb);
	    Label person2Lb=new Label("Person(s) Interacted With:");
	    hbPersonLb.getChildren().add(person2Lb);
		grid.add(hbPersonLb, 1, 0);
	    HBox hbPersonArea=new HBox(50);
		TextArea person1TextArea = new TextArea();
		person1TextArea.setMaxSize(175, 100);
		hbPersonArea.getChildren().add(person1TextArea);
	    TextArea person2TextArea = new TextArea();
	    person2TextArea.setMaxSize(175, 100);
	    hbPersonArea.getChildren().add(person2TextArea);
	    grid.add(hbPersonArea, 1, 1);
		Label locactionLb=new Label("Location:");
		grid.add(locactionLb, 0, 2);
		ComboBox location = new ComboBox(); 
		location.getItems().addAll(
				
		);
		location.setMinSize(450, 10);
		grid.add(location, 1, 2);
		Label dateLb=new Label("Date:");
		grid.add(dateLb, 0, 3);
		TextField dateTextField = new TextField();
	    grid.add(dateTextField, 1, 3);
	    Label interactionTypeLb=new Label("Interaction Type:");
		grid.add(interactionTypeLb, 0, 4);
		ComboBox interactionType = new ComboBox(); 
		interactionType.getItems().addAll(
				
		);
		interactionType.setMinSize(450, 10);
		grid.add(interactionType, 1,4);
	    Label citationLb=new Label("Bibliographical Citation:");
		grid.add(citationLb, 0, 5);
		ComboBox citation= new ComboBox(); 
		citation.getItems().addAll(
				
		);
		grid.add(citation, 1, 5);
		citation.setMinSize(450, 10);
		HBox hbNotesLb=new HBox();
		Label notesLb=new Label("Notes:");
		hbNotesLb.getChildren().add(notesLb);
		hbNotesLb.setAlignment(Pos.TOP_LEFT);
		grid.add(hbNotesLb, 0, 6);
	    TextArea notesTextArea = new TextArea();
	    notesTextArea.setMaxSize(450, 100);
	    grid.add(notesTextArea, 1, 6);
		Button btnAddInteraction = new Button("Add Interation");
		btnAddInteraction.setTextFill(Color.BLACK);
		btnAddInteraction.setTextFill(Color.WHITE);
		btnAddInteraction.setStyle("-fx-base: #FF0000");
		grid.add(btnAddInteraction,0,7);
		btnAddInteraction.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	
            }
        });
		HBox hbBtn = new HBox(10);
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnBack);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbBtn, 1, 7);
		btnBack.setOnAction(new EventHandler<ActionEvent>() {
	       	 
            @Override
            public void handle(ActionEvent e) {
            	HomeGUI Homegui=new HomeGUI();
            	Homegui.start(primaryStage);
            }
        });

		Scene scene = new Scene(grid, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
