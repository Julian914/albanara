package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployerUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		System.out.println("폼액션"+session.getAttribute("id"));
		
		forward.setRedirect(false); 
		forward.setPath("/login/employerUpdateForm.jsp");
		
		return forward;
	}

}
