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
		Label person1Lb=new Label("Person(s):");
	    grid.add(person1Lb, 0, 0);
	    HBox hbPerson2=new HBox(10);
		TextField person1TextField = new TextField();
		hbPerson2.getChildren().add(person1TextField);
	    Label person2Lb=new Label("Person(s):");
	    hbPerson2.getChildren().add(person2Lb);
	    TextField person2TextField = new TextField();
	    hbPerson2.getChildren().add(person2TextField);
	    grid.add(hbPerson2, 1, 0);
		Label locactionLb=new Label("Location:");
		grid.add(locactionLb, 0, 1);
		ComboBox location = new ComboBox(); 
		location.getItems().addAll(
				
		);
		location.setMinSize(450, 10);
		grid.add(location, 1, 1);
		Label dateLb=new Label("Date:");
		grid.add(dateLb, 0, 2);
		TextField dateTextField = new TextField();
	    grid.add(dateTextField, 1, 2);
	    Label interactionTypeLb=new Label("Interaction Type:");
		grid.add(interactionTypeLb, 0, 3);
		ComboBox interactionType = new ComboBox(); 
		interactionType.getItems().addAll(
				
		);
		interactionType.setMinSize(450, 10);
		grid.add(interactionType, 1,3);
	    Label citationLb=new Label("Bibliographical Citation:");
		grid.add(citationLb, 0, 4);
		ComboBox citation= new ComboBox(); 
		citation.getItems().addAll(
				
		);
		grid.add(citation, 1, 4);
		citation.setMinSize(450, 10);
		HBox hbNotesLb=new HBox();
		Label notesLb=new Label("Notes:");
		hbNotesLb.getChildren().add(notesLb);
		hbNotesLb.setAlignment(Pos.TOP_LEFT);
		grid.add(hbNotesLb, 0, 5);
	    TextArea notesTextArea = new TextArea();
	    notesTextArea.setMaxSize(450, 100);
	    grid.add(notesTextArea, 1, 5);
		Button btnAddPerson = new Button("Add Interation");
		btnAddPerson.setTextFill(Color.BLACK);
		btnAddPerson.setTextFill(Color.WHITE);
		btnAddPerson.setStyle("-fx-base: #FF0000");
		grid.add(btnAddPerson,0,6);
		HBox hbBtn = new HBox(10);
		Button btnBack = new Button("Back");
		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");
		hbBtn.getChildren().add(btnBack);
		hbBtn.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbBtn, 1, 6);
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
