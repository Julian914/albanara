package kosta.albanara.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kosta.albanara.model.Applications;
import kosta.albanara.model.Employees;
import kosta.albanara.model.NearRecruitments;
import kosta.albanara.model.Recruitments;

public interface RecruitmentMapper {

	List<Recruitments> recruitmentList();
	int insertRecruitment(Recruitments recruitment);
	int updateRecruitment(Recruitments recruitment);
	List<Recruitments> totalRecruitmentList();
	Recruitments getRecruitment(int seq);
	List<Employees> applicantList(int recruitmentSeq);
	int deleteRecruitment(int seq);
	List<Employees> employeeList(int recruitmentSeq);
	int insertApplication(Applications applications);
	List<Recruitments> nowRecruinmentList();
	List<Recruitments> endRecruitmentList();
	List<Applications> totalApplicationList();
	List<NearRecruitments> showNearRecruitments();
	List<Recruitments> showProposalRecruitments(int seq);
	int rejectProposalRecruitments(@Param("employSeq") String employeeSeq, @Param("recruitmentSeq") String recruitmentSeq);
	int acceptProposalRecruitments(@Param("employSeq") String employeeSeq, @Param("recruitmentSeq") String recruitmentSeq);
	int selectRecruitmentManCount(int seq);
	int selectRecruitmentWomanCount(int seq);
	List<Recruitments> completeRecruitment(int employeeSeq);
	List<Employees> hiredEmployeeList();

}
