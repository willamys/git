package bean;

import dao.TestCaseDAOImpl;
import dao.TestCaseSetupDAO;
import dao.TestCaseSetupDAOImpl;
import entity.Testcase;
import entity.Testcasesetup;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author 
 */
@ManagedBean
@ViewScoped
public class TestCaseBean {

    private Testcase testcase = new Testcase();
    private List<Testcase> testCases;
    public TestCaseBean() {
    	//listAll();
    }

    private TestCaseDAOImpl getPersistence() {
        return new TestCaseDAOImpl();
    }

    public Testcase getTestcase() {
        return testcase;
    }

    public void setTestcase(Testcase testcase) {
        this.testcase = testcase;
    }

    public List<Testcase> getTestCases() {
    	testCases = new ArrayList<Testcase>();
    	testCases = getPersistence().listAllOrderBy("orderworkflow");
        return testCases;
    }

    public void setTestCases(List<Testcase> testCases) {
        this.testCases = testCases;
    }

    private void listAll() {
        testCases = getPersistence().listAllOrderBy("orderworkflow");
    }

    public List<Testcase> autoComplete(String query) {
        List<Testcase> suggestions = new ArrayList<Testcase>();
        for (Testcase c : testCases) {
            if (c.getTestcasename().toLowerCase().startsWith(query.toLowerCase())) {
                suggestions.add(c);
            }
        }
        return suggestions;
    }
    
    public void adjustSave() {
        testcase.setId(testcase.getId());
        testcase.setDescriptionsteps(testcase.getDescriptionsteps());
        testcase.setTestcasename(testcase.getTestcasename());
        testcase.setOrderworkflow(testcase.getOrderworkflow());
        Testcasesetup tsetup = new Testcasesetup();
    	tsetup.setNote("note");
    	tsetup.setDescriptionsetup("description");
    	
        testcase.setTestcasesetup(tsetup);
        tsetup.setTestcase(testcase);
    }
    
  public void adjustUpdate() {
        testcase.setId(testcase.getId());
        testcase.setDescriptionsteps(testcase.getDescriptionsteps());
        testcase.setTestcasename(testcase.getTestcasename());
        testcase.setOrderworkflow(testcase.getOrderworkflow());
    }
    
    public String save() {
        try {
            adjustSave();
            getPersistence().save(testcase);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "manager";
    }

    public String update() {
        try {
            adjustUpdate();
            getPersistence().update(testcase);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "manager";
    }

    public void delete() {
        try {
            getPersistence().delete(testcase);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
    }
}
