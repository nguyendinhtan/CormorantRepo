package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.util.Comparator;

/**
 * The Class Person.
 */
public class Person {
	/** The id of the person. */
	private int id;

	/** The name of the person. */
	private String name;

	/** The short name of the person. */
	private String nickname;
	
	/** The gender of the person. */
	private String gender;

	/** The culture of the person. */
	private String culture;

	/** The occupation of the person. */
	private String occupation;

	/** The notes of the person . */
	private String notes;

	/**
	 * Instantiates a new person.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param nickname
	 * 			  the nickname
	 * @param gender
	 *            the gender
	 * @param culture
	 *            the culture
	 * @param occupation
	 *            the occupation
	 * @param notes
	 *            the notes
	 */
	public Person(int id, String name, String nickname, String gender, String culture, String occupation, String notes) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.culture = culture;
		this.occupation = occupation;
		this.notes = notes;
	}

	/**
	 * TODO: Comment here.
	 * 
	 * @param csvRowData
	 */
	public Person(String[] csvRowData) {
		this.id = Integer.parseInt(csvRowData[0]);
		this.name = csvRowData[1];
		this.nickname = csvRowData[2];
		this.gender = csvRowData[3];
		this.culture = csvRowData[4];
		this.occupation = csvRowData[5];
		this.notes = csvRowData[6];
	}

	@Override
	public String toString() {
		return name + " {id=" + id  + " nickname=" + nickname +  " gender=" + gender + " culture=" + culture + " occupation=" + occupation
				+ " notes=" + notes + "}";
	}

	/*
	 * Comments: This is the method modified from DataStorage
	 * 
	 * @Override public String toString() { return "Person {id=" +id + " name="
	 * + name + " gender="+gender + " culture="+culture + " occupation="
	 * +occupation + " notes="+notes +"}"; }
	 */

	public String[] toCSVRowArray() {
		return new String[] { Integer.toString(id), name, nickname, gender, culture, occupation, notes };
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getID() {
		return id;
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
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
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
	 * Gets the culture.
	 *
	 * @return the culture
	 */
	public String getCulture() {
		return culture;
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
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	// Checks if invalid chars are entered and returns -1 if there are and 0 if
	// there aren't
	public int checkForUnallowedInput(String name, String nickname, String culture, String occupation) {
		String unallowedChars = "1234567890!@#$%^&*()-+=[]{}?<>;";

		for (int i = 0; i < unallowedChars.length(); i++) {
			for (int j = 0; j < name.length(); j++) {
				if (name.charAt(j) == ((unallowedChars.charAt(i)))) {
					return -1;
				}
			}
			for (int j = 0; j < nickname.length(); j++) {
				if (nickname.charAt(j) == ((unallowedChars.charAt(i)))) {
					return -1;
				}
			}
			for (int j = 0; j < culture.length(); j++) {
				if (culture.charAt(j) == ((unallowedChars.charAt(i)))) {
					return -1;
				}
			}
			for (int j = 0; j < occupation.length(); j++) {
				if (occupation.charAt(j) == ((unallowedChars.charAt(i)))) {
					return -1;
				}
			}

		}
		return 0;

	}

	public static Comparator<Person> personNameComparator = new Comparator<Person>() {
		@Override
		public int compare(Person p1, Person p2) {
			String name1 = p1.getName().toLowerCase();
			String name2 = p2.getName().toLowerCase();
			return name1.compareTo(name2);
		}

	};

	public void replacePerson(Person person) {
		this.name = person.getName();
		this.nickname = person.getNickname();
		this.gender = person.getGender();
		this.culture = person.getCulture();
		this.occupation = person.getOccupation();
		this.notes = person.getNotes();
	}

	// For searching
	public int contains(String search) {
		String searchLower = search.toLowerCase();
		if (searchLower.equals(id) || name.toLowerCase().contains(searchLower) || nickname.toLowerCase().contains(searchLower)
				|| culture.toLowerCase().contains(searchLower) || occupation.toLowerCase().contains(searchLower)) {
			return 1;
		} else if (gender.toLowerCase().contains(searchLower)) {
			return 2;
		} else if (notes != null) {
			if (notes.contains(searchLower)) {
				return 2;
			}
		}
		return -1;
	}

}
