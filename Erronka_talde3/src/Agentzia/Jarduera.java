package Agentzia;

import java.io.Serializable;
import java.util.Scanner;

public class Jarduera implements Serializable{
	private String nan;
	private int id_Jarduera;
	private int id_Helmuga;
	private String Izena;
	private String Mota;
	private int Balorazioa;
	private String Eskuragarri;
	
	/**
	 * Defektuzko konstruktorea
	 * @author Kaiet
	 */
	public Jarduera () {
		this.nan = "";
		this.id_Jarduera = 0;
		this.id_Helmuga = 0;
		this.Izena = "";
		this.Mota = "";
		this.Balorazioa = 0;
		this.Eskuragarri = "";
	}
	/**
	 * Konstruktore pertsonalizatua, hau egingo dugu gure Jarduera objetuak gura dugun modura editatzeko
	 * @author Kaiet
	 * @param n Jardueraren izena jakitzeko
	 * @param idJ Jardueraren id zenbakia zehazteko
	 * @param idH Jardueran egiten den helmugaren id-a
	 * @param iz Jardueraren izena jakitzeko
	 * @param mo Jarduera mota zehin izengo den
	 * @param b Jarduerak dituen balorazio desberdinak
	 * @param es Eskuragarri dagoen jakitzeko
	 */
	public Jarduera (String n,int idJ, int idH, String iz, String mo, int b, String es) {
		this.nan = n;
		this.id_Helmuga = idH;
		this.id_Jarduera = idJ;
		this.Izena = iz;
		this.Mota =mo;
		this.Balorazioa = b;
		this.Eskuragarri = es;
	}
	/*
	 * Kopia konstruktorea
	 * @author Kaiet
	 */
	public Jarduera (Jarduera j) {
		this.nan = j.nan;
		this.id_Helmuga = j.id_Helmuga;
		this.id_Jarduera = j.id_Jarduera;
		this.Izena = j.Izena;
		this.Mota = j.Mota;
		this.Balorazioa = j.Balorazioa;
		this.Eskuragarri = j.Eskuragarri;
	}
	public String getEskuragarri() {
		return Eskuragarri;
	}
	public void setEskuragarri(String eskuragarri) {
		Eskuragarri = eskuragarri;
	}
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public int getId_Jarduera() {
		return id_Jarduera;
	}
	public void setId_Jarduera(int id_Jarduera) {
		this.id_Jarduera = id_Jarduera;
	}
	public int getId_Helmuga() {
		return id_Helmuga;
	}
	public void setId_Helmuga(int id_Helmuga) {
		this.id_Helmuga = id_Helmuga;
	}
	public String getIzena() {
		return Izena;
	}
	public void setIzena(String izena) {
		Izena = izena;
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
	 * @author Aitor Leon
	 * Gure erabiltzaileak antolatzen duten jarduerak bistaratzeko
	 */
	public void pantailaratuJarduera () {
		System.out.println("------------------------------------------------------------------");
		System.out.println("** Jardueraren kodea " + this.id_Jarduera + " da. **");
		System.out.println("** Jardueraren izena: " + this.Izena + " **");
		System.out.println("** Jardueraren mota: " + this.Mota + " **");
		System.out.println("** Bezeroengatik emandako balorazioa: " + this.Balorazioa + " **");
		System.out.println("------------------------------------------------------------------");
	}
}
