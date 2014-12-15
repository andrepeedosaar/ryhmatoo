package GUI;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class CenterLeht {
	
	final static ObservableList<Tabel> data = FXCollections.observableArrayList();
	static ArrayList<String> andmed = new ArrayList<String>();
	
	private static double hektar_kokku;
	private static double hektar_hetk;
	private static double paagid_kokku;
	private static int langi_kogusumma = 0;
	
	private static ComboBox<String> c_skill;
	private static TextField tf_name;
	private static TextField tf_parv;
	
	public static void vale_sisend(){
		
		Label secondLabel = new Label("Sisesta õige anmetüüp!");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);
        Scene secondScene = new Scene(secondaryLayout, 200, 100);
        Stage secondStage = new Stage();
        secondStage.setTitle("Viga!");
        secondStage.setScene(secondScene);
         
        secondStage.setX(250);
        secondStage.setY(100);

        secondStage.show();
	}
	
	public static void tyhi_sisend(){
		
		Label secondLabel = new Label("Sisendiväli on tühi!");
        StackPane secondaryLayout = new StackPane();
        secondaryLayout.getChildren().add(secondLabel);
        Scene secondScene = new Scene(secondaryLayout, 200, 100);
        Stage secondStage = new Stage();
        secondStage.setTitle("Viga!");
        secondStage.setScene(secondScene);
         
        secondStage.setX(250);
        secondStage.setY(100);

        secondStage.show();
	}
			
	public static Node centerPane(){
		
		GridPane grid = new GridPane();
		
		grid.setHgap(20);
		grid.setVgap(10);
		grid.setPadding(new Insets(35, 10, 10, 10));
		
		//Esimene rida
		
		Label l_hektar = new Label("Sisesta kogu hektarid: ");
		grid.add(l_hektar, 1, 0);
		 
		TextField tf_hektar = new TextField(null);
		tf_hektar.setPromptText("Number");
		grid.add(tf_hektar, 2, 0);
		
		Label l_kogu_paagid = new Label("Sisesta kogupaakide arv: ");
		grid.add(l_kogu_paagid, 3, 0);
		 
		TextField tf_kogu_paagid = new TextField(null);
		tf_kogu_paagid.setPromptText("Number");
		grid.add(tf_kogu_paagid, 4, 0);
		
		//Teine rida
		
		Label l_combo = new Label("Sisesta raskusastmed: ");
		grid.add(l_combo, 1, 1);
		
		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("Kerge", "Normaalne", "Raske", "Väga raske", "Kohutav");
		combo.setPromptText("");
		grid.add(combo, 2, 1);
		
		Label l_hek_suur = new Label("Maa-ala raskuste kaupa: ");
		grid.add(l_hek_suur, 3, 1);
		
		TextField tf_hek = new TextField(null);
		tf_hek.setPromptText("Number");
		grid.add(tf_hek, 4, 1);
		
		Button h_lisa = new Button("Lisa");
		grid.add(h_lisa, 5, 1);
		
		//Kolmas rida
		
		Label l_sis_hek = new Label("Sisestatud hektarid: ");
		grid.add(l_sis_hek, 1, 2);
		
		Label kokku = new Label("");
		grid.add(kokku, 2, 2);
		
		Label kontroll_hek = new Label("Kontroll: ");
		grid.add(kontroll_hek, 3, 2);
		
		Label kontroll = new Label("");
		grid.add(kontroll, 4, 2);
		
		Label paagi_hind = new Label("Ühe paagi hind: ");
		grid.add(paagi_hind, 3, 3);
		
		Label phind = new Label("");
		grid.add(phind, 4, 3);
				
		//Lisa nupu funktsionaalsused
		h_lisa.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	
            	/*
            	if (tf_hektar.getText().equals("") || tf_parv.getText().equals("") || tf_hek.getText().equals("")){
            		try {
            			tyhi_sisend();
					} catch (Exception e) {
						e.printStackTrace();
					}
            	}
            	*/
            	
            	/*
            	if (tf_hektar.getText().equals(String.class) || 
            		tf_parv.getText().equals(String.class) || 
            		tf_hek.getText().equals(String.class)){
            		try {
            			vale_sisend();
					} catch (Exception e) {
						e.printStackTrace();
					}
            	}
            	*/
            	
            	hektar_kokku = Double.parseDouble(tf_hektar.getText());
            	
            	kokku.setText(tf_hektar.getText());
            	tf_hektar.setEditable(false);
            	
            	hektar_hetk += Double.parseDouble(tf_hek.getText());
            	kontroll.setText(String.valueOf(hektar_hetk));
            	
            	paagid_kokku = Double.parseDouble(tf_kogu_paagid.getText());

            	//Liidab kokku ja leiab kogusumma
            	if(combo.getValue() == "Kerge"){
            		langi_kogusumma += 100*Double.parseDouble(tf_hek.getText());
            	}
            	if(combo.getValue() == "Normaalne"){
            		langi_kogusumma += 155*Double.parseDouble(tf_hek.getText());
            	}
            	if(combo.getValue() == "Raske"){
            		langi_kogusumma += 200*Double.parseDouble(tf_hek.getText());
            	}
            	if(combo.getValue() == "Väga raske"){
            		langi_kogusumma += 270*Double.parseDouble(tf_hek.getText());
            	}
            	if(combo.getValue() == "Kohutav"){
            		langi_kogusumma += 350*Double.parseDouble(tf_hek.getText());
            	}
            	    	
            	if(hektar_hetk> hektar_kokku){
            		tf_hek.clear();
            		hektar_hetk =0;
            		langi_kogusumma=0;
            		phind.setText("Suurused ei klapi!");
            		phind.setTextFill(Color.FIREBRICK);
            		tf_hek.setEditable(true);
            		tf_hektar.clear();
        			tf_hektar.setEditable(true);
            	
            		
            	}
            	//Kontrollib kas koguhektarite arv klapib raskuste tasemetega 
            	if(hektar_hetk == hektar_kokku){
        			tf_hek.setEditable(false);
        			tf_hektar.setEditable(false);
        			l_sis_hek.setText("Kogusumma: ");
        			System.out.println(langi_kogusumma);
        			kokku.setText(Integer.toString(langi_kogusumma));
        			kontroll.setText("");
        			kontroll_hek.setText("");
        			h_lisa.setDisable(true);
        			phind.setText(Double.toString(langi_kogusumma/paagid_kokku));
        			phind.setTextFill(Color.BLACK);
        		}
            	//System.out.print(palk);
            }
         });

		
		//Neljas rida
		Label l_skill = new Label("Sisesta oskustase: ");
		grid.add(l_skill, 1, 3);
		 
		ComboBox<String> c_skill = new ComboBox<String>();
		c_skill.getItems().addAll("80","85", "90", "95", "100");
		c_skill.getSelectionModel().select("100");
		c_skill.setPromptText("100");
		grid.add(c_skill, 2, 3);
		
		//Viies rida
		Label l_name = new Label("Töölise nimi: ");
		grid.add(l_name, 1, 4);
		 
		TextField tf_name = new TextField();
		tf_name.setPromptText("Nimi");
		grid.add(tf_name, 2, 4);
		
		//Kuues rida
		Label l_parv = new Label("Töölise paakide arv: ");
		grid.add(l_parv, 1, 5);
		 
		TextField tf_parv = new TextField();
		tf_parv.setPromptText("Number");
		grid.add(tf_parv, 2, 5);
		
		//Seitsmes rida
		Button lisa = new Button("Lisa tabelisse");
		lisa.setMaxWidth(Double.MAX_VALUE);
		grid.add(lisa, 1, 6);
		
		//lisa nupu funktsionaalsus
		lisa.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	
            	try {
            		
            	if (tf_name.getText().equals("")){
            			tyhi_sisend();
            			throw new Exception();
            	}
            	
            	else if (tf_parv.getText().equals(String.class)) {
            			vale_sisend();
            			throw new NumberFormatException();
            	}
            	
            	//String tase, String nimi, int paakide_arv, double palk
            	data.add(new Tabel(
            			c_skill.getValue().toString(),
            			tf_name.getText(),
            			Integer.parseInt(tf_parv.getText()),
            			Double.toString(Double.parseDouble((String)c_skill.getValue())/100*Double.parseDouble(phind.getText())*Double.parseDouble(tf_parv.getText())))
            	);
            			
            	andmed.add(c_skill.getValue().toString());
            	andmed.add(tf_name.getText());
            	andmed.add(tf_parv.getText());
            	andmed.add(Double.toString(Double.parseDouble((String)c_skill.getValue())/100*Double.parseDouble(phind.getText())*Double.parseDouble(tf_parv.getText())).toString());
            			
            	System.out.println(andmed);
            			
            	tf_name.clear();
                tf_parv.clear();
            	}
            	
            	catch(Exception e){
            		e.printStackTrace();
            	}
            }
         });
		
		Button clear = new Button("Puhasta väljad");
		clear.setMaxWidth(Double.MAX_VALUE);
		grid.add(clear, 2, 6);
		
		//puhasta nupu funktsionaalsus
		clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
               tf_hektar.clear();
               combo.setPromptText("");
               tf_hek.clear();
               c_skill.setPromptText("100");
               tf_name.clear();
               tf_parv.clear();
               tf_hektar.setEditable(true);
               h_lisa.setDisable(false);
               kokku.setText("");
               kontroll.setText("");
               tf_hek.setEditable(true);
       		   hektar_hetk =0;
       		   langi_kogusumma=0;
       		   tf_kogu_paagid.clear();
            }
         });
		
		Button write = new Button("Salvesta");
		write.setMaxWidth(Double.MAX_VALUE);
		grid.add(write, 3, 6);
		
		write.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Txtfile.createFile();
			}
		});
		
		
		
		return grid;
	}

	//Getterid, setterid
	
	public static ComboBox<String> getC_skill() {
		return c_skill;
	}
	public static void setC_skill(ComboBox<String> c_skill) {
		CenterLeht.c_skill = c_skill;
	}
	
	public ArrayList<String> getAndmed(){
		return andmed;
	}

	public static TextField getTf_name() {
		return tf_name;
	}

	public static void setTf_name(TextField tf_name) {
		CenterLeht.tf_name = tf_name;
	}

	public static TextField getTf_parv() {
		return tf_parv;
	}
	public static void setTf_parv(TextField tf_parv) {
		CenterLeht.tf_parv = tf_parv;
	}
}
