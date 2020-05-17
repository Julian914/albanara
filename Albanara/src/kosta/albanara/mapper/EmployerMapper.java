package kosta.albanara.mapper;

import java.util.List;

import kosta.albanara.model.Employer;
import kosta.albanara.model.MarkerLocation;

public interface EmployerMapper {
	int insertEmployer(Employer employers);

	Employer employerLogIn(Employer employer);

	int updateEmployer(Employer employer);

	int deleteEmployer(Employer employer);

	Employer detailEmployer(int employerSeq);

	int selectEmployerManCount(int seq);

	int selectEmployerWomanCount(int seq);

	List<MarkerLocation> selectHireMap(int seq);

}
