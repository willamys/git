package planilhaMetodos;
import java.io.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jxl.*;
import jxl.read.biff.BiffException;

import jxl.write.WriteException;

import jxl.write.*;

import exceptions.NoExistingOfflineAdress;
import exceptions.SpreadsheetExceptions;



@ManagedBean
@SessionScoped
public class PlanilhaMetodos {
	//WritableWorkbook spreadsheet = null;

	public PlanilhaMetodos(){
		System.out.println("Construindo planilha...");
	}


//	/**
//	 * Add a new sheet in the spreadsheet
//	 * @param spreadsheet
//	 * @param nameSheet
//	 * @return
//	 * @throws IOException
//	 * @throws WriteException
//	 */
//	public WritableWorkbook addSheet(WritableWorkbook spreadsheet, String nameSheet) throws IOException, WriteException, SpreadsheetExceptions{
//		if(spreadsheet==null)
//			throw new NoExistingOfflineSpreadsheet("null");
//		int numSheets = spreadsheet.getNumberOfSheets();
//		WritableSheet newSheet = spreadsheet.createSheet(nameSheet,numSheets);//jah q inicia em zero
//		spreadsheet.write();
//		spreadsheet.close();
//		return spreadsheet;
//	}

	public void getNomes(WritableWorkbook spreadsheet){
		System.out.println(spreadsheet.getSheetNames());
	}
	/**
	 * Return a Workbook for the file
	 * @param nameSpread
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	// USA ESSE
	public Workbook getWorkbook(String nameSpread) throws BiffException, IOException, SpreadsheetExceptions{
		File file = new File(nameSpread);
		if(!file.exists())
			throw new NoExistingOfflineAdress(nameSpread);
		Workbook wb;
		wb = Workbook.getWorkbook(file);
		return wb;
	}

	// USA ESSE
	private WritableSheet getWritableSheet(WritableWorkbook spread, int numSheet){
		return spread.getSheet(numSheet);
	}

	// USA ESSE
	public WritableWorkbook getWritableWorkbook(Workbook wb,String nameSpread) throws BiffException, IOException{
		//Workbook wb = this.getWorkbook(nameSpread);
		WritableWorkbook copy = Workbook.createWorkbook(new File(nameSpread),wb);
		return copy;
	}

//	/**
//	 * Create a new workbook
//	 * @param endPlanilha
//	 * @param nomePlanilha
//	 * @param nameFirstSheet
//	 * @return the created spreadsheet
//	 * @throws IOException
//	 * @throws WriteException
//	 */
//	// USA ESSE
//	public WritableWorkbook createSpreadsheet(String endPlanilha, String nomePlanilha, String nameFirstSheet) throws IOException, WriteException, SpreadsheetExceptions{
//
//		if(!nomePlanilha.contains(".xls"))
//			nomePlanilha=nomePlanilha+".xls";
//		String filename = nomePlanilha;
//		File file = new File(endPlanilha+filename);
//		if(file.exists())
//			throw new ExistingOfflineSpreadsheet(nomePlanilha);
//		WorkbookSettings ws = new WorkbookSettings();
//		ws.setLocale(new Locale("en", "EN"));
//
//		WritableWorkbook spreadsheet = 
//				Workbook.createWorkbook(file, ws);
//		// System.out.println(file.getAbsolutePath());
//		WritableSheet s = spreadsheet.createSheet(nameFirstSheet, 0);
//
//		// WritableSheet s1 = workbook.createSheet("Folha1", 0);
//		spreadsheet.write();
//
//		spreadsheet.close(); 
//		return spreadsheet;
//	}
//
//
//	/**
//	 * Read a data from the specific cell in the specific sheet
//	 * @param wb
//	 * @param numberSheet
//	 * @param numberXCell
//	 * @param numberYCell
//	 * @return
//	 * @throws BiffException
//	 * @throws IOException
//	 */
//	public String readCell(Workbook wb, int numberSheet, int numberXCell, int numberYCell) throws BiffException, IOException{
//
//		Sheet sheet = wb.getSheet(numberSheet);
//		Cell cell = sheet.getCell(numberXCell, numberYCell);
//		String contents = cell.getContents();
//		wb.close();
//		return contents;
//	}

	public WritableWorkbook writeDataCell(WritableWorkbook spread, int numSheet, int numberXCell, int numberYCell, String dado) throws WriteException, IOException{
		WritableSheet sheet = this.getWritableSheet(spread, numSheet);
		/* Formata a fonte */
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 
				10, WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(wf);
		cf.setWrap(true);
		/* Cria um label e escreve a data em uma célula da folha*/
		Label l = new Label(numberXCell,numberYCell,dado,cf);
		sheet.addCell(l);
		spread.write();
		spread.close();
		return spread;
	}

