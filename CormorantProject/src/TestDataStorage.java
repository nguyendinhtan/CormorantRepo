import java.io.IOException;

public class TestDataStorage {

	public static void main(String[] args) throws IOException {
		CSVUtil.loadPerson("data/People.csv");
		DataCollections.addPerson(new Person(17, "FreddyTheTelescopeMan", "Male", "Italian", "Telescope Man", "Good man"));
		CSVUtil.savePerson("data/People2.csv");
		CSVUtil.loadInteractions("data/Interaction.csv");
		CSVUtil.saveInteractions("data/Interaction2.csv");

	}

}
