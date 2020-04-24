package kosta.albanara.service;

import kosta.albanara.dao.EvaluationDao;

public class EvaluationService {
	public static EvaluationService instance;
	public static EvaluationDao evaluationDao;

	public static EvaluationService getInstance() {
		if (instance == null) {
			evaluationDao = EvaluationDao.getInstance();
			instance = new EvaluationService();
		}
		return instance;
	}
}
