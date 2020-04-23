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
		RecruitmentService recruitmentService = RecruitmentService.getInstance();
		request.setCharacterEncoding("utf-8");
		
		List<Recruitments> recruitmentList = recruitmentService.recruitmentListService();   //service에서 공고목록을 불러옴 
		request.setAttribute("recruitmentList", recruitmentList);
		System.out.println("action : "+recruitmentList);
		
		actionforward.setRedirect(false);
		actionforward.setPath("/recruitmentList.jsp");
		
		return actionforward;
	}

}
