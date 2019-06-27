package dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	
	
	
	
	
}
