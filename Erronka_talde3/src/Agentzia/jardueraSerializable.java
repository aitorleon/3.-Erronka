package Agentzia;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class jardueraSerializable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jarduera t = new Jarduera();
		{
			try {
				FileOutputStream fos = new FileOutputStream("jarduerak.dat");
				ObjectOutputStream oos = new ObjectOutputStream (fos);	

				// lo grabo
				oos.writeObject(t);

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
