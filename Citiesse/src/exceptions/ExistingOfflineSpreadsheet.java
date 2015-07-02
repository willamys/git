package exceptions;

public class ExistingOfflineSpreadsheet extends SpreadsheetExceptions{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String spreadsheetName;
	
	public ExistingOfflineSpreadsheet(String name){
		this.spreadsheetName = name;
	}
	
	public String getConflictingName() {
		return this.spreadsheetName;
	}
}
