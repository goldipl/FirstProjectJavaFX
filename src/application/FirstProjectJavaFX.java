package application;
	

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;


public class FirstProjectJavaFX extends Application {
	@Override
	public void start(Stage stage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,300,300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setTitle("First JavaFX Project");
			stage.setScene(scene);
			stage.show();
			
			Label label1 = new Label("Enter your name: "); 
			label1.setLayoutX(10);
			label1.setLayoutY(0);
			Label label2 = new Label("Enter your surname: ");
			label2.setLayoutX(10);
			label2.setLayoutY(50);
			
			TextField text1 = new TextField();
			text1.getStyleClass().add("fieldstyle");
			text1.setLayoutX(10);
			text1.setLayoutY(20);
			
			TextField text2 = new TextField();
			text2.getStyleClass().add("fieldstyle");
			text2.setLayoutX(10);
			text2.setLayoutY(70);
			
			Button button = new Button("Click me now!");
			button.setLayoutX(40);
			button.setLayoutY(110);
			
			Button button2 = new Button("Clear textfields");
			button2.setLayoutX(38);
			button2.setLayoutY(150);
			Group center_group = new Group();
			root.setCenter(center_group);
			center_group.getChildren().addAll(text1,text2,label1,label2,button,button2);
			
			
			button.setOnAction(event->{
				System.out.println("Button clicked");
				Stage stage2 = new Stage();
				stage2.setTitle("Hello");
				BorderPane root_dlg = new BorderPane();
				stage2.setScene(new Scene(root_dlg,300,200));
				
				Label msg = new Label("Hello " + text1.getText() + " " + text2.getText() +"!");
				root_dlg.setCenter(msg);
				
				stage2.initOwner(stage);
				stage2.initModality(Modality.WINDOW_MODAL);
				stage2.show();
			}
			);
			
			button2.setOnAction(event->{
					text1.setText("");
					text2.setText("");
					System.out.println("Wyczyszczono wszystkie pola tekstowe");
				});	
			
			//Add tooltip to button
			
			Tooltip t1 = new Tooltip("Run Application");
			
			button.setTooltip(t1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
