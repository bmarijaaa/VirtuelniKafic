package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artikal;
import model.Racun;
import model.User;

public class UserDAO {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public List<Artikal> vratiSveArtikle(){
		
		List<Artikal> listaArtikala = null;
		
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				String upit = "FROM Artikal";
				Query query = session.createQuery(upit);
					listaArtikala = query.getResultList();
				session.getTransaction().commit();
				return listaArtikala;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
		}finally {
			session.close();
		}
	}
	
	public List<Artikal> artikliSaRacuna(String[] check){
		
		List<Artikal> listaArtikala = new ArrayList<Artikal>();
		
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				Query query;
				for(int i = 0; i<check.length; i++) {
					Artikal artikal = new Artikal();
					int id = Integer.parseInt(check[i]);
					query = session.createQuery("FROM Artikal WHERE idArtikal = :id");
					query.setParameter("id", id);
					artikal = (Artikal)query.getResultList().get(i);
					listaArtikala.add(artikal);
				}
				session.getTransaction().commit();
				return listaArtikala;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return listaArtikala;
		}finally {
			session.close();
		}
			
	}
	
	public Racun sacuvajRacun(User user, Date date, List<Artikal>listaArtikala) {
		
		Racun racun = new Racun();
		racun.setUser(user);
		racun.setDate(date);
		racun.setListaArtikala(listaArtikala);
		Session session = sf.openSession();
		session.beginTransaction();
			try {

				session.save(racun);
				session.getTransaction().commit();
				return racun;
			} catch (Exception e) {
				session.getTransaction().rollback();
				return null;
		}finally {
			session.close();
		}
	}
	
	public double iznosRacuna(List<Artikal>listaArtikala, List<String> listaKolicina) {
		
		double rez = 0.0;
		int velicina = listaArtikala.size();
		if(velicina != 0) {
			for(int i = 0; i<velicina; i++) {
				rez = rez + listaArtikala.get(i).getCena() * Integer.parseInt(listaKolicina.get(i)) *(100-listaArtikala.get(i).getPopust())/100;
			}
			return rez;
		}else {
			return 500;
		}

	}
	
	public void apdejtujNovcanik(User user, double totalPrice) {
		
		user.setNovcanik(user.getNovcanik() - totalPrice);
		
		Session session = sf.openSession();
		session.beginTransaction();
			try {

				session.update(user);
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	
	public void apdejtujStanje(List<Artikal> listaArtikala, List<String> listaKolicina) {
		Artikal artikal;
		Session session = sf.openSession();
		session.beginTransaction();
			try {
				for(int i = 0; i<listaArtikala.size(); i++) {
					artikal = listaArtikala.get(i);
					artikal.setStanje(artikal.getStanje() - Integer.parseInt(listaKolicina.get(i)));
					session.update(artikal);
				}
				
				session.getTransaction().commit();
			} catch (Exception e) {
				session.getTransaction().rollback();
		}finally {
			session.close();
		}
	}
	
	
	
	
	
	

}
