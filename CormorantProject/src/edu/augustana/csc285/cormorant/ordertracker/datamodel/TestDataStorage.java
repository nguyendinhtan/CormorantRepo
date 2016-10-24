package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import java.io.IOException;

public class TestDataStorage {

	public static void main(String[] args) throws IOException {
		CSVUtil.loadPerson("data/People.csv");
		// DataCollections
		// .addPerson(new Person(17, "FreddyTheTelescopeMan","Freddy", "Male",
		// "Italian", "Telescope Man", "Good man"));
		CSVUtil.writePerson("data/People.csv");
		CSVUtil.loadInteractions("data/Interaction.csv");
		CSVUtil.writeInteractions("data/Interaction.csv");
		// CSVUtil.palladioExport("data/PalladioExport.csv");
		// CSVUtil.gephiExportNodes("data/GephiExportNodes.csv");
		// CSVUtil.gephiExportEdges("data/GephyExportEdges.csv");
	}

}
