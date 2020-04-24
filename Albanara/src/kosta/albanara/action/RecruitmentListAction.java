package kosta.albanara.action;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;
import sun.print.resources.serviceui;

public class RecruitmentListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionforward = new ActionForward();
		RecruitmentService Service = RecruitmentService.getInstance();
		request.setCharacterEncoding("utf-8");

		// 공고목록 불러오기
		List<Recruitments> recruitmentList = Service.recruitmentListService(request);
		request.setAttribute("recruitmentList", recruitmentList);
		System.out.println(recruitmentList.size());
		
		// 해당 공고의 지원자목록 불러오기
	
		List<List<Employees>> applicantListList = new ArrayList<List<Employees>>();
		
		for (int i = 0; i <recruitmentList.size(); i++) {
			System.out.println(i);
			if (Service.applicantListService(recruitmentList.get(i).getRecruitmentSeq()) == null ){
				System.out.println("null --- ");
			}
			applicantListList.add(Service.applicantListService(recruitmentList.get(i).getRecruitmentSeq()));
		}		
		request.setAttribute("applicantListList", applicantListList);

		/*
		 * for(int i =0; i<recruitmentList.size(); i++) { applicantList=
		 * Service.applicantListService(recruitmentList.get(i).getRecruitmentSeq()); }
		 */

		
		System.out.println("action:" + applicantListList);

		actionforward.setRedirect(false);
		actionforward.setPath("/recruitmentList.jsp");

		return actionforward;
	}

}
