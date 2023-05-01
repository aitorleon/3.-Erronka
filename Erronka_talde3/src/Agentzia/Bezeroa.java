package Agentzia;

import java.util.Date;
import java.util.Scanner;

public abstract class Bezeroa {

	protected String nan;
	protected String izena;
	protected String abizena1;
	protected String abizena2;
	protected Date Jaiotze_Data;
	protected String email;
	protected String telefono;
	protected String mota;
	
	public Bezeroa(){
		this.nan="";
		this.izena="";
		this.abizena1="";
		this.abizena2="";
		this.Jaiotze_Data= new Date();
		this.email="";
		this.telefono="";
		this.mota = "";
	}
	public Bezeroa(String n, String izn, String abz1, String abz2, Date jdata, String em, String tlf, String mo) {
		this.nan=n;
		this.izena=izn;
		this.abizena1=abz1;
		this.abizena2=abz2;
		this.Jaiotze_Data=jdata;
		this.email=em;
		this.telefono=tlf;
		this.mota = mo;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public Bezeroa(String n) {
		this.nan=n;
	}
	public String getNan() {
		return nan;
	}
	public void setNan(String nan) {
		this.nan = nan;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getAbizena1() {
		return abizena1;
	}
	public void setAbizena1(String abizena1) {
		this.abizena1 = abizena1;
	}
	public String getAbizena2() {
		return abizena2;
	}
	public void setAbizena2(String abizena2) {
		this.abizena2 = abizena2;
	}
	public Date getJaiotze_data() {
		return Jaiotze_Data;
	}
	public void setJaiotze_data(Date jaiotze_data) {
		this.Jaiotze_Data = jaiotze_data;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * 
	 * @param teklatua gura dugun eremuak eskaneatzeko eta gordetzeko
	 * @author Iker Elorrieta
	 */
	public abstract void irakurri(Scanner teklatua);
	/**
	 * Gure bezeroen datuak pantailaratzeko
	 * @author aitor
	 */
	public abstract void pantailaratu();
}
