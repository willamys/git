package planilhaMetodos;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jxl.Cell;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@ManagedBean
@SessionScoped
public class EscreverNaCelula {
	
	public WritableWorkbook escreverNaCelula(WritableWorkbook planilha, int numSheet, int numberXCell, int numberYCell, String dado) throws WriteException, IOException{
		
		
		//WritableWorkbook é a planilha criada que pode ser escrita, populada.
		//WritableSheet é a aba da planilha a ser escrita (int 0,1,2,3...) 
		WritableSheet sheet = this.getWritableSheet(planilha, numSheet);
		
		if( sheet == null ){
			System.out.println("Null");
		}
		else{

		Cell celula = sheet.getCell(numberXCell, numberYCell);
			
	    /* Cria um label e escreve a data em uma célula da folha*/
	    Label l = new Label(numberXCell, numberYCell, dado, celula.getCellFormat());
	    sheet.addCell(l);
		}
	    planilha.write();
	    planilha.close();
		
	    System.out.println("O dado " + dado +" foi inserido na celula.");
	    
	    return planilha;
	}

	private WritableSheet getWritableSheet(WritableWorkbook spread, int numSheet){
		return spread.getSheet(numSheet);
	}
	
}
