package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import kosta.albanara.service.HiredHistoryService;

public class HiredHistoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HiredHistoryService service = HiredHistoryService.getInstance();
		service.insertHiredHistroyService(request);
		forward.setRedirect(true);
		forward.setPath("/index.jsp");
		return forward;
	}

}
