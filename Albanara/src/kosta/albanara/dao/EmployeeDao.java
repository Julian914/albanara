package kosta.albanara.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EmployeeMapper;
import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;
import kosta.albanara.model.Resumes;


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
	
	public int insertEmployee(Employees employees) {
		
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
	
	
	public int insertResume(Resumes resume){
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
	
	
	public Resumes searchResume(int employeeSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Resumes resume = null;
		
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
	
	public int updateResume(Resumes resume) {
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

	public Employees getEmployee(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		EmployeeMapper mapper = null;
		Employees employee = null;
		try {
			mapper = session.getMapper(EmployeeMapper.class);
			System.out.println("구직자 SEQ: " + seq);
			employee = mapper.getEmployee(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return employee;
	}

	public int updateEmployee(Employees employee) {
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

}
