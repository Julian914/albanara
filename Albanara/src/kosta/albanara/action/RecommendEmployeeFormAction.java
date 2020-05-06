package kosta.albanara.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employees;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.Recruitments;
import kosta.albanara.model.Resumes;
import kosta.albanara.service.EmployeeService;
import kosta.albanara.service.MapService;
import kosta.albanara.service.MarkerLocationService;
import kosta.albanara.service.RecruitmentService;

public class RecommendEmployeeFormAction implements Action {

	@SuppressWarnings("unused")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		EmployeeService service = EmployeeService.getInstance();
		MarkerLocationService markerService = MarkerLocationService.getInstance();
		RecruitmentService recruitmentService = RecruitmentService.getInstance();
		HttpSession session = request.getSession();
		
		
		int employerSeq = (Integer)session.getAttribute("seq");
		double employerLatitude =  Double.parseDouble((String)session.getAttribute("latitude"));
		System.out.println(employerLatitude);
		double employerLongitude = Double.valueOf((double)session.getAttribute("longitude"));
		List<Employees> allEmployeeList = service.allEmployeeListService(request);
		List<Recruitments> recruitment = recruitmentService.nowRecruinmentListService(employerSeq);
		String recruitmentType = recruitment.get(0).getRecruitmentType();
		String gender = recruitment.get(0).getGender();
		
		for (int i = 0; i < allEmployeeList.size(); i++) {
			Resumes resume = service.searchResumeService(allEmployeeList.get(i).getEmployeeSeq());
			String favoriteField = resume.getFavoriteField();
			String address = allEmployeeList.get(i).getEmployeeAddress();
			String employeeGender = allEmployeeList.get(i).getEmployeeGender(); 
			MarkerLocation markerLocation = markerService.sessionAddressService(address);
			double lat2 = Double.parseDouble(markerLocation.getLatitude());
			double lon2 = Double.parseDouble(markerLocation.getLongitude());
			double distance = MapService.distance(employerLatitude, employerLongitude, lat2, lon2);
			if (distance > 3 || !recruitmentType.equals(favoriteField) || !gender.equals(employeeGender)) {
				allEmployeeList.remove(i);
			}
		}
		request.setAttribute("recommendEmployee", allEmployeeList);
		
		forward.setRedirect(false);
		forward.setPath("/recommendEmployee.jsp");
		return forward;
	}

}
