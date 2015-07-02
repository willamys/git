package planilhaMetodos;

import java.io.File;
import java.io.IOException;

import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class InserirImagem {

	public void inserirImagem(WritableWorkbook planilha, int numSheet, String imagem, int posX, int posY, int comp, int  larg) throws WriteException, IOException{

		//WritableWorkbook é a planilha criada que pode ser escrita, populada.
		//WritableSheet é a aba da planilha a ser escrita (int 0,1,2,3...) 
		WritableSheet sheet = this.getWritableSheet(planilha, numSheet);
		
				
		/* Cria um label e escreve uma imagem em uma célula da folha*/    
		//Label l = new Label(0, 3, "Imagem");
		//sheet.addCell(l);
		
		// Escreve a imagem na tabela com as dimensões definidas como parâmetros
		// O 1º numero indica a primeira coluna
		// O 2º numero indica primeira linha
		// O 3º numero indica a quantidade de colunas que seram ocupadas
		// O 4º indica numero indica a quantidade de linhas que seram ocupadas
		WritableImage wi = new WritableImage(posX, posY, comp, larg, new File(imagem));
		sheet.addImage(wi);
		
		planilha.write();
	    planilha.close();
	    
		System.out.println("A Imagem abaixo foi adicionada na aba " + sheet.getName() +".");
		System.out.println(imagem + "\n");
	}
	
	private WritableSheet getWritableSheet(WritableWorkbook spread, int numSheet){
		return spread.getSheet(numSheet);
	}
}
