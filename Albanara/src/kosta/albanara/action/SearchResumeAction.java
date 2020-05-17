package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Resume;
import kosta.albanara.service.EmployeeService;

public class SearchResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
		//������ seq ������ �� ����� �̷¼��� ������ �ϴ� ��� (������ 
		//int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		int employeeSeq = 21;
		Resume resume = service.searchResumeService(employeeSeq);
		System.out.println("action");
		
		request.setAttribute("Resume", resume);
		System.out.println(resume);
		actionForward.setRedirect(false);
		actionForward.setPath("/searchResumeForm.jsp");
		
		return actionForward;
	}

}
