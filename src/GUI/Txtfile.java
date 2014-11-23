package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Txtfile {
	
	static Elemendid e = new Elemendid();
	
	public static String kuupaev(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	static void createFile(){
		
		File f = new File(kuupaev() + ".txt");
		
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			
			FileWriter outf = new FileWriter(f);
			BufferedWriter outstream = new BufferedWriter(outf);
			
			outstream.write(kuupaev() + "\n" + "\n");
			outstream.write("Tase" + "\t" + "Nimi" + "\t" + "Paakide arv " + "\t" + "Palk" + "\n");
			
			for(int i = 0; i < Elemendid.andmed.size(); i++){
				
				if(i % 4 == 0){
					outstream.write("\n");
				}
				
				String tase = (String) Elemendid.andmed.get(i);
				String nimi = (String) Elemendid.andmed.get(i++);
				String paak = (String) Elemendid.andmed.get(i++);
				String palk = (String) Elemendid.andmed.get(i++);
				
				outstream.write(tase + "\t");
				outstream.write("\t" + nimi + "\t");
				outstream.write("\t" + paak + "\t");
				outstream.write("\t" + palk);
					
			}
		
			outstream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
