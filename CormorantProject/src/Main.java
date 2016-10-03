import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	DataCollections list;
	public Main(){
		list=new DataCollections();
	}

	public static void main(String[] args) {
		launch(args);

    }
	
    public void start(Stage primaryStage) {
    	//Dummy Data for testing
    	Person jared=new Person(1, "Jared", "Male", "American", "Student", "CSC Major");
    	Person juan=new Person(2, "Juan", "Male", "Spanish","Teacher", "test person" );
   		Person anaon=new Person(3, "Anonymous","Unknown", "Unknown", "Unknown", " ");
   		list.addPerson(jared);
 		list.addPerson(juan);
   		list.addPerson(anaon);
  		list.addLocationVocab("Rock Island");
   		list.addLocationVocab("Moline");
   		list.addLocationVocab("Davenport");
   		list.addInteractionTypeVocab("Journal");
   		list.addInteractionTypeVocab("Party");
   		list.addInteractionTypeVocab("Letter");
   		list.addCitationVocab("test");
   		list.addCitationVocab("test2");
    	HomeGUI homeGUI = new HomeGUI();
    	homeGUI.start(primaryStage,list);	
    }

}
