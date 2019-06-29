package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Artikal;
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
	
	
	
	
	
	
	

}
