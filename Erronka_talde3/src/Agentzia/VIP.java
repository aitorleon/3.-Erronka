package Agentzia;

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
