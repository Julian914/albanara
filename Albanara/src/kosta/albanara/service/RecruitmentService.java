package kosta.albanara.service;

import java.util.List;

import java.sql.Date;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import kosta.albanara.dao.RecruitmentDao;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;

public class RecruitmentService {
	public static RecruitmentService instance;
	public static RecruitmentDao recruitmentDao;

	public static RecruitmentService getInstance() {
		if (instance == null) {
			recruitmentDao = RecruitmentDao.getInstance();
			instance = new RecruitmentService();
		}
		return instance;
	}

	public List<Recruitments> recruitmentListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		List<Recruitments> list = recruitmentDao.recruitmentList();
		return list;
	}

	public List<Employees> applicantListService(int recruitmentSeq)throws Exception {
		List<Employees> applicantList = recruitmentDao.applicantList(recruitmentSeq);		
		return applicantList;
	}

	
	public int insertRecruitment(HttpServletRequest request) throws ParseException {
		int resultCount = -1;
		System.out.println("insert 서비스 출력");
		// int employerSeq = Integer.parseInt(request.getParameter("employerSeq"));
		int employerSeq = 1;
		String recruitmentTitle = request.getParameter("recruitmentTitle");
		String recruitmentType = request.getParameter("recruitmentType");
		int recruitmentSize = Integer.parseInt(request.getParameter("recruitmentSize"));
		Date startingWorkingDate = Date.valueOf(request.getParameter("startingWorkingDate"));
		Date endingWorkingDate = Date.valueOf(request.getParameter("endingWorkingDate"));
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
		// String workingPlaceAddress = request.getParameter("workingPlaceAddress");
		String workingPlaceAddress = "도로명주소값";
		Date closingDate = Date.valueOf(request.getParameter("closingDate"));
		// String recruitmentContents = request.getParameter("recruitmentContents");
		String recruitmentContents = "상세정보값";
		System.out.println("상세정보: " + recruitmentContents);

		Recruitments recruitment = new Recruitments(employerSeq, recruitmentTitle, recruitmentType, recruitmentSize,
				startingWorkingDate, endingWorkingDate, totalWorkingDay, startingWorkingTime, endingWorkingTime,
				totalWorkingTime, wageType, wage, gender, minAge, maxAge, requirementQuestion1, requirementQuestion2,
				requirementQuestion3, workingPlaceAddress, closingDate, recruitmentContents);

		resultCount = recruitmentDao.insertRecruitment(recruitment);

		return resultCount;
	}

	public Recruitments getRecruitment(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		return recruitmentDao.getRecruitment(seq);
	}
}