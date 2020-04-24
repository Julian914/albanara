package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.RecruitmentService;

public class InsertRecruitmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		int resultCount = RecruitmentService.getInstance().insertRecruitment(request);

		// Set value to HttpSession

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);

		if (resultCount == 1) {
			System.out.println("Success to regist a recruitment. ");
			actionForward.setPath("insertRecruitmentForm.do");
		} else {
			System.err.println("Fail to regist a recruitment. " + actionForward.isRedirect());
			actionForward.setPath("insertRecruitmentForm.do");
		}

		return actionForward;
	}

}
