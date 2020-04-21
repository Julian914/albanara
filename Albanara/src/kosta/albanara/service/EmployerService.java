package kosta.albanara.service;

import kosta.albanara.dao.EmployerDao;

public class EmployerService {
	public static EmployerService instance;
	public static EmployerDao employerDao;

	public static EmployerService getInstance() {
		if (instance == null) {
			employerDao = EmployerDao.getInstance();
			return new EmployerService();
		}
		return instance;
	}
}
