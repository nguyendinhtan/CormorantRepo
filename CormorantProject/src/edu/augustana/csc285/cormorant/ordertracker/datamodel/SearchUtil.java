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
	 * @param query
	 *            the search query
	 * @return serachResultsList the list of search results
	 */
	public static List search(String query) {

		List searchResultsList = null;
		return searchResultsList;
	}

	/**
	 * 
	 * @param query
	 *            the search query
	 * @return searchInteractionsResultsList the list of search interaction
	 *         results
	 */
	public static List<Interaction> searchInteractions(String query) {
		List<Interaction> interactionResults = new ArrayList<>();
		return interactionResults;
	}

	/**
	 * 
	 * @param query
	 *            the search query
	 * @return searchPeopleResultsList the list of search people results
	 */
	public static List<Person> searchPeople(String query) {
		List<Person> personResults = new ArrayList<>();
		for (int i = 0; i < DataCollections.getPersonCollection().size(); i++) {
			if (DataCollections.getPersonCollection().get(i).contains(query) == 1) {
				personResults.add(0, DataCollections.getPersonCollection().get(i));
			} else if (DataCollections.getPersonCollection().get(i).contains(query) == 2) {
				personResults.add(DataCollections.getPersonCollection().get(i));
			}

		}
		return personResults;
	}

}
