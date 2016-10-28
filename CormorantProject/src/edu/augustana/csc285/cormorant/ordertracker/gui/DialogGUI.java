package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

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

	public static void showWarning(String headerText, String infoText) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Warning");
		alert.setHeaderText(headerText);
		alert.setContentText(infoText);
		alert.showAndWait();
	}

	public static boolean conformation(String headerText, String confirmText) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation");
		alert.setHeaderText(headerText);
		alert.setContentText(confirmText);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}
}
