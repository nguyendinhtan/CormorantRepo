import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

/**
 * The CSVUtil class loads and saves data to and from the CSV file.
 *
 */
public class CSVUtil{
	
	private Map<Integer, Person> personMap;
	private List<Interaction> interactions;
	private CSVReader reader;

	public CSVUtil() {
		personMap = new TreeMap<>();
		interactions =  new ArrayList<>();
	}

	public void loadPerson(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));

		List<String[]> myRows = reader.readAll();
		myRows.remove(0); //Remove header row.

		for (String[] row : myRows) {
			addPerson(new Person(row));
		}

		// TODO: Delete DEBUG CODE later 
		//		for (Integer key : watcherMap.keySet()) {
		//			System.out.println("key: " + key + " value: " + watcherMap.get(key));
		//		}
	}
	
	public void addPerson(Person person) {
		personMap.put(person.getID(), person);
	}

	public void savePerson(String fileName) throws IOException {
		CSVWriter writer = new CSVWriter(new FileWriter(fileName));
		for (Person person : personMap.values()) {
		     writer.writeNext(person.toCSVRowArray());		     
		}
		 writer.close();	   
	}

	public void loadInteractions(String fileName) throws IOException {		
		reader = new CSVReader(new FileReader(fileName));		
		List<String[]> myRows = reader.readAll();

		// 0:1, 2:3,Old Main, 09/30/2016,Invite to Party, Citation from Augustana, No one comes
		for (String[] row : myRows) {
			String idListTextPerson1 = row[0];
			String idListTextPerson2 = row[1];
			String location= row[2];
			String date = row[3];
			String interactionType = row[4];
			String citation = row[5];
			String notes = row[6];
			String[] idArrayPerson1 = idListTextPerson1.split(":");
			String[] idArrayPerson2 = idListTextPerson2.split(":");			
			List<Person> personList1 = new ArrayList<Person>();
			List<Person> personList2 = new ArrayList<Person>();
			for (String idStr : idArrayPerson1) {
				int id = Integer.parseInt(idStr);
				Person person1 = personMap.get(id);
				personList1.add(person1); 
			}
			for (String idStr : idArrayPerson2) {
				int id = Integer.parseInt(idStr);
				Person person2 = personMap.get(id);
				personList2.add(person2); 
			}
			Interaction interaction = new Interaction(personList1, personList2, location, date, interactionType, citation, notes, true);
			interactions.add(interaction);
			
		}		
	}

	public void saveInteractions(String fileName) {
		
	}

}
