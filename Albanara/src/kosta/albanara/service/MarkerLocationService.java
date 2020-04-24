package kosta.albanara.service;

import javax.servlet.http.HttpServletRequest;
import kosta.albanara.dao.MarkerLocationDao;
import kosta.albanara.model.MarkerLocation;

public class MarkerLocationService {
	private static MarkerLocationService instance;
	private static MarkerLocationDao markerLocationDao;
	
	public static MarkerLocationService getInstance() {
		if (instance == null) {
			markerLocationDao = MarkerLocationDao.getInstance();
			instance = new MarkerLocationService();
		}
		return instance;
	}
	
	public void insertMarkerLocation(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		MarkerLocation markerLocation = new MarkerLocation();
		String roadAddress = request.getParameter("employeeAddress");
		int re = 0;
		re = markerLocationDao.existMarkerLocation(roadAddress);
		if(re == 0) { // 二쇱냼媛� �뾾�쑝硫�
			markerLocation.setRoadAddress(roadAddress);
			markerLocation.setLatitude(request.getParameter("latitude"));
			markerLocation.setLongitude(request.getParameter("longitude"));
			markerLocationDao.insertMarkerLocation(markerLocation);
		}
		
	}
}
