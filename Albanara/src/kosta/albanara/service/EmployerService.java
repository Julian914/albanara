package kosta.albanara.service;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import kosta.albanara.action.ActionForward;
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
		String employerHomePage = request.getParameter("employerHomePage");
		String employerField = request.getParameter("employerField");
		String ownerName = request.getParameter("ownerName");
		String ownerPhone = request.getParameter("ownerPhoneNo1")+request.getParameter("ownerPhoneNo2")+request.getParameter("ownerPhoneNo3");
		
		Employers employers = new Employers(employerId, employerPw, employerName, employerNumber, employerAddress, employerHomePage, employerField, ownerName, ownerPhone);
				
				
		return employerDao.insertEmployer(employers);

	}
	
	public Employers employerLogInService(HttpServletRequest request) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		Employers employer = new Employers();
		Employers login = new Employers();
	      
		employer.setEmployerId(request.getParameter("employerLogInId"));
		employer.setEmployerPw(request.getParameter("employerLogInPw"));
		
	      login = employerDao.employerLogIn(employer);
	      
	      if(login==null) {
	    	  System.out.println("�α��� ����");
	    	  return null;
//	    	  ActionForward forward = new ActionForward();
//	    	    forward.setRedirect(false); 
//	  			forward.setPath("/employerLogInForm.jsp");
	    	 
	      }else if(login.getEmployerId().equals(employer.getEmployerId()) && login.getEmployerPw().equals(employer.getEmployerPw())) {
	    	 System.out.println("로그인성공");
	   
	    	  HttpSession session = request.getSession();
	    	  
	    	  session.setAttribute("id",login.getEmployerId());
	    	  session.setAttribute("seq", login.getEmployerSeq());
	    	  
	    	  System.out.println(session.getAttribute("id"));
	    	  
	    	  session.setAttribute("login",login);
	    	  /*String employerId = (String)session.getAttribute("login");*/
	    	
	      }
		return login;
	}
	
	public int updateEmployerService(Employers employer) throws Exception{
		
		System.out.println(employer.getEmployerId());
		System.out.println(employer.getEmployerName());
		
		
		return employerDao.updateEmployer(employer);
	}
	
	public int deleteEmployerService(Employers employer) throws Exception{
		
		
		return employerDao.deleteEmployer(employer);
	}
	
	public Employers detailEmployerService(int employerSeq) throws Exception{
		System.out.println("����" + employerSeq);
		return employerDao.detailEmployers(employerSeq);
	}
	
}
