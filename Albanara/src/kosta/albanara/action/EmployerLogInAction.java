package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employer;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.service.EmployerService;
import kosta.albanara.service.MarkerLocationService;

public class EmployerLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance();

		Employer employers = service.employerLogInService(request);
		System.out.println(employers);
		if (employers != null) {
			System.out.println(employers);
			MarkerLocationService markerService = MarkerLocationService.getInstance();
			MarkerLocation markerLocation = markerService.sessionAddressService(employers.getEmployerAddress());
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", employers.getEmployerId());
			System.out.println("id : " + session.getAttribute("id"));
			session.setAttribute("seq", employers.getEmployerSeq());
			System.out.println("seq : " + session.getAttribute("seq"));
			session.setAttribute("latitude", markerLocation.getLatitude());
			
			session.setAttribute("longitude", markerLocation.getLongitude());
			System.out.println("1 : " +session.getAttribute("longitude"));
			System.out.println("2 : "   +session.getAttribute("latitude"));
			
			
			forward.setRedirect(true);
			forward.setPath("recommendEmployeeActionForm.do");
		}else if(employers == null) {
			forward.setRedirect(false);
			forward.setPath("/index.jsp");
			
		}

		return forward;
	}

}
