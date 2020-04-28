package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.MarkerLocationService;

public class EmployeeSignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeService employeeService = EmployeeService.getInstance(); 
		MarkerLocationService markerService = MarkerLocationService.getInstance();
		
		employeeService.insertEmployeeService(request);		
		markerService.insertMarkerLocation(request);

		forward.setRedirect(true); 
		forward.setPath("employeeSignUpForm.do");
		
		return forward;
	}

}
