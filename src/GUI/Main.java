package GUI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		//Loome layout tüübi
		BorderPane root = new BorderPane();  
		root.setStyle("-fx-background-color: #f0f4c3;");
		
		//Lisame akna elemendid
	    Elemendid e = new Elemendid();
	    
	    //Ülemine element
		root.setTop(e.topPane());
		root.setAlignment(e.topPane(), Pos.CENTER);
		
		//Parem element
		root.setRight(e.rightPane());
		root.setAlignment(e.rightPane(), Pos.CENTER);
		
		//Keskmine element
		root.setCenter(e.centerPane());
		
		//Vasak element
		root.setLeft(e.leftPane());
		root.setAlignment(e.leftPane(), Pos.CENTER);
		
		//Alumine element
		root.setBottom(e.bottomPane());
		root.setAlignment(e.bottomPane(), Pos.CENTER);
		
		//Muudame akna nähtavaks
		Scene scene = new Scene(root, 750, 600);
		primaryStage.setTitle("Võsalõikuse arvestamise App");
		primaryStage.setScene(scene); 
		primaryStage.show();

		//Saab klahviga sulgeda akent
		root.setOnKeyPressed(new EventHandler<KeyEvent>() {
	         public void handle(KeyEvent ke) {
	             if (ke.getCode() == KeyCode.ESCAPE) {
	                 primaryStage.close();
	             }
	         }
	     });
		
	}
}
