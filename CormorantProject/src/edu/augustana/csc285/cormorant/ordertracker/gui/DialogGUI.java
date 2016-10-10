package edu.augustana.csc285.cormorant.ordertracker.gui;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogGUI {

	public static void showError(String headerText, String errorText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(headerText);
		alert.setContentText(errorText);
		alert.showAndWait();
	}

	public static void showInfo(String headerText, String infoText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(headerText);
		alert.setHeaderText(infoText);
		alert.showAndWait();
	}
}
