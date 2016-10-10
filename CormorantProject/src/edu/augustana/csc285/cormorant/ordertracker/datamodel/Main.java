package edu.augustana.csc285.cormorant.ordertracker.datamodel;
import edu.augustana.csc285.cormorant.ordertracker.gui.HomeGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


	public static void main(String[] args) {
		launch(args);
    }
	
    public void start(Stage primaryStage) throws Exception {
    	//Dummy Data for testing
    	/*Person jared=new Person(1, "Jared", "Male", "American", "Student", "CSC Major");
    	Person juan=new Person(2, "Juan", "Male", "Spanish","Teacher", "test person" );
   		Person anon=new Person(3, "Anonymous","Unknown", "Unknown", "Unknown", " ");
   		list.addPerson(jared);
 		list.addPerson(juan);
   		list.addPerson(anon);*/
		CSVUtil.loadPerson("data/People.csv");
		CSVUtil.loadInteractions("data/Interaction.csv");
		ControlledVocab.addLocationVocab("Rock Island");
		ControlledVocab.addLocationVocab("Moline");
		ControlledVocab.addLocationVocab("Davenport");
		ControlledVocab.addInteractionTypeVocab("Journal");
		ControlledVocab.addInteractionTypeVocab("Party");
		ControlledVocab.addInteractionTypeVocab("Letter");
		ControlledVocab.addCultureVocab("American");
		ControlledVocab.addCultureVocab("French");
		ControlledVocab.addOccupationVocab("Painter");
		ControlledVocab.addOccupationVocab("Sculptor");
		HomeGUI homeGUI = new HomeGUI();
		homeGUI.start(primaryStage);
	}

}
