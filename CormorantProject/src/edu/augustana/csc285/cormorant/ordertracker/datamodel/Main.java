
package edu.augustana.csc285.cormorant.ordertracker.datamodel;

import edu.augustana.csc285.cormorant.ordertracker.gui.HomeGUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage primaryStage) throws Exception {
		HomeGUI homeGUI = new HomeGUI();
		homeGUI.start(primaryStage);
		CSVUtil.loadPerson("data\\People.csv");
		CSVUtil.loadInteractions("data\\Interaction.csv");
		CSVUtil.loadInteractionType("data\\InteractionType.csv");
		CSVUtil.loadCultureVocab("data\\CultureVocab.csv");
		CSVUtil.loadOccupationVocab("data\\OccupationVocab.csv");
	}
}