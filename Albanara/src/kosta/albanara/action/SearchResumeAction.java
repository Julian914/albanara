package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Resumes;
import kosta.albanara.service.EmployeeService;

public class SearchResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
		//구직자 seq 던지면 그 사람의 이력서가 나오게 하는 방법 (하지만 
		int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		Resumes resume = service.searchResumeService(employeeSeq);
		
		request.setAttribute("Resume", resume);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/searchResumeForm.jsp");
		
		return actionForward;
	}

}
