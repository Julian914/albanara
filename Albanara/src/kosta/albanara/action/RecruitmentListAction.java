package kosta.albanara.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;

public class RecruitmentListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionforward = new ActionForward();
		RecruitmentService Service = RecruitmentService.getInstance();
		request.setCharacterEncoding("utf-8");
		
		List<Recruitments> recruitmentList = Service.recruitmentListService(request);  
		request.setAttribute("recruitmentList", recruitmentList);
		
		
		actionforward.setRedirect(false);
		actionforward.setPath("/recruitmentList.jsp");
		
		return actionforward;
	}

}
