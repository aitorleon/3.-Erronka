package Agentzia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


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
		Boolean encontradoVip=false,encontradoOhikoa = false;
		boolean estantziaerr = false;
		Bezeroa b;
		int i = 0,j = 0, kont=0;
		//////DB BUELTA ESTANTZIA TAULA/////
		int id_Estantzia,Kapazitatea, Balorazioa;
		String NAN, Izena, Mota;
		
		//KONEXIOA DATU BASEAREKIN
		try{
			 Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
			// si se ha conectado correctamente
			System.out.println("ondo");
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
				Ohikoa o1 = new Ohikoa(rs.getInt("GonbidatuKop"),rs.getString("NAN"), rs.getString("Abizena1"), rs.getString("Abizena2"), rs.getDate("Jaiotze_Data"), rs.getString("Telefonoa"), rs.getString("Email"), rs.getString("Mota"));
				aOhikoa.add(o1);
				}
			rs = st.executeQuery("Select * FROM bidaiagentzia.tiketa;");
			while (rs.next()){
				Tiketak t1 = new Tiketak(rs.getInt("id_Tiket"),rs.getString("NAN"),rs.getDouble("Prezioa"),rs.getString("Jesarlekua"),rs.getString("Wifi"),rs.getString("Jesarleku_Mota"),rs.getString("TV"));
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
			System.out.println("Error, txakurrak.dat fitxeroa ez da aurkitu.");
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
				if (aVIP.get(i).getNan().equalsIgnoreCase(idLogin)) {
					encontradoVip = true;
				}else {
					i++;
				}
			}
			while (!encontradoOhikoa && j<aOhikoa.size()) {
				if (aOhikoa.get(j).getNan().equalsIgnoreCase(idLogin)) {
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
					encontradoVip = true;
				}else if (vipOhikoa.equalsIgnoreCase("ohikoa")) {
					o2.irakurri(teklatua);
					aOhikoa.add(o2);
					encontradoOhikoa = true;
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
						boolean encontradoErr = false;
						int y =0;
						while (!encontradoErr && y<aEstantzia.size()) {
							if ((aEstantzia.get(y).equals(aEstantzia.get(i).getNAN()))) {
								encontradoErr = true;
							}else {
								y++;
							}
						}
						if (encontradoErr) {
							for (Estantzia e : aEstantzia) {
								if (e.getNAN().equals(idLogin)) {
									e.estantziaPantailaratu();
								}
							}
						}else {
							System.out.println("ERROR, ez dituzu erreserbarik.");
							System.out.println("Erreserba bat egin nahi baduzu, 4 aukeran klik egin.");
						}
						break;
					case 2:
						boolean encontradoTi = false;
						kont  =0;
						while (!encontradoTi && kont<aTiketak.size()) {
							if ((aTiketak.get(kont).equals(aTiketak.get(j).getNan()))) {
								encontradoTi = true;
							}else {
								kont++;
							}
						}
						if (encontradoTi) {
							for (Tiketak t : aTiketak) {
								if (t.getNan().equals(idLogin)) {
									t.pantailaratu();
								}
							}
						}else {
							System.out.println("ERROR, ez duzu tiketarik erosi.");
							System.out.println("Tiketa erosi nahi baduzu, 5. aukeran klik egin.");
						}
						break;
					case 3:
						boolean encontradoJar = false;
						kont  =0;
						while (!encontradoJar && kont<aJarduera.size()) {
							if ((aJarduera.get(kont).equals(aJarduera.get(i).getNan()))) {
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
							System.out.println("ERROR, ez duzu tiketarik erosi.");
							System.out.println("Tiketa erosi nahi baduzu, 5. aukeran klik egin.");
						}
						break;
					case 4:
						boolean estantziaAur = false;
						estantziaerr = false;
						int idEs;
						System.out.println("Huek dira ikusgai dauden estantziak.");
						for (Estantzia t : aEstantzia) {
							if (t.getNAN()==null) {
								t.estantziaPantailaratu();
								estantziaAur = true;
							}
						}
						if (!estantziaAur) {
							System.out.println("___________________________________________________________");
							System.out.println("Sentitzen dugu baina estantzia guztiak erreserbatuta daude.");
							System.out.println("___________________________________________________________");
						}else {
							System.out.println("Idatzi zein estantzia erreserbatu nahi duzun.");
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
						boolean tiketEros = false;
						Tiketak t1 = new Tiketak();
						System.out.println("** TIKET BAT EROSI **");
						System.out.println("______________________");
						t1.irakurri(teklatua);
						t1.setId_tiket(aTiketak.get(aTiketak.size() - 1).getId_tiket() + 1);
						aTiketak.add(t1);
						tiketEros = true;
						System.out.println("Zure tiketaren erosketa egin da.");
						break;
					case 6:
						boolean jardueraarr = false;
						int idHelmu;
						kont = 0;
						System.out.println("Hauek dira eskuragarri dauden jarduerak");
						for (int w = 0; w < aJarduera.size(); w++) {
							if (aJarduera.get(w).getEskuragarri().equalsIgnoreCase("bai")) {
								aJarduera.get(w).pantailaratuJarduera();
								jardueraarr = true;
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
						boolean borratuErr = false,encontradoBorr = false;
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
									aEstantzia.get(kont).setNAN(null);
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
						int deskontua = 0;
						System.out.println("Kontuan izanda " + aVIP.get(i).getPuntuak() + " dituzula...");
						if (aVIP.get(i).getPuntuak() > 1 && aVIP.get(i).getPuntuak() < 25) {
							deskontua = 10;
							System.out.println("Zure deskontua %" + deskontua + "koa da.");
							System.out.println("Prezio finala: ");
						}else if (aVIP.get(i).getPuntuak() > 25 && aVIP.get(i).getPuntuak() < 50) {
							deskontua = 20;
							System.out.println("Zure deskonktua %" + deskontua + "koa da.");
							System.out.println("Prezio finala: ");
						}else if (aVIP.get(i).getPuntuak() > 50 && aVIP.get(i).getPuntuak() < 80) {
							deskontua = 25;
							System.out.println("Zure deskonktua %" + deskontua + "koa da.");
							System.out.println("Prezio finala: ");
						}else if (aVIP.get(i).getPuntuak() > 80 && aVIP.get(i).getPuntuak() < 100) {
							System.out.println("Zure deskontua %" + deskontua + "koda da.");
							System.out.println("Prezio finala: ");
						}
						break;
					case 12:
						System.out.println("Plazer bat izan da" + aVIP.get(konktVip).getIzena() + ", gero arte.");
						break;
					}
				}while(aukeraVip > 0 || aukeraVip < 13);
			}else if (encontradoOhikoa) {
				int aukeraOhikoa = 0;
				do {
					System.out.println("** ONGI ETORRI, " + aOhikoa.get(j).getIzena() + ", ZER EGIN NAHI DUZU?**");
					System.out.println("|| 1. Egindako erreserbak ikusi.   			  ||");
					System.out.println("|| 2. Erositako tiketak ikusi.     			  ||");
					System.out.println("|| 3. Antolatutako jarduerak ikusi.			  ||");
					System.out.println("|| 4. Erreserba bat egin.          			  ||");
					System.out.println("|| 5. Tiket bat erosi.             			  ||");
					System.out.println("|| 6. Jarduera bat antolatu.       			  ||");
					System.out.println("|| 7. Irten.                                              ||");
					aukeraOhikoa = teklatua.nextInt();
					switch (aukeraOhikoa) {
					case 1:
						boolean encontradoErr = false;
						kont =0;
						while (!encontradoErr && kont<aEstantzia.size()) {
							if ((aEstantzia.get(kont).equals(aEstantzia.get(j).getNAN()))) {
								encontradoErr = true;
							}else {
								kont++;
							}
						}
						if (encontradoErr) {
							for (Estantzia e : aEstantzia) {
								if (e.getNAN().equals(idLogin)) {
									e.estantziaPantailaratu();
								}
							}
						}else {
							System.out.println("ERROR, ez dituzu erreserebarik.");
						}
						break;
					case 2:
						boolean encontradoTi = false;
						kont  =0;
						while (!encontradoTi && kont<aTiketak.size()) {
							if ((aTiketak.get(kont).equals(aTiketak.get(j).getNan()))) {
								encontradoTi = true;
							}else {
								kont++;
							}
						}
						if (encontradoTi) {
							for (Tiketak t : aTiketak) {
								if (t.getNan().equals(idLogin)) {
									t.pantailaratu();
								}
							}
						}else {
							System.out.println("ERROR, ez duzu tiketarik erosi.");
							System.out.println("Tiketa erosi nahi baduzu, 5. aukeran klik egin.");
						}
						break;
					case 3:
						boolean encontradoJar = false;
						kont  =0;
						while (!encontradoJar && kont<aJarduera.size()) {
							if ((aJarduera.get(kont).equals(aJarduera.get(j).getNan()))) {
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
							System.out.println("ERROR, ez duzu tiketarik erosi.");
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
							System.out.println("___________________________________________________________");
							System.out.println("Sentitzen dugu baina estantzia guztiak erreserbatuta daude.");
							System.out.println("___________________________________________________________");
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
						boolean tiketEros = false;
						Tiketak t1 = new Tiketak();
						System.out.println("** TIKET BAT EROSI **");
						System.out.println("______________________");
						t1.irakurri(teklatua);
						t1.setId_tiket(aTiketak.get(aTiketak.size() - 1).getId_tiket() + 1);
						aTiketak.add(t1);
						tiketEros = true;
						System.out.println("Zure tiketaren erosketa egin da.");
						break;
					case 6:
						boolean jardueraarr = false;
						int idHelmu;
						kont = 0;
						System.out.println("Hauek dira eskuragarri dauden jarduerak");
						for (int w = 0; w < aJarduera.size(); w++) {
							if (aJarduera.get(w).getEskuragarri().equalsIgnoreCase("bai")) {
								aJarduera.get(w).pantailaratuJarduera();
								jardueraarr = true;
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
						System.out.println("Plazer bat izan da " + aOhikoa.get(j).getIzena() + ", agur.");
						break;
					}
				}while(aukeraOhikoa > 0 || aukeraOhikoa < 10);
			}
			
			////////DB BUELTA//////////////////
			if (estantziaerr) {
				try {
					String consultaReserba="";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
					Statement st = conexion.createStatement();
					consultaReserba = "DELETE FROM estantzia";
					st.execute(consultaReserba);
					for (int i1=0;i<aEstantzia.size();i1++) {
						Estantzia e1 = aEstantzia.get(i1);
						id_Estantzia = e1.getId_Estantzia();
						NAN = e1.getNAN();
						Izena = e1.getIzena();
						Kapazitatea = e1.getKapazitatea();
						Mota = e1.getMota();
						Balorazioa = e1.getBalorazioa();
						st.executeUpdate("INSERT INTO estantzia VALUES ('"+id_Estantzia+"','"+NAN+"','"+Izena+"','"+Kapazitatea+"','"+Mota+"','"+Balorazioa+"');");
					}
					/*String consultaVip="";
					Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bidaiagentzia", "root", "");
					Statement st = conexion.createStatement();
					consultaReserba = "DELETE FROM vip";
					st.execute(consultaReserba);
					for (VIP e : aVIP) {
						Estantzia e1 = aEstantzia.get(i1);
						id_Estantzia = e1.getId_Estantzia();
						NAN = e1.getNAN();
						Izena = e1.getIzena();
						Kapazitatea = e1.getKapazitatea();
						Mota = e1.getMota();
						Balorazioa = e1.getBalorazioa();
						st.executeUpdate("INSERT INTO estantzia VALUES ('"+id_Estantzia+"','"+NAN+"','"+Izena+"','"+Kapazitatea+"','"+Mota+"','"+Balorazioa+"');");
					}*/
					/*ResultSet rs1 = st.executeQuery("SELECT * FROM bdalumnos.alumnos;");*/
					// cierro la conexion
					st.close();
					conexion.close();
				}
				catch (SQLException e){
				// si NO se ha conectado correctamente
				e.printStackTrace();
				System.out.println("Error de Conexión");
				}
			}
	}
}
