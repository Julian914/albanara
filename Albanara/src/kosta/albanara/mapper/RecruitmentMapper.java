package kosta.albanara.mapper;

import java.util.List;

import kosta.albanara.model.Applications;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;

public interface RecruitmentMapper {

	List<Recruitments> recruitmentList();
	int insertRecruitment(Recruitments recruitment);
	int updateRecruitment(Recruitments recruitment);
	List<Recruitments> totalRecruitmentList();
	Recruitments getRecruitment(int seq);
	int deleteRecruitment(int seq);
	List<Employees> employeeList(int recruitmentSeq);
	int insertApplication(Applications applications);
	List<Recruitments> nowRecruinmentList();
	List<Recruitments> endRecruitmentList();

	
	List<Applications> totalApplicationList();

}
