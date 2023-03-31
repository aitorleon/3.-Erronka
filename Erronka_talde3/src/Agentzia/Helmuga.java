package Agentzia;

public class Helmuga {
	private int id_Helmuga;
	private int id_Estantzia;
	private String izena;
	
	public Helmuga () {
		this.id_Helmuga = 0;
		this.id_Estantzia = 0;
		this.izena = "";
	}
	public Helmuga (int idH, int idE, String iz) {
		this.id_Helmuga = idH;
		this.id_Estantzia = idE;
		this.izena = iz;
	}
	public Helmuga (Helmuga h) {
		this.id_Helmuga = h.id_Helmuga;
		this.id_Estantzia = h.id_Estantzia;
		this.izena = h.izena;
	}
	public int getId_Helmuga() {
		return id_Helmuga;
	}
	public void setId_Helmuga(int id_Helmuga) {
		this.id_Helmuga = id_Helmuga;
	}
	public int getId_Estantzia() {
		return id_Estantzia;
	}
	public void setId_Estantzia(int id_Estantzia) {
		this.id_Estantzia = id_Estantzia;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	/**
	 * @author Aitor Leon
	 * Gure erabiltzaielak daukaten helmugen informazioa pantailaratzeko
	 */
	public void helmugaPantailaratu() {
		System.out.println("Helmugaren izena: " + this.izena);
		System.out.println("Helmugaren IDa: " + this.id_Helmuga);
		System.out.println("Helmuga horrek daukan estantziaren IDa: " + this.id_Estantzia);
	}
}
