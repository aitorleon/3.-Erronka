package Agentzia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class jardueraSerializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * @author aitor
		 * Gure .dat fitxeroa sortzeko beharrzekoa den klasea. Bertan gure jarduera gorde egingo dira
		 */
		Jarduera t = new Jarduera("11111111A",1,1, "Sagrada Familiaren Bisita Gidatua", "Kultura",4,"Bai");
		Jarduera t1 = new Jarduera ("22222222B",2,2, "Sopelanako Parapenteak", "Arrisku Kirola", 3, "Bai");
		Jarduera t2 = new Jarduera ("33333333C", 3,3, "Flamenku ikuskisuna Sevillan", "Sarrera Tiketa", 5, "Ez");
		Jarduera t3 = new Jarduera ("33333333C", 4,4, "Sachsenhausen Konzentrazio Zentruko bisita gidatua", "Kultura", 4, "Bai");
		Jarduera t4 = new Jarduera ("44444444D", 5,5, "Sennatik Kruzero Ibilbidea", "Jarduera Akuatikoa", 4, "Ez");
		Jarduera t5 = new Jarduera ("33333333C",6,6, "Tango ikuskisuna Kasku Zaharrean", "Sarrera Tiketa", 5, "Ez");
		{
			try {
				FileOutputStream fos = new FileOutputStream("jarduerak.dat");
				ObjectOutputStream oos = new ObjectOutputStream (fos);	

				// lo grabo
				oos.writeObject(t);
				oos.writeObject(t1);
				oos.writeObject(t2);
				oos.writeObject(t3);
				oos.writeObject(t4);
				oos.writeObject(t5);

				// cierro los recursos abiertos
				oos.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
