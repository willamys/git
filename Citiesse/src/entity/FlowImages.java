package entity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FlowImages {

	private String [] firstline;
	private String [] secondline;
	private String [] thirdline;
	private String [] fourline;
	private String [] fiveline;
	private String [] sixline;
	private String [] sevenline;
	private String [] eightline;
	private String [] nineline;
	private String [] tenline;
	
	public String[] getFirstline(){
		firstline = new String[]{"first_1","_68","first_3","first_4"};
		return firstline;
	}
	
	public String[] getSecondline(){
		secondline = new String[]{"second_1","_266","second_3","second_4"};
		return secondline;
	}
	
	public String[] getThirdline(){
		thirdline = new String[]{"_66","_64","_65","_56"};
		return thirdline;
	}
	
	public String[] getFourline(){
		fourline = new String[]{"_52","_71","_73","_67"};
		return fourline;
	}
	public String[] getFiveline(){
		fiveline = new String[]{"five_1","five_2","five_3","five_4"};
		return fiveline;
	}
	public String[] getSixline(){
		sixline = new String[]{"_55","_69","_46","_36"};
		return sixline;
	}
	public String[] getSevenline(){
		sevenline = new String[]{"1","2","3","4"};
		return sevenline;
	}
	public String[] getEightline(){
		eightline = new String[]{"1","2","3","4"};
		return eightline;
	}
	public String[] getNineline(){
		nineline = new String[]{"1","2","3","4"};
		return nineline;
	}
	public String[] getTenline(){
		tenline = new String[]{"1","2","3","4"};
		return tenline;
	}
}
