import java.util.*;

/**
 * This class contains all methods for searching through collections, persons,
 * and interactions.
 *
 */
public class SearchUtil{
	
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
	public static List searchInteractions(String query) {
		List searchInteractionsResultsList = null;
		return searchInteractionsResultsList;
	}

	/**
	 * 
	 * @param query
	 *            the search query
	 * @return searchPeopleResultsList the list of search people results
	 */
	public static List searchPeople(String query) {
		List<Person> results=new ArrayList<>();
		for (int i=0; i<DataCollections.getPersonCollection().size(); i++){
			if (DataCollections.getPersonCollection().get(i).contains(query)==1){
				results.add(0,DataCollections.getPersonCollection().get(i));
			}else if(DataCollections.getPersonCollection().get(i).contains(query)==2){
				results.add(DataCollections.getPersonCollection().get(i));
			}
			
		}
		return results;
	}

}
