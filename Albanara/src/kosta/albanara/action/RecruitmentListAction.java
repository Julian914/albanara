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

		// 전체 공고목록 불러오기
		List<Recruitments> recruitmentList = service.recruitmentListService(request);
		request.setAttribute("recruitmentList", recruitmentList);
		// System.out.println("전체 공고목록 : " + recruitmentList.size());

		
		//진행중인 공고목록
		List<Recruitments> nowRecruinmentList = service.nowRecruinmentListService();
		request.setAttribute("nowRecruinmentList", nowRecruinmentList);
		
		
		//마감된 공고목록
		List<Recruitments> endRecruitmentList = service.endRecruitmentListService();
		request.setAttribute("endRecruitmentList", endRecruitmentList);
		//System.out.println("endRecruitmentList : "+endRecruitmentList);
	
		
		//전체공고의 전체지원자 목록(테스트용)
		List<Applications> totalApplicationList = service.totalApplicationListService();
		request.setAttribute("totalApplicationList", totalApplicationList);
		//System.out.println("totalApplicationList : "+totalApplicationList);
		
		

		
		
		
		
		// TODO: at RecruitmentListAction.java
		// 1. applyedEmployeeListMap 객체를 만들고
		// 2.String key(지원자 목록 식별자), List list(지원자 목록) 선언
		// 3. request.setAttribute로 applyedEmployeeListMap 값 입력

		// TODO: at recruitmentList.jsp
		// 1. ${status.index} 로 인덱스 받기
		// 2. 받은 인덱스와 전달받은 applyedEmployeeListMap의 key 값이 같은 value를 찾아냄.
		// 3. 찾아낸 값을 이용해 foreach value로 출력

		
		
		// 해당 공고의 지원자목록 불러오기
		List<ApplyedEmployeeListMap> mapList1 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < recruitmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(service.employeeListService(recruitmentList.get(i).getRecruitmentSeq()));
			mapList1.add(mapClass);
		}
		
		//지원자 불러오기
		request.setAttribute("employeeListMapList", mapList1);
				
		
		
		// 채용자 목록
		List<ApplyedEmployeeListMap> mapList2 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < endRecruitmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(service.hiredEmployeeListService());
			mapList2.add(mapClass);
		}
		
		//채용자 목록 불러오기
		request.setAttribute("hiredEmployeeListMapList", mapList2);
		
		
		
		actionforward.setRedirect(false);
		actionforward.setPath("/recruitmentList.jsp");

		return actionforward;
	}

}
