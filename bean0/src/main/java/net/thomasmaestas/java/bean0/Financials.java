package net.thomasmaestas.java.bean0;
  
import java.util.HashMap;
import java.util.Map;

public class Financials {
	
	private Map<String, String> requests = new HashMap<String, String>();
	private Map<String, Reimburse> reimburses = new HashMap<String, Reimburse>();
	
	public void setRequests(Map<String, String> requests) {
		this.requests = requests;
	}

	public void setReimburses(Map<String, Reimburse> reimburses) {
		this.reimburses = reimburses;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Map.Entry<String, String> entry: requests.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		sb.append("\n");
		
		for(Map.Entry<String, Reimburse> entry: reimburses.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
		}
		
		return sb.toString();
	}
	
	
}
