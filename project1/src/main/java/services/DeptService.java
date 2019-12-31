package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import db.DB;
import models.Dept; 

public class DeptService {

	public static Dept getDept(int id) {
		return DB.depts.get(id);
	} 
	
	public static Dept addDept(Dept d) { 
		 DB.depts.put(d.getDeptId(), d);
		return null;
	}
	public static  List<Dept> listDept() {  
		List<Dept> dailyList = new ArrayList<Dept>();
		Set<Integer> keys = DB.depts.keySet();
		for(Integer k: keys)
			dailyList.add(DB.depts.get(k));
		return dailyList;
	}
	
}
