package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EmployeeMapper;
import kosta.albanara.mapper.EmployerMapper;
import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.Employee;
import kosta.albanara.model.Employer;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.Recruitment;
import kosta.albanara.model.Resume;


public class EmployeeDao {
	private static EmployeeDao instance;

	public static EmployeeDao getInstance() {
		if (instance == null)
			instance = new EmployeeDao();
		return instance;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public int insertEmployee(Employee employees) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(EmployeeMapper.class).insertEmployee(employees);
	
			if(re > 0) {
				sqlSession.commit();		
			}else {
				sqlSession.rollback();		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	
	public int insertResume(Resume resume){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(EmployeeMapper.class).insertResume(resume);
			if (re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}
	
	
	public Resume searchResume(int employeeSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Resume resume = null;
		
		try {
			resume = sqlSession.getMapper(EmployeeMapper.class).searchResume(employeeSeq);
			System.out.println(resume);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return resume;
	}
	
	public int updateResume(Resume resume) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(EmployeeMapper.class).updateResume(resume);
			if(re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}

	
	public Employee basicInformation(int employeeSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Employee employee = null;
		
		try {
			employee = sqlSession.getMapper(EmployeeMapper.class).basicInformation(employeeSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		
		return employee;
	}
	
	
	
	
	public Employee getEmployee(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		EmployeeMapper mapper = null;
		Employee employee = null;
		try {
			mapper = session.getMapper(EmployeeMapper.class);
			System.out.println("?��?�쭅�옄 SEQ: " + seq);
			employee = mapper.getEmployee(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return employee;
	}

	public int updateEmployee(Employee employee) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re= -1;
		
		try {
			
			re = sqlSession.getMapper(EmployeeMapper.class).updateEmployee(employee);
			
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
	public int deleteEmployee(Employee employee) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re= -1;
		
		try {
			
			re = sqlSession.getMapper(EmployeeMapper.class).deleteEmployee(employee);
			
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}
	
public Employee employeeLogIn(Employee employees) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Employee employee = new Employee();
		
		try {
			employee = sqlSession.getMapper(EmployeeMapper.class).employeeLogIn(employees);
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return employee;
	}


public List<Employee> allEmployeeList(){
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	List<Employee> employeeList = null;
	try {
		employeeList = sqlSession.getMapper(EmployeeMapper.class).allEmployeeList();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	return employeeList;
}



//한 공고에 해당하는 지원자목록
	public List<Employee> employeeList(int recruitmentSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Employee> employeeList = null;

		try {
			employeeList = sqlSession.getMapper(EmployeeMapper.class).employeeList(recruitmentSeq);
			//System.out.println("dao: " + employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return employeeList;
	}
	
	//채용된 구직자 목록
	public List<Employee> hiredEmployeeList(){
		List<Employee> hiredEmployeeList = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			hiredEmployeeList = sqlSession.getMapper(EmployeeMapper.class).hiredEmployeeList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return hiredEmployeeList;
	};
	

}
