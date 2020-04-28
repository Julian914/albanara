package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.HiredHistroy;
import kosta.albanara.service.HiredHistroyService;

public class InsertHiredHistroyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HiredHistroyService service = HiredHistroyService.getInstance();
		HiredHistroy hiredHistory = service.insertHiredHistroyService(request);
		forward.setRedirect(true);
		forward.setPath("/index.jsp");
		return forward;
	}

}
