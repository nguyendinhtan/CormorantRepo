import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	static DataCollections dataList;
	CSVUtil storage;

	public Main() {
		dataList = new DataCollections();
		storage = new CSVUtil();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		// Dummy Data for testing
		/*
		 * Person jared=new Person(1, "Jared", "Male", "American", "Student",
		 * "CSC Major"); Person juan=new Person(2, "Juan", "Male",
		 * "Spanish","Teacher", "test person" ); Person anon=new Person(3,
		 * "Anonymous","Unknown", "Unknown", "Unknown", " ");
		 * list.addPerson(jared); list.addPerson(juan); list.addPerson(anon);
		 */
		storage.loadPerson("data/People.csv");
		System.out.println(dataList.getPersonCollection().size());
		dataList.addLocationVocab("Rock Island");
		dataList.addLocationVocab("Moline");
		dataList.addLocationVocab("Davenport");
		dataList.addInteractionTypeVocab("Journal");
		dataList.addInteractionTypeVocab("Party");
		dataList.addInteractionTypeVocab("Letter");
		dataList.addCitationVocab("test");
		dataList.addCitationVocab("test2");
		HomeGUI homeGUI = new HomeGUI();
		homeGUI.start(primaryStage);
	}

}
