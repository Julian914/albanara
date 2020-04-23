package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertRecruitmentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		//int resultCount = BoardService.getInstance().insertPost(request);

		// Set value to HttpSession

		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(true);

		/*
		 * if (resultCount == 1) { System.out.println("Success to write a post. ");
		 * actionForward.setPath("listAction.do");
		 * //actionForward.setPath("PostAction.do?seq="+request.getParameter("seq")); }
		 * else { System.err.println("Fail to write a post. " +
		 * actionForward.isRedirect()); actionForward.setPath("listAction.do"); }
		 */

		return actionForward;
	}

}
