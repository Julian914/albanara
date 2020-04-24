package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Resumes;
import kosta.albanara.service.EmployeeService;

public class InsertResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
	
		service.insertResumeService(request);
		System.out.println();
		
		actionForward.setRedirect(false);
		actionForward.setPath("/index.jsp");	//인서트하고 나서는 다시 마이페이지에 기본정보 보여주는 곳으로 돌아가기. 지금은 임시로 index로 돌아간다
		
		return actionForward;
	}

}
