package kosta.albanara.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import kosta.albanara.action.ActionForward;
import kosta.albanara.dao.EmployerDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.Recruitments;

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
		System.out.println("기업seq : " + employerSeq);
		return employerDao.detailEmployers(employerSeq);

	}
	
	/* 기업에 지원한 남자 수 */
	public int selectEmployerManCount(int seq) {
		return employerDao.selectEmployerManCount(seq);
	}
	
	/* 기업에 지원한 여자 수 */
	public int selectEmployerWomanCount(int seq) {
		return employerDao.selectEmployerWomanCount(seq);
	}
	
	/* 채용자들 위치 구하기 */
	public List<MarkerLocation> selectHireMap(int seq) {
		return employerDao.selectHireMap(seq);
	}
	
	
	
	
	//기업의 전체 공고목록
	public List<Recruitments> recruitmentListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		//int employerSeq = Integer.parseInt(request.getParameter("seq"));
		int employerSeq =1;
		
		List<Recruitments> list = employerDao.totalRecruitmentList(employerSeq);
		return list;
	}
	// 기업의 진행중인 공고목록
	public List<Recruitments> nowRecruinmentListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		//int employerSeq = Integer.parseInt(request.getParameter("seq"));
		int employerSeq =1;
		List<Recruitments> list =  employerDao.nowRecruinmentList(employerSeq);
		return list;
	}

		//기업의 마감된 공고목록
	public List<Recruitments> endRecruitmentListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		//int employerSeq = Integer.parseInt(request.getParameter("seq"));
		int employerSeq =1;
		List<Recruitments> list =  employerDao.nowRecruinmentList(employerSeq);
		return list;
	}
	
	
	// 한 공고에 해당하는 지원자목록	
	public List<Employees> employeeListService(int recruitmentSeq) throws Exception {
		List<Employees> employeeList = employerDao.employeeList(recruitmentSeq);
		return employeeList;
	}

	//공고에 채용된 지원자 목록
	public List<Employees> hiredEmployeeListService()throws Exception{
		return employerDao.hiredEmployeeList();
	}
	

	
	
	
}
