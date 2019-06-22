package validacija;

import admin.Admin;

public class ValidacijaZaRegistraciju {
	
	public static boolean proveraPassworda(String password, String repeatedPassword) {
		
		if(password.equals(repeatedPassword)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static  boolean daLiJeAdmin(String userName, String password) {
		
		Admin admin = new Admin();
			if(userName.equals(admin.getAdminUserName()) && password.equals(admin.getAdminPassword())) {	
				return true;
			}else {
				return false;
			}
		
	}
	
	
	
	
}
