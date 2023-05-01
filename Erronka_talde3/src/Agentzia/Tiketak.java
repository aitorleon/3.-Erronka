package Agentzia;

import java.util.Scanner;

public class Tiketak extends Bezeroa implements Bez{

	private int id_tiket;
	private String TV;
	private String Wifi;
	private double prezioa;
	private String tipo_asiento;
	private String jesarlekua;
	
	/**
	 * Defektuzko konstruktorea
	 * @author Iker
	 */
	public Tiketak() {
		super();
		this.id_tiket=0;
		this.TV="";
		this.Wifi="";
		this.prezioa=0;
		this.tipo_asiento="";
		this.jesarlekua="";
		this.nan = "";
	}

	/**
	 * @author Iker
	 * @param idt Tiketaren id zenbakia
	 * @param n Tiketaren NAN zenbakia jakitzeko
	 * @param prz Tiketaren prezioa zehazteko
	 * @param jes Tiketa zer jesarlekua izango duen jakitzeko
	 * @param wifi Tiketa wifia izango duen jakitzeko
	 * @param ta Tiketa zer motatakoa izango den
	 * @param tv Tiketa TV-a izango duen zehazteko
	 */
	public Tiketak(int idt,String n,  double prz,String jes,String wifi,String ta, String tv) {
		super(n);
		this.id_tiket=idt;
		this.TV=tv;
		this.Wifi=wifi;
		this.prezioa=prz;
		this.tipo_asiento=ta;
		this.jesarlekua=jes;
	}
	/**
	 * Kopia konstruktorea
	 * @param t Tiketak motatako objetua
	 * @author Iker
	 */
	public Tiketak (Tiketak t) {
		super();
		this.id_tiket = t.id_tiket;
		this.TV = t.TV;
		this.Wifi = t.Wifi;
		this.prezioa = t.prezioa;
		this.tipo_asiento = t.tipo_asiento;
		this.jesarlekua = t.jesarlekua;
	}
	
	public int getId_tiket() {
		return id_tiket;
	}

	public void setId_tiket(int id_tiket) {
		this.id_tiket = id_tiket;
	}

	public String getTV() {
		return TV;
	}

	public void setTV(String tV) {
		TV = tV;
	}

	public String getWifi() {
		return Wifi;
	}

	public void setWifi(String wifi) {
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

	/**
	 * @author Iker
	 * @param teklatua gure tiket bat erreserbatu nahi dugunean gauzak eskaneatzeko 
	 */
	@Override
	public void irakurri(Scanner teklatua) {
		this.prezioa = 0;
		// TODO Auto-generated method stub
		System.out.println("**Ongi Etorri gure Tiket Erosketara**");
		System.out.println("**Zein da zure NAN zenbakia?**");
		this.nan = teklatua.next();
		System.out.println("**Zer motatako tiketa nahi duzu? Turista/Business/Lehen**");
		this.tipo_asiento = teklatua.next();
		if (this.tipo_asiento.equalsIgnoreCase("turista")) {
			this.prezioa= this.prezioa + 300;
		}else if (this.tipo_asiento.equalsIgnoreCase("business")) {
			this.prezioa = this.prezioa + 600;
		}else if (this.tipo_asiento.equalsIgnoreCase("lehen")) {
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
		int puntuak = 0;
		puntuak = puntuak + 5;
		System.out.println("Eskerrikasko, tiketaren prezioa " + this.prezioa + " da.");
	}
	/**
	 * 
	 */
	@Override
	public void pantailaratu() {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------------");
		System.out.println("**Tiketaren IDa: " + this.id_tiket + " da.**");
		System.out.println("**Zure tiketa " + this.tipo_asiento + " motatakoa da.**");
		System.out.println("**Zure jesarlekua " + this.jesarlekua + " zenbakia da.**");
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
	/**
	 * 
	 * @param puntuak Bezeroak dituen puntuak
	 * @return Puntuengatik jasotako kalkulu bitartez, dagokion deskontua
	 * @author aitor
	 */
	public static int deskontuaFun(int puntuak) {
		int deskontua=0;
		if (puntuak > 1 && puntuak < 25) {
			deskontua = 10;
		}else if (puntuak > 25 && puntuak < 50) {
			deskontua = 20;
		}else if (puntuak > 50 && puntuak < 80) {
			deskontua = 25;
		}else if (puntuak > 80 && puntuak < 100) {
			deskontua = 30;
		}
		System.out.println("Zure deskontua %" + deskontua + "koda da.");
		return deskontua;
	}
	
	/**
	 * 	
	 * @param tiket Tiket motatako objetua
	 * @param deskontua deskontuaFun-etik jasotako zenbakia
	 * @return Tiketaren prezio finala
	 * @author aitor
	 */
	public static double kalkulatuDesk(Tiketak tiket, int deskontua) {
		double prezioFin = 0;
		if (deskontua == 10) {
			prezioFin = (tiket.getPrezioa() * 0.90);
		}else if (deskontua == 20) {
			prezioFin = ((tiket.getPrezioa() * 0.80));
		}else if (deskontua == 25) {
			prezioFin = ((tiket.getPrezioa() * 0.75));
		}else if (deskontua == 30) {
			prezioFin = ((tiket.getPrezioa() * 0.70));
		}
		return prezioFin;
	}

	@Override
	public double kalkulatuTotala() {
		// TODO Auto-generated method stub
		double prezioFinala;
		prezioFinala = kalkulatuTotala()*BEZ;
		return prezioFinala;
	}
}