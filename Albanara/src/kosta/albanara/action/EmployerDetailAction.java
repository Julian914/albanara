package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employers;
import kosta.albanara.service.EmployerService;

public class EmployerDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance();
		
		HttpSession session = request.getSession();

		//String employerId = request.getParameter("employerId");
		System.out.println(session.getAttribute("seq"));
		int employerSeq = Integer.parseInt(session.getAttribute("seq").toString());
		//String employerId = "aaaa"; //���Ƿ� �� ���̵�
		System.out.println(employerSeq);
		Employers employer = service.detailEmployerService(employerSeq);

		request.setAttribute("employer", employer);
		System.out.println("�׼�" + employer.toString());

		
		forward.setRedirect(false);
		forward.setPath("/employerPage.jsp");
		
		return forward;
	
	}

}
