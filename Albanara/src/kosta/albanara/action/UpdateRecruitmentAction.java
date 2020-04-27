package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.RecruitmentService;

public class UpdateRecruitmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		int resultCount = RecruitmentService.getInstance().updateRecruitment(request);

		// Set value to HttpSession

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);

		if (resultCount == 1) {
			System.out.println("Success to update the recruitment. ");
			actionForward.setPath("updateRecruitmentForm.do?seq=" + request.getParameter("recruitmentSeq"));
		} else {
			System.err.println("Fail to update the recruitment. ");
			actionForward.setPath("updateRecruitmentForm.do?seq=" + request.getParameter("recruitmentSeq"));
		}

		return actionForward;
	}

}
