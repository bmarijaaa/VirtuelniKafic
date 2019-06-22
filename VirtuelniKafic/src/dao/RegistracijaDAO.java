package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Rola;
import model.User;
import validacija.ValidacijaZaRegistraciju;

public class RegistracijaDAO {
	
	private SessionFactory sf = new Configuration().configure().buildSessionFactory();

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	public boolean upisiUseraUbazu(String userName, String password) {
		
		User user = new User();
			user.setUserName(userName);
			user.setPassword(password);
		
		Rola rola = new Rola();
			
		if(ValidacijaZaRegistraciju.daLiJeAdmin(userName, password)) {
			rola.setUloga("administrator");
		}else {
			rola.setUloga("korisnik");
		}
		
		user.setRola(rola);
	
		Session session = sf.openSession();
			session.beginTransaction();
			
			try {
				session.save(user);
				session.getTransaction().commit();
				System.out.println("Uspesno je ubacen user");
				return true;
			} catch (Exception e) {
				session.getTransaction().rollback();
				System.out.println("Nije ubacen user");
				return false;
			}finally {
				session.close();
			}
		
	}
	
	

}
