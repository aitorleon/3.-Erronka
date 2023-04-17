package Agentzia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VIP extends Bezeroa{

	private int puntuak;
	private int beherapenak;
	
	public VIP() {
		super();
		this.puntuak=0;
		this.beherapenak=0;
	}
	public VIP(String n, int pnt, int bp) {
		super(n);
		this.puntuak=pnt;
		this.beherapenak=bp;
	}

	public VIP (int pun, int behe, String nan, String iz, String ab1, String ab2, Date jd, String telf, String mail, String mo) {
		super(nan,iz,ab1,ab2,jd,telf,mail,mo);
		this.puntuak = pun;
		this.beherapenak = behe;
	}
	public int getPuntuak() {
		return puntuak;
	}
	public void setPuntuak(int puntuak) {
		this.puntuak = puntuak;
	}
	public int getBeherapenak() {
		return beherapenak;
	}
	public void setBeherapenak(int beherapenak) {
		this.beherapenak = beherapenak;
	}
	@Override
	public void irakurri(Scanner teklatua) {
		// TODO Auto-generated method stub
		System.out.println("Idatzi zure NAN zenbakia:");
		this.nan=teklatua.next();
		System.out.println("Idatzi zure izena:");
		this.izena=teklatua.next();
		System.out.println("Idatzi zure lehenengo abizena:");
		this.abizena1=teklatua.next();
		System.out.println("Idatzi zure bigarren abizena:");
		this.abizena2=teklatua.next();
		System.out.println("Idatzi jaiotze data(yyyy/mm/dd):");
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
		System.out.println("Idatzi zenbat puntu dituzun:");
		this.puntuak=teklatua.nextInt();
	}
	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("Zure NAN zenbakia: " + this.nan);
		System.out.println("Zure izena" + this.izena);
		System.out.println("Zure lehen abizena" + this.abizena1);
		System.out.println("Zure bigarren abizena" + this.abizena2);
		System.out.println("Zure jaiotze data: " + this.jaiotze_data);
		System.out.println("Zure email-a: " + this.email);
		System.out.println("Zure telefono zenbakia" + this.telefono);
		System.out.println("Zure puntuak: " + this.puntuak);
	}
}
