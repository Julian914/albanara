package kosta.albanara.service;

import java.util.List;

import kosta.albanara.dao.RecruitmentDao;
import kosta.albanara.model.Recruitments;

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
	
	public List<Recruitments> recruitmentListService()throws Exception {
		return recruitmentDao.recruitmentList();
		
	}
}
