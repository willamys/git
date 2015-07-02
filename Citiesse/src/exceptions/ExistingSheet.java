package exceptions;


public class ExistingSheet extends SpreadsheetExceptions {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String sheetName;
	
	public ExistingSheet(String name){
		this.sheetName = name;
	}
	
	public String getConflictingName() {
		return this.sheetName;
	}
}
