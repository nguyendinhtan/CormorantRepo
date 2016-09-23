import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
public class GUI extends Application{
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
        grid.add(searchTextField, 1, 1);


        Button btnSearch = new Button("Search");
        btnSearch.setTextFill(Color.WHITE);
        btnSearch.setStyle("-fx-base: #FF0000"); 
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER_RIGHT);
        hbBtn.getChildren().add(btnSearch);
        
        Button btnInsert = new Button("Insert");
        btnInsert.setTextFill(Color.BLACK); 
        hbBtn.getChildren().add(btnInsert);
        grid.add(hbBtn, 1, 4);
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);	
        primaryStage.show();
    }
    
}
	