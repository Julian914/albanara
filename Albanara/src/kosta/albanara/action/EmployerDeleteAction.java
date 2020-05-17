package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kosta.albanara.model.Employer;
import kosta.albanara.service.EmployerService;

public class EmployerDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance(); 
		
		Employer employer = new Employer();
		
		employer.setEmployerId(request.getParameter("employerId"));
		service.deleteEmployerService(employer);
		
		System.out.println(request.getParameter("employerId")+"�׼�");
		
		
		forward.setRedirect(true); 
		forward.setPath("employerLogIn.do");
		return forward;
	}

}
