
public class Meetodid extends Andmed{
	
	public Meetodid(double hektarid, double kerge, double normaalne, double raske, double v2garaske, double kohutav,
			int paagid1, int paagid2, int paagid3, int paagid4, int paagid5,
			double raskus1, double raskus2, double raskus3, double raskus4, double raskus5) {
		super(hektarid, kerge, normaalne, raske, v2garaske, kohutav,
				paagid1, paagid2, paagid3, paagid4, paagid5,
				raskus1, raskus2, raskus3, raskus4, raskus5);
	}

	public Meetodid() {
		super();
	}
	
	

	//Kontrollime erinevaid raskusi kogu hektarite arvuga
	double hektaritesumma(){
  		return(double)(kerge+normaalne+raske+v2garaske+kohutav);
  	}
	
	//Tagastame langi maksumuse
	double hind(){
  		return(double)kerge*100+normaalne*155+raske*200+v2garaske*270+kohutav*350;
  	}
	
	//Arvutame paakide arvu
	int paagid(){
		return(int)paagid1+paagid2+paagid3+paagid4+paagid5;
	}
	
	//Tagastame paagihinna
	double paagihind(){
  		return(double)hind()/paagid();
  	}
	
	//Töötaja 1 palk
	double palk1(){
  		return(double)paagihind()*(raskus1/100)*paagid1;
  	}
	
	//Töötaja 2 palk
	double palk2(){
  		return(double)paagihind()*(raskus2/100)*paagid2;
  	}
	
	//Töötaja 3 palk
	double palk3(){
  		return(double)paagihind()*(raskus3/100)*paagid3;
  	}
	
	//Töötaja 4 palk
	double palk4(){
  		return(double)paagihind()*(raskus4/100)*paagid4;
  	}
	
	//Töötaja 5 palk
	double palk5(){
  		return(double)paagihind()*(raskus5/100)*paagid5;
  	}
	
	//Kokku palgad
	double palgad(){
		return(double)palk1()+palk2()+palk3()+palk4()+palk5();
	}
	
	//Ülejääl
	double yle(){
		return(double)hind()-palgad();
	}
	
}
