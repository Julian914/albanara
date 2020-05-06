package kosta.albanara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;

public class TotalRecruitmentsAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionforward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		request.setCharacterEncoding("utf-8");
		
		// 전체 공고목록 불러오기 
		 List<Recruitments> recruitmentList =  service.recruitmentList();
		 request.setAttribute("recruitmentList", recruitmentList); //
		 System.out.println("전체 공고목록 : " + recruitmentList.size());
		  
		 
		actionforward.setRedirect(false);
		actionforward.setPath("/recruitmentList.jsp");

		return actionforward;
	}

}
