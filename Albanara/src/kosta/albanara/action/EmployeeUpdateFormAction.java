package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.service.EmployeeService;

public class EmployeeUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id"));
		
		System.out.println("테스트1");
		forward.setRedirect(false); 
		forward.setPath("/login/employeeUpdateForm.jsp");
		
		return forward;
	}

}
