import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	DataCollections list;
	public Main(){
		list=new DataCollections();
	}
	public static void main(String[] args) {
		//Dummy data for testing
		launch(args);
    }
	
    public void start(Stage primaryStage) {
    	HomeGUI homeGUI = new HomeGUI();
    	homeGUI.start(primaryStage,list );	
    }
}
