import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtil{
	
	private Map<Integer, Person> personMap;
	private List<Interaction> interactions;

	public CSVUtil() {
		personMap = new TreeMap<>();
		interactions =  new ArrayList<>();
	}

	public void loadPerson(String fileName) throws IOException {
		CSVReader reader = new CSVReader(new FileReader(fileName));

		List<String[]> myRows = reader.readAll();
		String[] headerRow = myRows.remove(0); // remove header row

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
/*
	public void loadInteractions(String fileName) throws IOException {		
		CSVReader reader = new CSVReader(new FileReader(fileName));		
		List<String[]> myRows = reader.readAll();

		// ,Old Main,0:3:7,Pelican=3:Green Heron=1
		for (String[] row : myRows) {
			String date = row[0];
			String location= row[1];
			String idListText=row[2];
			String obsListText=row[3];
			String[] idArray = idListText.split(":");
			List<BirdWatcher> watchersThisTrip = new ArrayList<BirdWatcher>();

			for (String idStr : idArray) {
				int id = Integer.parseInt(idStr);
				BirdWatcher watcher = watcherMap.get(id);
				watchersThisTrip.add(watcher); 
			}
			
			List<BirdObservation> birdObsThisTrip = new ArrayList<>(); 
			String[] obsListArray = obsListText.split(":");
			for (String obsText : obsListArray) {
				String[] pair = obsText.split("=");
				String birdName = pair[0];
				int birdCount = Integer.parseInt(pair[1]);
				birdObsThisTrip.add(new BirdObservation(birdName, birdCount));
			}
			BirdingTrip trip = new BirdingTrip(location, watchersThisTrip, date, birdObsThisTrip);
			trips.add(trip);
			
		}		
	}

	public void saveTrips(String fileName) {
		
	}
*/
}
