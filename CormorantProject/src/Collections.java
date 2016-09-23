import java.util.Date;
import java.util.List;

public class Collections {
	private List<Person> personCollection;
	private List<Interaction> interactionCollection;
		
	/**
	 * Adds a person to the personCollection list.
	 */
	public void addPerson(Person person){
		personCollection.add(person);
	}
	
	/**
	 * Deletes a person from personCollection.
	 * @param person
	 */
	public void deletePerson(Person person){
		personCollection.remove(person);
	}
	/**
	 * edits an element of personCollection.
	 * @param id
	 * @param person
	 * @param name
	 * @param gender
	 * @param culture
	 * @param occupation
	 * @param notes
	 */
	public void editPerson(int id, Person person, String name, String gender, List<String> culture, String occupation, String notes){
		person = new Person(id, name, gender, culture, occupation, notes);
	}
	
	/**
	 * Adds an interaction to the interactionCollection list.
	 */
	public void addInteraction(Interaction interaction){
		interactionCollection.add(interaction);
	}
	/**
	 * Deletes an interaction from interactionCollection.
	 * @param interaction
	 */
	public void deleteInteraction(Interaction interaction){
		interactionCollection.remove(interaction);
	}
	/**
	 * edits an element of interactionCollection. 
	 * @param interaction
	 * @param people1
	 * @param people2
	 * @param location
	 * @param date
	 * @param interactionType
	 * @param citation
	 * @param notes
	 */
	public void editInteraction(Interaction interaction, List<Person> people1, List<Person> people2, String location, Date date, List<String> interactionType,
			List<String> citation, String notes){
		interaction = new Interaction(people1, people2, location, date, interactionType, citation, notes, false);
	}
	
	/**
	 * CSV Collection Methods
	 * Loads the data for each person.
	 * @param fileName
	 * @return
	 */
	public List<Person> loadDataPerson(String fileName){
		return personCollection; /**Temporary return object.*/
	}
	/**
	 * Loads the data for each interaction.
	 * @param fileName
	 * @return
	 */
	public List<Interaction> loadDataInteraction(String fileName){
		return interactionCollection; /**Temporary return object.*/
	}
	/**
	 * Saves the data for each person.
	 * @param fileName
	 */
	public void saveDataPerson(String fileName){
		/**Saves people to people CSV File.*/
	}
	/**
	 * Saves the data for each interaction. 
	 * @param fileName
	 */
	public void saveDataInteraction(String fileName){
		/**Saves interactions to interaction CSV File.*/
	}
}
