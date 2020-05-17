package kosta.albanara.model;

import java.util.List;

public class ApplyedEmployeeListMap {
	private int key;
	private List<Employee> employeeList;
	
	
	public ApplyedEmployeeListMap() {};
	
	
	public ApplyedEmployeeListMap(int key, List<Employee> employeeList) {
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
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	

}
