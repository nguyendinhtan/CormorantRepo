
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
		for (int i = 0; i < DataCollections.getInteractionCollection().size(); i++) {
			if (DataCollections.getInteractionCollection().get(i).contains(search) == 1) {
				interactionResults.add(0, DataCollections.getInteractionCollection().get(i));
			} else if (DataCollections.getInteractionCollection().get(i).contains(search) == 2) {
				interactionResults.add(DataCollections.getInteractionCollection().get(i));
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
		for (int i = 0; i < DataCollections.getPersonCollection().size(); i++) {
			if (DataCollections.getPersonCollection().get(i).contains(search) == 1) {
				personResults.add(0, DataCollections.getPersonCollection().get(i));
			} else if (DataCollections.getPersonCollection().get(i).contains(search) == 2) {
				personResults.add(DataCollections.getPersonCollection().get(i));
			}

		}
		return personResults;
	}

}
