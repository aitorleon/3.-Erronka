package Agentzia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public int getGonbidatukop() {
		return gonbidatukop;
	}
	public void setGonbidatukop(int gonbidatukop) {
		this.gonbidatukop = gonbidatukop;
	}
	@Override
	public void irakurri(Scanner teklatua) {
		// TODO Auto-generated method stub
		System.out.println("sartu zure NAN:");
		this.nan=teklatua.next();
		System.out.println("sartu izena:");
		this.izena=teklatua.next();
		System.out.println("sartu lehenengo abizena:");
		this.abizena1=teklatua.next();
		System.out.println("sartu bigarren abizena:");
		this.abizena2=teklatua.next();
		System.out.println("Sartu jaiotze data(yyyy/mm/dd):");
		try {
			this.jaiotze_data = new SimpleDateFormat("dd/MM/yyyy").parse(teklatua.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sartu emaila:");
		this.email=teklatua.next();
		System.out.println("sartu telefono zenbakia:");
		this.telefono=teklatua.next();
		System.out.println("sartu pertsona kopurua:");
		this.gonbidatukop=teklatua.nextInt();
	}
/*rs.getDate()*/
	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println(this.gonbidatukop);
		System.out.println(this.nan);
		System.out.println(this.izena);
		System.out.println(this.abizena1);
		System.out.println(this.abizena2);
		System.out.println(this.jaiotze_data);
		System.out.println(this.email);
		System.out.println(this.telefono);
	}
	/*public boolean adinezNagusi() {
		if(this.jaiotze_data>=18) {
			return true;
		}else {
			return false;
		}
	}*/
}
