package kosta.albanara.service;

import kosta.albanara.dao.EmployeeDao;

public class EmployeeService {
	public static EmployeeService instance;
	public static EmployeeDao employeeDao;

	public static EmployeeService getInstance() {
		if (instance == null) {
			employeeDao = EmployeeDao.getInstance();
			return new EmployeeService();
		}
		return instance;
	}
}
