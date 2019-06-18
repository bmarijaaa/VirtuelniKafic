package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Racun {

	private long idRacun;
	private User user;
	private Date date = new Date();
	private List<Artikal> listaArtikala = new ArrayList<Artikal>();
	
	public long getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(long idRacun) {
		this.idRacun = idRacun;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Artikal> getListaArtikala() {
		return listaArtikala;
	}
	public void setListaArtikala(List<Artikal> listaArtikala) {
		this.listaArtikala = listaArtikala;
	}
	
	
}
