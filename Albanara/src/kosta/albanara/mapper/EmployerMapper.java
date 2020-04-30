package kosta.albanara.mapper;

import java.util.List;


import kosta.albanara.model.Employers;
import kosta.albanara.model.MarkerLocation;


public interface EmployerMapper {
	int insertEmployer(Employers employers);
	Employers employerLogIn(Employers employers);
	int updateEmployer(Employers employer);
	int deleteEmployer(Employers employer);
	Employers detailEmployer(int employerSeq);
	int selectEmployerManCount(int seq);
	int selectEmployerWomanCount(int seq);
	List<MarkerLocation> selectHireMap(int seq);


	
}
