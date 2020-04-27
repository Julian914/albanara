package kosta.albanara.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Applications;
import kosta.albanara.model.ApplyedEmployeeListMap;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;
import kosta.albanara.service.RecruitmentService;

public class RecruitmentListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionforward = new ActionForward();
		RecruitmentService service = RecruitmentService.getInstance();
		request.setCharacterEncoding("utf-8");

		// 공고목록 불러오기
		List<Recruitments> recruitmentList = service.recruitmentListService(request);
		request.setAttribute("recruitmentList", recruitmentList);
		// System.out.println("총 공고목록 : " + recruitmentList.size());

		
		// TODO: at RecruitmentListAction.java
		// 1. applyedEmployeeListMap 객체를 만들고
		// 2.String key(지원자 목록 식별자), List list(지원자 목록) 선언
		// 3. request.setAttribute로 applyedEmployeeListMap 값 입력

		// TODO: at recruitmentList.jsp
		// 1. ${status.index} 로 인덱스 받기
		// 2. 받은 인덱스와 전달받은 applyedEmployeeListMap의 key 값이 같은 value를 찾아냄.
		// 3. 찾아낸 값을 이용해 foreach value로 출력

		// 해당 공고의 지원자목록 불러오기

		
		List<ApplyedEmployeeListMap> mapList = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < recruitmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(service.employeeListService(recruitmentList.get(i).getRecruitmentSeq()));
			mapList.add(mapClass);
		
		}
	
		request.setAttribute("employeeListMapList", mapList);
		
		actionforward.setRedirect(false);
		actionforward.setPath("/recruitmentList.jsp");

		return actionforward;
	}

}
