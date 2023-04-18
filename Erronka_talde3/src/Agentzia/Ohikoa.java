package Agentzia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ohikoa extends Bezeroa{

	private int gonbidatukop;
	
	public Ohikoa() {
		super();
		this.gonbidatukop=0;
	}
	public Ohikoa(String n, int gk) {
		super(n);
		this.gonbidatukop=gk;
	}
	public Ohikoa (int gbkp, String nan, String iz, String ab1, String ab2, Date jd, String telf, String email, String mo) {
		super(nan,iz,ab1,ab2,jd,telf,email,mo);
		this.gonbidatukop = gbkp;
	}

	public int getGonbidatukop() {
		return gonbidatukop;
	}
	public void setGonbidatukop(int gonbidatukop) {
		this.gonbidatukop = gonbidatukop;
	}
	/**
	 * @author Aitor Leon
	 * Gure erabiltzaile ohikoak nahi dutenak erregistratzeko
	 * @Override dago erentzia bat delako
	 */
	@Override
	public void irakurri(Scanner teklatua) {
		// TODO Auto-generated method stub
		System.out.println("Idatzi zure NAN:");
		this.nan=teklatua.next();
		System.out.println("Idatzi zure izena:");
		this.izena=teklatua.next();
		System.out.println("Idatzi zure lehenengo abizena:");
		this.abizena1=teklatua.next();
		System.out.println("Idatzi zure bigarren abizena:");
		this.abizena2=teklatua.next();
		System.out.println("Idatzi zure jaiotze data(yyyy/mm/dd):");
		try {
			this.jaiotze_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.next());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Idatzi zure emaila:");
		this.email=teklatua.next();
		System.out.println("Idatzi zure telefono zenbakia:");
		this.telefono=teklatua.next();
		System.out.println("Idatzi zenbat pertsona joango zareten.");
		this.gonbidatukop=teklatua.nextInt();
	}
/*rs.getDate()*/
	/**
	 * @author Aitor Leon
	 * Gure erabiltzaile ohikoak bistaratzeko
	 */
	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("NAN zenbakia: " + this.nan);
		System.out.println("Izena: " + this.izena);
		System.out.println("Abizena: " + this.abizena1);
		System.out.println("Bigarren abizena: " + this.abizena2);
		System.out.println("Zure jaiotze data: " + this.jaiotze_data);
		System.out.println("Zure korreo elektronikoa: " + this.email);
		System.out.println("Zure telefonoa: " + this.telefono);
		System.out.println("Gonbidatu dituzun pertsona kopurua: " + this.gonbidatukop);
	}
	/*public boolean adinezNagusi() {
		if(this.jaiotze_data>=18) {
			return true;
		}else {
			return false;
		}
	}*/
}
