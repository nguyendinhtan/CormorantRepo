package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import edu.augustana.csc285.cormorant.ordertracker.gui.HomeGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		CSVUtil.loadPerson("data/People.csv");
		CSVUtil.loadInteractions("data/Interaction.csv");
		CSVUtil.loadInteractionType("data/InteractionType.csv");
		CSVUtil.loadCultureVocab("data/CultureVocab.csv");
		CSVUtil.loadOccupationVocab("data/OccupationVocab.csv");
		/*
		ControlledVocab.addLocationVocab("Rock Island");
		ControlledVocab.addLocationVocab("Moline");
		ControlledVocab.addLocationVocab("Davenport");
		ControlledVocab.addInteractionTypeVocab("Journal");
		ControlledVocab.addInteractionTypeVocab("Party");
		ControlledVocab.addInteractionTypeVocab("Letter");
		ControlledVocab.addCultureVocab("American");
		ControlledVocab.addCultureVocab("French");
		ControlledVocab.addOccupationVocab("Painter");
		ControlledVocab.addOccupationVocab("Sculptor");
		*/
		HomeGUI homeGUI = new HomeGUI();
		homeGUI.start(primaryStage);
	}

}
