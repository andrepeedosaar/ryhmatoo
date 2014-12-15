package GUI;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Lehed {
	
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
	
	@SuppressWarnings("unchecked")
	public static Node bottomPane(){
		
		//Tabeli kuju ja struktuur
		TableView<Tabel> table = new TableView<Tabel>();
		
		table.setMaxHeight(200);
		
		TableColumn<Tabel, Double> skill = new TableColumn<Tabel, Double>("Tase");
		skill.setCellValueFactory(new PropertyValueFactory<Tabel, Double>("tase"));
		skill.setMinWidth(200.0);
		
        TableColumn<Tabel, String> name = new TableColumn<Tabel, String>("Nimi");
        name.setCellValueFactory(new PropertyValueFactory<Tabel, String>("nimi"));
        name.setMinWidth(200.0);
        
        TableColumn<Tabel, Double> paakide_arv = new TableColumn<Tabel, Double>("Paakide arv");
        paakide_arv.setCellValueFactory(new PropertyValueFactory<Tabel, Double>("paakide_arv"));
        paakide_arv.setMinWidth(200.0);
        
        TableColumn<Tabel, Double> palk = new TableColumn<Tabel, Double>("Palk");
        palk.setCellValueFactory(new PropertyValueFactory<Tabel, Double>("palk"));
        palk.setMinWidth(200.0);
        
        table.setItems(CenterLeht.data);
        table.setEditable(true);
        table.getColumns().addAll(skill, name, paakide_arv, palk);

		return table;
	}
	
}
