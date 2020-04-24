package kosta.albanara.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import kosta.albanara.dao.EmployerDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;

public class EmployerService {
	public static EmployerService instance;
	public static EmployerDao employerDao;

	public static EmployerService getInstance() {
		if (instance == null) {
			employerDao = EmployerDao.getInstance();
			instance = new EmployerService();
		}
		return instance;
	}

	public int insertEmployerService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");

		String employerId = request.getParameter("employerId");
		String employerPw = request.getParameter("employerPw");
		String employerName = request.getParameter("employerName");
		String employerNumber = request.getParameter("employerNo1") + "-" + request.getParameter("employerNo2") + "-"
				+ request.getParameter("employerNo3");
		String employerAddress = request.getParameter("employerAddress");
		String employerHomepage = request.getParameter("employerHomepage");
		String employerField = request.getParameter("employerField");
		String ownerName = request.getParameter("ownerName");
		String ownerPhoneNo = request.getParameter("ownerPhoneNo1") + request.getParameter("ownerPhoneNo2")
				+ request.getParameter("ownerPhoneNo3");

		System.out.println("employerId");
		System.out.println("employerPw");
		System.out.println("employerName");
		System.out.println("employerNumber");
		System.out.println("employerAddress");
		System.out.println("employerHomepage");
		System.out.println("employerField");
		System.out.println("ownerName");
		System.out.println("ownerPhoneNo");

		Employers employers = new Employers(employerId, employerPw, employerName, employerNumber, employerAddress,
				employerHomepage, employerField, ownerName, ownerPhoneNo);

		return employerDao.insertEmployer(employers);

	}
}
