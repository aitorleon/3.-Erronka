package Agentzia;

import java.util.Scanner;

public class Tiketak extends Bezeroa{

	private int id_tiket;
	private boolean TV;
	private boolean Wifi;
	private double prezioa;
	private String tipo_asiento;
	private String jesarlekua;
	
	public Tiketak() {
		super();
		this.id_tiket=0;
		this.TV=true;
		this.Wifi=true;
		this.prezioa=0;
		this.tipo_asiento="";
		this.jesarlekua="";
	}
	public Tiketak(String n, int idt, boolean tv, boolean wifi, double prz, String ta, String jes) {
		super(n);
		this.id_tiket=idt;
		this.TV=tv;
		this.Wifi=wifi;
		this.prezioa=prz;
		this.tipo_asiento=ta;
		this.jesarlekua=jes;
	}
	public int getId_tiket() {
		return id_tiket;
	}
	public void setId_tiket(int id_tiket) {
		this.id_tiket = id_tiket;
	}
	public boolean isTV() {
		return TV;
	}
	public void setTV(boolean tV) {
		TV = tV;
	}
	public boolean isWifi() {
		return Wifi;
	}
	public void setWifi(boolean wifi) {
		Wifi = wifi;
	}
	public double getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	public String getTipo_asiento() {
		return tipo_asiento;
	}
	public void setTipo_asiento(String tipo_asiento) {
		this.tipo_asiento = tipo_asiento;
	}
	public String getJesarlekua() {
		return jesarlekua;
	}
	public void setJesarlekua(String jesarlekua) {
		this.jesarlekua = jesarlekua;
	}
	@Override
	public void irakurri(Scanner teklatua) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		
	}
}
