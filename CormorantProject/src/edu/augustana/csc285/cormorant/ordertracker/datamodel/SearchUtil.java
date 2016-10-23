package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.util.*;

/**
 * This class contains all methods for searching through collections, persons,
 * and interactions.
 *
 */

public class SearchUtil {

	/**
	 * 
	 * @param search
	 *            the search query
	 * @return searchInteractionsResultsList the list of search interaction
	 *         results
	 */

	public static List<Interaction> searchInteractions(String search) {
		List<Interaction> interactionResults = new ArrayList<>();
		for (Interaction interaction : DataCollections.getInteractionCollection()) {
			if (interaction.contains(search) == 1) {
				interactionResults.add(0, interaction);
			} else if (interaction.contains(search) == 2) {
				interactionResults.add(interaction);
			}
		}
		return interactionResults;
	}

	/**
	 * 
	 * @param search
	 *            the search query
	 * @return searchPeopleResultsList the list of search people results
	 */

	public static List<Person> searchPeople(String search) {
		List<Person> personResults = new ArrayList<>();
		for (Person person : DataCollections.getPersonCollection()) {
			if (person.contains(search) == 1) {
				personResults.add(0, person);
			} else if (person.contains(search) == 2) {
				personResults.add(person);
			}

		}
		return personResults;
	}

}
