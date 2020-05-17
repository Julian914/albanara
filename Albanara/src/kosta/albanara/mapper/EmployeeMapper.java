package kosta.albanara.mapper;

import java.util.List;

import kosta.albanara.model.Employee;
import kosta.albanara.model.Resume;

public interface EmployeeMapper {
	int insertEmployee(Employee employee);

	int insertResume(Resume resume); // �̷¼� ���?(����)

	Resume searchResume(int employeeSeq); // �̷¼� ��ȸ��ư�� Ŭ���ϸ� resume_seq�� ��������(����)

	int updateResume(Resume resume); // �̷¼� ����(����)

	int updateEmployee(Employee employee);

	Employee basicInformation(int employeeSeq);

	Employee getEmployee(int seq);

	int deleteEmployee(Employee employee);

	Employee employeeLogIn(Employee employee);

	List<Employee> allEmployeeList();

	List<Employee> employeeList(int recruitmentSeq);

	List<Employee> hiredEmployeeList();

}
