package kosta.albanara.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EmployeeMapper;
import kosta.albanara.model.Employees;
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

	public int insertResume(Resumes resume) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;

		try {
			re = sqlSession.getMapper(EmployeeMapper.class).insertResume(resume);
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

		return re;
	}

	public Resumes searchResume(int employeeSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Resumes resume = null;

		try {
			resume = sqlSession.getMapper(EmployeeMapper.class).searchResume(employeeSeq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return resume;
	}

}
