package net.thomasmaestas.java.bean0;
 
import java.util.List;
 
public class Department {
	private String nameId;
	private String deptId; 
	private Title deptHead;
	
	private List<Title> titles;

	public Title getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(Title deptHead) {
		this.deptHead = deptHead;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("DeptHead: " + deptHead);
		sb.append("\n");
		sb.append("Others:\n");
		
		for(Title title: titles) {
			sb.append(title);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
