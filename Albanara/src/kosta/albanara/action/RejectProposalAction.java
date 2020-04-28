package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.RecruitmentService;

public class RejectProposalAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		request.setCharacterEncoding("utf-8");
		String employeeSeq = request.getParameter("employee");
		String recruitmentSeq = request.getParameter("recruitment");
		RecruitmentService.getInstance().rejectProposalRecruitments(employeeSeq, recruitmentSeq);
		
		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("../member/showEmployee.do?seq=" + employeeSeq);
		return actionForward;
	}

}
