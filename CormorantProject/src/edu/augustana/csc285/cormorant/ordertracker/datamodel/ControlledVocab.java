package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.util.ArrayList;
import java.util.List;

//Unimplemented class
//The methods and fields of this class are currently in the DataCollections class

/**
 * 
 * The Controlled Vocab class.
 */

public class ControlledVocab {

	private static List<String> interactionTypeVocab = new ArrayList<String>();
	private static List<String> cultureVocab = new ArrayList<String>();
	private static List<String> occupationVocab = new ArrayList<String>();
	

	public static List<String> getInteractionTypeVocab() {
		return interactionTypeVocab;
	}

	public static List<String> getCultureVocab() {
		return cultureVocab;
	}

	public static List<String> getOccupationVocab() {
		return occupationVocab;
	}

	public static void remove(int vocabIndex, String listType) {
		if (listType == "Interaction Type") {
			interactionTypeVocab.remove(vocabIndex);
		} else if (listType == "Occupation") {
			occupationVocab.remove(vocabIndex);
		} else {
			cultureVocab.remove(vocabIndex);
		}
	}


	public static void addInteractionTypeVocab(String interactionType) {
		interactionTypeVocab.add(interactionType);
		interactionTypeVocab.sort(null);
	}

	public static void addCultureVocab(String culture) {
		cultureVocab.add(culture);
		cultureVocab.sort(null);
	}

	public static void addOccupationVocab(String occupation) {
		occupationVocab.add(occupation);
		occupationVocab.sort(null);
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
		if (list == "Occupation") {
			for (int i = 0; i < occupationVocab.size(); i++) {
				if (vocab.toLowerCase().equals(occupationVocab.get(i).toLowerCase())) {
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
		if (list == "Culture") {
			for (int i = 0; i < cultureVocab.size(); i++) {
				if (vocab.toLowerCase().equals(cultureVocab.get(i).toLowerCase())) {
					return i;
				}
			}
		}
		return -1;
	}

}
