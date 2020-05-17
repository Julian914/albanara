package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Recruitment;
import kosta.albanara.service.RecruitmentService;

public class UpdateRecruitmentForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		int seq = Integer.parseInt(request.getParameter("seq"));
		Recruitment recruitment = RecruitmentService.getInstance().getRecruitment(seq);

		// Set value to HttpSession
		request.setAttribute("recruitment", recruitment);

		System.out.println("공고수정 action");
		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/updateRecruitmentForm.jsp");

		return actionForward;
	}

}
