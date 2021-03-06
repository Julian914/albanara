package kosta.albanara.service;

import java.util.List;

import kosta.albanara.dao.MapDao;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.NearRecruitment;


public class MapService {
	
	public static MapService instance;
	public static MapDao mapDao;
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
	public static MapService getInstance() {
		if (instance == null) {
			mapDao = MapDao.getInstance(); 
			instance = new MapService();
		}
		return instance;
	}
    
	

	public List<NearRecruitment> nearRecruitment() {
		System.out.println("MapService 안");
		return mapDao.nearRecruitment();
	}
	

}
