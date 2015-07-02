
package planilhaMetodos;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.*;  
import exceptions.SpreadsheetExceptions;


import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@ManagedBean
@SessionScoped
public class Comunicacao {

	private PlanilhaMetodos spread;
	private EscreverNaCelula escreve;
	private LerDaCelula ler;
	private InserirImagem inserirImg;
	private RemoverImagem removerImg; 

	private Workbook wb = null;
	private WritableWorkbook writeWb = null;

	public void metodos(String opcao, int posX, int posY, String dado) {

		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		String nomeEnd;
		String nomePlan = "planilha.xls";
			
		nomeEnd = request.getSession().getServletContext().getRealPath("/") + "planilha\\";
		
		System.out.println("Planiha:" + nomeEnd);	
	
		spread = new PlanilhaMetodos();
		escreve = new EscreverNaCelula();
		ler = new LerDaCelula();

		if( opcao.equals("escrever")){
			try {
				try {

					wb = spread.getWorkbook(nomeEnd+nomePlan);

				} catch (SpreadsheetExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Cria uma instância de população da planilha, abilitando a escrita na planilha
				writeWb = spread.getWritableWorkbook(wb,nomeEnd+nomePlan);

			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				//Escreve o campo "1" no objeto passado como primeiro parametro nas posiçoes:
				// 0 que indica a aba 1 da planiha
				// 2 que indica a coluna 3 da planilha
				// 2 indica a linha 3 da planilha

				escreve.escreverNaCelula(writeWb, 1, posX, posY, dado);			

			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else if( opcao.equals("ler")){
			try {
				try {

					wb = spread.getWorkbook(nomeEnd+nomePlan);

				} catch (SpreadsheetExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ler.lerDaCelula(wb, 0, posX, posY);

			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	public void metodos(String opcao, String imagem, int posX, int posY, int comp, int larg) {

		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		String nomeEnd;
		String nomePlan = "planilha.xls";
			
		nomeEnd = request.getSession().getServletContext().getRealPath("/") + "planilha\\";
		
		System.out.println("Planiha:" + nomeEnd);	
		
		spread = new PlanilhaMetodos();
		inserirImg = new InserirImagem();
		removerImg = new RemoverImagem(); 

		if( opcao.equals("inserir imagem")){
			try {
				try {

					wb = spread.getWorkbook(nomeEnd+nomePlan);

				} catch (SpreadsheetExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Cria uma instância de população da planilha, abilitando a escrita na planilha
				writeWb = spread.getWritableWorkbook(wb,nomeEnd+nomePlan);

				try{
					// 1 representa a segunda aba da planilha
					inserirImg.inserirImagem(writeWb, 1, imagem, posX, posY, comp, larg);

				} catch( WriteException we ){
					// TODO Auto-generated catch block
					we.printStackTrace();
				}
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else if( opcao.equals("remover imagem")){
			try {
				try {

					wb = spread.getWorkbook(nomeEnd+nomePlan);

				} catch (SpreadsheetExceptions e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Cria uma instância de população da planilha, abilitando a escrita na planilha
				writeWb = spread.getWritableWorkbook(wb,nomeEnd+nomePlan);

				try{

					removerImg.removerImagem(writeWb, 1);

				} catch( WriteException we ){
					// TODO Auto-generated catch block
					we.printStackTrace();
				}
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}

	}
}
