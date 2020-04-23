package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Resumes;
import kosta.albanara.service.EmployeeService;

public class SearchResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService();
		
		int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		Resumes resume = service.searchResumeService(employeeSeq);
		
		request.setAttribute("Resume", resume);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/searchResumeForm.jsp");
		
		return actionForward;
	}

}
