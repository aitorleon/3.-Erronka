package Agentzia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class agentziaMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teklatua = new Scanner(System.in);
		ArrayList <Estantzia> aEstantzia = new ArrayList <Estantzia>();
		ArrayList <Bezeroa> aBezeroa = new ArrayList <Bezeroa>();
		ArrayList <Helmuga> aHelmuga = new ArrayList <Helmuga>();
		ArrayList <Jarduera> aJarduera = new ArrayList <Jarduera>();
		ArrayList <Ohikoa> aOhikoa = new ArrayList <Ohikoa>();
		ArrayList <VIP> aVIP = new ArrayList <VIP>();
		ArrayList <Tiketak> aTiketak = new ArrayList <Tiketak>();
		/********************************************************/
		String idLogin,vipOhikoa;
		Boolean encontradoVip=false,encontradoOhikoa = false, erregistroaVip = false, erregistroaOhikoa = false;
		boolean estantziaerr = false, tiketEros = false, jardueraarr = false, borratuErr = false;
		Bezeroa b;
		int i = 0,j = 0, kont=0;
		//////DB BUELTA ESTANTZIA TAULA/////
		int id_Estantzia,Kapazitatea, Balorazioa;
		String NAN, Izena, Mota;
		/////DB BUELTA VIP TAULA/////
		int puntuak;
		double beherapenak;
		/////DB BUELTA OHIKOA TAULA/////
		int gonbidatukop;
		/////DB BUELTA TIKETAK TAULA/////
		int id_Tiket;
		double prezioa;
		String Jesarlekua,Wifi,Jesarleku_Mota,TV;
		/////DB BUELTA HELMUGA TAULA/////
		int id_Helmuga;
		String Izena1;
		/////DB BUELTA BEZEROA TAULA/////
		String Abizena1, Abizena2,Telefonoa,Email;
		Date Jaiotze_Data;
		
		//KONEXIOA DATU BASEAREKIN
		dbKonexioa(aEstantzia, aHelmuga, aJarduera, aOhikoa, aVIP, aTiketak);
		////////////////////////////////////
		try {
			FileInputStream fis = new FileInputStream("jarduerak.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			while(fis.available() > 0){
				Jarduera t = (Jarduera)ois.readObject();
				aJarduera.add(t);
				}
		} catch (FileNotFoundException fnfe) {
			// si el archivo complejos.dat no está creado
			System.out.println("Error, jarduerak.dat fitxeroa ez da aurkitu.");
		} catch (IOException ioe) {
			// si se produce otro error de Entrada / Salida
			System.out.println("Sarrera/Irteera errorea");
		} catch (ClassNotFoundException cnfe) {
			// si se produce un error de Clase No Encontrada
			System.out.println("Error klasea ez da aurkitu");
		}
		int aukera;
		Bezeroa b1= new VIP();
		VIP v2 = new VIP();
		Ohikoa o2 = new Ohikoa();
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				System.out.println("**ONGI ETORRI IKA BIDAI AGENTZIARA**");
				System.out.println("**             LOGIN              **");
				System.out.println("|  Idatzi zure erabiltzaile NANa:  |");
			idLogin = teklatua.next();			
			while (!encontradoVip && i<aVIP.size()) {
				if (aVIP.get(i).getNan().equals(idLogin)) {
					encontradoVip = true;
				}else {
					i++;
				}
			}
			while (!encontradoOhikoa && j<aOhikoa.size()) {
				if (aOhikoa.get(j).getNan().equals(idLogin)) {
					encontradoOhikoa = true;
				}else {
					j++;
				}
			}
			
			if ((encontradoVip == false) && (encontradoOhikoa == false)) {
				System.out.println("Zure NAN-a ez dago gure datu basean, erregistratu mesedez.");
				System.out.println("Bezero VIP ala Ohikoa izan nahi duzu?");
				vipOhikoa = teklatua.next();
				if (vipOhikoa.equalsIgnoreCase("vip")) {
					v2.irakurri(teklatua);
					aVIP.add(v2);
					erregistroaVip = true;
				}else if (vipOhikoa.equalsIgnoreCase("ohikoa")) {
					o2.irakurri(teklatua);
					aOhikoa.add(o2);
					erregistroaOhikoa = true;
				}
			}
			
			if (encontradoVip) {
				int aukeraVip = 0, konktVip = 0;
				do {
					System.out.println("**ONGI ETORRI, " + aVIP.get(i).getIzena() + ", ZER EGIN NAHI DUZU?**");
					System.out.println("|| 1. Egindako erreserbak ikusi.               ||");
					System.out.println("|| 2. Erositako tiketak ikusi.                 ||");
					System.out.println("|| 3. Antolatutako jarduerak ikusi.            ||");
					System.out.println("|| 4. Erreserba bat egin.                      ||");
					System.out.println("|| 5. Tiket bat erosi.                         ||");
					System.out.println("|| 6. Jarduera bat antolatu                    ||");
					System.out.println("|| 7. Erreserba bat kantzelatu                 ||");
					System.out.println("|| 8. Tiket bat kantzelatu                     ||");
					System.out.println("|| 9. Jarduera bat kantzelatu                  ||");
					System.out.println("|| 10. Zure puntuak ikusi.                     ||");
					System.out.println("|| 11. Zure beherapenak ikusi.                 ||");
					System.out.println("|| 12. Irten                                   ||");
					aukeraVip = teklatua.nextInt();
					switch (aukeraVip) {
					case 1:
						kont = 0;
						boolean encontradoErr = false;
						kont = 0;
						while (!encontradoErr && kont<aEstantzia.size()-1) {
							if (aEstantzia.get(kont).getNAN().equals(idLogin)) {
								encontradoErr = true;
							}else {
								kont++;
							}
						}
						if (encontradoErr) {
							for (Estantzia e : aEstantzia) {
								if (idLogin.equals(e.getNAN())) {
									e.estantziaPantailaratu();
								}
							}
						}else {
							System.out.println("ERROR, ez dituzu erreserebarik.");
							System.out.println("Estantzia bat erreserbatu nahi baldin baduzu 4. aukeran klik egin.");
						}
						break;
					case 2:
						erakutsiTiketak(aTiketak, idLogin);
						break;
					case 3:
						erakutsiJarduera(aJarduera, idLogin, i);
						break;
					case 4:
						boolean estantziaAur = false;
						int idEs;
						System.out.println("Huek dira ikusgai dauden estantziak.");
						for (Estantzia t : aEstantzia) {
							if (t.getNAN()==null) {
								t.estantziaPantailaratu();
								estantziaAur = true;
							}
						}
						if (estantziaAur == false) {
							System.out.println("-----------------------------------------------------------");
							System.out.println("Sentitzen dugu baina estantzia guztiak erreserbatuta daude.");
							System.out.println("-----------------------------------------------------------");
						}else {
							System.out.println("Idatzi zein estantzia erreserbatu nahi duzun estantziaren IDa.");
							idEs = teklatua.nextInt();
							for (Estantzia r : aEstantzia) {
								if (r.getId_Estantzia()==idEs) {
									r.setNAN(idLogin);
									System.out.println("Estantzia erreserbatu da.");
									estantziaerr = true;
								}
							}
						}
						break;
					case 5:
						tiketEros = tiketErosketa(teklatua, aTiketak);
						break;
					case 6:
						jardueraarr = false;
						int idHelmu;
						kont = 0;
						System.out.println("Hauek dira eskuragarri dauden jarduerak");
						for (int w = 0; w < aJarduera.size(); w++) {
							if (aJarduera.get(w).getEskuragarri().equalsIgnoreCase("bai")) {
								aJarduera.get(w).pantailaratuJarduera();
							}
						}
						System.out.println("Idatzi erreserbatu nahi duzun jardueraren ID-a");
						idHelmu = teklatua.nextInt();
						
						while (!jardueraarr && kont < aJarduera.size()) {
							if (aJarduera.get(kont).getId_Jarduera()==idHelmu) {
								aJarduera.get(kont).setEskuragarri("ez");
								System.out.println("Zure jarduera erreserbatu da");
								jardueraarr = true;
							}else {
								kont++;
							}
						}
						break;
					case 7:
						boolean encontradoBorr = false;
						int idEs1;
						kont = 0;
						System.out.println("Hauek dira zure erreserbak");
						for (Estantzia t : aEstantzia) {
							if (t.getNAN()!=null &&t.getNAN().equalsIgnoreCase(idLogin)) {
								t.estantziaPantailaratu();
								borratuErr = true;
							}
						}
						if (!borratuErr) {
							System.out.println("Ez dituzu erreserbarik, horretarako 4. aukeran klik egin");
						}else {
							System.out.println("Idatzi borratu nahi duzun estantziaren ID-a");
							idEs1 = teklatua.nextInt();
							while (!encontradoBorr && kont < aEstantzia.size()) {
								if (aEstantzia.get(kont).getId_Estantzia()==idEs1) {
									aEstantzia.get(kont).setNAN(" ");
									encontradoBorr = true;
									System.out.println("Zure estantzia borratu da.");
								}else {
									kont++;
								}
							}
						}
						break;
					case 8:
						boolean tiketAurr = false, encontradoTik = false;
						kont = 0;
						int idTik;
						System.out.println("Hauek dira zure tiketak.");
						for (Tiketak t2 : aTiketak) {
							if (t2.getNan().equals(idLogin)) {
								t2.pantailaratu();
								tiketAurr = true;
							}
						}
						if (!tiketAurr) {
							System.out.println("Ez dituzu tiketik erosi, horretarako 5. aukeran klik egin");
						}else {
							System.out.println("Idatzi borratu nahi duzun tiketaren IDa");
							idTik = teklatua.nextInt();
							while (!encontradoTik && kont < aTiketak.size()) {
								if (aTiketak.get(kont).getId_tiket()==idTik) {
									aTiketak.remove(kont);
									encontradoTik = true;
									System.out.println("Zure tiketa borratu da.");
								}else {
									kont++;
								}
							}
						}
						break;
					case 9:
						boolean encontradoJarr = false, borratuJar = false;
						int idHelm, idJar;
						kont =0;
						System.out.println("Idatzi zure helmugaren ID-a");
						idHelm = teklatua.nextInt();
						for (Jarduera t : aJarduera) {
							if (t.getId_Helmuga()==idHelm) {
								t.pantailaratuJarduera();
								encontradoJarr = true;
							}
						}
						if (!encontradoJarr) {
							System.out.println("Ez da aurkitu zure jarduera");
						}else {
							System.out.println("Idatzi zein jarduera ezabatu nahi duzu");
							idJar = teklatua.nextInt();
							while (!borratuJar && kont < aJarduera.size()) {
								if (aJarduera.get(kont).getId_Jarduera()==idJar) {
									aJarduera.get(kont).setEskuragarri("bai");
									borratuJar = true;
									System.out.println("Zure jarduera kantzelatu da.");
								}else {
									kont++;
								}
							}
						}
						break;
					case 10:
						System.out.println("Zure puntuak: " + aVIP.get(i).getPuntuak());
						break;
					case 11:
						boolean encontradoTiket = false;
						int deskontua = 0, puntuak1;
						kont = 0;
						int id;
						puntuak1 = aVIP.get(i).getPuntuak();
						Tiketak t54 = new Tiketak();
						System.out.println("Kontuan izanda " + aVIP.get(i).getPuntuak() + " puntu dituzula...");
						deskontua = t54.deskontuaFun(puntuak1);
						System.out.println("-----------------------------------------------------------------");
						System.out.println("Idatzi deskontua aplikatu nahi duzun tiketeko IDa");
						id = teklatua.nextInt();
						while (!encontradoTiket && kont<aTiketak.size()) {
							if (aTiketak.get(kont).getId_tiket() == (id)) {
								encontradoTiket = true;
							}else {
								kont++;
							}
						}
						if (encontradoTiket) {
							Tiketak tiket = aTiketak.get(kont);
							System.out.println("Prezio finala: " + t54.kalkulatuDesk(tiket, deskontua));
						}else {
							System.out.println("Ez dira tiketarik aurkitu. Saiatu berriro edo bat erosi");
						}
						break;
					case 12:
						System.out.println("Plazer bat izan da " + aVIP.get(konktVip).getIzena() + ", gero arte.");
						break;
					}
				}while(aukeraVip!=12);
			}else if (encontradoOhikoa) {
				int aukeraOhikoa = 0;
				do {
					System.out.println("** ONGI ETORRI, " + aOhikoa.get(j).getIzena() + ", ZER EGIN NAHI DUZU?**");
					System.out.println("|| 1. Egindako erreserbak ikusi.   			  ||");
					System.out.println("|| 2. Erositako tiketak ikusi.     			  ||");
					System.out.println("|| 3. Antolatutako jarduerak ikusi.			  ||");
					System.out.println("|| 4. Erreserba bat egin.          			  ||");
					System.out.println("|| 5. Tiket bat erosi.             			  ||");
					System.out.println("|| 6. Jarduera bat antolatu.                			  ||");
					System.out.println("|| 7. Erreserba bat kantzelatu.                           ||");
					System.out.println("|| 8. Tiket bat kantzelatu.                               ||");
					System.out.println("|| 9. Jarduera bat desegin.                               ||");
					System.out.println("|| 10. Irten.                                             ||");
					aukeraOhikoa = teklatua.nextInt();
					switch (aukeraOhikoa) {
					case 1:
						kont = 0;
						boolean encontradoErr = false;
						kont = 0;
						while (!encontradoErr && kont<aEstantzia.size()-1) {
							if (aEstantzia.get(kont).getNAN().equals(idLogin)) {
								encontradoErr = true;
							}else {
								kont++;
							}
						}
						if (encontradoErr) {
							for (Estantzia e : aEstantzia) {
								if (idLogin.equals(e.getNAN())) {
									e.estantziaPantailaratu();
								}
							}
						}else {
							System.out.println("ERROR, ez dituzu erreserebarik.");
							System.out.println("Estantzia bat erreserbatu nahi baldin baduzu 4. aukeran klik egin.");
						}
						break;
					case 2:
						erakutsiTiketak(aTiketak, idLogin);
						break;
					case 3:
						boolean encontradoJar = false;
						kont  =0;
						while (!encontradoJar && kont<aJarduera.size()) {
							if (aJarduera.get(kont).getNan().equals(idLogin)) {
								encontradoJar = true;
							}else {
								kont++;
							}
						}
						if (encontradoJar) {
							for (Jarduera j1 : aJarduera) {
								if (j1.getNan().equals(idLogin)) {
									j1.pantailaratuJarduera();
								}
							}
						}else {
							System.out.println("ERROR, ez duzu jarduerarik antolatu.");
							System.out.println("Tiketa erosi nahi baduzu, 5. aukeran klik egin.");
						}
						System.out.println("_____________________________________________________________");
						break;
					case 4:
						boolean estantziaAur = false;
						boolean estantziaErres = false;
						int idEs;
						System.out.println("Huek dira ikusgai dauden estantziak.");
						for (Estantzia t : aEstantzia) {
							if (t.getNAN()==null) {
								t.estantziaPantailaratu();
								estantziaAur = true;
							}
						}
						if (!estantziaAur) {
							System.out.println("-----------------------------------------------------------");
							System.out.println("Sentitzen dugu baina estantzia guztiak erreserbatuta daude.");
							System.out.println("-----------------------------------------------------------");
						}else {
							System.out.println("Idatzi zein estantzia erreserbatu nahi duzun.");
							idEs = teklatua.nextInt();
							for (Estantzia r : aEstantzia) {
								if (r.getId_Estantzia()==idEs) {
									r.setNAN(idLogin);
									System.out.println("Estantzia erreserbatu da.");
									estantziaErres = true;
								}
							}
						}
						break;
					case 5:
						tiketEros = tiketErosketa(teklatua, aTiketak);
						System.out.println("Zure tiketaren erosketa egin da.");
						break;
					case 6:
						jardueraarr = false;
						int idHelmu;
						kont = 0;
						System.out.println("Hauek dira eskuragarri dauden jarduerak");
						for (int w = 0; w < aJarduera.size(); w++) {
							if (aJarduera.get(w).getEskuragarri().equalsIgnoreCase("bai")) {
								aJarduera.get(w).pantailaratuJarduera();
							}
						}
						System.out.println("Idatzi erreserbatu nahi duzun jardueraren ID-a");
						idHelmu = teklatua.nextInt();
						
						while (!jardueraarr && kont < aJarduera.size()) {
							if (aJarduera.get(kont).getId_Jarduera()==idHelmu) {
								aJarduera.get(kont).setEskuragarri("ez");
								System.out.println("Zure jarduera erreserbatu da");
								jardueraarr = true;
							}else {
								kont++;
							}
						}
						break;
					case 7:
						borratuErr = false;
						boolean encontradoBorr = false;
						int idEs1;
						kont = 0;
						System.out.println("Hauek dira zure erreserbak");
						for (Estantzia t : aEstantzia) {
							if (t.getNAN()!=null &&t.getNAN().equalsIgnoreCase(idLogin)) {
								t.estantziaPantailaratu();
								borratuErr = true;
							}
						}
						if (!borratuErr) {
							System.out.println("Ez dituzu erreserbarik, horretarako 4. aukeran klik egin");
						}else {
							System.out.println("Idatzi borratu nahi duzun estantziaren ID-a");
							idEs1 = teklatua.nextInt();
							while (!encontradoBorr && kont < aEstantzia.size()) {
								if (aEstantzia.get(kont).getId_Estantzia()==idEs1) {
									aEstantzia.get(kont).setNAN(" ");
									encontradoBorr = true;
									System.out.println("Zure estantzia borratu da.");
								}else {
									kont++;
								}
							}
						}
						break;
					case 8:
						boolean tiketAurr = false, encontradoTik = false;
						kont = 0;
						int idTik;
						System.out.println("Hauek dira zure tiketak.");
						for (Tiketak t2 : aTiketak) {
							if (t2.getNan().equals(idLogin)) {
								t2.pantailaratu();
								tiketAurr = true;
							}
						}
						if (!tiketAurr) {
							System.out.println("Ez dituzu tiketik erosi, horretarako 5. aukeran klik egin");
						
						}else {
							System.out.println("Idatzi borratu nahi duzun tiketaren IDa");
							idTik = teklatua.nextInt();
							while (!encontradoTik && kont < aTiketak.size()) {
								if (aTiketak.get(kont).getId_tiket()==idTik) {
									aTiketak.remove(kont);
									encontradoTik = true;
									System.out.println("Zure tiketa borratu da.");
								}else {
									kont++;
								}
							}
						}
						break;
					case 9:
						boolean encontradoJarr = false, borratuJar = false;
						int idHelm, idJar;
						kont =0;
						System.out.println("Idatzi zure helmugaren ID-a");
						idHelm = teklatua.nextInt();
						for (Jarduera t : aJarduera) {
							if (t.getId_Helmuga()==idHelm) {
								t.pantailaratuJarduera();
								encontradoJarr = true;
							}
						}
						if (!encontradoJarr) {
							System.out.println("Ez da aurkitu zure jarduera");
						}else {
							System.out.println("Idatzi zein jarduera ezabatu nahi duzu");
							idJar = teklatua.nextInt();
							while (!borratuJar && kont < aJarduera.size()) {
								if (aJarduera.get(kont).getId_Jarduera()==idJar) {
									aJarduera.get(kont).setEskuragarri("bai");
									borratuJar = true;
									System.out.println("Zure jarduera kantzelatu da.");
								}else {
									kont++;
								}
							}
						}
						break;
					case 10:
						System.out.println("Plazer bat izan da " + aOhikoa.get(j).getIzena() + ", agur.");
						break;
					}
				}while(aukeraOhikoa!=10);
			}
			
			////////DB BUELTA//////////////////
			if (estantziaerr || borratuErr) {
				try {
					String consultaReserba="";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
					Statement st = conexion.createStatement();
					consultaReserba = "DELETE FROM estantzia";
					st.execute(consultaReserba);
					for (int i1=0;i1<aEstantzia.size();i1++) {
						Estantzia e1 = aEstantzia.get(i1);
						id_Estantzia = e1.getId_Estantzia();
						NAN = e1.getNAN();
						Izena = e1.getIzena();
						Kapazitatea = e1.getKapazitatea();
						Mota = e1.getMota();
						Balorazioa = e1.getBalorazioa();
						consultaReserba = "INSERT INTO estantzia VALUES ('"+id_Estantzia+"','"+NAN+"','"+Izena+"','"+Kapazitatea+"','"+Mota+"','"+Balorazioa+"');";
						st.execute(consultaReserba);
						}
				}
				catch (SQLException e){
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de ERRESERBA/ESTANTZIA");
				}
			}
			else if (tiketEros)  {
				try {
					String consultaTiketa="";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
					Statement st = conexion.createStatement();
					consultaTiketa = "DELETE FROM tiketa";
					st.execute(consultaTiketa);
					for (int i4 = 0; i4<aTiketak.size(); i4++) {
						Tiketak t1 = aTiketak.get(i4);
						id_Tiket = t1.getId_tiket();
						NAN = t1.getNan();
						prezioa = t1.getPrezioa();
						Jesarlekua = t1.getJesarlekua();
						Wifi = t1.getWifi();
						Jesarleku_Mota = t1.getJesarlekua();
						TV = t1.getTV();
						consultaTiketa = "INSERT INTO tiketa VALUES ('"+id_Tiket+"','"+NAN+"','"+prezioa+"','"+Jesarlekua+"','"+Wifi+"','"+Jesarleku_Mota+"','"+TV+"');";
						st.executeUpdate(consultaTiketa);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();	
					System.out.println("ERROR TIKET");
				}
				
			}
			else if (jardueraarr) {
				try {
					FileOutputStream fos = new FileOutputStream("jarduerak.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					
					for (Jarduera y : aJarduera) {
						oos.writeObject(y);
					}
				} catch (FileNotFoundException fnfe) {
					// si el archivo complejos.dat no está creado
					System.out.println("Error jarduerak.dat fitxeroa ez da aurkitu.");
				} catch (IOException ioe) {
					// si se produce otro error de Entrada / Salida
					System.out.println("Sarrera/Irteera errorea");
				}
			}
			try {
				String consultaVip="";
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				Statement st = conexion.createStatement();
				consultaVip = "DELETE FROM vip";
				st.execute(consultaVip);
				for (int i2 = 0; i2<aVIP.size(); i2++) {
					VIP v1 = aVIP.get(i2);
					NAN = v1.getNan();
					puntuak = v1.getPuntuak();
					beherapenak = v1.getBeherapenak();
					st.executeUpdate("INSERT INTO vip VALUES ('"+NAN+"','"+puntuak+"','"+beherapenak+"');");
				}
				String consultaOhikoa="";
				conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
				st = conexion.createStatement();
				consultaOhikoa = "DELETE FROM ohikoa";
				st.execute(consultaOhikoa);
				for (int i3 = 0; i3<aOhikoa.size(); i3++) {
					Ohikoa o1 = aOhikoa.get(i3);
					NAN = o1.getNan();
					gonbidatukop = o1.getGonbidatukop();
					st.executeUpdate("INSERT INTO ohikoa VALUES ('"+NAN+"','"+gonbidatukop+"');");
				}
				
				
			}
			catch (SQLException e ) {
				e.printStackTrace();
				System.out.println("ERROR VIP/OHIKOA");
			}
			if (erregistroaVip || erregistroaOhikoa) {
				try {
					String consultaBezeroa="";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
					Statement st = conexion.createStatement();
					consultaBezeroa = "DELETE FROM bezeroa";
					st.execute(consultaBezeroa);
					for (int i6 = 0; i6<aVIP.size(); i6++) {
						Bezeroa b2 = aBezeroa.get(i6);
						NAN = b2.getNan();
						Izena = b2.getIzena();
						Abizena1 = b2.getAbizena1();
						Abizena2 = b2.getAbizena2();
						Jaiotze_Data = b2.getJaiotze_data();
						Telefonoa = b2.getTelefono();
						Email = b2.getEmail();
						Mota = b2.getMota();
						st.executeUpdate("INSERT INTO bezeroa VALUES ('"+NAN+"','"+Izena+"','"+Abizena1+"','"+Abizena2+"','"+Jaiotze_Data+"','"+Telefonoa+"','"+Email+"','"+Mota+"');");
					}
				}catch (SQLException e ) {
					e.printStackTrace();
					System.out.println("ERROR ERREGISTROA");
				}}
	}

	private static boolean tiketErosketa(Scanner teklatua, ArrayList<Tiketak> aTiketak) {
		boolean tiketEros;
		tiketEros = false;
		Tiketak t1 = new Tiketak();
		System.out.println("** TIKET BAT EROSI **");
		System.out.println("______________________");
		t1.irakurri(teklatua);
		t1.setId_tiket(aTiketak.get(aTiketak.size() - 1).getId_tiket() + 1);
		aTiketak.add(t1);
		tiketEros = true;
		return tiketEros;
	}

	private static void erakutsiJarduera(ArrayList<Jarduera> aJarduera, String idLogin, int i) {
		int kont;
		boolean encontradoJar = false;
		kont = 0;
		while (!encontradoJar && kont<aJarduera.size()) {
			if ((aJarduera.get(kont).getNan().equals(aJarduera.get(i).getNan()))) {
				encontradoJar = true;
			}else {
				kont++;
			}
		}
		if (encontradoJar) {
			for (Jarduera j1 : aJarduera) {
				if (idLogin.equals(j1.getNan())) {
					j1.pantailaratuJarduera();
				}
			}
		}else {
			System.out.println("ERROR, ez duzu jarduerarik antolatu.");
			System.out.println("Tiketa erosi nahi baduzu, 6. aukeran klik egin.");
		}
	}

	private static void erakutsiTiketak(ArrayList<Tiketak> aTiketak, String idLogin) {
		int kont;
		boolean encontradoTi = false;
		kont  =0;
		while (!encontradoTi && kont<aTiketak.size()-1) {
			if (aTiketak.get(kont).getNan().equals(idLogin)) {
				encontradoTi = true;
			}else {
				kont++;
			}
		}
		if (encontradoTi) {
			for (Tiketak t : aTiketak) {
				if (idLogin.equals(t.getNan())) {
					t.pantailaratu();
				}
			}
		}else {
			System.out.println("ERROR, ez dituzu tiketarik erosi.");
			System.out.println("Estantzia bat erreserbatu nahi baldin baduzu 5. aukeran klik egin.");
		}
	}
	
	private static void dbKonexioa(ArrayList<Estantzia> aEstantzia, ArrayList<Helmuga> aHelmuga,
			ArrayList<Jarduera> aJarduera, ArrayList<Ohikoa> aOhikoa, ArrayList<VIP> aVIP,
			ArrayList<Tiketak> aTiketak) {
		try{
			 Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
			// si se ha conectado correctamente
			Statement st = conexion.createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT * FROM bidaiagentzia.estantzia;");
			
			
			
			while (rs.next()){
				Estantzia e1 = new Estantzia(rs.getInt("id_Estantzia"),rs.getString("NAN"),rs.getString("Izena"),rs.getInt("Kapazitatea"),rs.getString("Mota"),rs.getInt("Balorazioa"));
				aEstantzia.add(e1);
				}
			rs = st.executeQuery("Select * FROM bidaiagentzia.helmuga;");
			while (rs.next()){
				Helmuga h1 = new Helmuga(rs.getInt("id_Helmuga"),rs.getInt("id_Estantzia"),rs.getString("Izena"));
				aHelmuga.add(h1);
				}
			rs = st.executeQuery("SELECT b.NAN, j.* from bezeroa b, estantzia e, helmuga h, jarduera j where b.NAN = e.NAN and e.id_Estantzia = h.id_Estantzia and h.id_Helmuga = j.id_Helmuga;");
			while (rs.next()){
				Jarduera j1 = new Jarduera(rs.getString("NAN"),rs.getInt("id_Jarduera"),rs.getInt("id_Helmuga"),rs.getString("Izena"),rs.getString("Mota"),rs.getInt("Balorazioa"), rs.getString("Eskuragarri"));
				aJarduera.add(j1);
				}
			rs = st.executeQuery("SELECT o.GonbidatuKop, b.* from ohikoa o, bezeroa b where o.NAN = b.NAN;");
			while (rs.next()){
				Ohikoa o1 = new Ohikoa(rs.getInt("GonbidatuKop"),rs.getString("NAN"),rs.getString("Izena"), rs.getString("Abizena1"), rs.getString("Abizena2"), rs.getDate("Jaiotze_Data"), rs.getString("Telefonoa"), rs.getString("Email"), rs.getString("Mota"));
				aOhikoa.add(o1);
				}
			rs = st.executeQuery("Select * FROM bidaiagentzia.tiketa;");
			while (rs.next()){
				Tiketak t1 = new Tiketak(rs.getInt("id_Tiket"),rs.getString("NAN"),rs.getInt("Prezioa"),rs.getString("Jesarlekua"),rs.getString("Wifi"),rs.getString("Jesarleku_Mota"),rs.getString("TV"));
				aTiketak.add(t1);
				}
			rs = st.executeQuery("SELECT v.Puntuak, v.Beherapenak, b.* from vip v, bezeroa b where v.NAN = b.NAN;");
			while (rs.next()){
				VIP v1 = new VIP(rs.getInt("Puntuak"),rs.getInt("Beherapenak"),rs.getString("NAN"),rs.getString("Izena"),rs.getString("Abizena1"),rs.getString("Abizena2"),rs.getDate("Jaiotze_Data"),rs.getString("Telefonoa"),rs.getString("Email"),rs.getString("mota"));
				aVIP.add(v1);
				}
			rs.close();
			st.close();
		}
		catch (SQLException eq) {
			eq.printStackTrace();
		}
	}
}