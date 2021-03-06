package application;

import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.Random;
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
			
			Label label3 = new Label("&");
			label3.setLayoutX(80);
			label3.setLayoutY(180);
			
			Button button3 = new Button("Your Lucky Number");
			button3.setLayoutX(24);
			button3.setLayoutY(200);
			
			Group center_group = new Group();
			root.setCenter(center_group);
			center_group.getChildren().addAll(text1,text2,label1,label2,label3,button,button2,button3);
			
			// First button
			
			button.setOnAction(event->{
				System.out.println("Button1 clicked");
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
			
			// Second button
			
			button2.setOnAction(event->{
					System.out.println("Button2 clicked");
					text1.setText("");
					text2.setText("");
					System.out.println("Wyczyszczono wszystkie pola tekstowe");
				});	
			
			// Third button
			Random rnd = new Random();
			int lnr = rnd.nextInt(10);
			
			button3.setOnAction(event->{
				System.out.println("Button3 clicked");
				Stage stage3 = new Stage();
				stage3.setTitle("Lucky Number");
				BorderPane root_dlg = new BorderPane();
				stage3.setScene(new Scene(root_dlg,200,200));
				
				Label msg = new Label("Your Lucky Number is " + lnr);
				root_dlg.setCenter(msg);
				
				stage3.initOwner(stage);
				stage3.initModality(Modality.WINDOW_MODAL);
				stage3.show();
			}
			);
			
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