package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.EmployeeService;

public class InsertResumeForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		System.out.println("액션 테스트1: ");
		actionForward.setRedirect(false);
		actionForward.setPath("/insertResumeForm.jsp");
		
		return actionForward;
	}

}
