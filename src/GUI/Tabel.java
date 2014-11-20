package GUI;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tabel {
	
	//Tabeli andmemudel
	private final SimpleStringProperty tase;
	private final SimpleStringProperty nimi;
	private final SimpleDoubleProperty paakide_arv;
	private final SimpleStringProperty palk;

	public Tabel(String tase, String nimi, double paakide_arv, String palk) {
		super();
		this.tase = new SimpleStringProperty(tase);
		this.nimi = new SimpleStringProperty(nimi);
		this.paakide_arv = new SimpleDoubleProperty(paakide_arv);
		this.palk = new SimpleStringProperty(palk);
	}

	public String getTase() {
		return tase.get();
	}

	public String getNimi() {
		return nimi.get();
	}

	public Double getPaakide_arv() {
		return paakide_arv.get();
	}

	public String getPalk() {
		return palk.get();
	}

}
