package kosta.albanara.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employee;
import kosta.albanara.model.Employer;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;

public class EmployerUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance(); 
		
		Employer employer = new Employer();
		HttpSession session = request.getSession();
		System.out.println("dd"+session.getAttribute("id"));
		
		employer.setEmployerId(request.getParameter("employerId"));
		employer.setEmployerPw(request.getParameter("employerPw"));
		employer.setEmployerAddress(request.getParameter("employerAddress"));
		employer.setEmployerHomepage(request.getParameter("employerHomePage"));
		employer.setOwnerName(request.getParameter("ownerName"));
		employer.setOwnerPhone(request.getParameter("ownerPhoneNo1")+request.getParameter("ownerPhoneNo2")+request.getParameter("ownerPhoneNo3"));
		
		
		if(service.updateEmployerService(employer) == 1) {
			System.out.println("오잉");
			forward.setRedirect(true); 
			forward.setPath("UpdateEmployersForm.do");
			return forward;
		}else {
			System.out.println("오잉");
			forward.setRedirect(true); 
			forward.setPath("UpdateEmployersForm.do");
			return forward;
		}
	}
	

}
