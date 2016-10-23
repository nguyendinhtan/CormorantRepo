package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import edu.augustana.csc285.cormorant.ordertracker.gui.DialogGUI;

/**
 * The Class Interaction.
 */
public class Interaction {

	/** The first list of people. */
	private List<Person> people1;

	/** The second list of people. */
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

	/** The interaction is directed or indirected. */
	private boolean directed;

	/**
	 * Instantiates a new interaction.
	 *
	 * @param people1
	 *            the people 1
	 * @param people2
	 *            the people 2
	 * @param location
	 *            the location
	 * @param date
	 *            the date
	 * @param interactionType
	 *            the interaction type
	 * @param citation
	 *            the citation
	 * @param notes
	 *            the notes
	 * @param directed
	 *            the directed
	 */
	public Interaction(List<Person> persons1, List<Person> persons2, String location, String date,
			String interactionType, String citation, String notes, boolean directed) {
		people1 = new ArrayList<Person>();
		people2 = new ArrayList<Person>();
		this.people1.addAll(persons1);
		this.people2.addAll(persons2);
		this.location = location;
		this.date = date;
		this.interactionType = interactionType;
		this.citation = citation;
		this.notes = notes;
		this.directed = directed;

	}

	public String[] toCSVRowArray() {
		String idString1 = toIdString(people1);
		String idString2 = toIdString(people2);
		return new String[] { idString1, idString2, location, date, interactionType, citation, notes };
	}

	public String toIdString(List<Person> people) {
		String idString = "";
		if (!people.isEmpty()) {
			idString = Integer.toString(people.get(0).getID());
			for (int i = 1; i < people.size(); i++) {
				idString = idString + ":" + Integer.toString(people.get(i).getID());
			}
		}
		return idString;
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
	 * @param people
	 *            the new people 1
	 */
	public void addPeople1(Person person) {
		people1.add(person);
	}

	/**
	 * Sets the people 2.
	 *
	 * @param people
	 *            the new people 2
	 */
	public void addPeople2(Person person) {
		people2.add(person);
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
	 * Gets the date in a string format.
	 *
	 * @return the date string
	 */
	public String getDateString() {
		return date;
	}

	/**
	 * Gets the date in a LocalDate format.
	 *
	 * @return the LocalDate date
	 */
	public LocalDate getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		try {
			d = df.parse(date);
		} catch (ParseException e) {
			DialogGUI.showError("Error Creating Date", e.toString());
		}
		Instant i = d.toInstant();
		LocalDate l = i.atZone(ZoneId.systemDefault()).toLocalDate();
		return l;
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
	 * Gets the citation.
	 *
	 * @return the citation
	 */
	public String getCitation() {
		return citation;
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
	 * Checks if is directed.
	 *
	 * @param directed
	 *            the directed
	 * @return true, if is directed
	 */
	public boolean isDirected(boolean directed) {
		return this.directed;
	}

	public String getNamesOfGroup(List<Person> peopleList) {
		if (peopleList.size() > 0) {
			String peopleGroup = peopleList.get(0).getName();
			for (Person person : peopleList.subList(1, peopleList.size())) {
				peopleGroup += ", " + person.getName();
			}
			return peopleGroup;
		}
		return " ";
	}

	@Override
	public String toString() {
		return "Group 1=(" + getNamesOfGroup(people1) + ") interacted with Group 2=(" + getNamesOfGroup(people2)
				+ ") {Location=" + location + ", Date=" + date + ", Interaction Type=" + interactionType
				+ ", Bibliographical Citation=" + citation + ", Notes=" + notes + "}";
	}

	public int contains(String search) {
		String searchLower = search.toLowerCase();
		for (Person person : people1) {
			if (person.contains(searchLower) == 1) {
				return 1;
			}
		}
		for (Person person : people2) {
			if (person.contains(searchLower) == 1) {
				return 1;
			}
		}
		if (location.contains(searchLower) || date.contains(searchLower)) {
			return 2;
		} else if (notes != null) {
			if (notes.contains(searchLower) || citation.contains(searchLower)) {
				return 2;
			}
		}
		return -1;
	}
}
