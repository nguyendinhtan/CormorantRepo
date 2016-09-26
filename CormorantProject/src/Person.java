import java.util.List;

/**
 * The Class Person.
 */
public class Person {
	/** The id of the person. */
	private int id;
	
	/** The name of the person. */
	private String name;
	
	/** The gender of the person. */
	private String gender;
	
	/** The culture of the person. */
	private List<String> culture;
	
	/** The occupation of the person. */
	private String occupation;
	
	/** The notes of the person . */
	private String notes;

	/**
	 * Instantiates a new person.
	 *
	 * @param id the id
	 * @param name the name
	 * @param gender the gender
	 * @param culture the culture
	 * @param occupation the occupation
	 * @param notes the notes
	 */
	public Person(int id, String name, String gender, List<String> culture, String occupation, String notes) {
		this.id=id;
		this.name = name;
		this.gender = gender;
		this.culture = culture;
		this.occupation = occupation;
		this.notes = notes;
	}
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID()	{
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setID(int id)	{
		this.id=id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the culture.
	 *
	 * @return the culture
	 */
	public List<String> getCulture() {
		return culture;
	}

	/**
	 * Sets the culture.
	 *
	 * @param culture the new culture
	 */
	public void setCulture(List<String> culture) {
		this.culture = culture;
	}

	/**
	 * Gets the occupation.
	 *
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * Sets the occupation.
	 *
	 * @param occupation the new occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
	
}
