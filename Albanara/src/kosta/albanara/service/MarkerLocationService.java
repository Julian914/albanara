package kosta.albanara.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kosta.albanara.dao.EmployeeDao;
import kosta.albanara.dao.MarkerLocationDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.MarkerLocation;

public class MarkerLocationService {
	private static MarkerLocationService instance;
	private static MarkerLocationDao markerLocationDao;
	private static EmployeeDao employeeDao;
	
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
		if(re == 0) { // 주소가 없으면
			markerLocation.setRoadAddress(roadAddress);
			markerLocation.setLatitude(request.getParameter("latitude"));
			markerLocation.setLongitude(request.getParameter("longitude"));
			markerLocationDao.insertMarkerLocation(markerLocation);
		}
		
	}
	public MarkerLocation sessionAddressService(HttpServletRequest request) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		Employees employee = new Employees();
		Employees login = new Employees();
	    MarkerLocation sessionAddress = new MarkerLocation();
		employee.setEmployeeId(request.getParameter("employeeLogInId"));
		employee.setEmployeePw(request.getParameter("employeeLogInPw"));
	      login = employeeDao.employeeLogIn(employee);
	      sessionAddress = markerLocationDao.sessionAddress(login);
	      if(login==null) {

	    	  return null;

	    	 
	      }else if(login.getEmployeeId().equals(employee.getEmployeeId()) && login.getEmployeePw().equals(employee.getEmployeePw())) {

	    	  HttpSession session = request.getSession();
	    	  
	    	  session.setAttribute("latitude", sessionAddress.getLatitude());
	    	  session.setAttribute("longitude", sessionAddress.getLongitude());
	    	
	      }
		return sessionAddress;
	}	
}
