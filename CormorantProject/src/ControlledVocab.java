import java.util.ArrayList;
import java.util.List;

//Unimplemented class
//The methods and fields of this class are currently in the DataCollections class

/**
 * 
 * The Controlled Vocab class.
 */

public class ControlledVocab {

	private static List<String> locationVocab= new ArrayList<String>();
	private static List<String> interactionTypeVocab= new ArrayList<String>();
	private static List<String> citationVocab= new ArrayList<String>();


	public static List<String> getLocationVocab() {
		return locationVocab;
	}

	public static List<String> getInteractionTypeVocab() {
		return interactionTypeVocab;
	}

	public static List<String> getCitationVocab() {
		return citationVocab;
	}

	public static void remove(int vocabIndex, String listType) {
		if (listType == "Location") {
			locationVocab.remove(vocabIndex);
		} else if (listType == "Interaction Type") {
			interactionTypeVocab.remove(vocabIndex);
		} else {
			citationVocab.remove(vocabIndex);
		}
	}

	public static void addLocationVocab(String location) {
		locationVocab.add(location);
		locationVocab.sort(null);
	}

	public static void addInteractionTypeVocab(String interactionType) {
		interactionTypeVocab.add(interactionType);
		interactionTypeVocab.sort(null);
	}

	public static void addCitationVocab(String citation) {
		citationVocab.add(citation);
		citationVocab.sort(null);
	}

	public static int checkForUnallowedInput(String vocab) {
		String unallowedChars = "@#^-+=[]{}";

		for (int i = 0; i < unallowedChars.length(); i++) {
			for (int j = 0; j < vocab.length(); j++) {
				if (vocab.charAt(j) == ((unallowedChars.charAt(i)))) {
					return -1;

				}
			}

		}
		return 0;

	}

	public static int checkForVocabDuplicates(String vocab, String list) {
		if (list == "Location") {
			for (int i = 0; i < locationVocab.size(); i++) {
				if (vocab.toLowerCase().equals(locationVocab.get(i).toLowerCase())) {
					return i;
				}
			}
		}
		if (list == "Interaction Type") {
			for (int i = 0; i < interactionTypeVocab.size(); i++) {
				if (vocab.toLowerCase().equals(interactionTypeVocab.get(i).toLowerCase())) {
					return i;
				}
			}
		}
		if (list == "Bibliographical Citation") {
			for (int i = 0; i < citationVocab.size(); i++) {
				if (vocab.toLowerCase().equals(citationVocab.get(i).toLowerCase())) {
					return i;
				}
			}
		}
		return -1;
	}

}
