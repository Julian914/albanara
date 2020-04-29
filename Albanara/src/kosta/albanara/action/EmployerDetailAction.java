package kosta.albanara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employers;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.service.EmployerService;

public class EmployerDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance();
		
		/* 기업 정보 가져오기 */
		//String employerId = request.getParameter("employerId");
		int employerSeq = Integer.parseInt(request.getParameter("seq"));
		//String employerId = "aaaa"; //���Ƿ� �� ���̵�
		
		Employers employer = service.detailEmployerService(employerSeq);


		request.setAttribute("employer", employer);
		System.out.println("�׼�" + employer.toString());

		
		/* 채용자들 성별 구하기 */
		int man = service.selectEmployerManCount(employerSeq);
		int woman = service.selectEmployerWomanCount(employerSeq);
		
		request.setAttribute("man", man);
		request.setAttribute("woman", woman);
		
		
		/* 채용자들 위치 구하기 */
		List<MarkerLocation> mapList = service.selectHireMap(employerSeq);
		
		request.setAttribute("mapList", mapList);
		
		
		forward.setRedirect(false);
		forward.setPath("/employerPage.jsp");
		
		return forward;
	
	}

}
