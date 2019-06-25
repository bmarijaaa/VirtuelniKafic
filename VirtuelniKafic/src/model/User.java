package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	private String userName;
	private String password;
	private double novcanik;
	@OneToMany
	private List<Racun> listaRacuna = new ArrayList<Racun>();
	@Enumerated
	private Rola rola;
	
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getNovcanik() {
		return novcanik;
	}
	public void setNovcanik(double novcanik) {
		this.novcanik = novcanik;
	}
	public List<Racun> getListaRacuna() {
		return listaRacuna;
	}
	public void setListaRacuna(List<Racun> listaRacuna) {
		this.listaRacuna = listaRacuna;
	}
	public Rola getRola() {
		return rola;
	}
	public void setRola(Rola rola) {
		this.rola = rola;
	}
	
	
	
}
