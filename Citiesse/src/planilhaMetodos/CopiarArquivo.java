package planilhaMetodos;

import java.io.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@SessionScoped
public class CopiarArquivo {

	public void copiar() throws IOException {

		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

		String nomeEnd;
		String nomePlan = "planilha_origem.xls";
			
		nomeEnd = request.getSession().getServletContext().getRealPath("/") + "planilha\\";

		File origem = new File(nomeEnd+nomePlan);
		FileInputStream fis = new FileInputStream(origem);
		BufferedInputStream bis = new BufferedInputStream(fis);

		File destino = new File(nomeEnd+"planilha.xls");
		if(destino.exists()){
			System.out.println("Arquivo já existe e não será substituido.");
			System.out.println("Temos que tratar isso.");
		}
		else{
			FileOutputStream fos = new FileOutputStream(destino);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int i = -1;

			do {
				i = bis.read();
				if(i != -1) bos.write(i);
			} while(i !=-1);
			
			bis.close();
			bos.close();
			
			System.out.println("O arquivo foi copiado com sucesso.");
		}
	} 
} 
