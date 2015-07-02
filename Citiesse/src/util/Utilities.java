package util;

public class Utilities {

	 public static boolean isUsuarioValido(
		      String username, String password){
		    String login = "admin";
		    String pass = "admin";

		    if((login.equals(username)) && (password.equals(pass)))
		      return true;
		    else
		    return false;
		  }
}
