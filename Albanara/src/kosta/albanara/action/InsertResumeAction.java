package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Resume;
import kosta.albanara.service.EmployeeService;

public class InsertResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService().getInstance();
		
	
		service.insertResumeService(request);
		System.out.println();
		
		actionForward.setRedirect(false);
		actionForward.setPath("/index.jsp");	//�μ�Ʈ�ϰ� ������ �ٽ� ������������ �⺻���� �����ִ� ������ ���ư���. ������ �ӽ÷� index�� ���ư���
		
		return actionForward;
	}

}
