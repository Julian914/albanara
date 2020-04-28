package kosta.albanara.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employees;
import kosta.albanara.service.EmployeeService;

public class EmployeeUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ActionForward forward = new ActionForward();
		EmployeeService service = EmployeeService.getInstance(); 
		
		Employees employee = new Employees();
		
		employee.setEmployeeId(request.getParameter("employeeId"));
		employee.setEmployeePw(request.getParameter("employeePw"));
		employee.setEmployeeName(request.getParameter("employeeName"));
		employee.setEmployeeBirthday(Date.valueOf(request.getParameter("employeeBirthYear") + "-"
				+ request.getParameter("employeeBirthMonth") + "-" + request.getParameter("employeeBirthDay")));
		employee.setEmployeeEmail(request.getParameter("employeeEmailInput1")
				+ request.getParameter("employeeEmailInput2"));
		employee.setEmployeeGender(request.getParameter("employeeGender"));
		employee.setEmployeePhone(request.getParameter("employeePhone1") + request.getParameter("employeePhone2")
				+ request.getParameter("employeePhone3"));
		employee.setEmployeeAddress(request.getParameter("employeeAddress"));
		
		//int re = service.updateEmployeeService(employee);
		
		
		
		if(service.updateEmployeeService(employee) == 1) {
			System.out.println("성공");
			forward.setRedirect(true); 
			forward.setPath("UpdateEmployeesForm.do");
			return forward;
		}else {
			System.out.println("실패");
			forward.setRedirect(true); 
			forward.setPath("UpdateEmployeesForm.do");
			return forward;
		}
	}

}
