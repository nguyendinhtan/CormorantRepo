import java.io.IOException;

public class TestDataStorage {

	public static void main(String[] args) throws IOException {
		CSVUtil storage = new CSVUtil();
		// storage.loadPerson("data/People.csv");
		CSVUtil.addPerson(new Person(17, "FreddyTheTelescopeMan", "Male", "Italian", "Telescope Man", "Good man"));
		CSVUtil.savePerson("data/People2.csv");
		storage.loadInteractions("data/Interaction.csv");
		storage.saveInteractions("data/Interaction2.csv");

	}

}
