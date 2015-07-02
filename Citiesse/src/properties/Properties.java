package properties;

import java.util.ResourceBundle;

public class Properties {

	private static ResourceBundle rb;

	private static ResourceBundle instance() {
		if(rb == null) {
			rb = ResourceBundle.getBundle("properties/strings");
		}
		return rb;
	}
	
	public static String getString(ApplicationStrings str) {
		return instance().getString(str.toString());
	}

}
