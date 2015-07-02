package util;

import properties.Properties;
import properties.ApplicationStrings;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(ApplicationStrings string) {
		super(Properties.getString(string));
	}
	
	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

}