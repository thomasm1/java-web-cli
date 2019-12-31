package net.thomasmaestas.java.bean0;

import java.util.HashMap;
import java.util.Map;

public class Task {
	private String nameId;
	private String titleId; 

	private Map<String, Title> titles = new HashMap<String, Title>();
	 
	public void setTitles(Map<String, Title> titles) {
		this.titles = titles;
	}
	public String getNameId() {
		return nameId;
	}
	public void setNameId(String nameId) {
		this.nameId = nameId;
	}
	public String getDeptId() {
		return titleId;
	}
	public void setDeptId(String titleId) {
		this.titleId = titleId;
	}
//	public Map<String, Title> getTitles() {
//		return titles;
//	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	 
		
		for(Map.Entry<String, Title> entry: titles.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		return  "Reimbursements="+ sb.toString()  ;
	}
}
