package planilhaMetodos;

import java.io.*;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class MovendoAqruivo {
	
	public void mover(){
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		String nomeEnd;
		String nomePlan = "planilha.xls";
			
		nomeEnd = request.getSession().getServletContext().getRealPath("/") + "\\planilha\\";
		
		System.out.println(request.getSession().getServletContext().getRealPath("/"));	
		
		// arquivo a ser movido
		File arquivo = new File(nomeEnd+nomePlan);
		
		// diretorio de destino
		File dir = new File(nomeEnd+"\\destino");

		// move o arquivo para o novo diretorio
		boolean ok = arquivo.renameTo(new File(dir, arquivo.getName()));
		if(ok){
			System.out.println("Arquivo foi movido com sucesso.");
		}
		else{
			System.out.println("Nao foi possivel mover o arquivo.");
		}
	}
}
