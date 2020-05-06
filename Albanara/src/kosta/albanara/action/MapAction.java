package kosta.albanara.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.NearRecruitments;
import kosta.albanara.service.MapService;

public class MapAction implements Action {
	

	
	@SuppressWarnings("null")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		MapService service = MapService.getInstance();
		List<NearRecruitments> list = service.nearRecruitment();
		HttpSession session = request.getSession();
		
		double lat1; 
		double lon1;
		
		if(session.getAttribute("latitude") != null) {
			lat1 = (double) session.getAttribute("latitude");
			lon1 = (double) session.getAttribute("longitude");
		} else {
			lat1 = 126.890098469594; 
			lon1 = 37.4798037664073;
		}
		 
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
			double lat2 = Double.parseDouble(list.get(i).getLatitude());
			double lon2 = Double.parseDouble(list.get(i).getLongitude());
			double distance = MapService.distance(lat1, lon1, lat2, lon2);
			System.out.println(distance);
			if (distance > 3) {
				System.out.println(list.get(i));
				list.remove(i);
			}
		}
		request.setAttribute("list", list);
		request.setAttribute("centricLatitude", lat1);
		request.setAttribute("centricLongitude", lon1);
		
		forward.setRedirect(false);
		 forward.setPath("/main.jsp");
		return forward;
	}

}
