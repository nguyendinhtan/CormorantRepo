import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorGUI {

	public static void showError(String headerText, String errorText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(headerText);
		alert.setContentText(errorText);
		alert.showAndWait();
	}

	public static void main(String[] args) {
		showError("Header", "content");
	}
}
