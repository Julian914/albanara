package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.HiredHistory;
import kosta.albanara.service.HiredHistoryService;
import kosta.albanara.service.RecruitmentService;

public class ProposalAcceptAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		request.setCharacterEncoding("utf-8");
		String employeeSeq = request.getParameter("employeeSeq");
		String recruitmentSeq = request.getParameter("recruitmentSeq");
		RecruitmentService.getInstance().acceptProposalRecruitments(employeeSeq, recruitmentSeq);
		
		HiredHistory hiredHistory = new HiredHistory();
		HiredHistoryService.getInstance().insertHiredHistroyService(request);
		
		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);
		actionForward.setPath("../member/showEmployee.do?seq=" + employeeSeq);
		return actionForward;
	}

}
