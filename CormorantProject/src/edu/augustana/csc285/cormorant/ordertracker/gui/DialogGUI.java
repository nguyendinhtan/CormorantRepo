package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
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

	public static boolean confirmation(String headerText, String confirmText) {
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
	
	public static String saveConfirmation(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Save Confirmation");
		alert.setHeaderText("Save Confirmation");
		alert.setContentText("Do you want to save the data");

		ButtonType buttonTypeOne = new ButtonType("Save");
		ButtonType buttonTypeTwo = new ButtonType("Don't Save");
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == buttonTypeOne){
			return "Save";
		} else if (result.get() == buttonTypeTwo) {
			return "Don't Save";
		}
		return "Cancel";
	}
}
