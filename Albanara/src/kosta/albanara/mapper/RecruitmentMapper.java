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
	List<Employees> totalEmployeeList();
	List<Applications> totalApplicationList();
	int insertApplication(Applications application);

	List<NearRecruitments> showNearRecruitments();
	List<Recruitments> showProposalRecruitments(int seq);
	int rejectProposalRecruitments(@Param("employSeq") String employeeSeq, @Param("recruitmentSeq") String recruitmentSeq);
	int acceptProposalRecruitments(@Param("employSeq") String employeeSeq, @Param("recruitmentSeq") String recruitmentSeq);
	int selectRecruitmentManCount(int seq);
	int selectRecruitmentWomanCount(int seq);
}