	public boolean setSpreadsheet(String endSpread, String nameSpread, String newNameSpread) throws IOException, WriteException, BiffException{
		//		if(!nameSpread.contains(".xls"))
		//			nameSpread.concat(".xls");
		File file = new File(endSpread+nameSpread);
		Workbook workbook = Workbook.getWorkbook(file); 
		WritableWorkbook copy = Workbook.createWorkbook(new File(endSpread+newNameSpread), workbook);

		WritableSheet sheet2 = copy.getSheet(1);
		WritableCell cell = sheet2.getWritableCell(1, 2); 
		if (cell.getType() == CellType.LABEL)
		{
			Label l = (Label) cell;
			l.setString("modified cell");
		}
		copy.write();
		copy.close();
		//		WorkbookSettings ws = new WorkbookSettings();
		//	      ws.setLocale(new Locale("en", "EN"));
		//	      Workbook sp = Workbook.getWorkbook(file);
		//	     this.spreadsheet =  sp.createWorkbook(file, ws);
		////	    this.spreadsheet = 
		////	      Workbook.createWorkbook(file, ws);
		//	      System.out.println(file.getAbsolutePath());
		//	      WritableSheet newSheet = this.spreadsheet.createSheet("aiii",2);
		//	      
		//	      this.spreadsheet.close();
		return true;
	}







//	private static void writeDataSheet(WritableSheet s) 
//			throws WriteException
//			{
//
//		/* Formata a fonte */
//		WritableFont wf = new WritableFont(WritableFont.ARIAL, 
//				10, WritableFont.BOLD);
//
//		WritableCellFormat cf = new WritableCellFormat(wf);
//		cf.setWrap(true);
//
//		/* Cria um label e escreve a data em uma célula da folha*/
//		Label l = new Label(0,0,"Data",cf);
//		s.addCell(l);
//		WritableCellFormat cf1 = 
//				new WritableCellFormat(DateFormats.FORMAT9);
//
//		DateTime dt = 
//				new DateTime(0,1,new Date(), cf1, DateTime.GMT);
//
//		s.addCell(dt);
//
//		/* Cria um label e escreve um float numver em uma célula da folha*/
//		l = new Label(2,0,"Float", cf);
//		s.addCell(l);
//		WritableCellFormat cf2 = new WritableCellFormat(NumberFormats.FLOAT);
//		Number n = new Number(2,1,3.1415926535,cf2);
//		s.addCell(n);
//
//		n = new Number(2,2,-3.1415926535, cf2);
//		s.addCell(n);
//
//		/* Cria um label e escreve um float number acima de 3 decimais 
//	       em uma célula da folha*/
//		l = new Label(3,0,"3dps",cf);
//		s.addCell(l);
//		NumberFormat dp3 = new NumberFormat("#.###");
//		WritableCellFormat dp3cell = new WritableCellFormat(dp3);
//		n = new Number(3,1,3.1415926535,dp3cell);
//		s.addCell(n);
//
//		/* Cria um label e adiciona 2 células na folha*/
//		l = new Label(4, 0, "Add 2 cells",cf);
//		s.addCell(l);
//		n = new Number(4,1,10);
//		s.addCell(n);
//		n = new Number(4,2,16);
//		s.addCell(n);
//		Formula f = new Formula(4,3, "E1+E2");
//		s.addCell(f);
//
//		/* Cria um Label e mulpiplica o valor de uma célula da folha por 2 */
//		l = new Label(5,0, "Multiplica por 2",cf);
//		s.addCell(l);
//		n = new Number(5,1,10);
//		s.addCell(n);
//		f = new Formula(5,2, "F1 * 3");
//		s.addCell(f);
//
//		/* Cria um Label e divide o valor de uma célula da folha por 2.5 */
//		l = new Label(6,0, "Divide por 2.5",cf);
//		s.addCell(l);
//		n = new Number(6,1, 12);
//		s.addCell(n);
//		f = new Formula(6,2, "F1/2.5");
//		s.addCell(f);
//			}
//
//	private static void writeImageSheet(WritableSheet s) 
//			throws WriteException
//			{
//		/* Cria um label e escreve uma imagem em uma célula da folha*/    
//		Label l = new Label(0, 0, "Imagem");
//		s.addCell(l);
//		WritableImage wi = new WritableImage(5, 3, 14, 14, new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\teste.png"));
//		s.addImage(wi);

		/* Cria um label e escreve hyperlink em uma célula da folha*/
		//	    l = new Label(0,15, "HYPERLINK");
		//	    s.addCell(l);
		//	    Formula f = new Formula(1, 15, 
		//	      "DevMedia(\"http://www.devmedia.com.br\", "+
		//	      "\"Portal DevMedia\")");
		//	    s.addCell(f);
		//	    
//			}
}

//  System.out.println(file.getAbsolutePath());
//WritableSheet s = workbook.createSheet("Folha1", 0);
//WritableSheet s1 = workbook.createSheet("Folha1", 0);
//writeDataSheet(s);

//writeImageSheet(s1);
//workbook.write();
//workbook.close();      
//}
//catch (IOException e)
//{
//e.printStackTrace();
//}
//catch (WriteException e)
//{
//e.printStackTrace();
//}

