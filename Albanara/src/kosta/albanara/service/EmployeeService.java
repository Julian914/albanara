package kosta.albanara.service;

import kosta.albanara.dao.EmployeeDao;
import kosta.albanara.model.Resumes;

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
	
	public int insertResumeService(Resumes resume){
		return employeeDao.insertResume(resume);
	}
	
	public Resumes searchResumeService(int employeeSeq) {
		return employeeDao.searchResume(employeeSeq);
	}
	
	
	
	
}
