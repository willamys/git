package exceptions;

public class NoExistingOfflineSpreadsheet extends SpreadsheetExceptions{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String spreadsheetName;
	
	public NoExistingOfflineSpreadsheet(String name){
		this.spreadsheetName = name;
	}
	
	public String getConflictingName() {
		return this.spreadsheetName;
	}
}
