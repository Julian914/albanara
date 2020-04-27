package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;

public class ShowRecruitmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		Recruitments recruitment = RecruitmentService.getInstance().getRecruitment(request);

		// Set value to HttpSession
		request.setAttribute("recruitment", recruitment);

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/showRecruitment.jsp");

		return actionForward;
	}

}
