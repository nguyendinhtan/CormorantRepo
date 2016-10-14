package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.io.IOException;

public class TestDataStorage {

	public static void main(String[] args) throws IOException {
		CSVUtil.loadPerson("data/People.csv");
		DataCollections
				.addPerson(new Person(17, "FreddyTheTelescopeMan","Freddy", "Male", "Italian", "Telescope Man", "Good man"));
		CSVUtil.savePerson("data/People.csv");
		CSVUtil.loadInteractions("data/Interaction.csv");
		CSVUtil.saveInteractions("data/Interaction.csv");
		//CSVUtil.loadInteractionType("data/InteractionType.csv");
		//ControlledVocab.addInteractionTypeVocab("Meeting");
		//CSVUtil.saveInteractionType("data/InteractionType.csv");
		//CSVUtil.loadInteractionType("data/CultureVocab.csv");
		//ControlledVocab.addInteractionTypeVocab("Italian");
		//CSVUtil.saveInteractionType("data/CultureVocab.csv");
		CSVUtil.loadOccupationVocab("data/OccupationVocab.csv");
		ControlledVocab.addOccupationVocab("Artist");
		CSVUtil.saveOccupationVocab("data/OccupationVocab.csv");
	}

}
