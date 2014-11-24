package GUI;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Elemendid {
	
	private static double hektar_kokku;
	private static double hektar_hetk;
	private static double paagid_kokku;
	
	private static ComboBox c_skill;
	private static TextField tf_name;
	private static TextField tf_parv;
		
	TableView<Tabel> table = new TableView<Tabel>();	
	final static ObservableList<Tabel> data = FXCollections.observableArrayList();

	static ArrayList palk = new ArrayList();
	static ArrayList andmed = new ArrayList();
	
	private static int langi_kogusumma = 0;
	private static double paakide_arv = 0;
	
	public ArrayList getAndmed(){
		return andmed;
	}
	
	public static DropShadow dropShadow(){
		DropShadow ds = new DropShadow();
		ds.setOffsetY(3.0);
        ds.setOffsetX(3.0);
        ds.setColor(Color.GRAY);
		return ds;
	}
	
	public static Node topPane() {
		 HBox top = new HBox();
		 top.setMaxHeight(50.0);
		 top.setPadding(new Insets(15, 22, 15, 22));
		 top.setStyle("-fx-background-color: #4caf50;");
		 top.setEffect(dropShadow());
		 
		 Label label = new Label("Töötajate ülevaade");
		 label.setFont(new Font("Arial", 30));
		 label.setStyle("-fx-text-fill: #ffffff;");
		 
		 top.getChildren().addAll(label);
		 return top;
	}
	
	public static Node leftPane(){
		HBox top = new HBox();
		top.setPadding(new Insets(0, 10, 0, 0));
		top.setStyle("-fx-background-color: #4caf50;");
		top.setEffect(dropShadow());
		return top;
	}
	
	public static Node rightPane(){
		HBox top = new HBox();
		top.setPadding(new Insets(0, 10, 0, 0));
		top.setStyle("-fx-background-color: #4caf50;");
		top.setEffect(dropShadow());
		return top;
	}
	
	public static Node centerPane(){
		GridPane grid = new GridPane();
		
		grid.setHgap(20);
		grid.setVgap(10);
		grid.setPadding(new Insets(35, 10, 10, 10));
		
		//Esimene rida
		Label l_hektar = new Label("Sisesta kogu hektarid: ");
		grid.add(l_hektar, 1, 0);
		 
		TextField tf_hektar = new TextField();
		grid.add(tf_hektar, 2, 0);
		
		Label l_kogu_paagid = new Label("Sisesta kogupaakide arv: ");
		grid.add(l_kogu_paagid, 3, 0);
		 
		TextField tf_kogu_paagid = new TextField();
		grid.add(tf_kogu_paagid, 4, 0);
		
		//Teine rida
		Label l_combo = new Label("Sisesta raskusastmed: ");
		grid.add(l_combo, 1, 1);
		
		ComboBox combo = new ComboBox();
		combo.getItems().addAll("Kerge", "Normaalne", "Raske", "Väga raske", "Kohutav");
		combo.setPromptText("");
		grid.add(combo, 2, 1);
		
		Label l_hek_suur = new Label("Maa-ala raskuste kaupa: ");
		grid.add(l_hek_suur, 3, 1);
		
		TextField tf_hek = new TextField();
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
            	
            	if (tf_hektar.getText().contains(null)){
            		try {
						throw new Numbrierind("Vale arv");
					} catch (Numbrierind e) {
						e.printStackTrace();
					}
            	}
            	
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
		
		/////////////////////////////////////////////////////////////////////////////////////
		//Teine osa programmist
		////////////////////////////////////////////////////////////////////////////////////
		//Neljas rida
		Label l_skill = new Label("Sisesta oskustase: ");
		grid.add(l_skill, 1, 3);
		 
		ComboBox c_skill = new ComboBox();
		c_skill.getItems().addAll("80","85", "90", "95", "100");
		c_skill.getSelectionModel().select("100");
		c_skill.setPromptText("100");
		grid.add(c_skill, 2, 3);
		
		//Viies rida
		Label l_name = new Label("Töölise nimi: ");
		grid.add(l_name, 1, 4);
		 
		TextField tf_name = new TextField();
		grid.add(tf_name, 2, 4);
		
		//Kuues rida
		Label l_parv = new Label("Töölise paakide arv: ");
		grid.add(l_parv, 1, 5);
		 
		TextField tf_parv = new TextField();
		grid.add(tf_parv, 2, 5);
		
		//Seitsmes rida
		Button lisa = new Button("Lisa tabelisse");
		lisa.setMaxWidth(Double.MAX_VALUE);
		grid.add(lisa, 1, 6);
		
		//lisa nupu funktsionaalsus
		lisa.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	//String tase, String nimi, int paakide_arv, double palk
            	data.add(new Tabel(c_skill.getValue().toString(),
            			
            			tf_name.getText(),
            			Integer.parseInt(tf_parv.getText()),
            			Double.toString(Double.parseDouble((String)c_skill.getValue())/100*Double.parseDouble(phind.getText())*Double.parseDouble(tf_parv.getText()))));
            			
            			andmed.add(c_skill.getValue().toString());
            			andmed.add(tf_name.getText());
            			andmed.add(tf_parv.getText());
            			andmed.add(Double.toString(Double.parseDouble((String)c_skill.getValue())/100*Double.parseDouble(phind.getText())*Double.parseDouble(tf_parv.getText())).toString());
            			
            			System.out.println(andmed);
            			
            	tf_name.clear();
                tf_parv.clear();
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
				Txtfile tf = null;
				tf.createFile();
			}
		});
		
		return grid;
	}
	
	public static Node bottomPane(){
		
		//Tabeli kuju ja struktuur
		TableView<Tabel> table = new TableView<Tabel>();
		
		table.setMaxHeight(200);
		
		TableColumn skill = new TableColumn("Tase");
		skill.setCellValueFactory(new PropertyValueFactory<Tabel, Double>("tase"));
		skill.setMinWidth(200.0);
		
        TableColumn name = new TableColumn("Nimi");
        name.setCellValueFactory(new PropertyValueFactory<Tabel, String>("nimi"));
        name.setMinWidth(200.0);
        
        TableColumn paakide_arv = new TableColumn("Paakide arv");
        paakide_arv.setCellValueFactory(new PropertyValueFactory<Tabel, Double>("paakide_arv"));
        paakide_arv.setMinWidth(200.0);
        
        TableColumn palk = new TableColumn("Palk");
        palk.setCellValueFactory(new PropertyValueFactory<Tabel, Double>("palk"));
        palk.setMinWidth(200.0);
        
        table.setItems(data);
        table.setEditable(true);
        table.getColumns().addAll(skill, name, paakide_arv, palk);

		return table;
	}

}
