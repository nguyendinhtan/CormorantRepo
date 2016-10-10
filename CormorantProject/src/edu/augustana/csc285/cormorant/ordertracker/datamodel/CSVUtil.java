package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtil {

	private static Map<Integer, Person> personMap = new TreeMap<>();
	private static List<Interaction> interactions = new ArrayList<>();
	private static CSVReader reader;
	private static CSVWriter writer;

	public static void loadPerson(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();
		for (String[] row : myRows) {
			addPerson(new Person(row));
		}
		// TODO: Delete DEBUG CODE later
		// for (Integer key : watcherMap.keySet()) {
		// System.out.println("key: " + key + " value: " + watcherMap.get(key));
		// }

	}

	/**
	 * This adds a person to a person map.
	 * 
	 * @param person
	 *            the person
	 */
	public static void addPerson(Person person) {
		personMap.put(person.getID(), person);
		DataCollections.addPerson(person);

	}

	public static void addPersonList(List<Person> persons) {
		for (int i = 0; i < persons.size(); i++) {
			personMap.put(persons.get(i).getID(), persons.get(i));
		}
	}

	/**
	 * This saves people data to a CSV file from a person map..
	 * 
	 * @param fileName
	 *            the CSV source file
	 * @throws IOException
	 */
	public static void savePerson(String fileName) throws IOException {

		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);

		for (Person person : personMap.values()) {
			writer.writeNext(person.toCSVRowArray());
		}
		writer.close();
	}

	public static void loadInteractions(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();

		// 0:1, 2:3,Old Main, 09/30/2016,Invite to Party, Citation from
		// Augustana, No one comes
		for (String[] row : myRows) {
			String idListTextPerson1 = row[0];
			String idListTextPerson2 = row[1];
			String location = row[2];
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
			Interaction interaction = new Interaction(personList1, personList2, location, date, interactionType,
					citation, notes, true);
			interactions.add(interaction);
			DataCollections.addInteraction(interaction);

		}
	}

	public static void addInteraction(Interaction interaction) {
		interactions.add(interaction);
		DataCollections.addInteraction(interaction);
	}

	/**
	 * Goes through an array and adds all the people to a person list.
	 * 
	 * @param personArray
	 *            the source person array
	 * @param personList
	 *            the designated person list
	 */
	public static void convertPersonArrayToList(String[] personArray, List<Person> personList) {
		for (String idStr : personArray) {
			int id = Integer.parseInt(idStr);
			Person person = personMap.get(id);
			personList.add(person);
		}

	}

	public static void saveInteractions(String fileName) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		for (Interaction interaction : interactions) {
			writer.writeNext(interaction.toCSVRowArray());
		}
		writer.close();

	}

}
