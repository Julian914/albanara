package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;

public class UpdateResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
		System.out.println("updateAction");
		
		service.updateResumeService(request);
		
		
		actionForward.setRedirect(false);
		actionForward.setPath("/index.jsp");
		
		return actionForward;
	}

}
