package bean;


import dao.ExecutionTestDAOImpl;
import dao.TestCaseDAOImpl;
import entity.Executiontest;
import entity.Testcase;
import entity.Testcasesetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class ExecutionTestBean {

	private Executiontest executionTest = new Executiontest();
	private List<Executiontest> executionTests = new ArrayList<Executiontest>();
	private List<Testcase> list = new ArrayList<Testcase>();
	private List<Testcase> listTemp =  new ArrayList<Testcase>();
	private TestCaseDAOImpl dao = new TestCaseDAOImpl();
	private Testcase t;
	private int listSize = 0;
	private int indice = 0;
	private int idTest;
	private int lastidinserted = 0;
	private boolean enableStart = true;
	private boolean enableGenerate = true;
	private boolean enableNext = true;
	private boolean enablePrev = true;
	private boolean enableFinish = true;
	private boolean enableGettingStart = true;


	/**buttons**/
	public boolean isEnableStart() {
		return enableStart;
	}

	public void setEnableStart(boolean enableStart) {
		this.enableStart = enableStart;
	}

	public boolean isEnableGenerate() {
		return enableGenerate;
	}

	public void setEnableGenerate(boolean enableGenerate) {
		this.enableGenerate = enableGenerate;
	}

	public boolean isEnableNext() {
		return enableNext;
	}

	public void setEnableNext(boolean enableNext) {
		this.enableNext = enableNext;
	}

	public boolean isEnablePrev() {
		return enablePrev;
	}

	public void setEnablePrev(boolean enablePrev) {
		this.enablePrev = enablePrev;
	}

	public boolean isEnableFinish() {
		return enableFinish;
	}

	public void setEnableFinish(boolean enableFinish) {
		this.enableFinish = enableFinish;
	}

	public boolean isEnableGettingStart() {
		return enableGettingStart;
	}

	public void setEnableGettingStart(boolean enableGettingStart) {
		this.enableGettingStart = enableGettingStart;
	}

	/****end Buttons***/

	public List<Testcase> getListTemp() {
		return listTemp;
	}

	public void setListTemp(List<Testcase> listTemp) {
		this.listTemp = listTemp;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public Testcase getT() {
		return t;
	}

	public void setT(Testcase t) {
		this.t = t;
	}

	public List<Testcase> getList() {
		return list;
	}

	public void setList(List<Testcase> list) {
		this.list = list;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public ExecutionTestBean() {
		this.list = dao.listAllOrderBy("orderworkflow");
		this.listSize = list.size();
	}

	private ExecutionTestDAOImpl getPersistence() {
		return new ExecutionTestDAOImpl();
	}

	public Executiontest getExecutionTest() {
		return executionTest;
	}

	public void setExecutionTest(Executiontest executionTest) {
		this.executionTest = executionTest;
	}

	public List<Executiontest> getExecutionTests() {
		executionTests = new ArrayList<Executiontest>();
		executionTests = getPersistence().listAllOrderBy("id");
		return executionTests;
	}

	public void setExecutionTests(List<Executiontest> executionTests) {
		this.executionTests = executionTests;
	}

	public int getLastidinserted() {
		return lastidinserted;
	}

	public void setLastidinserted(int lastidinserted) {
		this.lastidinserted = lastidinserted;
	}

	private void listAll() {
		executionTests = getPersistence().listAllOrderBy("id");
	}

	public String recoveryItemList(String value){
		String description = "";
		for (int i = 0; i < listSize; i++) {
			if(list.get(i).getId() == Integer.parseInt(value)){
				description = list.get(i).getDescriptionsteps();
			}
		}
		return description;
	}
//	public void execute(){
//		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
//		String css = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("css");
//		listTemp.clear();
//		if(value.equals("52")){
//			for (int i = 52; i < 55; i++) {
//				t = new Testcase();
//				t.setOrderworkflow(css);
//				t.setDescriptionsteps(recoveryItemList(String.valueOf(i)));
//				t.setId(i);
//				idTest = Integer.parseInt(value);
//				listTemp.add(t);
//			}
//			System.out.println(listTemp.size());
//		}else{
//			t = new Testcase();
//			t.setOrderworkflow(css);
//			t.setDescriptionsteps(recoveryItemList(value));
//			t.setId(Integer.parseInt(value));
//			idTest = Integer.parseInt(value);
//			listTemp.add(t);
//		}
//	}

	public void executeFirst(){
		if(indice == 0){
			t = new Testcase();
			t.setId(list.get(indice).getId());
			idTest = list.get(indice).getId();
			System.out.println(idTest);
			t.setDescriptionsteps(list.get(indice).getDescriptionsteps());
			System.out.println("first"+indice);
			enableStart = true;
			enableNext = false;
			enablePrev = true;
		}
		else{
			new MessageBean().error();
		}
	}

	public void executeNext(){
		indice++;
		System.out.println(indice+" antes");
		if(indice <= listSize & indice > 0){
			if(indice == listSize - 1){
				t = new Testcase();
				t.setId(list.get(indice).getId());
				idTest = list.get(indice).getId();
				t.setDescriptionsteps(list.get(indice).getDescriptionsteps());
				System.out.println("nextif="+indice);
				enableFinish = false;
				enableNext = true;
			}else{
				t = new Testcase();
				t.setId(list.get(indice).getId());
				idTest = list.get(indice).getId();
				t.setDescriptionsteps(list.get(indice).getDescriptionsteps());
				System.out.println("nextif!="+indice);
				enableNext = false;
				enablePrev = false;
				enableFinish = true;
			}
		}else{
			new MessageBean().error();
	}
}

public void executePrevious(){
	indice--;
	if(indice < listSize & indice > 0){
		t = new Testcase();
		t.setId(list.get(indice).getId());
		idTest = list.get(indice).getId();
		t.setDescriptionsteps(list.get(indice).getDescriptionsteps());
		System.out.println("previous"+indice);
		enableNext = false;
		enableFinish = true;
	}else{
		if(indice == 0){
			enablePrev = true;
		}
		new MessageBean().error();
	}
}

public List<Executiontest> autoComplete(String query) {
	List<Executiontest> suggestions = new ArrayList<Executiontest>();
	for (Executiontest c : executionTests) {
		if (String.valueOf(c.getId()).toLowerCase().startsWith(query.toLowerCase())) {
			suggestions.add(c);
		}
	}
	return suggestions;
}
public void adjustSave() {
	executionTest.setStartdatatime(new UtilBean().formatDate(new Date()));
	executionTest.setStarttime(new UtilBean().formatHour(new Date()));
	executionTest.setFinishdatatime("");
	executionTest.setFinishtime("");
	enableStart = false;
	enableGettingStart = true;
	enableGenerate = true;
}
public void adjustUpdate() {
	executionTest.setFinishdatatime(new UtilBean().formatDate(new Date()));
	executionTest.setFinishtime(new UtilBean().formatHour(new Date()));
	enableStart = true;
	enableGenerate = false;
	enableFinish = true;
	enablePrev = true;

}
public String save() {
	try {
		adjustSave();
		lastidinserted = getPersistence().savereturn(executionTest);
		listAll();
		new MessageBean().success();
	} catch (Exception e) {
		new MessageBean().error();
	}
	return "/execution/manager";
}

public String update() {
	try {
		adjustUpdate();
		getPersistence().update(executionTest);
		listAll();
		new MessageBean().success();
	} catch (Exception e) {
		new MessageBean().error();
	}
	return "/execution/manager";
}
public void delete() {
	try {
		getPersistence().delete(executionTest);
		listAll();
		new MessageBean().success();
	} catch (Exception e) {
		new MessageBean().error();
	}
}
}