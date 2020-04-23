package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Resumes;
import kosta.albanara.service.EmployeeService;

public class InsertResumeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward actionForward = new ActionForward();
		EmployeeService service = new EmployeeService();
		
		Resumes resume = new Resumes();
		String pictureFilename = request.getParameter("pictureFilename");
		String resumeTitle = request.getParameter("resumeTitle");
		String resumeContents = request.getParameter("resumeContents");
		String desiredWorkingArea = request.getParameter("desiredWorkingArea");
		String favoriteField = request.getParameter("favoriteField");
		
		resume.setPictureFilename(pictureFilename);
		resume.setResumeTitle(resumeTitle);
		resume.setResumeContents(resumeContents);
		resume.setDesiredWorkingArea(desiredWorkingArea);
		resume.setFavoriteField(favoriteField);
		
		
		service.insertResumeService(resume);
		
		
		actionForward.setRedirect(false);
		actionForward.setPath("/mypage.jsp");	//�μ�Ʈ�ϰ� ������ �ٽ� ������������ �⺻���� �����ִ� ������ ���ư���
		
		return actionForward;
	}

}
