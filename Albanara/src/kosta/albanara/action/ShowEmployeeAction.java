package kosta.albanara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kosta.albanara.model.Employee;
import kosta.albanara.model.Recruitment;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.RecruitmentService;

public class ShowEmployeeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Call Service
		request.setCharacterEncoding("utf-8");
		RecruitmentService service = RecruitmentService.getInstance(); 
		int seq = Integer.parseInt(request.getParameter("seq"));	
		
		Employee employee = EmployeeService.getInstance().getEmployee(seq);
		List<Recruitment> recruitmentList = RecruitmentService.getInstance().showProposalRecruitments(seq);

		List<Recruitment> completeRecruitment = service.completeRecruitmentService(seq);
		List<Recruitment> applyRecruitment = service.applyRecruitmentService(seq);

		request.setAttribute("employee", employee);
		request.setAttribute("recruitmentList", recruitmentList);
		request.setAttribute("completeRecruitment", completeRecruitment);
		request.setAttribute("applyRecruitment", applyRecruitment);


		// Set ActionForward
		ActionForward actionForward = new ActionForward();
		actionForward.setRedirect(false);
		actionForward.setPath("/showEmployee.jsp");

		return actionForward;
	}

}
