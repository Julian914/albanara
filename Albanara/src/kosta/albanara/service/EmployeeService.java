package kosta.albanara.service;



import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import kosta.albanara.dao.EmployeeDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;
import kosta.albanara.model.Resumes;
import sun.rmi.transport.proxy.HttpReceiveSocket;

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
		 * = "占싱몌옙"; Date employeeBirthday = Date.valueOf("1992-05-11"); String
		 * employeeEmail = "employeeEmailInput1"+"employeeEmailInput2"; String
		 * employeeGender = "占쏙옙占쏙옙"; String employeePhone = "010"+"2785"+"1111"; String
		 * employeeAddress ="占쏙옙占쏙옙";
		 */

		Employees employee = new Employees(employeeId, employeePw, employeeName, employeeBirthday, employeeEmail,
				employeeGender, employeePhone, employeeAddress);

		return employeeDao.insertEmployee(employee);
	}
	
	public int insertResumeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		//占쏙옙占싹억옙占싸듸옙(占쏙옙占�, 占쏙옙占쏙옙크占쏙옙, 占쏙옙占쌘듸옙, 占쏙옙占쏙옙占싱몌옙占쏙옙첩 占쏙옙책)
		String uploadPath = request.getRealPath("upload/resumePicture");
		int size = 20 * 1024 * 1024;		//20MB
		
		//占쏙옙占싹억옙占싸듸옙 占쏙옙占쏙옙占쏙옙트占쏙옙 처占쏙옙占쏙옙占쌍댐옙 API(占쎌리占쏙옙 tomcat占쏙옙 占쏙옙占쏙옙 cos.jar占쏙옙 占쌍댐옙). 占쏙옙 占쏙옙체占쏙옙 request 占쏙옙체占쏙옙 占쏙옙占쏙옙 占쌍억옙占쌔댐옙. 占쌓뤄옙占쏙옙 request占쏙옙占� multi占쏙옙 占쌍억옙占쌔댐옙.
		MultipartRequest multi =		
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		
		
		String resumeTitle = multi.getParameter("resumeTitle");
		String resumeContents = multi.getParameter("resumeContents");
		String desiredWorkingArea = multi.getParameter("desiredWorkingArea");
		String favoriteField = multi.getParameter("favoriteField");
		String pictureFilename = (String)multi.getFilesystemName("pictureFilename");
		
		
		
		/*
		//占쏙옙占싹억옙占싸듸옙 占쏙옙 DB占쏙옙 占쏙옙占쏙옙占싱몌옙 占쏙옙占쏙옙占싹댐옙 占쏙옙
				if(multi.getFilesystemName("pictureFilename") != null) {		//占쌔쇽옙 : 占쏙옙占쏙옙占쏙옙 占쏙옙占싸듸옙 占쏙옙占쏙옙 占쏙옙
				String pictureFilename = (String)multi.getFilesystemName("pictureFilename");
				

				}
		*/
		
		Resumes resume = new Resumes(pictureFilename, resumeTitle, resumeContents, desiredWorkingArea, favoriteField);
	System.out.println(resume.toString());
		
		return employeeDao.insertResume(resume);
	}

	public Resumes searchResumeService(int employeeSeq)throws Exception {
	System.out.println(employeeSeq);
		return employeeDao.searchResume(employeeSeq);
	}

	
	public int updateResumeService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		String uploadPath = request.getRealPath("upload/resumePicture");
		int size = 20 * 1024 * 1024;
		
		MultipartRequest multi =
				new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//String resumeSeq = multi.getParameter("resumeSeq");
		String resumeTitle = multi.getParameter("resumeTitle");
		String resumeContents = multi.getParameter("resumeContents");
		String desiredWorkingArea = multi.getParameter("desiredWorkingArea");
		String pictureFilename = (String)multi.getFilesystemName("pictureFilename");
		String favoriteField = multi.getParameter("favoriteField");
		
		Resumes resume = new Resumes(pictureFilename, resumeTitle, resumeContents, desiredWorkingArea, favoriteField);
		
	System.out.println(resume.toString());
		
		return employeeDao.updateResume(resume);
	}

	public Employees getEmployee(int seq) {
		return employeeDao.getEmployee(seq);
	}
	

	public int updateEmployeeService(Employees employee) throws Exception{
		
		return employeeDao.updateEmployee(employee);
	}
	
	public int deleteEmployeeService(Employees employee) throws Exception{
		
		
		return employeeDao.deleteEmployee(employee);
	}
	
public Employees employeeLogInService(HttpServletRequest request) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		Employees employee = new Employees();
		Employees login = new Employees();
	      
		employee.setEmployeeId(request.getParameter("employeeLogInId"));
		employee.setEmployeePw(request.getParameter("employeeLogInPw"));
		
	      login = employeeDao.employeeLogIn(employee);
	      
	      if(login==null) {
	    	  System.out.println("�α��� ����");
	    	  return null;
//	    	  ActionForward forward = new ActionForward();
//	    	    forward.setRedirect(false); 
//	  			forward.setPath("/employerLogInForm.jsp");
	    	 
	      }else if(login.getEmployeeId().equals(employee.getEmployeeId()) && login.getEmployeePw().equals(employee.getEmployeePw())) {
	    	  
	    	  System.out.println("로그인성공");
	    	  HttpSession session = request.getSession();
	    	  
	    	  session.setAttribute("id",login.getEmployeeId());
	    	  session.setAttribute("seq", login.getEmployeeSeq());
	    	  
	    	  System.out.println(session.getAttribute("id"));
	    	  /*String employerId = (String)session.getAttribute("login");*/
	    	
	      }
		return login;
	}
public void logOut(HttpServletRequest request) throws Exception{
	
	HttpSession session = request.getSession();
	session.invalidate();
	System.out.println("로그아웃");
		
	}

}
