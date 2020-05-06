package kosta.albanara.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Applications;
import kosta.albanara.model.ApplyedEmployeeListMap;

import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;

public class RecruitmentListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionforward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		request.setCharacterEncoding("utf-8");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		// 한 기업의 전체 공고목록 불러오기
		List<Recruitments> totalRecruitmentList = service.recruitmentListService(seq);
		request.setAttribute("totalRecruitmentList", totalRecruitmentList);
		System.out.println("전체 공고목록 : " + totalRecruitmentList.size());

		
		 // 해당 공고의 지원자목록 불러오기 
		List<ApplyedEmployeeListMap> mapList1 = new ArrayList<ApplyedEmployeeListMap>();
		 
		 for (int i = 0; i < totalRecruitmentList.size(); i++) { ApplyedEmployeeListMap
		 mapClass = new ApplyedEmployeeListMap(); mapClass.setKey(i);
		 mapClass.setEmployeeList(service.employeeListService(totalRecruitmentList.get(i).getRecruitmentSeq()));
		 mapList1.add(mapClass); 
		 }
		 request.setAttribute("employeeListMapList", mapList1);
		
		
		// 진행중인 공고목록
		List<Recruitments> nowRecruinmentList = service.nowRecruinmentListService(seq);
		request.setAttribute("nowRecruinmentList", nowRecruinmentList);

		// 해당 공고의 지원자목록 불러오기
		List<ApplyedEmployeeListMap> mapList2 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < nowRecruinmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(service.employeeListService(nowRecruinmentList.get(i).getRecruitmentSeq()));
			mapList2.add(mapClass);
		}
		request.setAttribute("nowEmployeeListMapList", mapList2);

		
		
		// 마감된 공고목록
		List<Recruitments> endRecruitmentList = service.endRecruitmentListService(seq);
		System.out.println(endRecruitmentList);
		request.setAttribute("endRecruitmentList", endRecruitmentList);
		//System.out.println("endRecruitmentList : "+endRecruitmentList.size());

		// 채용자 목록
		List<ApplyedEmployeeListMap> mapList3 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < endRecruitmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(service.hiredEmployeeListService());
			mapList3.add(mapClass);
			System.err.println("endRecruitmentList:"+endRecruitmentList.get(i));
		}
		request.setAttribute("hiredEmployeeListMapList", mapList3);

		
		
		
		
		actionforward.setRedirect(false);
		actionforward.setPath("/employerPage.jsp");

		return actionforward;
	}

}
