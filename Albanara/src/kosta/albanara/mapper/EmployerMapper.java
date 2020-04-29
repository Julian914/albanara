package kosta.albanara.mapper;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;

public interface EmployerMapper {
	int insertEmployer(Employers employers);
	Employers employerLogIn(Employers employers);
	int updateEmployer(Employers employer);
	int deleteEmployer(Employers employer);
	Employers detailEmployer(int employerSeq);
}
