package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ReadMeGUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("README");

		// popup methods
		Popup popup = new Popup();
		popup.setHeight(500);

		// readme scanner
		Scanner readme = null;
		try {
			readme = new Scanner(new File("../Readme.md"));
		} catch (FileNotFoundException e) {
			DialogGUI.confirmation("Error Reading README", e.toString());
		}
		StringBuilder readmeText = new StringBuilder();
		while (readme.hasNextLine()) {
			readmeText.append(readme.nextLine() + "\n");
		}
		//System.out.println(readmeText.toString());

		// textfield
		Text text = new Text(readmeText.toString());
		text.setFont(new Font(16));
		text.setWrappingWidth(680);
		text.maxWidth(700);
		text.setTextAlignment(TextAlignment.CENTER);

		// scrollpane
		ScrollPane sp = new ScrollPane();
		sp.setMaxHeight(500);
		sp.setMaxWidth(700);
		sp.setContent(text);
		sp.setHbarPolicy(ScrollBarPolicy.NEVER);
		sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		HBox layout = new HBox();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				HomeGUI home=new HomeGUI();
				try {
					home.start(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}
				we.consume();
			}
		});
		layout.getChildren().add(sp);
		primaryStage.setScene(new Scene(layout));
		primaryStage.show();
	}

}
