package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.HyunMapService;

public class EmployeeSignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeService service = EmployeeService.getInstance(); 
		service.insertEmployeeService(request);		

		
		forward.setRedirect(true); 
		forward.setPath("employeeSignUpForm.do");
		
		return forward;
	}

}
