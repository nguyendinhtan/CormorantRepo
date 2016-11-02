package edu.augustana.csc285.cormorant.ordertracker.gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

public class LoginGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cormorant Welcome");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        Button btnRegis = new Button("Register");
        Button btnLog = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btnRegis);
        hbBtn.getChildren().add(btnLog);
        grid.add(hbBtn, 1, 4);
        
        btnRegis.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                RegisterGUI register = new RegisterGUI();
                register.start(primaryStage);
            }
        });

        btnLog.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	File data = new File("data\\Data.txt");
				try {
					Scanner scan = new Scanner(data);
					boolean registered = false;
					while(scan.hasNextLine()){
	                	String text = scan.nextLine();
	                	if(text.equals(userTextField.getText())){
	                		String passwordCheck = scan.nextLine();
	                		if(passwordCheck.equals(pwBox.getText())){
	                			registered = true;
	                		}
	                	}
	                }
	                if(registered){
	                	HomeGUI homeGUI = new HomeGUI();
	            		try {
							homeGUI.start(primaryStage);
						} catch (Exception error) {
							DialogGUI.showError("Error to load the Home stage", error.toString());
						}
	                }
	                else{
	                	DialogGUI.showError("Error", "You must register before logging in");
	                }
				} catch (FileNotFoundException error) {
					DialogGUI.showError("Error to load the Home stage", error.toString());
				}
                
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
