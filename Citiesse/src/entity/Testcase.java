package entity;

// Generated May 11, 2012 3:56:49 AM by Hibernate Tools 3.2.1.GA

/**
 * Testcase generated by hbm2java
 */
public class Testcase implements java.io.Serializable {

	private Integer id;
	private String descriptionsteps;
	private String testcasename;
	private Testcasesetup testcasesetup;
	private int orderworkflow;

	public int getOrderworkflow() {
		return orderworkflow;
	}

	public void setOrderworkflow(int orderworkflow) {
		this.orderworkflow = orderworkflow;
	}

	public Testcasesetup getTestcasesetup() {
		return testcasesetup;
	}

	public void setTestcasesetup(Testcasesetup testcasesetup) {
		this.testcasesetup = testcasesetup;
	}

	public Testcase() {
	}

	public Testcase(Integer id) {
		this.id = id;
	}
	
	public Testcase(Integer id,String descriptionsteps, String testcasename, Testcasesetup testcasesetup, int orderworkflow) {
		this.id = id;
		this.descriptionsteps = descriptionsteps;
		this.testcasename = testcasename;
		this.testcasesetup = testcasesetup;
		this.orderworkflow = orderworkflow;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescriptionsteps() {
		return this.descriptionsteps;
	}

	public void setDescriptionsteps(String descriptionsteps) {
		this.descriptionsteps = descriptionsteps;
	}

	public String getTestcasename() {
		return this.testcasename;
	}

	public void setTestcasename(String testcasename) {
		this.testcasename = testcasename;
	}

}