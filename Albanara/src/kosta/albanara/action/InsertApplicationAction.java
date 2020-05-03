package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.control.Alert;
import kosta.albanara.service.RecruitmentService;

public class InsertApplicationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		
		service.insertApplicationService(request);

		
		actionForward.setRedirect(true);
		actionForward.setPath("../member/showEmployersPage.do");
		
		
		return actionForward;
	}

}
