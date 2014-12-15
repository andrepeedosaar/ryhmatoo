package GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Txtfile {
	
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
			
			int y = 0;
			
			for(int i = 0; i < CenterLeht.andmed.size(); i=i+4){
				
				if(y % 4 == 0){
					outstream.write("\n");
				}
				
				String tase = (String) CenterLeht.andmed.get(y);
				y++;
				String nimi = (String) CenterLeht.andmed.get(y);
				y++;
				String paak = (String) CenterLeht.andmed.get(y);
				y++;
				String palk = (String) CenterLeht.andmed.get(y);
				y++;
				
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
