package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;

public class EmployeeLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeService service = EmployeeService.getInstance();

		Employees employees = service.employeeLogInService(request);

		forward.setRedirect(false);
		forward.setPath("/employeeLogInForm.jsp");
		// if������ �б� ���Ѽ� �̵�
		if (employees == null) {
			forward.setPath("/index.jsp");
		}
		return forward;
	}

}
