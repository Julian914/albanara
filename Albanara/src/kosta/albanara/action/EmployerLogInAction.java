package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employers;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;

public class EmployerLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance();

		Employers employers = service.employerLogInService(request);

		forward.setRedirect(false);
		forward.setPath("/employerLogInForm.jsp");
		// if문으로 분기 시켜서 이동
		if (employers == null) {
			forward.setPath("/index.jsp");
		}
		return forward;
	}

}
