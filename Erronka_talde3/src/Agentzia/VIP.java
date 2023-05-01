package Agentzia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VIP extends Bezeroa{

	private int puntuak;
	private int beherapenak;
	
	/**
	 * Defektuzko konstruktorea
	 * @author Kaiet
	 */
	public VIP() {
		super();
		this.puntuak=0;
		this.beherapenak=0;
	}
	/**
	 * Konstruktore pertsonalizatua, gure VIP objetuak gure modura adaptatzeko
	 * @author Kaiet
	 * @param n Vip bezeroaren NAN zenbakia jakitzeko
	 * @param pnt VIP bezeroa dituen puntuak zehazteko
	 * @param bp VIP beherapenak ikusteko
	 */
	public VIP(String n, int pnt, int bp) {
		super(n);
		this.puntuak=pnt;
		this.beherapenak=bp;
	}
	
	/*
	 * @author Kaiet
	 * Gure datu basera konektatzeko beharrezkoa den konstruktorea 
	 */
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
	
	/**
	 * @author Kaiet
	 * @param teklatua Gure baloreak eskaneatzeko eta gordetzeko
	 */
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
		System.out.println("Idatzi jaiotze data(yyyy-mm-dd):");
		try {
			this.Jaiotze_Data = new SimpleDateFormat("yyyy-mm-dd").parse(teklatua.next());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Idatzi zure emaila:");
		this.email=teklatua.next();
		System.out.println("Idatzi zure telefono zenbakia:");
		this.telefono=teklatua.next();
	}
	
	/**
	 * @author Kaiet
	 * Gure VIP bezeroen informazioa ikusteko
	 */
	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("Zure NAN zenbakia: " + this.nan);
		System.out.println("Zure izena" + this.izena);
		System.out.println("Zure lehen abizena" + this.abizena1);
		System.out.println("Zure bigarren abizena" + this.abizena2);
		System.out.println("Zure jaiotze data: " + this.Jaiotze_Data);
		System.out.println("Zure email-a: " + this.email);
		System.out.println("Zure telefono zenbakia" + this.telefono);
		System.out.println("Zure puntuak: " + this.puntuak);
	}
}
