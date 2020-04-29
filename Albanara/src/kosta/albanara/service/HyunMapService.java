package kosta.albanara.service;

import java.util.List;

import kosta.albanara.dao.HyunMapDao;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.NearRecruitments;


public class HyunMapService {
	public static HyunMapService instance;
	public static HyunMapDao mapDao;

	public static HyunMapService getInstance() {
		if (instance == null) {
			mapDao = HyunMapDao.getInstance();
			instance = new HyunMapService();
		}
		return instance;
	}

	public List<NearRecruitments> nearRecruitment() {
		return mapDao.nearRecruitment();
	}
	

}
