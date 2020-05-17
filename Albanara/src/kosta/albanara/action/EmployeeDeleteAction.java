package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employee;
import kosta.albanara.model.Employer;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;

public class EmployeeDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		EmployeeService service = EmployeeService.getInstance(); 
		
		Employee employee = new Employee();
		
		employee.setEmployeeId(request.getParameter("employeeId"));
		service.deleteEmployeeService(employee);
		
		System.out.println(request.getParameter("employeeId")+"�׼�");
		
		
		forward.setRedirect(true); 
		forward.setPath("employeeLogIn.do");
		return forward;
	}

}
