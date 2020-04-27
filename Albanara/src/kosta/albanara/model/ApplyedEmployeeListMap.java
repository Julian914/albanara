package kosta.albanara.model;

import java.util.List;

public class ApplyedEmployeeListMap {
	private int key;
	private List<Employees> employeeList;
	
	
	public ApplyedEmployeeListMap() {};
	
	
	public ApplyedEmployeeListMap(int key, List<Employees> employeeList) {
		super();
		this.key = key;
		this.employeeList = employeeList;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public List<Employees> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employees> employeeList) {
		this.employeeList = employeeList;
	}
	
	

}
