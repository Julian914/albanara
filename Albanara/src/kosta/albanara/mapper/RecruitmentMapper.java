package kosta.albanara.mapper;

import java.util.List;

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

}
