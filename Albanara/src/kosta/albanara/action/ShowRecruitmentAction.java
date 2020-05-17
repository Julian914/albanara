package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Recruitment;
import kosta.albanara.service.EvaluationService;
import kosta.albanara.service.RecruitmentService;

public class ShowRecruitmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		int seq = Integer.parseInt(request.getParameter("seq"));
		Recruitment recruitment = RecruitmentService.getInstance().getRecruitment(seq);
		
		int man = RecruitmentService.getInstance().selectRecruitmentManCount(seq);
		int woman = RecruitmentService.getInstance().selectRecruitmentWomanCount(seq);
		
		/* 기업 평점 구하기 */
		int avgTotal = EvaluationService.getInstance().selectAvgEvaluation(seq);
		request.setAttribute("avgTotal", avgTotal);
		

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
