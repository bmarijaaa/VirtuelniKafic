package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artikal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idArtikal;
	private String imeArtikla;
	private double cena;
	private int stanje;
	private double popust;
	
	public long getIdArtikal() {
		return idArtikal;
	}
	public void setIdArtikal(long idArtikal) {
		this.idArtikal = idArtikal;
	}
	public String getImeArtikla() {
		return imeArtikla;
	}
	public void setImeArtikla(String imeArtikla) {
		this.imeArtikla = imeArtikla;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getStanje() {
		return stanje;
	}
	public void setStanje(int stanje) {
		this.stanje = stanje;
	}
	public double getPopust() {
		return popust;
	}
	public void setPopust(double popust) {
		this.popust = popust;
	}
	
	

}
