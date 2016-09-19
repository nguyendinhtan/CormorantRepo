import java.util.Date;
import java.util.List;

public class Collections {
	private List<Person> personCollection;
	private List<Interaction> interactionCollection;
		
	//Person Collection Methods
	public void addPerson(Person person){
		personCollection.add(person);
	}
	
	
	public void deletePerson(Person person){
		personCollection.remove(person);
	}
	
	public void editPerson(Person person, String name, String gender, List<String> culture, String occupation, String notes){
		person = new Person(name, gender, culture, occupation, notes);
	}
	
	//Interaction Collection Methods
	public void addInteraction(Interaction interaction){
		interactionCollection.add(interaction);
	}
	
	public void deleteInteraction(Interaction interaction){
		interactionCollection.remove(interaction);
	}
	
	public void editInteraction(Interaction interaction, List<Person> people1, List<Person> people2, String location, Date date, List<String> interactionType,
			List<String> citation, String notes){
		interaction.setPeople1(people1);
		interaction.setPeople2(people2);
		interaction.setDate(date);
		interaction.setInteractionType(interactionType);
		interaction.setLocation(location);
		interaction.setCitation(citation);
		interaction.setNotes(notes);
	}
	
	//CSV Collection Methods
	public List<Person> loadDataPerson(String fileName){
		return personCollection; //Temporary return object.
	}
	
	public List<Interaction> loadDataInteraction(String fileName){
		return interactionCollection; //Temporary return object.
	}
	
	public void saveDataPerson(String fileName){
		//Saves people to people CSV File.
	}
	
	public void saveDataInteraction(String fileName){
		//Saves interactions to interaction CSV File.
	}
}
