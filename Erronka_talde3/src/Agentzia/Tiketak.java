package Agentzia;

import java.util.Scanner;

public class Tiketak extends Bezeroa{

	private int id_tiket;
	private String TV;
	private String Wifi;
	private int prezioa;
	private String tipo_asiento;
	private String jesarlekua;
	
	public Tiketak() {
		super();
		this.id_tiket=0;
		this.TV="";
		this.Wifi="";
		this.prezioa=0;
		this.tipo_asiento="";
		this.jesarlekua="";
	}
	//Tiketak t1 = new Tiketak(rs.getInt("id_Tiket"),rs.getString("NAN"),rs.getDouble("Prezioa"),rs.getString("Jesarlekua"),rs.getString("Wifi"),rs.getString("Jesarleku_Mota"),rs.getString("TV"));

	public Tiketak(int idt,String n,  int prz,String jes,String wifi,String ta, String tv) {
		super(n);
		this.id_tiket=idt;
		this.TV=tv;
		this.Wifi=wifi;
		this.prezioa=prz;
		this.tipo_asiento=ta;
		this.jesarlekua=jes;
	}
	public Tiketak (Tiketak t) {
		super();
		this.id_tiket = t.id_tiket;
		this.TV = t.TV;
		this.Wifi = t.Wifi;
		this.prezioa = t.prezioa;
		this.tipo_asiento = t.tipo_asiento;
		this.jesarlekua = t.jesarlekua;
	}
	public String getWifi() {
		return Wifi;
	}
	public int getId_tiket() {
		return id_tiket;
	}
	public void setId_tiket(int id_tiket) {
		this.id_tiket = id_tiket;
	}
	public String isTV() {
		return TV;
	}
	public String getTV() {
		return TV;
	}
	public void setTV(String tV) {
		TV = tV;
	}
	public String isWifi() {
		return Wifi;
	}
	public void setWifi(String wifi) {
		Wifi = wifi;
	}
	public int getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(int prezioa) {
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
		this.prezioa = 0;
		// TODO Auto-generated method stub
		System.out.println("**Ongi Etorri gure Tiket Erosketara**");
		System.out.println("**Zer motatako tiketa nahi duzu? Turista/Business/Lehen Klasea**");
		this.tipo_asiento = teklatua.next();
		if (this.tipo_asiento.equalsIgnoreCase("turista")) {
			this.prezioa= this.prezioa + 300;
		}else if (this.tipo_asiento.equalsIgnoreCase("business")) {
			this.prezioa = this.prezioa + 600;
		}else if (this.tipo_asiento.equalsIgnoreCase("lehen klasea")) {
			this.prezioa = this.prezioa + 1000;
		}
		System.out.println("**Zure jesarlekua leku zehatz batean egotea gustautuko litzaizuke? (0tik 300era eta LETRA BAT IDATZIZ)**");
		this.jesarlekua = teklatua.next();
		System.out.println("**Telebista edukitzea gustatuko litzaizuke? (Bai/Ez)**");
		this.TV = teklatua.next();
		if (this.TV.equalsIgnoreCase("bai")) {
			this.prezioa = this.prezioa + 40;
		}else {
			this.prezioa = this.prezioa;
		}
		System.out.println("**Wifia edukitzea gustatuko litzaizuke? (Bai/Ez)**");
		this.Wifi = teklatua.next();
		if (this.Wifi.equalsIgnoreCase("bai")) {
			this.prezioa = this.prezioa + 50;
		}else {
			this.prezioa = this.prezioa;
		}
		
		System.out.println("Eskerrikasko, tiketaren prezioa " + this.prezioa + " da.");
	}

	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------------");
		System.out.println("**Zure tiketa " + this.tipo_asiento + " motatakoa da.");
		System.out.println("**Zure jesarlekua " + this.jesarlekua + " zenbakia da.");
		if (this.TV.equalsIgnoreCase("Bai")) {
			System.out.println("**Telebista daukazu**");
		}else {
			System.out.println("**Ez daukazu telebista**");
		}
		if (this.Wifi.equalsIgnoreCase("ez")) {
			System.out.println("**Wifia izatea aukeratu duzu**");
		}else {
			System.out.println("**Ez daukazu wifirik**");
		}
		System.out.println("---------------------------------------------------------");
	}
}
