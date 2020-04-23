package kosta.albanara.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	public int insertRecruitment(HttpServletRequest request) throws ParseException {
		int resultCount = -1;

		String recruitmentTitle = request.getParameter("recruitmentTitle");
		String recruitmentType = request.getParameter("recruitmentType");
		int recruitmentSize = Integer.parseInt(request.getParameter("recruitmentSize"));
		Date startingWorkingDate = new SimpleDateFormat("yyyy/MM/dd")
				.parse(request.getParameter("startingWorkingDate"));
		Date endingWorkingDate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("endingWorkingDate"));
		int totalWorkingDay = Integer.parseInt(request.getParameter("totalWorkingDay"));
		int startingWorkingTime = Integer.parseInt(request.getParameter("startingWorkingTime"));
		int endingWorkingTime = Integer.parseInt(request.getParameter("endingWorkingTime"));
		int totalWorkingTime = Integer.parseInt(request.getParameter("totalWorkingTime"));
		String wageType = request.getParameter("wageType");
		int wage = Integer.parseInt(request.getParameter("wage"));
		String gender = request.getParameter("gender");
		int minAge = 0, maxAge = 0;
		if (request.getParameter("age") == "age") {
			minAge = Integer.parseInt(request.getParameter("minAge"));
			maxAge = Integer.parseInt(request.getParameter("maxAge"));
		}
		String requirementQuestion1 = request.getParameter("requirementQuestion1");
		String requirementQuestion2 = request.getParameter("requirementQuestion2");
		String requirementQuestion3 = request.getParameter("requirementQuestion3");
		String workingPlaceAddress = request.getParameter("workingPlaceAddress");
		Date closingDate = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("closingDate"));
		String recruitmentContents = request.getParameter("recruitmentContents");

		Recruitments recruitment = new Recruitments(recruitmentTitle, recruitmentType, recruitmentSize,
				startingWorkingDate, endingWorkingDate, totalWorkingDay, startingWorkingTime, endingWorkingTime,
				totalWorkingTime, wageType, wage, gender, minAge, maxAge, requirementQuestion1, requirementQuestion2,
				requirementQuestion3, workingPlaceAddress, closingDate, recruitmentContents);

		resultCount = recruitmentDao.insertRecruitment(recruitment);

		return resultCount;
	}
}
