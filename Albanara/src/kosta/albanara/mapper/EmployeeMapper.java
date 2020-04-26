package kosta.albanara.mapper;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Resumes;

public interface EmployeeMapper {
	int insertEmployee(Employees employees);
	
	int insertResume(Resumes resume);	//이력서 등록(동현)
	Resumes searchResume(int employeeSeq);	//이력서 조회버튼을 클릭하면 resume_seq로 가져오기(동현)
	int updateResume(Resumes resume);	//이력서 수정(동현)
	
}
