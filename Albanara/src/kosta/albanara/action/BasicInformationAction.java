package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employees;
import kosta.albanara.service.EmployeeService;

public class BasicInformationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
		//int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		int employeeSeq = 3;
		
		Employees employee = service.basicInformationService(employeeSeq);
		
		request.setAttribute("Employee", employee);
		
		actionForward.setRedirect(false);
		actionForward.setPath("/basicInformation.jsp");
		
		return actionForward;
	}

}
