package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;

public class logOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeService service = EmployeeService.getInstance(); 
		
		service.logOut(request);;
		forward.setRedirect(false); 
		forward.setPath("/index.jsp");
		
		return forward;
	}

}
