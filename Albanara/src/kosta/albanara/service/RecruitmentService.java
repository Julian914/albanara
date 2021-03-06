package kosta.albanara.service;

import java.util.List;

import java.sql.Date;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import kosta.albanara.dao.RecruitmentDao;
import kosta.albanara.model.Application;
import kosta.albanara.model.Proposal;
import kosta.albanara.model.Recruitment;

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

	public List<Recruitment> recruitmentListService() throws Exception {
		List<Recruitment> list = recruitmentDao.recruitmentList();
		return list;
	}
	

	
	public List<Recruitment> totalRecruitmentListService(int seq) throws Exception {
		List<Recruitment> list = recruitmentDao.totalRecruitmentList(seq);
		return list;
	}

	public List<Recruitment> nowRecruinmentListService(int employerSeq) throws Exception {
		//int employerSeq = Integer.parseInt(request.getParameter("seq"));
		List<Recruitment> list =  recruitmentDao.nowRecruinmentList(employerSeq);
		return list;
	}


	public List<Recruitment> endRecruitmentListService(int seq) throws Exception {
		List<Recruitment> list =  recruitmentDao.endRecruitmentList(seq);
		return list;
	}


	public int insertRecruitment(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		int resultCount = -1;
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
		int wage = Integer.parseInt(request.getParameter("wage"));
		String wageType = request.getParameter("wageType");
		String gender = request.getParameter("gender");
		int minAge = 0, maxAge = 100;
		if (request.getParameter("minAge") != null) {
			minAge = Integer.parseInt(request.getParameter("minAge"));
		}
		if (request.getParameter("maxAge") != null) {
			maxAge = Integer.parseInt(request.getParameter("maxAge"));
		}
		String recruitmentContents = request.getParameter("recruitmentContents");
		String requirementQuestion1 = request.getParameter("requirementQuestion1");
		String requirementQuestion2 = request.getParameter("requirementQuestion2");
		String requirementQuestion3 = request.getParameter("requirementQuestion3");
		String workingPlaceAddress = request.getParameter("workingPlaceAddress");
		Date closingDate = Date.valueOf(request.getParameter("closingDate"));

		Recruitment recruitment = new Recruitment(employerSeq, recruitmentTitle, recruitmentType, recruitmentSize,
				startingWorkingDate, endingWorkingDate, totalWorkingDay, startingWorkingTime, endingWorkingTime,
				totalWorkingTime, wageType, wage, gender, minAge, maxAge, requirementQuestion1, requirementQuestion2,
				requirementQuestion3, workingPlaceAddress, closingDate, recruitmentContents);

		resultCount = recruitmentDao.insertRecruitment(recruitment);

		return resultCount;
	}

	public Recruitment getRecruitment(int seq) {
		return recruitmentDao.getRecruitment(seq);
	}

	public int updateRecruitment(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		int resultCount = -1;

		int recruitmentSeq = Integer.parseInt(request.getParameter("recruitmentSeq"));
		int employerSeq = Integer.parseInt(request.getParameter("employerSeq"));
		String recruitmentTitle = request.getParameter("recruitmentTitle");
		String recruitmentType = request.getParameter("recruitmentType");
		int recruitmentSize = Integer.parseInt(request.getParameter("recruitmentSize"));
		Date startingWorkingDate = Date.valueOf(request.getParameter("startingWorkingDate"));
		Date endingWorkingDate = Date.valueOf(request.getParameter("endingWorkingDate"));
		int totalWorkingDay = Integer.parseInt(request.getParameter("totalWorkingDay"));
		int startingWorkingTime = Integer.parseInt(request.getParameter("startingWorkingTime"));
		int endingWorkingTime = Integer.parseInt(request.getParameter("endingWorkingTime"));
		int totalWorkingTime = Integer.parseInt(request.getParameter("totalWorkingTime"));
		int wage = Integer.parseInt(request.getParameter("wage"));
		String wageType = request.getParameter("wageType");
		String gender = request.getParameter("gender");
		int minAge = 0, maxAge = 100;
		if (request.getParameter("minAge") != null) {
			minAge = Integer.parseInt(request.getParameter("minAge"));
		}
		if (request.getParameter("maxAge") != null) {
			maxAge = Integer.parseInt(request.getParameter("maxAge"));
		}
		String recruitmentContents = request.getParameter("recruitmentContents");
		String requirementQuestion1 = request.getParameter("requirementQuestion1");
		String requirementQuestion2 = request.getParameter("requirementQuestion2");
		String requirementQuestion3 = request.getParameter("requirementQuestion3");
		String workingPlaceAddress = request.getParameter("workingPlaceAddress");
		Date closingDate = Date.valueOf(request.getParameter("closingDate"));

		Recruitment recruitment = new Recruitment(employerSeq, recruitmentTitle, recruitmentType, recruitmentSize,
				startingWorkingDate, endingWorkingDate, totalWorkingDay, startingWorkingTime, endingWorkingTime,
				totalWorkingTime, wageType, wage, gender, minAge, maxAge, requirementQuestion1, requirementQuestion2,
				requirementQuestion3, workingPlaceAddress, closingDate, recruitmentContents);
		recruitment.setRecruitmentSeq(recruitmentSeq);

		resultCount = recruitmentDao.updateRecruitment(recruitment);

		return resultCount;
	}

	public int deleteRecruitment(HttpServletRequest request) {
		int resultCount = -1;

		int seq = Integer.parseInt(request.getParameter("seq"));

		resultCount = recruitmentDao.deleteRecruitment(seq);

		return resultCount;
	}

	public int insertApplicationService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = -1;

		int recruitmentSeq = Integer.parseInt(request.getParameter("recruitmentSeq"));
		System.out.println("공고번호 : "+recruitmentSeq);

		// int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		int employeeSeq = 1;
		
		
		int requirementAnswer1 = -2;
		int requirementAnswer2 = -2;
		int requirementAnswer3 = -2;
		
		
		if(request.getParameter("answer1").equals("1")||request.getParameter("answer1").equals("0")){
			requirementAnswer1 = Integer.parseInt(request.getParameter("answer1"));
			System.out.println("답변 1 :" +requirementAnswer1);
		}
		
		 if(request.getParameter("answer2").equals("1")||request.getParameter("answer2").equals("0")){ 
			 requirementAnswer2 = Integer.parseInt(request.getParameter("answer2"));
			 System.out.println("답변 2 :" +requirementAnswer2); 
		 };
		 
		 if(request.getParameter("answer3").equals("1")||request.getParameter("answer3").equals("0")){ 
			 requirementAnswer3 = Integer.parseInt(request.getParameter("answer3"));
			 System.out.println("답변 3 :" +requirementAnswer3); 
		};
		  
		Application application = new Application(recruitmentSeq, employeeSeq, requirementAnswer1, requirementAnswer2, requirementAnswer3); 
		  result = recruitmentDao.insertApplication(application);

		return result;
	}
	
	
	
	public List<Application> totalApplicationListService() throws Exception{
		return recruitmentDao.totalApplicationList();
	}
	
	
	
	//구직자에게 공고 제안하기
	public int insertProposalService(HttpServletRequest request, HttpServletResponse response)throws Exception {
		request.setCharacterEncoding("utf-8");
		int re =-1;
		
		int recruitmentSeq = Integer.parseInt(request.getParameter("recruitmentSeq"));
		int employeeSeq= Integer.parseInt(request.getParameter("employeeSeq"));
		//System.out.println("recruitmentSeq : "+recruitmentSeq);
		//System.out.println("employeeSeq : "+employeeSeq);
		
		
		Proposal proposals = new Proposal(recruitmentSeq, employeeSeq);
		proposals.setEmployeeSeq(employeeSeq);
		proposals.setRecruitmentSeq(recruitmentSeq);
		
		re = recruitmentDao.insertProposal(proposals);
		return re;
	}
	
	/*제안 받은 공고 리스트*/
	public List<Recruitment> showProposalRecruitments(int seq) throws Exception {
		List<Recruitment> list = recruitmentDao.showProposalRecruitments(seq);
		return list;
	}
	
	/*제안 받은 공고 수락*/
	public void acceptProposalRecruitments(String employeeSeq, String recruitmentSeq) {
		recruitmentDao.acceptProposalRecruitments(employeeSeq, recruitmentSeq);
	}
	
	/*제안 받은 공고 거절*/
	public void rejectProposalRecruitments(String employeeSeq, String recruitmentSeq) throws Exception {
		recruitmentDao.rejectProposalRecruitments(employeeSeq, recruitmentSeq);
	}
	

	/*공고에 지원한 남자 수*/
	public int selectRecruitmentManCount(int seq) {
		return recruitmentDao.selectRecruitmentManCount(seq);
	}
	
	/*공고에 지원한 여자 수*/
	public int selectRecruitmentWomanCount(int seq) {
		return recruitmentDao.selectRecruitmentWomanCount(seq);
	}


	public List<Recruitment> completeRecruitmentService(int seq){
		return recruitmentDao.completeRecruitment(seq);
	}
	
	public List<Recruitment> applyRecruitmentService(int seq){
		return recruitmentDao.applyRecruitment(seq);
	};
	
	public List<Recruitment> completeRecruitment(HttpServletRequest request){
		int employeeSeq = Integer.parseInt(request.getParameter("employeeSeq"));
		return recruitmentDao.completeRecruitment(employeeSeq);
	}
	
	

	
}