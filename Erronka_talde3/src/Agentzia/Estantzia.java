package Agentzia;

import java.util.Scanner;

public class Estantzia {
	private int id_Estantzia;
	private String NAN;
	private String Izena;
	private int Kapazitatea;
	private String Mota;
	private int Balorazioa;
	
	public Estantzia () {
		this.id_Estantzia = 0;
		this.NAN = "";
		this.Izena = "";
		this.Kapazitatea = 0;
		this.Mota = "";
		this.Balorazioa = 0;
	}
	public Estantzia (int id, String nan, String iz, int ka, String mo, int ba) {
		this.id_Estantzia = id;
		this.NAN = nan;
		this.Izena = iz;
		this.Kapazitatea = ka;
		this.Mota = mo;
		this.Balorazioa = ba;
	}
	public Estantzia (Estantzia e) {
		this.id_Estantzia = e.id_Estantzia;
		this.NAN = e.NAN;
		this.Izena = e.Izena;
		this.Kapazitatea = e.Kapazitatea;
		this.Mota = e.Mota;
		this.Balorazioa = e.Balorazioa;
	}
	public int getId_Estantzia() {
		return id_Estantzia;
	}
	public void setId_Estantzia(int id_Estantzia) {
		this.id_Estantzia = id_Estantzia;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
	}
	public int getKapazitatea() {
		return Kapazitatea;
	}
	public void setKapazitatea(int kapazitatea) {
		Kapazitatea = kapazitatea;
	}
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}
	public int getBalorazioa() {
		return Balorazioa;
	}
	public void setBalorazioa(int balorazioa) {
		Balorazioa = balorazioa;
	}
	/**
	 * Gure erabiltzaileak sortzen duten estantziak bistaratzeko
	 * @author Iker Elorrieta
	 */
	public void estantziaPantailaratu () {
		System.out.println("--------------------------------------------");
		System.out.println("Estantziaren ID zenbakia: " + this.id_Estantzia);
		System.out.println("Bezeroaren NAN zenbakia: " + this.NAN);
		System.out.println("Estantziaren izena: " + this.Izena);
		System.out.println("Estantziaren kapazitatea: " + this.Kapazitatea);
		System.out.println("Estantziaren mota: " + this.Mota);
		System.out.println("Estantziaren balorazioa: " + this.Balorazioa);
		System.out.println("--------------------------------------------");
	}
	/**
	 * 
	 * @param teklatua Gure erabiltzaileak sartzen duten datuak gordetzeko
	 * @author Iker Elorrieta
	 */
	public void estantziaErreserbatu (Scanner teklatua) {
		System.out.println("Idatzi zure erabiltzailearen NAN zenbakia: ");
		this.NAN = teklatua.next();
		System.out.println("");
	}
}
