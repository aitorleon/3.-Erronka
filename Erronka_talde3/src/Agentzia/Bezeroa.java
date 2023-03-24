package Agentzia;

import java.util.Date;
import java.util.Scanner;

public abstract class Bezeroa {

	protected String nan;
	protected String izena;
	protected String abizena1;
	protected String abizena2;
	protected Date jaiotze_data;
	protected String email;
	protected String telefono;
	
	public Bezeroa(){
		this.nan="";
		this.izena="";
		this.abizena1="";
		this.abizena2="";
		this.jaiotze_data= new Date();
		this.email="";
		this.telefono="";
	}
	public Bezeroa(String n, String izn, String abz1, String abz2, Date jdata, String em, String tlf) {
		this.nan=n;
		this.izena=izn;
		this.abizena1=abz1;
		this.abizena2=abz2;
		this.jaiotze_data=jdata;
		this.email=em;
		this.telefono=tlf;
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
		return jaiotze_data;
	}
	public void setJaiotze_data(Date jaiotze_data) {
		this.jaiotze_data = jaiotze_data;
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
	public abstract void irakurri(Scanner teklatua);
	public abstract void pantailaratu();
}
