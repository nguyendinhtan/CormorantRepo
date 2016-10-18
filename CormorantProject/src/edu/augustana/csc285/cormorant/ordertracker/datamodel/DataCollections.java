package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Class Collections.
 */
public class DataCollections {

	/** The person collection. */
	private static List<Person> personCollection = new ArrayList<>();
	/** The interaction collection. */
	private static List<Interaction> interactionCollection = new ArrayList<>();

	public static List<Person> getPersonCollection() {
		return personCollection;
	}

	public static List<Interaction> getInteractionCollection() {
		return interactionCollection;
	}

	/**
	 * Adds a person to the personCollection list.
	 *
	 * @param person
	 *            the person
	 */
	public static void addPerson(Person person) {
		personCollection.add(person);
		Collections.sort(personCollection, Person.personNameComparator);
	}

	/**
	 * Deletes a person from personCollection.
	 *
	 * @param person
	 *            the person
	 */
	public static void deletePerson(Person person) {
		personCollection.remove(person);
	}

	/**
	 * edits an element of personCollection.
	 *
	 * @param id
	 *            the id
	 * @param person
	 *            the person
	 * @param name
	 *            the name
	 * @param gender
	 *            the gender
	 * @param culture
	 *            the culture
	 * @param occupation
	 *            the occupation
	 * @param notes
	 *            the notes
	 */

	/**
	 * Adds an interaction to the interactionCollection list.
	 *
	 * @param interaction
	 *            the interaction
	 */
	public static void addInteraction(Interaction interaction) {
		interactionCollection.add(interaction);

	}

	/**
	 * Deletes an interaction from interactionCollection.
	 *
	 * @param interaction
	 *            the interaction
	 */
	public static void deleteInteraction(Interaction interaction) {
		interactionCollection.remove(interaction);
	}

	/**
	 * edits an element of interactionCollection.
	 *
	 * @param interaction
	 *            the interaction
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
	 */

	// checks for duplicates in person list and returns the id of the person if
	// there is a duplicate and -1 if there isn't
	public static int checkForPersonDuplicates(Person person) {
		for (int i = 0; i < personCollection.size(); i++) {

			if (person.getName().toLowerCase().equals(personCollection.get(i).getName().toLowerCase())
					&& person.getNickname().toLowerCase().equals(personCollection.get(i).getNickname().toLowerCase())
					&& person.getCulture().toLowerCase().equals(personCollection.get(i).getCulture().toLowerCase())
					&& person.getOccupation().toLowerCase()
							.equals(personCollection.get(i).getOccupation().toLowerCase())) {
				return personCollection.get(i).getID();
			}
		}
		return -1;
	}

	public static int checkForInteractionDuplicates(Interaction interaction) {
		for (int i = 0; i < interactionCollection.size(); i++) {
			// Checks for NullPointerException when comparing null values with
			// equals from duplicates
			try {
				if (interactionCollection.get(i).getPeople1().equals(interaction.getPeople1())
						&& interactionCollection.get(i).getPeople2().equals(interaction.getPeople2())
						&& interactionCollection.get(i).getLocation().equals(interaction.getLocation())
						&& interactionCollection.get(i).getDate().equals(interaction.getDate())
						&& interactionCollection.get(i).getInteractionType().equals(interaction.getInteractionType())) {
					return i;
				}
			} catch (NullPointerException e) {
				return 1;
			}
		}
		return -1;
	}

}
