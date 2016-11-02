package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterGUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Register");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Register Your Account");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw1 = new Label("Password:");
		grid.add(pw1, 0, 2);
		Label pw2 = new Label("Confirm your Password:");
		grid.add(pw2, 0, 3);

		PasswordField pwBox1 = new PasswordField();
		grid.add(pwBox1, 1, 2);
		PasswordField pwBox2 = new PasswordField();
		grid.add(pwBox2, 1, 3);
		Button backBtn = new Button("Back");
		Button regisBtn = new Button("Register");
		HBox hbBackBtn = new HBox(10);
		hbBackBtn.setAlignment(Pos.BOTTOM_LEFT);
		hbBackBtn.getChildren().add(backBtn);
		HBox hbRegisBtn = new HBox(10);
		hbRegisBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbRegisBtn.getChildren().add(regisBtn);
		grid.add(hbBackBtn, 0, 4);
		grid.add(hbRegisBtn, 1, 4);
		backBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				LoginGUI logingui = new LoginGUI();
				try {
					logingui.start(primaryStage);
				} catch (Exception error) {
					DialogGUI.showError("Error changing to the login stage", error.toString());
				}
			}
		});

		regisBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (pwBox1.getText().equals(pwBox2.getText())) {
					File data = new File("data\\Data.txt");
					data.setWritable(true);
					try {
						PrintWriter fileWriter = new PrintWriter(new FileWriter("data\\Data.txt", true));
						fileWriter.write(userTextField.getText());
						fileWriter.write(System.lineSeparator());
						fileWriter.write(pwBox1.getText());
						fileWriter.write(System.lineSeparator());
						DialogGUI.showInfo("Success!", "You succesfully registered new account!");
						fileWriter.close();
						data.setReadOnly();
					} catch (IOException error) {
						DialogGUI.showError("Error write to a file", error.toString());
					}

				} else {
					DialogGUI.showInfo("Fail!", "The confirmed password must match your password!");
				}
			}
		});

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
