package planilhaMetodos;

import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LerDaCelula {

	public String lerDaCelula(Workbook wb, int numberSheet, int numberXCell, int numberYCell) throws BiffException, IOException{

		// Retorna a aba correta da planilha
		Sheet sheet = wb.getSheet(numberSheet);
		// Retorna a celula correta da planilha
		Cell cell = sheet.getCell(numberXCell, numberYCell);
		// Retorna o dado da celula na forma de string
		String contents = cell.getContents();
		// Fecha a planilha
		wb.close();
		
		System.out.println("O dado " + cell.getContents() +" foi lido da celula.");
		
		return contents;
	}

}
