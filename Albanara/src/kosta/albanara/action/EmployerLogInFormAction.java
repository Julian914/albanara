package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployerLogInFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�α������׼� �������ϴ礷��");
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false); 
		forward.setPath("/employerLogInForm.jsp");
		return forward;
	}

}
