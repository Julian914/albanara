package kosta.albanara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kosta.albanara.model.Application;
import kosta.albanara.model.HiredHistory;
import kosta.albanara.model.NearRecruitment;
import kosta.albanara.model.Proposal;
import kosta.albanara.model.Recruitment;

public interface RecruitmentMapper {

	List<Recruitment> recruitmentList();

	int insertRecruitment(Recruitment recruitment);

	int updateRecruitment(Recruitment recruitment);

	List<Recruitment> totalRecruitmentList(int employerSeq);

	Recruitment getRecruitment(int seq);

	int deleteRecruitment(int seq);

	// List<Employees> employeeList(int recruitmentSeq);
	int insertApplication(Application application);

	List<Recruitment> nowRecruinmentList(int employerSeq);

	List<Recruitment> endRecruitmentList(int employerSeq);

	List<Application> totalApplicationList();

	List<NearRecruitment> showNearRecruitments();

	List<Recruitment> showProposalRecruitments(int seq);

	int rejectProposalRecruitments(@Param("employSeq") String employeeSeq,
			@Param("recruitmentSeq") String recruitmentSeq);

	int acceptProposalRecruitments(@Param("employSeq") String employeeSeq,
			@Param("recruitmentSeq") String recruitmentSeq);

	int selectRecruitmentManCount(int seq);

	int selectRecruitmentWomanCount(int seq);

	List<Recruitment> completeRecruitment(int employeeSeq);

	List<Recruitment> applyRecruitment(int applySeq);

	// List<Employees> hiredEmployeeList();
	int insertProposal(Proposal proposal);

	int insertHiredHistory(HiredHistory hiredHistory);
}
