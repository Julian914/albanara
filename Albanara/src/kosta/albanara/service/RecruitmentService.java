package kosta.albanara.service;

import kosta.albanara.dao.RecruitmentDao;

public class RecruitmentService {
	public static RecruitmentService instance;
	public static RecruitmentDao recruitmentDao;

	public static RecruitmentService getInstance() {
		if (instance == null) {
			recruitmentDao = RecruitmentDao.getInstance();
			return new RecruitmentService();
		}
		return instance;
	}
}
