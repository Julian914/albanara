package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;

public class UpdateResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
		
		service.updateResumeService(request);
		System.out.println("command");
		
		actionForward.setRedirect(false);
		actionForward.setPath("/resumetotal.jsp");
		
		return actionForward;
	}

}
