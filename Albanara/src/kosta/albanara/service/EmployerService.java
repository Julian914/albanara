package kosta.albanara.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.albanara.dao.EmployerDao;
import kosta.albanara.model.Employee;
import kosta.albanara.model.Employer;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.Recruitment;

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
		
		Employer employers = new Employer(employerId, employerPw, employerName, employerNumber, employerAddress, employerHomePage, employerField, ownerName, ownerPhone);
				
				
		return employerDao.insertEmployer(employers);

	}
	
	public Employer employerLogInService(HttpServletRequest request) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		Employer employer = new Employer();
		Employer login = new Employer();
		
		employer.setEmployerId(request.getParameter("employerLogInId"));
		employer.setEmployerPw(request.getParameter("employerLogInPw"));
		

		login = employerDao.employerLogIn(employer);

	    if(login==null) {
	    	System.out.println("로그인 실패");
	    	return null;

	    	 
	    }else if(login.getEmployerId().equals(employer.getEmployerId()) && login.getEmployerPw().equals(employer.getEmployerPw())) {
	    	  

	    	System.out.println("로그인 성공");
	    	HttpSession session = request.getSession();
	    	session.setAttribute("id",login.getEmployerId());
	    	session.setAttribute("seq", login.getEmployerSeq());
	    	session.setAttribute("login", login);
	    	  
	    	System.out.println(session.getAttribute("id"));
	    	  
	    	session.setAttribute("login",login);
	    	/*String employerId = (String)session.getAttribute("login");*/

	    	
	    }
		return login;
	}
	
	public int updateEmployerService(Employer employer) throws Exception{
		
		System.out.println(employer.getEmployerId());
		
		return employerDao.updateEmployer(employer);
	}
	
	public int deleteEmployerService(Employer employer) throws Exception{
		
		
		return employerDao.deleteEmployer(employer);
	}
	
	public Employer detailEmployerService(int employerSeq) throws Exception{
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
	public List<Recruitment> recruitmentListService(int seq) throws Exception {
		List<Recruitment> list = employerDao.totalRecruitmentList(seq);
		return list;
	}
	// 기업의 진행중인 공고목록
	public List<Recruitment> nowRecruinmentListService(int seq) throws Exception {
		List<Recruitment> list =  employerDao.nowRecruinmentList(seq);
		return list;
	}

		//기업의 마감된 공고목록
	public List<Recruitment> endRecruitmentListService(int seq) throws Exception {
		List<Recruitment> list =  employerDao.endRecruitmentList(seq);
		return list;
	}	
	
}
