package kosta.albanara.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import kosta.albanara.dao.EmployeeDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Resumes;

public class EmployeeService {
	public static EmployeeService instance;
	public static EmployeeDao employeeDao;

	public static EmployeeService getInstance() {
		if (instance == null) {
			employeeDao = EmployeeDao.getInstance();
			instance = new EmployeeService();
		}
		return instance;
	}

	public int insertEmployeeService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		String employeeName = request.getParameter("employeeName");
		Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthYear") + "-"
				+ request.getParameter("employeeBirthMonth") + "-" + request.getParameter("employeeBirthDay"));
		String employeeEmail = request.getParameter("employeeEmailInput1")
				+ request.getParameter("employeeEmailInput2");
		String employeeGender = request.getParameter("employeeGender");
		String employeePhone = request.getParameter("employeePhone1") + request.getParameter("employeePhone2")
				+ request.getParameter("employeePhone3");
		String employeeAddress = request.getParameter("employeeAddress");

		String employeeLatitude = request.getParameter("latitude");
		String employeeLongitude = request.getParameter("longitude");
		

		/*
		 * String employeeId = "ID"; String employeePw = "Password"; String employeeName
		 * = "�̸�"; Date employeeBirthday = Date.valueOf("1992-05-11"); String
		 * employeeEmail = "employeeEmailInput1"+"employeeEmailInput2"; String
		 * employeeGender = "����"; String employeePhone = "010"+"2785"+"1111"; String
		 * employeeAddress ="����";
		 */

		Employees employees = new Employees(employeeId, employeePw, employeeName, employeeBirthday, employeeEmail,
				employeeGender, employeePhone, employeeAddress);

		return employeeDao.insertEmployee(employees);

	}

	public int insertResumeService(Resumes resume) {
		return employeeDao.insertResume(resume);
	}

	public Resumes searchResumeService(int employeeSeq) {
		return employeeDao.searchResume(employeeSeq);
	}

}
