package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;
import kosta.albanara.service.MarkerLocationService;

public class EmployeeLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeService employeeService = EmployeeService.getInstance();
		
		Employees employees = employeeService.employeeLogInService(request);
		if(employees != null) {
			MarkerLocationService markerService = MarkerLocationService.getInstance();
			MarkerLocation markerLocation = markerService.sessionAddressService(employees.getEmployeeAddress());
			
			HttpSession session = request.getSession();
	    	  
	    	session.setAttribute("id",employees.getEmployeeId());
	    	session.setAttribute("seq", employees.getEmployeeSeq());
	    	  
	    	System.out.println(session.getAttribute("id"));
			session.setAttribute("latitude", markerLocation.getLatitude());
	    	session.setAttribute("longitude", markerLocation.getLongitude());
	    	System.out.println(session.getAttribute("latitude"));
	    	System.out.println(session.getAttribute("longitude"));
		}

		
		forward.setRedirect(false);
		forward.setPath("/employeeLogInForm.jsp");
		// if������ �б� ���Ѽ� �̵�
		if (employees == null) {
			forward.setPath("/index.jsp");
		}
		return forward;
	}

}
