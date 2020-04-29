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
		RecruitmentService service = RecruitmentService.getInstance(); 
		int seq = Integer.parseInt(request.getParameter("seq"));	
		int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		int applySeq = Integer.parseInt(request.getParameter("applySeq"));
		System.out.println(employeeSeq);
		System.out.println(applySeq);
		Employees employee = EmployeeService.getInstance().getEmployee(seq);
		List<Recruitments> recruitmentList = RecruitmentService.getInstance().showProposalRecruitments(seq);
		List<Recruitments> completeRecruitment = service.completeRecruitmentService(employeeSeq);
		List<Recruitments> applyRecruitment = service.applyRecruitmentService(applySeq);
		System.out.println(applyRecruitment);
		// Set value to HttpSession
		request.setAttribute("employee", employee);
		request.setAttribute("recruitmentList", recruitmentList);
		request.setAttribute("completeRecruitment", completeRecruitment);
		request.setAttribute("applyRecruitment", applyRecruitment);

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/showEmployee.jsp");

		return actionForward;
	}

}
