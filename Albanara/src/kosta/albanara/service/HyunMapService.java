package kosta.albanara.service;

import java.util.List;

import kosta.albanara.dao.HyunMapDao;
import kosta.albanara.model.HyunMap;

public class HyunMapService {
	public static HyunMapService instance;
	public static HyunMapDao mapDao;

	public static HyunMapService getInstance() {
		if (instance == null) {
			mapDao = HyunMapDao.getInstance();
			return new HyunMapService();
		}
		return instance;
	}
	
	public List<HyunMap> mapList() {
		return mapDao.mapList();
	}
}
