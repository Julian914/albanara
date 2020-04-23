package kosta.albanara.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	public List<Recruitments> recruitmentListService(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		List<Recruitments> list = recruitmentDao.recruitmentList(); 
		return list;		
	}
}
