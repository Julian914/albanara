package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.service.RecruitmentService;

public class InsertApplicationAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		
		int result = service.insertApplicationService(request);
		
		if(result > 0) {
			System.out.println("지원완료");
		}
		
		actionForward.setRedirect(true);
		actionForward.setPath("recruitmentList.do");
		
		
		return actionForward;
	}

}
