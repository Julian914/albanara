package kosta.albanara.mapper;

import java.util.List;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Resumes;

public interface EmployeeMapper {
	int insertEmployee(Employees employees);
	
	int insertResume(Resumes resume);	//�̷¼� ���?(����)
	Resumes searchResume(int employeeSeq);	//�̷¼� ��ȸ��ư�� Ŭ���ϸ� resume_seq�� ��������(����)
	int updateResume(Resumes resume);	//�̷¼� ����(����)
	int updateEmployee(Employees employee);
	Employees basicInformation(int employeeSeq);
	Employees getEmployee(int seq);
	int deleteEmployee(Employees employee);
	Employees employeeLogIn(Employees employees);
	List<Employees> allEmployeeList();
}
