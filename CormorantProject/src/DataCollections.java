import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class Collections.
 */
public class DataCollections {
	
	

	/** The person collection. */
	private List<Person> personCollection;
	/** The interaction collection. */
	private List<Interaction> interactionCollection;
	private List<String> locationVocab;
	private List<String> interactionTypeVocab;
	private List<String> citationVocab;
	
	public DataCollections(){
		personCollection= new ArrayList<>();
		interactionCollection=new ArrayList<>();
		locationVocab=new ArrayList<String>();
		interactionTypeVocab=new ArrayList<String>();
		citationVocab=new ArrayList<String>();
	}
	public List<Person> getPersonCollection() {
		return personCollection;
	}

	public List<Interaction> getInteractionCollection() {
		return interactionCollection;
	}
	/**
	 * Adds a person to the personCollection list.
	 *
	 * @param person the person
	 */
	public void addPerson(Person person){
		personCollection.add(person);
		Collections.sort(personCollection, Person.personNameComparator);
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
	public void editPerson(Person person, int id, String name, String gender, String culture, String occupation, String notes){
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
	public void editInteraction(Interaction interaction, List<Person> people1, List<Person> people2, String location, String date, String interactionType,
			String citation, String notes){
		interaction = new Interaction(people1, people2, location, date, interactionType, citation, notes, false);
	}
	//checks for duplicates in person list and returns the id of the person if there is a duplicate and -1 if there isn't
	public int checkForPersonDuplicates(Person person){
		for (int i=0; i<personCollection.size(); i++){

				if (person.getName().toLowerCase().equals(personCollection.get(i).getName().toLowerCase())&& person.getCulture().toLowerCase().equals(personCollection.get(i).getCulture().toLowerCase())&&person.getOccupation().toLowerCase().equals(personCollection.get(i).getOccupation().toLowerCase())){
					return personCollection.get(i).getID();
				}
		}
		return -1;
	}
	
	public int checkForInteractionDuplicates(Interaction interaction){
		for (int i=0; i<interactionCollection.size(); i++){
			//Checks for nullpointerexception when comparing null values with equals from duplicates
			try{
			if (interactionCollection.get(i).getPeople1().equals(interaction.getPeople1())&&interactionCollection.get(i).getPeople2().equals(interaction.getPeople2()) &&interactionCollection.get(i).getLocation().equals(interaction.getLocation())&& interactionCollection.get(i).getDate().equals(interaction.getDate())&&interactionCollection.get(i).getInteractionType().equals(interaction.getInteractionType())){
					return i;
				}
			}catch(NullPointerException e){
				return 1;
			}
		}
		return -1;
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
	
	
	public List<String> getLocationVocab() {
		return locationVocab;
	}

	public List<String> getInteractionTypeVocab() {
		return interactionTypeVocab;
	}

	public List<String> getCitationVocab() {
		return citationVocab;
	}
	
	
	public void remove(int vocabIndex, String listType){
		if (listType=="Location"){
		locationVocab.remove(vocabIndex);
		}else if(listType=="Interaction Type"){
			interactionTypeVocab.remove(vocabIndex);
		}else{
			citationVocab.remove(vocabIndex);
		}
	}
	
	public void addLocationVocab(String location){
		locationVocab.add(location);
		locationVocab.sort(null);
	}
	public void addInteractionTypeVocab(String interactionType){
		interactionTypeVocab.add(interactionType);
		interactionTypeVocab.sort(null);
	}
	public void addCitationVocab(String citation){
		citationVocab.add(citation);
		citationVocab.sort(null); 
	}
	public int checkForUnallowedInput(String vocab){
		String unallowedChars="@#^-+=[]{}";
		
		for (int i=0; i<unallowedChars.length();i++){
			for(int j=0; j<vocab.length(); j++){
				if (vocab.charAt(j)==((unallowedChars.charAt(i)))){
					return -1;
					
				}
			}
			
		}
		return 0;
		
	}
	public int checkForVocabDuplicates(String vocab, String list){
		if (list=="Location"){	
			for (int i=0; i<locationVocab.size(); i++){
				if (vocab.toLowerCase().equals(locationVocab.get(i).toLowerCase())){
				return i;
				}
			}
		}
		if (list=="Interaction Type"){
			for (int i=0; i<interactionTypeVocab.size(); i++){
				if (vocab.toLowerCase().equals(interactionTypeVocab.get(i).toLowerCase())){
				return i;
				}
			}
		}
		if (list=="Bibliographical Citation"){
			for (int i=0; i<citationVocab.size(); i++){
				if (vocab.toLowerCase().equals(citationVocab.get(i).toLowerCase())){
				return i;
				}
			}
		}
		return -1;
	}
}
