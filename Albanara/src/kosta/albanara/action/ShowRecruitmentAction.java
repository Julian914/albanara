package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;

public class ShowRecruitmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		int seq = Integer.parseInt(request.getParameter("seq"));
		Recruitments recruitment = RecruitmentService.getInstance().getRecruitment(seq);
		
		int man = RecruitmentService.getInstance().selectRecruitmentManCount(seq);
		int woman = RecruitmentService.getInstance().selectRecruitmentWomanCount(seq);

		// Set value to HttpSession
		request.setAttribute("recruitment", recruitment);
		request.setAttribute("man", man);
		request.setAttribute("woman", woman);

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/showRecruitment.jsp");

		return actionForward;
	}

}
