package Agentzia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class VIP extends Bezeroa{

	private int puntuak;
	private String beherapenak;
	
	public VIP() {
		super();
		this.puntuak=0;
		this.beherapenak="";
	}
	public VIP(String n, int pnt, String bp) {
		super(n);
		this.puntuak=pnt;
		this.beherapenak=bp;
	}
	public int getPuntuak() {
		return puntuak;
	}
	public void setPuntuak(int puntuak) {
		this.puntuak = puntuak;
	}
	public String getBeherapenak() {
		return beherapenak;
	}
	public void setBeherapenak(String beherapenak) {
		this.beherapenak = beherapenak;
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
		System.out.println("sartu puntuak:");
		this.puntuak=teklatua.nextInt();
		System.out.println("sartu nahi duzun beherapena(%):");
		this.beherapenak=teklatua.next();
	}
	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println(this.beherapenak);
		System.out.println(this.puntuak);
		System.out.println(this.nan);
		System.out.println(this.izena);
		System.out.println(this.abizena1);
		System.out.println(this.abizena2);
		System.out.println(this.jaiotze_data);
		System.out.println(this.email);
		System.out.println(this.telefono);
	}
}
