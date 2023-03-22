package Agentzia;

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

	@Override
	public void irakurri(Scanner teklatua) {
		// TODO Auto-generated method stub
		
	}

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

}
