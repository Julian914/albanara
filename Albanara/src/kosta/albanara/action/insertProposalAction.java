package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.RecruitmentService;

public class insertProposalAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		
		service.insertProposalService(request, response);
		
		forward.setRedirect(true);
		forward.setPath("../member/detailEmployers.do");
		return forward;
	}

}
