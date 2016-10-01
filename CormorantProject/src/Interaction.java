import java.util.*;

/**
 * The Class Interaction.
 */
public class Interaction {
		
	/** The people 1. */
	private List<Person> people1;
	
	/** The people 2. */
	private List<Person> people2;
	
	/** The location. */
	private String location;
	
	/** The date. */
	private String date;
	
	/** The interaction type. */
	private String interactionType;
	
	/** The citation. */
	private String citation;
	
	/** The notes. */
	private String notes;
	
	/** The directed. */
	private boolean directed;
	

	

	/**
	 * Instantiates a new interaction.
	 *
	 * @param people1 the people 1
	 * @param people2 the people 2
	 * @param location the location
	 * @param date the date
	 * @param interactionType the interaction type
	 * @param citation the citation
	 * @param notes the notes
	 * @param directed the directed
	 */
	public Interaction(List<Person> people1, List<Person> people2, String location, String date, String interactionType,
			String citation, String notes, boolean directed) {
		this.people1 = people1;
		this.people2 = people2;
		this.location = location;
		this.date = date;
		this.interactionType = interactionType;
		this.citation = citation;
		this.notes = notes;
		this.directed = directed;
	}
	
	/**
	 * Gets the people 1.
	 *
	 * @return the people 1
	 */
	public List<Person> getPeople1() {
		return people1;
	}
	
	/**
	 * Gets the people 2.
	 *
	 * @return the people 2
	 */
	public List<Person> getPeople2() {
		return people2;
	}

	/**
	 * Sets the people 1.
	 *
	 * @param people the new people 1
	 */
	public void setPeople1(List<Person> people) {
		this.people1 = people;
	}
	
	/**
	 * Sets the people 2.
	 *
	 * @param people the new people 2
	 */
	public void setPeople2(List<Person> people) {
		this.people2 = people;
	}

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the interaction type.
	 *
	 * @return the interaction type
	 */
	public String getInteractionType() {
		return interactionType;
	}

	/**
	 * Sets the interaction type.
	 *
	 * @param interactionType the new interaction type
	 */
	public void setInteractionType(String interactionType) {
		this.interactionType = interactionType;
	}

	/**
	 * Gets the citation.
	 *
	 * @return the citation
	 */
	public String getCitation() {
		return citation;
	}

	/**
	 * Sets the citation.
	 *
	 * @param citation the new citation
	 */
	public void setCitation(String citation) {
		this.citation = citation;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * Checks if is directed.
	 *
	 * @param directed the directed
	 * @return true, if is directed
	 */
	public boolean isDirected(boolean directed){
		return this.directed;
	}
	public String getNamesOfGroup(List<Person> peopleList){
		String peopleGroup=peopleList.get(0).getName();
		for (int i=1; i<people1.size();i++){
			peopleGroup+=", "+people1.get(i).getName();
		}
		return peopleGroup;
	}
	
	public String toString(){
		return "("+getNamesOfGroup(people1)+") interacted with ("+getNamesOfGroup(people2)+"), "+ location+", "+date+", "+interactionType+", "+citation+", "+notes;
	}
}
