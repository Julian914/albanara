package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;

public class EmployeeUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		
		forward.setRedirect(false); 
		forward.setPath("/employeeUpdateForm.jsp");
		
		return forward;
	}

}
