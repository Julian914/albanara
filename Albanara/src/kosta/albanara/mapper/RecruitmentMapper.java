package kosta.albanara.mapper;

import java.util.List;

import kosta.albanara.model.Applications;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;

public interface RecruitmentMapper {
	List<Recruitments> totalRecruitmentList();
	int insertRecruitment(Recruitments recruitment);
	Recruitments getRecruitment(int seq);
	List<Employees> employeeList(int recruitmentSeq);
	List<Employees> totalEmployeeList();
	List<Applications> totalApplicationList();
	int insertApplication(Applications application);

}
