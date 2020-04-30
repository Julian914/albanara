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
		
		System.out.println("채용완료");
		
		forward.setRedirect(true);
		forward.setPath("/Albanara/index.jsp");
		return forward;
	}
}
