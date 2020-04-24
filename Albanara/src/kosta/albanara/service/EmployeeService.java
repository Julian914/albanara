package kosta.albanara.service;



import java.sql.Date;

import javax.servlet.http.HttpServletRequest;


import kosta.albanara.dao.EmployeeDao;
import kosta.albanara.model.Employees;

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
	
	public int insertEmployeeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String employeeId = request.getParameter("employeeId");
		String employeePw = request.getParameter("employeePw");
		String employeeName = request.getParameter("employeeName");
		Date employeeBirthday = Date.valueOf(request.getParameter("employeeBirthYear")+"-"+request.getParameter("employeeBirthMonth")+"-"+request.getParameter("employeeBirthDay"));
		String employeeEmail = request.getParameter("employeeEmailInput1")+request.getParameter("employeeEmailInput2");
		String employeeGender = request.getParameter("employeeGender");
		String employeePhone = request.getParameter("employeePhone1")+request.getParameter("employeePhone2")+request.getParameter("employeePhone3");
		String employeeAddress = request.getParameter("employeeAddress");
		
		/*
		 * String employeeId = "ID"; String employeePw = "Password"; String employeeName
		 * = "이름"; Date employeeBirthday = Date.valueOf("1992-05-11"); String
		 * employeeEmail = "employeeEmailInput1"+"employeeEmailInput2"; String
		 * employeeGender = "여자"; String employeePhone = "010"+"2785"+"1111"; String
		 * employeeAddress ="서울";
		 */
		
		
		
		Employees employees = new Employees(employeeId, employeePw, employeeName, employeeBirthday, employeeEmail, employeeGender, employeePhone, employeeAddress);
		
		return employeeDao.insertEmployee(employees);
		
	}
}
