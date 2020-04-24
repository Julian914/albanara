package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;
import kosta.albanara.service.MarkerLocationService;

public class EmployerSignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance(); 
		MarkerLocationService markerLocationService = MarkerLocationService.getInstance();
		markerLocationService.insertMarkerLocation(request);
		service.insertEmployerService(request);		
		
		
		forward.setRedirect(true); 
		forward.setPath("employerSignUpForm.do");
		
		return forward;
	}

}
