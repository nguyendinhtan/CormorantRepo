
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

import edu.augustana.csc285.cormorant.ordertracker.gui.DialogGUI;

public class CSVUtil {

	private static Map<Integer, Person> personMap = new TreeMap<>();
	private static CSVReader reader;
	private static CSVWriter writer;

	// Read Methods
	public static void loadPerson(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();
		myRows.remove(0);
		if (!myRows.isEmpty()) {
			for (String[] row : myRows) {
				addPerson(new Person(row));
			}
		}
	}

	public static void loadInteractions(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();
		myRows.remove(0);
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
				if (!idStr.isEmpty()) {
					int id = Integer.parseInt(idStr);
					Person person1 = personMap.get(id);
					personList1.add(person1);
				}
			}
			for (String idStr : idArrayPerson2) {
				if (!idStr.isEmpty()) {
					int id = Integer.parseInt(idStr);
					Person person2 = personMap.get(id);
					personList2.add(person2);
				}
			}
			Interaction interaction = new Interaction(personList1, personList2, location, date, interactionType,
					citation, notes, true);

			// interactions.add(interaction);
			DataCollections.addInteraction(interaction);
			personMap.clear();

		}
	}

	public static void loadInteractionType(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();
		myRows.remove(0);
		if (!myRows.isEmpty()) {
			for (String row : myRows.get(0)) {
				ControlledVocab.addInteractionTypeVocab(row);
			}
		}
	}

	public static void loadCultureVocab(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();
		myRows.remove(0);
		if (!myRows.isEmpty()) {
			for (String row : myRows.get(0)) {
				ControlledVocab.addCultureVocab(row);
			}
		}
	}

	public static void loadOccupationVocab(String fileName) throws IOException {
		reader = new CSVReader(new FileReader(fileName));
		List<String[]> myRows = reader.readAll();
		myRows.remove(0);
		if (!myRows.isEmpty()) {
			for (String row : myRows.get(0)) {
				ControlledVocab.addOccupationVocab(row);
			}
		}
	}

	// Write Methods
	/**
	 * This saves people data to a CSV file from a person map..
	 * 
	 * @param fileName
	 *            the CSV source file
	 * @throws IOException
	 */
	public static void writePerson(String fileName) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		String[] header = "ID,Name,Nickname,Gender,Culture,Occupation,Notes".split(",");
		writer.writeNext(header);
		for (Person person : DataCollections.getPersonCollection()) {
			personMap.put(person.getID(), person);
		}
		for (Person person : DataCollections.getPersonCollection()) {
			writer.writeNext(person.toCSVRowArray());
		}
		writer.close();
	}

	public static void writeInteractions(String fileName) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		String[] header = "IDList1,IDList2,Location,Date,Interaction Type, Citation,Notes".split(",");
		writer.writeNext(header);
		for (Interaction interaction : DataCollections.getInteractionCollection()) {
			writer.writeNext(interaction.toCSVRowArray());
		}
		writer.close();

	}

	public static void writeInteractionType(String fileName) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		int sizeList = ControlledVocab.getInteractionTypeVocab().size();
		String[] interactionTypeArray = new String[sizeList];
		String[] header = new String[1];
		header[0] = "Interaction Type Vocabulary";
		writer.writeNext(header);
		for (int i = 0; i < sizeList; i++) {
			interactionTypeArray[i] = ControlledVocab.getInteractionTypeVocab().get(i);
		}
		if (!(ControlledVocab.getInteractionTypeVocab().isEmpty())) {
			writer.writeNext(interactionTypeArray);
		}
		writer.close();
	}

	public static void writeCultureVocab(String fileName) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		int sizeList = ControlledVocab.getCultureVocab().size();
		String[] header = new String[1];
		header[0] = "Culture Vocabulary";
		writer.writeNext(header);
		String[] cultureVocabArray = new String[sizeList];
		for (int i = 0; i < sizeList; i++) {
			cultureVocabArray[i] = ControlledVocab.getCultureVocab().get(i);
		}
		if (!(ControlledVocab.getCultureVocab().isEmpty())) {
			writer.writeNext(cultureVocabArray);
		}
		writer.close();
	}

	public static void writeOccupationVocab(String fileName) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		int sizeList = ControlledVocab.getOccupationVocab().size();
		String[] header = new String[1];
		header[0] = "Occupation Vocabulary";
		writer.writeNext(header);
		String[] occupationVocabArray = new String[sizeList];

		for (int i = 0; i < sizeList; i++) {
			occupationVocabArray[i] = ControlledVocab.getOccupationVocab().get(i);
		}
		if (!(ControlledVocab.getOccupationVocab().isEmpty())) {
			writer.writeNext(occupationVocabArray);
		}
		writer.close();
	}

	// Load Methods
	public static void savePerson() {
		try {
			CSVUtil.writePerson("data/People.csv");
		} catch (IOException error) {
			DialogGUI.showError("Couldn't save Person object.", error.toString());
		}
	}

	public static void saveInteractions() {
		try {
			CSVUtil.writeInteractions("data/Interaction.csv");
		} catch (IOException error) {
			DialogGUI.showError("Couldn't Save Interaction to CSV", error.toString());
		}
	}

	public static void saveInteractionsType() {
		try {
			CSVUtil.writeInteractionType("data/InteractionType.csv");
		} catch (IOException error) {
			DialogGUI.showError("Couldn't save interaction type vocab.", error.toString());
		}
	}

	public static void saveCultureVocab() {
		try {
			CSVUtil.writeCultureVocab("data/CultureVocab.csv");
		} catch (IOException error) {
			DialogGUI.showError("Couldn't save culture vocab.", error.toString());
		}	
	}
	
	public static void saveOccupationVocab() {
		try {
			CSVUtil.writeOccupationVocab("data/OccupationVocab.csv");
		} catch (IOException error) {
			DialogGUI.showError("Couldn't save occupation vocab.", error.toString());
		}
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

	public static void palladioExport(String fileName1, String fileName2) throws IOException {
		reader = new CSVReader(new FileReader(fileName1));
		writer = new CSVWriter(new FileWriter(fileName2), ',', CSVWriter.NO_QUOTE_CHARACTER);
		for (Interaction interaction : DataCollections.getInteractionCollection()) {
			writer.writeNext(interaction.toCSVRowArray());
		}
		for (Person person : DataCollections.getPersonCollection()) {
			writer.writeNext(person.toCSVRowArray());
		}
		reader.close();
		writer.close();
	}

	public static void palladioExport(String fileName, List<Interaction> list) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		List<Interaction> interactionList = list;
		String[] header = "Source,Target".split(",");
		writer.writeNext(header);
		for (Interaction interaction : interactionList) {
			List<Person> people1 = interaction.getPeople1();
			List<Person> people2 = interaction.getPeople2();
			for (Person person1 : people1) {
				for (Person person2 : people2) {
					String[] arrayName = new String[2];
					arrayName[0] = person1.getName();
					arrayName[1] = person2.getName();
					writer.writeNext(arrayName);
				}
			}
		}
		writer.close();
	}

	public static void gephiExportNodes(String fileName, List<Person> list) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		List<Person> personList = list;
		String[] header = "Node ID,Label".split(",");
		writer.writeNext(header);
		for (Person person : personList) {
			String[] arrayNodes = new String[2];
			arrayNodes[0] = Integer.toString(person.getID());
			arrayNodes[1] = person.getName();
			writer.writeNext(arrayNodes);
		}
		writer.close();
	}

	public static void gephiExportEdges(String fileName, List<Interaction> list) throws IOException {
		writer = new CSVWriter(new FileWriter(fileName), ',', CSVWriter.NO_QUOTE_CHARACTER);
		List<Interaction> interactionList = list;
		String[] header = "Source,Target,Edge ID".split(",");
		writer.writeNext(header);
		for (Interaction interaction : interactionList) {
			List<Person> people1 = interaction.getPeople1();
			List<Person> people2 = interaction.getPeople2();
			int edgeId = 0;
			for (Person person1 : people1) {
				for (Person person2 : people2) {
					edgeId++;
					String[] arrayName = new String[3];
					arrayName[0] = Integer.toString(person1.getID());
					arrayName[1] = Integer.toString(person2.getID());
					arrayName[2] = Integer.toString(edgeId);
					writer.writeNext(arrayName);
				}
			}
		}
		writer.close();
	}
}
