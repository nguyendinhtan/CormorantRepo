import java.util.Date;
import java.util.List;

/**
 * The Class Collections.
 */
public class Collections {
	
	/** The person collection. */
	private List<Person> personCollection;
	
	/** The interaction collection. */
	private List<Interaction> interactionCollection;
		
	/**
	 * Adds a person to the personCollection list.
	 *
	 * @param person the person
	 */
	public void addPerson(Person person){
		personCollection.add(person);
	}
	
	/**
	 * Deletes a person from personCollection.
	 *
	 * @param person the person
	 */
	public void deletePerson(Person person){
		personCollection.remove(person);
	}
	
	/**
	 * edits an element of personCollection.
	 *
	 * @param id the id
	 * @param person the person
	 * @param name the name
	 * @param gender the gender
	 * @param culture the culture
	 * @param occupation the occupation
	 * @param notes the notes
	 */
	public void editPerson(int id, Person person, String name, String gender, List<String> culture, String occupation, String notes){
		person = new Person(id, name, gender, culture, occupation, notes);
	}
	
	/**
	 * Adds an interaction to the interactionCollection list.
	 *
	 * @param interaction the interaction
	 */
	public void addInteraction(Interaction interaction){
		interactionCollection.add(interaction);
	}
	
	/**
	 * Deletes an interaction from interactionCollection.
	 *
	 * @param interaction the interaction
	 */
	public void deleteInteraction(Interaction interaction){
		interactionCollection.remove(interaction);
	}
	
	/**
	 * edits an element of interactionCollection. 
	 *
	 * @param interaction the interaction
	 * @param people1 the people 1
	 * @param people2 the people 2
	 * @param location the location
	 * @param date the date
	 * @param interactionType the interaction type
	 * @param citation the citation
	 * @param notes the notes
	 */
	public void editInteraction(int id, Interaction interaction, List<Person> people1, List<Person> people2, String location, Date date, List<String> interactionType,
			List<String> citation, String notes){
		interaction = new Interaction(id, people1, people2, location, date, interactionType, citation, notes, false);
	}
	
	/**
	 * CSV Collection Methods
	 * Loads the data for each person.
	 *
	 * @param fileName the file name
	 * @return the list of personCollection
	 */
	public List<Person> loadDataPerson(String fileName){
		return personCollection; /**Temporary return object.*/
	}
	
	/**
	 * Loads the data for each interaction.
	 *
	 * @param fileName the file name
	 * @return the list of interactionCollection
	 */
	public List<Interaction> loadDataInteraction(String fileName){
		return interactionCollection; /**Temporary return object.*/
	}
	
	/**
	 * Saves the data for each person.
	 *
	 * @param fileName the file name
	 */
	public void saveDataPerson(String fileName){
		/**Saves people to people CSV File.*/
	}
	
	/**
	 * Saves the data for each interaction. 
	 *
	 * @param fileName the file name
	 */
	public void saveDataInteraction(String fileName){
		/**Saves interactions to interaction CSV File.*/
	}
}
