package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateResumeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		
		System.out.println("updateForm");
		
		actionForward.setRedirect(false);
		actionForward.setPath("/updateResumeForm.jsp");
		
		return actionForward;
	}

}
