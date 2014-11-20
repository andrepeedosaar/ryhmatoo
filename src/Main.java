import java.util.*;
public class Main {
 
 public static void main(String[] args) {
	 
	 System.out.println("Lankide hinnad 1 hektari kohta");
	 System.out.println();
	 int langihinnad[] = {100,155,200,270,350};
	 String langiraskus[] = {"Kerge   ", "Keskmine ", "Raske   ", "V�ga raske ", "Kohutav "};
	 
	 for(int i = 0; i<langiraskus.length; i++){
			System.out.println(langiraskus[i] + "\t" + langihinnad[i] + " eurot");
		}
	 System.out.println();
	 
	 Scanner scan = new Scanner(System.in);
	
	 
	 System.out.println("Sisesta kogu maa-ala suurus hektarites");
	 double koguhektar = scan.nextDouble();
	 
	 System.out.println("Sisesta kerge: ");
	 double kerge = scan.nextDouble();
	 
	 System.out.println("Sisesta normaalne: ");
	 double normaalne = scan.nextDouble();
	 
	 System.out.println("Sisesta raske: ");
	 double raske = scan.nextDouble();
	 
	 System.out.println("Sisesta v�garaske: ");
	 double v2garaske = scan.nextDouble();
	 
	 System.out.println("Sisesta kohutav: ");
	 double kohutav = scan.nextDouble();
	 
	 System.out.println("Sisesta 1 t��taja paakide arv: ");
	 int paagid1 = scan.nextInt();
	 System.out.println("Sisesta 1 t��taja oskustase(protsentides): ");
	 double raskus1 = scan.nextDouble();
	 
	 System.out.println("Sisesta 2 t��taja paakide arv: ");
	 int paagid2 = scan.nextInt();
	 System.out.println("Sisesta 2 t��taja oskustase: ");
	 double raskus2 = scan.nextDouble();
	 
	 System.out.println("Sisesta 3 t��taja paakide arv: ");
	 int paagid3 = scan.nextInt();
	 System.out.println("Sisesta 3 t��taja oskustase: ");
	 double raskus3 = scan.nextDouble();
	 
	 System.out.println("Sisesta 4 t��taja paakide arv: ");
	 int paagid4 = scan.nextInt();
	 System.out.println("Sisesta 4 t��taja oskustase: ");
	 double raskus4 = scan.nextDouble();
	 
	 System.out.println("Sisesta 5 t��taja paakide arv: ");
	 int paagid5 = scan.nextInt();
	 System.out.println("Sisesta 5 t��taja oskustase: ");
	 double raskus5 = scan.nextDouble();
	 
	 
	 Meetodid m = new Meetodid(koguhektar, kerge, normaalne, raske, v2garaske, kohutav,
			 paagid1, paagid2, paagid3, paagid4, paagid5,
			 raskus1, raskus2, raskus3, raskus4, raskus5);
	 //System.out.println(a.toString());
	 
	 //kontrollime hektarite summat
	 
	 if(koguhektar == m.hektaritesumma()){
		 System.out.println("Hektarite summa klapib osade summaga");
		 
		//Arvutame l�ikuse hinna
		 System.out.println("Langi kogumaksumuseks tuleb " + m.hind() + " eurot.");
		 
	 }
	 else{
		 System.out.println("Kogu maa-ala ei klapi eraldi m�rgitud raskustega. Sisesta andmed uuesti!");
		 System.exit(1);
	 }
	 
	 //Tr�kime v�lja palju l�ks paake kokku langi peale
	 System.out.println("Kokku l�ks langi peale " + m.paagid() + " paaki.");
	 
	 //Tr�kime v�lja, mis kujunes �he paagi hinnaks
	 System.out.println("�he paagi hind on " + m.paagihind() + " eurot.");
	 
	 //Arvutame v�lja t��tajate hinnad
	 System.out.println("T��taja1 palgaks tuleb " + m.palk1() + " eurot.");
	 System.out.println("T��taja2 palgaks tuleb " + m.palk2() + " eurot.");
	 System.out.println("T��taja3 palgaks tuleb " + m.palk3() + " eurot.");
	 System.out.println("T��taja4 palgaks tuleb " + m.palk4() + " eurot.");
	 System.out.println("T��taja5 palgaks tuleb " + m.palk5() + " eurot.");
	 
	 //Kontrolliks arvutame palju palgad kokku tulid
	 System.out.println("Kokku l�heb palkadeks " + m.palgad() + " eurot.");
	 
	 //Leiame �lej��gi, mis l�heb parimate vahel jagamiseks
	 System.out.println("�lej��giks tuleb "+ m.yle() + "eurot");
	 
	 
	 
 
	 
	 
	 
	 
	 
	 
	 
	 
	      
 	}
}
