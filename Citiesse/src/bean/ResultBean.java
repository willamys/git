package bean;

import dao.ResultDAOImpl;
import entity.Executiontest;
import entity.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class ResultBean {

	private Result resultB = new Result();
	private List<Result> results = new ArrayList<Result>();

	public ResultBean() {
		//listAll();
	}

	private ResultDAOImpl getPersistence() {
		return new ResultDAOImpl();
	}

	public Result getResultB() {
		return resultB;
	}

	public void setResultB(Result resultB) {
		this.resultB = resultB;
	}

	public List<Result> getResults() {
		results = new ArrayList<Result>();
		results = getPersistence().listAllOrderBy("id");
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	private void listAll() {
		results = getPersistence().listAllOrderBy("id");
	}

	public List<Result> autoComplete(String query) {
		List<Result> suggestions = new ArrayList<Result>();
		for (Result c : results) {
			if (String.valueOf(c.getId()).toLowerCase().startsWith(query.toLowerCase())) {
				suggestions.add(c);
			}
		}
		return suggestions;
	}
	public void adjustSave() {
		
		resultB.setIdexec(resultB.getId());
		resultB.setResulttest(resultB.getResulttest());
		resultB.setComment(resultB.getComment());
		resultB.setIdtest(resultB.getIdtest());
	}
	public void adjustUpdate() {
		//result.setId(result.getId());
		resultB.setResulttest(resultB.getResulttest());
		resultB.setComment(resultB.getComment());
	}
	public void save() {
		try {
			String idtest = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idtest");
			String idExec = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idExec");
//			resultB.setId(Integer.parseInt(id));
			resultB.setIdexec(Integer.parseInt(idExec));
			resultB.setResulttest(resultB.getResulttest());
			resultB.setComment(resultB.getComment());
		//	resultB.setIdtest(resultB.getIdtest());
			resultB.setIdtest(Integer.parseInt(idtest));
			
		//	System.out.println(res);
			//System.out.println(comm);
			System.out.println(resultB.getComment());
			System.out.println(resultB.getIdtest());
		
			
			//adjustSave();
			getPersistence().save(resultB);
			listAll();
			new MessageBean().success();
		} catch (Exception e) {
			new MessageBean().error();
		}
	}

	public String update() {
		try {
			adjustUpdate();
			getPersistence().update(resultB);
			listAll();
			new MessageBean().success();
		} catch (Exception e) {
			new MessageBean().error();
		}
		return "/execution/manager";
	}
	public void delete() {
		try {
			getPersistence().delete(resultB);
			listAll();
			new MessageBean().success();
		} catch (Exception e) {
			new MessageBean().error();
		}
	}
}