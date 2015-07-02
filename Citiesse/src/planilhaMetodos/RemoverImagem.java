package planilhaMetodos;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.write.Label;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class RemoverImagem {
	
	public void removerImagem(WritableWorkbook planilha, int numSheet) throws WriteException, IOException{

		//WritableWorkbook é a planilha criada que pode ser escrita, populada.
		//WritableSheet é a aba da planilha a ser escrita (int 0,1,2,3...) 
		WritableSheet sheet = this.getWritableSheet(planilha, numSheet);
		
		WritableImage wi = new WritableImage(1, 1, 2, 6, new File("C:\\Users\\Artur Jr\\workspace\\Plugins Planilha\\java.png\\"));
		sheet.removeImage(wi);
		
		planilha.write();
	    planilha.close();
	    
		System.out.println("A Imagem foi removida da aba " + sheet.getName() +".");
	
	}
	
	private WritableSheet getWritableSheet(WritableWorkbook spread, int numSheet){
		return spread.getSheet(numSheet);
	}

}
