package bean;


import dao.TestCaseSetupDAOImpl;
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
public class TestCaseSetupBean {

    private Testcasesetup testCaseSetup = new Testcasesetup();
    private List<Testcasesetup> testCaseSetups;

    public TestCaseSetupBean() {
        //listAll();
    }

    private TestCaseSetupDAOImpl getPersistence() {
        return new TestCaseSetupDAOImpl();
    }

    public Testcasesetup getTestCaseSetup() {
        return testCaseSetup;
    }

    public void setTestCaseSetup(Testcasesetup testCaseSetup) {
        this.testCaseSetup = testCaseSetup;
    }

    public List<Testcasesetup> getTestCaseSetups() {
    	testCaseSetups = new ArrayList<Testcasesetup>();
    	testCaseSetups = getPersistence().listAllOrderBy("descriptionsetup");
        return testCaseSetups;
    }

    public void setTestCaseSetups(List<Testcasesetup> testCaseSetups) {
        this.testCaseSetups = testCaseSetups;
    }

    private void listAll() {
        testCaseSetups = getPersistence().listAllOrderBy("descriptionsetup");
    }

    public List<Testcasesetup> autoComplete(String query) {
        List<Testcasesetup> suggestions = new ArrayList<Testcasesetup>();
        for (Testcasesetup c : testCaseSetups) {
            if (c.getDescriptionsetup().toLowerCase().startsWith(query.toLowerCase())) {
                suggestions.add(c);
            }
        }
        return suggestions;
    }
    
    public void adjust() {
        testCaseSetup.setDescriptionsetup(testCaseSetup.getDescriptionsetup().toLowerCase());
        testCaseSetup.setNote(testCaseSetup.getNote().toLowerCase());
    }
    
    public String save() {
        try {
            adjust();
            getPersistence().save(testCaseSetup);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "manager";
    }

    public String update() {
        try {
            adjust();
            getPersistence().update(testCaseSetup);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
        return "manager";
    }

    public void delete() {
        try {
            getPersistence().delete(testCaseSetup);
            listAll();
            new MessageBean().success();
        } catch (Exception e) {
            new MessageBean().error();
        }
    }
}

