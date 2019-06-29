package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artikal;
import model.Rola;
import model.User;

public class AdminDAO {
	
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public static List<User> vratiSveUsere(){
		
		List<User> listaUsera = null;
		
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				String upit = "FROM User";
				Query query = session.createQuery(upit);
					listaUsera = query.getResultList();
				session.getTransaction().commit();
				return listaUsera;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
		}finally {
			session.close();
		}
	}
	
	public static boolean dodajUnovcanik(User user, String balance) {
		
		double uplata = Double.parseDouble(balance);
		double staroStanjeUnovcaniku = user.getNovcanik();
		double konacno = uplata + staroStanjeUnovcaniku;
		
		if(user.getRola().equals(Rola.ADMINISTRATOR)) {
			user.setNovcanik(0);
		}else {
			user.setNovcanik(konacno);
		}
		
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				session.update(user);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
		}finally {
			session.close();
		}
	}
	
	public static boolean ubaciArtikalUBazu(String imeArtikla, String cena, String stanje , String popust){
		
		Artikal artikal = new Artikal();
			artikal.setImeArtikla(imeArtikla);
				double cenaArtikla = Double.parseDouble(cena);
			artikal.setCena(cenaArtikla);
				int stanjeUMagacinu = Integer.parseInt(stanje);
			artikal.setStanje(stanjeUMagacinu);
			if(popust.isEmpty()) {
				artikal.setPopust(0);
			}else {
				double popustNaArtikal  = Double.parseDouble(popust);
				artikal.setPopust(popustNaArtikal);
			}
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				session.save(artikal);
				session.getTransaction().commit();
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return false;
		}finally {
			session.close();
		}
		
	}
	
	
	
	
	
	
	
	
}
