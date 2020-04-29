package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.RecruitmentService;

public class insertHiredHistoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		
		service.insertHiredHistoryService(request, response);
		
		
		actionForward.setRedirect(true);
		actionForward.setPath("index.jspp");
		
		
		return actionForward;
	}


}
