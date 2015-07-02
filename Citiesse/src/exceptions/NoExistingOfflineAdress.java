package exceptions;

public class NoExistingOfflineAdress extends SpreadsheetExceptions{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String AdressName;
	
	public NoExistingOfflineAdress(String name){
		this.AdressName = name;
	}
	
	public String getConflictingName() {
		return this.AdressName;
	}
}
