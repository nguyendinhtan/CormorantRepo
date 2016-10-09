import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 
 * Search Result GUI view class.
 */
public class SearchResultGUI extends Application {
	private ObservableList<Person> oListPersonResults;
	private ObservableList<Interaction> oListInteractionResults;
	private static Person selectedPerson;
	private static Interaction selectedInteraction;

	// @override
	public void start(Stage primaryStage) {
		SearchUtil search=new SearchUtil();
		// GUI Variables
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid, 600, 400);
		ListView<Person> personResultsView = new ListView<Person>();
		ListView<Interaction> interactionResultsView = new ListView<Interaction>();
		Image imageEdit=new Image(getClass().getResourceAsStream("edit_icon.png"));
		Image imageDelete=new Image(getClass().getResourceAsStream("delete_icon.png"));
		ImageView imageEditView=new ImageView(imageEdit);
		ImageView imageDeleteView=new ImageView(imageDelete);
		Button btnEdit = new Button("Edit", imageEditView);
		Button btnDelete = new Button("Delete", imageDeleteView);
		imageEditView.setFitHeight(15);
		imageEditView.setFitWidth(15);
		imageDeleteView.setFitHeight(15);
		imageDeleteView.setFitWidth(15);
		Button btnBack = new Button("Back");
		HBox hbBtn = new HBox(120);

		// Grid Methods
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		// Styling of Buttons
		btnEdit.setTextFill(Color.BLACK);
		btnEdit.setTextFill(Color.WHITE);
		btnEdit.setStyle("-fx-base: #FF0000");

		btnDelete.setTextFill(Color.WHITE);
		btnDelete.setStyle("-fx-base: #FF0000");
		btnDelete.setTextFill(Color.WHITE);

		btnBack.setTextFill(Color.WHITE);
		btnBack.setStyle("-fx-base: #FF0000");

		// Action for back button to return program to the home screen
		btnBack.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				HomeGUI homeGUI = new HomeGUI();
				try {
					homeGUI.start(primaryStage);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// adds buttons to box

		hbBtn.getChildren().add(btnEdit);
		hbBtn.getChildren().add(btnDelete);
		hbBtn.getChildren().add(btnBack);

		// adds box and list view to grid for display

		grid.add(hbBtn, 1, 1);

		if (HomeGUI.getType().equals("Person")) {
			// sets size of list view
			personResultsView.setMinSize(400, 300);
			personResultsView.setMaxSize(400, 300);
			grid.add(personResultsView, 1, 0);
			if (HomeGUI.getSearchKey().isEmpty()||HomeGUI.getSearchKey().equals(" ")){
				oListPersonResults = FXCollections.observableList(DataCollections.getPersonCollection());
			}else{
				oListPersonResults=FXCollections.observableArrayList(search.searchPeople(HomeGUI.getSearchKey()));
			}
			personResultsView.setItems(oListPersonResults);
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent e) {
	            	int selectedIndex=personResultsView.getSelectionModel().getSelectedIndex();
	            	if (selectedIndex>=0){
	            	for (int i=0; i<DataCollections.getInteractionCollection().size(); i++){
						for (int j=0; j<DataCollections.getInteractionCollection().get(i).getPeople1().size();j++){
							if(DataCollections.getInteractionCollection().get(i).getPeople1().get(j).equals(personResultsView.getSelectionModel().getSelectedItem())){
								DataCollections.getInteractionCollection().get(i).getPeople1().remove(j);
							}
						}
							for (int j=0; j<DataCollections.getInteractionCollection().get(i).getPeople2().size();j++){
								if(DataCollections.getInteractionCollection().get(i).getPeople2().get(j).equals(personResultsView.getSelectionModel().getSelectedItem())){
									DataCollections.getInteractionCollection().get(i).getPeople2().remove(j);
								}
							}
					}
	            	oListPersonResults.remove(selectedIndex);
	            	}
	            	
	            }
	        });

			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = personResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						selectedPerson=personResultsView.getSelectionModel().getSelectedItem();
						EditPersonGUI editPerson = new EditPersonGUI();
						editPerson.start(primaryStage);
					}

				}
			});
		}
		if (HomeGUI.getType().equals("Interaction")) {
			interactionResultsView.setMinSize(400, 300);
			interactionResultsView.setMaxSize(400, 300);
			grid.add(interactionResultsView, 1, 0);
			oListInteractionResults = FXCollections.observableList(DataCollections.getInteractionCollection());
			interactionResultsView.setItems(oListInteractionResults);
			btnDelete.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = interactionResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						oListInteractionResults.remove(selectedIndex);
					}
				}
			});
			btnEdit.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {
					int selectedIndex = interactionResultsView.getSelectionModel().getSelectedIndex();
					if (selectedIndex >= 0) {
						selectedInteraction=interactionResultsView.getSelectionModel().getSelectedItem();
						EditInteractionGUI interactionEdit = new EditInteractionGUI();
						interactionEdit.start(primaryStage);
					}

				}
			});
		}
		// primaryStage methods

		primaryStage.setTitle("Search Results");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static Person getSelectedPerson(){
		return selectedPerson;
	}
	
	public static Interaction getSelectedInteraction(){
		return selectedInteraction;
	}

}
