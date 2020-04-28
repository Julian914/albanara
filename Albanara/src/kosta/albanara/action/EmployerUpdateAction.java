package kosta.albanara.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;

public class EmployerUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance(); 
		
		Employers employer = new Employers();
		
		employer.setEmployerId(request.getParameter("employerId"));
		employer.setEmployerPw(request.getParameter("employerPw"));
		employer.setEmployerName(request.getParameter("employerName"));
		employer.setEmployerNumber(request.getParameter("employerNo1") + "-" + request.getParameter("employerNo2") + "-"
				+ request.getParameter("employerNo3"));
		employer.setEmployerAddress(request.getParameter("employerAddress"));
		employer.setEmployerHomepage(request.getParameter("employerHomePage"));
		employer.setEmployerField(request.getParameter("employerField"));
		employer.setOwnerName(request.getParameter("ownerName"));
		employer.setOwnerPhone(request.getParameter("ownerPhoneNo1")+request.getParameter("ownerPhoneNo2")+request.getParameter("ownerPhoneNo3"));
		
		
		if(service.updateEmployerService(employer) == 1) {
			System.out.println("����");
			forward.setRedirect(true); 
			forward.setPath("UpdateEmployersForm.do");
			return forward;
		}else {
			System.out.println("����");
			forward.setRedirect(true); 
			forward.setPath("UpdateEmployersForm.do");
			return forward;
		}
	}
	

}
