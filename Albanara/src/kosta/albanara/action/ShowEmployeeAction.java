package kosta.albanara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.RecruitmentService;

public class ShowEmployeeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		request.setCharacterEncoding("utf-8");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		Employees employee = EmployeeService.getInstance().getEmployee(seq);
		
		List<Recruitments> recruitmentList = RecruitmentService.getInstance().showProposalRecruitments(seq);
		

		// Set value to HttpSession
		request.setAttribute("employee", employee);
		request.setAttribute("recruitmentList", recruitmentList);

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/showEmployee.jsp");

		return actionForward;
	}

}
