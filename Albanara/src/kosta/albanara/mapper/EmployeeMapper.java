package kosta.albanara.mapper;

import kosta.albanara.model.Resumes;

public interface EmployeeMapper {
	
	int insertResume(Resumes resume);	//�̷¼� ���(����)
	Resumes searchResume(int employeeSeq);	//�̷¼� ��ȸ��ư�� Ŭ���ϸ� resume_seq�� ��������(����)
	
	
}
