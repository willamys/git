package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import dao.TestCaseDAOImpl;

import entity.Testcase;
import entity.Testcasesetup;

public class TestCaseBeanTest {

	Testcase testCase;
	TestCaseDAOImpl testDao;
	Testcasesetup tSetup;
	@Before
	public void setUp() throws Exception {
		testCase = new Testcase();
		tSetup  = new Testcasesetup();
		testDao =  new TestCaseDAOImpl();
	}

	@Test
	public void test() {
		testCase.setId(1);
		testCase.setOrderworkflow(1);
		testCase.setTestcasename("Teste 1");
		testCase.setDescriptionsteps("Description of the test");
		
		tSetup.setDescriptionsetup("descriptionsetup");
		tSetup.setNote("note");
		
		testCase.setTestcasesetup(tSetup);
		tSetup.setTestcase(testCase);
		Assert.assertEquals(1, Integer.parseInt(testDao.savereturn(testCase).toString()));
	}
	@Test
	public void test2() {
		testCase.setId(2);
		testCase.setOrderworkflow(2);
		testCase.setTestcasename("Teste 2");
		testCase.setDescriptionsteps("Description of the test 2");
		
		tSetup.setDescriptionsetup("descriptionsetup 2");
		tSetup.setNote("note 2");
		
		testCase.setTestcasesetup(tSetup);
		tSetup.setTestcase(testCase);
		Assert.assertEquals(2, Integer.parseInt(testDao.savereturn(testCase).toString()));
	}
	@Test
	public void test3() {
		testCase.setId(3);
		testCase.setOrderworkflow(3);
		testCase.setTestcasename("Teste 3");
		testCase.setDescriptionsteps("Description of the test 3");
		
		tSetup.setDescriptionsetup("descriptionsetup 3");
		tSetup.setNote("note 3");
		testCase.setTestcasesetup(tSetup);
		tSetup.setTestcase(testCase);
		Assert.assertEquals(3, Integer.parseInt(testDao.savereturn(testCase).toString()));
	}

	
}
