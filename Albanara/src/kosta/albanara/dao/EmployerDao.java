package kosta.albanara.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EmployeeMapper;
import kosta.albanara.mapper.EmployerMapper;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Employers;

public class EmployerDao {
	private static EmployerDao instance;

	public static EmployerDao getInstance() {
		if (instance == null)
			instance = new EmployerDao();
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

	public int insertEmployer(Employers employers) {

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(EmployerMapper.class).insertEmployer(employers);

			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public Employers employerLogIn(Employers employers) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Employers employer = new Employers();
		
		try {
			employer = sqlSession.getMapper(EmployerMapper.class).employerLogIn(employers);
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return employer;
	}
	
	public int updateEmployer(Employers employer) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re= -1;
		
		try {
			
			re = sqlSession.getMapper(EmployerMapper.class).updateEmployer(employer);
			
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
	
public int deleteEmployer(Employers employer) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re= -1;
		
		try {
			
			re = sqlSession.getMapper(EmployerMapper.class).deleteEmployer(employer);
			
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

public Employers detailEmployers(String employerId) {
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	Employers employer = null;
	try {
		employer = sqlSession.getMapper(EmployerMapper.class).detailEmployer(employerId);
		
		System.out.println("´Ù¿À"+employer.getEmployerId());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return employer;
	}
}
