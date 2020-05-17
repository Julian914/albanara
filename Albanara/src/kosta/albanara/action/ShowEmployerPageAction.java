package kosta.albanara.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.ApplyedEmployeeListMap;
import kosta.albanara.model.Employer;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.Recruitment;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.EmployerService;
import kosta.albanara.service.EvaluationService;
import kosta.albanara.service.RecruitmentService;

public class ShowEmployerPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		EmployerService employerService = EmployerService.getInstance();
		RecruitmentService recruitmentService = RecruitmentService.getInstance();
		EmployeeService employeeService = EmployeeService.getInstance();

		/* 기업 정보 가져오기 */
	
		int seq = Integer.parseInt(request.getParameter("seq"));


		Employer employer = employerService.detailEmployerService(seq);


		request.setAttribute("employer", employer);

		/* 채용자들 성별 구하기 */

		int man = employerService.selectEmployerManCount(seq);
		int woman = employerService.selectEmployerWomanCount(seq);


		request.setAttribute("man", man);
		request.setAttribute("woman", woman);

		/* 채용자들 위치 구하기 */

		List<MarkerLocation> mapList = employerService.selectHireMap(seq);


		request.setAttribute("mapList", mapList);

		/* 기업 평점 구하기 */
		int avgTotal = EvaluationService.getInstance().selectAvgEvaluation(seq);
		request.setAttribute("avgTotal", avgTotal);
		
		// 한 기업의 전체 공고목록 불러오기

		List<Recruitment> recruitmentList = employerService.recruitmentListService(seq);

		request.setAttribute("recruitmentList", recruitmentList);
		System.out.println("전체 공고목록 : " + recruitmentList.size());

		// 전체 공고의 지원자목록 불러오기
		List<ApplyedEmployeeListMap> mapList1 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < recruitmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(employeeService.employeeListService(recruitmentList.get(i).getRecruitmentSeq()));
			mapList1.add(mapClass);
		}
		request.setAttribute("employeeListMapList", mapList1);

		
		
		
		
		// 진행중인 공고목록

		List<Recruitment> nowRecruinmentList = recruitmentService.nowRecruinmentListService(seq);

		request.setAttribute("nowRecruinmentList", nowRecruinmentList);
		System.out.println("진행중 공고목록 : " + nowRecruinmentList.size());

		//진행중 공고의 지원자목록 불러오기
		List<ApplyedEmployeeListMap> mapList2 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < nowRecruinmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(employeeService.employeeListService(recruitmentList.get(i).getRecruitmentSeq()));
			mapList2.add(mapClass);
		}
		request.setAttribute("마감공고목록 : ", mapList2);
	
		
		
		// 마감된 공고목록

		List<Recruitment> endRecruitmentList = recruitmentService.endRecruitmentListService(seq);

		request.setAttribute("endRecruitmentList", endRecruitmentList);
		System.out.println("endRecruitmentList : "+endRecruitmentList.size());

		// 채용자 목록
		List<ApplyedEmployeeListMap> mapList3 = new ArrayList<ApplyedEmployeeListMap>();

		for (int i = 0; i < endRecruitmentList.size(); i++) {
			ApplyedEmployeeListMap mapClass = new ApplyedEmployeeListMap();
			mapClass.setKey(i);
			mapClass.setEmployeeList(employeeService.hiredEmployeeListService());
			mapList3.add(mapClass);
		}
		request.setAttribute("hiredEmployeeListMapList", mapList3);
		
		

		forward.setRedirect(false);
		forward.setPath("/employerPageEmployeeView.jsp");

		return forward;

	}

}
