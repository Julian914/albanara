package kosta.albanara.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.Employers;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.service.EmployerService;
import kosta.albanara.service.MarkerLocationService;

public class EmployerLogInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		EmployerService service = EmployerService.getInstance();

		Employers employers = service.employerLogInService(request);
		if (employers != null) {
			MarkerLocationService markerService = MarkerLocationService.getInstance();
			String address = employers.getEmployerAddress();
			MarkerLocation markerLocation = markerService.sessionAddressService(address);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("id", employers.getEmployerId());
			session.setAttribute("seq", employers.getEmployerSeq());
			session.setAttribute("latitude", markerLocation.getLatitude());
			session.setAttribute("longitude", markerLocation.getLongitude());
		}
		
		forward.setRedirect(false);
		forward.setPath("/employerLogInForm.jsp");

		if (employers == null) {
			forward.setPath("/index.jsp");
		}
		return forward;
	}

}
