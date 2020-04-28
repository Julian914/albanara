package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employers;
import kosta.albanara.service.EmployerService;

public class EmployerDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance(); 
		
		
		/* String employerId = request.getParameter("employerId"); */
		String employerId = "aaaa"; //임의로 준 아이디
		
		Employers employer = service.detailEmployerService(employerId);
		request.setAttribute("employers", employer);
		System.out.println("액션" + employer.getEmployerId());
		
		forward.setRedirect(false);
		forward.setPath("/employerPage.jsp");
		return forward;
	
	}

}
