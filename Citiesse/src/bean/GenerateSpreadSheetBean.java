package bean;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.ResultDAOImpl;
import dao.TestCaseDAOImpl;
import entity.Result;
import entity.Testcase;

import planilhaMetodos.Comunicacao;
import planilhaMetodos.CopiarArquivo;
import planilhaMetodos.MovendoAqruivo;

@ManagedBean
@SessionScoped
public class GenerateSpreadSheetBean {

	public int flag = 1;
	/**
	 * @param args
	 */
	private int id_execution;

	public int getId_execution() {
		return id_execution;
	}

	public void setId_execution(int id_execution) {
		this.id_execution = id_execution;
	}

	private ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	private HttpSession getSession() {
		return (HttpSession) getExternalContext().getSession(false);
	}

	public void vai() {

		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_execution");
		System.out.println(value);
		Comunicacao comunica = new Comunicacao();
		CopiarArquivo copy = new CopiarArquivo();
		MovendoAqruivo move = new MovendoAqruivo();
		List<Result> list = new ArrayList<Result>();
		ResultDAOImpl tdao = new ResultDAOImpl();

		//Integer.parseInt(value)
		list = tdao.listAllWhere("idexec", Integer.parseInt(value));

		int i, linha = 6, coluna = 4; 

		int tamanho = 3;

		linha = 6;
		coluna = 4; 

		for( i = 0; i < list.size(); i++ ){
			//dado = JOptionPane.showInputDialog(null,"Digite o dado para armazenar na celula " + i+1 +":");
			if(list.get(i).getIdtest() > 36){
				System.out.println(list.get(i).getResulttest());
				System.out.println(list.get(i).getIdtest());
				System.out.println(list.get(i).getComment());
				comunica.metodos("escrever", coluna, list.get(i).getIdtest(), list.get(i).getResulttest());
				System.out.println("Linha: " + i);
			}else{
				comunica.metodos("escrever", coluna, list.get(i).getIdtest(), list.get(i).getResulttest());
			}
			if( i == 31 ){
				i = 35;
			}
		}
		new MessageBean().success();
		getSession().invalidate();
		System.out.println("fim");
		if( flag == 2 ){
			for( i = 0; i<tamanho; i++){
				for(int j = 0; j<tamanho; j++){
					comunica.metodos("ler", i, j,"");
				}
			}
		}
		else if( flag == 3 ){

			// Linhas e Colunas eh uma a menos que o valor mostrado na planilha
			// Devem ser enviadas de forma trocada (coluna,linha)
			linha = 35;
			coluna = 6;

			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

			String imagem = request.getSession().getServletContext().getRealPath("/");			
			imagem = imagem + "planilha\\imagens\\";

			// Insere a imagem do Central Painel
			comunica.metodos("inserir imagem", imagem+"1.png", coluna, linha, 2, 1);

			linha = linha + 2;
			// Insere a imagem do icone do App Store
			comunica.metodos("inserir imagem", imagem+"1.png", coluna, linha, 2, 1);

			linha = linha + 8;
			// Insere as 7 imagens das aplicações do App Store
			int cont=2;
			for(i=coluna; i<coluna+7; i++ ){
				comunica.metodos("inserir imagem", imagem+cont+".png", i, linha, 1, 1);
				cont++;
			}

			linha = linha + 7;
			// Insere a imagem do icone do Google Search
			comunica.metodos("inserir imagem", imagem+"1.png", coluna, linha, 2, 1);

			System.out.println("fim");
		}
		else if( flag == 4 ){

			comunica.metodos("remover imagem", 2, 2,"");
		}
		else if( flag == 5 ){

			move.mover();
			try {
				copy.copiar();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro ao tentar copiar o arquivo.");
			}
		}
	}

}
