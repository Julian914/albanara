package kosta.albanara.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kosta.albanara.model.NearRecruitments;
import kosta.albanara.service.HyunMapService;

public class HyunMapAction implements Action {
	
	    public static final double R = 6372.8; // In kilometers
	    public static double distance(double lat1, double lon1, double lat2, double lon2) {
	        double dLat = Math.toRadians(lat2 - lat1);
	        double dLon = Math.toRadians(lon2 - lon1);
	        lat1 = Math.toRadians(lat1);
	        lat2 = Math.toRadians(lat2);

	        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
	        double c = 2 * Math.asin(Math.sqrt(a));
	        return R * c;
	    }
	
	@SuppressWarnings("null")
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HyunMapService service = HyunMapService.getInstance();
		List<NearRecruitments> list = service.nearRecruitment();
//		HttpSession session =
		double lat1 = 126.890098469594; 
		double lon1 = 37.4798037664073;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i);
			double lat2 = Double.parseDouble(list.get(i).getLatitude());
			double lon2 = Double.parseDouble(list.get(i).getLongitude());
			double distance = distance(lat1, lon1, lat2, lon2);
			System.out.println(distance);
			if (distance > 3) {
				System.out.println(list.get(i));
				list.remove(i);
				
			}
		}
		request.setAttribute("list", list);
		forward.setRedirect(false);
		 forward.setPath("/HyunNewFile.jsp");
		return forward;
	}

}
