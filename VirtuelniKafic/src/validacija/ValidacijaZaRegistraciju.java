package validacija;

public class ValidacijaZaRegistraciju {
	
	public static boolean proveraPassworda(String password, String repeatedPassword) {
		
		if(password.equals(repeatedPassword)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
}
