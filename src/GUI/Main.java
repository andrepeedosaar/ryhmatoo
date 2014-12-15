package GUI;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
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
	    //Ülemine element
		root.setTop(Lehed.topPane());
		BorderPane.setAlignment(Lehed.topPane(), Pos.CENTER);
		
		//Parem element
		root.setRight(Lehed.rightPane());
		BorderPane.setAlignment(Lehed.rightPane(), Pos.CENTER);
		
		//Keskmine element
		root.setCenter(CenterLeht.centerPane());
		
		//Vasak element
		root.setLeft(Lehed.leftPane());
		BorderPane.setAlignment(Lehed.leftPane(), Pos.CENTER);
		
		//Alumine element
		root.setBottom(Lehed.bottomPane());
		BorderPane.setAlignment(Lehed.bottomPane(), Pos.CENTER);
		
		//Muudame akna nähtavaks
		Scene scene = new Scene(root, 800, 600);
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
