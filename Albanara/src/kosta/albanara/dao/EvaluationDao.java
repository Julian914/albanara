package kosta.albanara.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EvaluationMapper;

public class EvaluationDao {
	private static EvaluationDao instance;

	public static EvaluationDao getInstance() {
		if (instance == null)
			instance = new EvaluationDao();
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

	public double selectAvgWorkingSpaceEnviroment(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		double re = 0;
		try {
			re = sqlSession.getMapper(EvaluationMapper.class).selectAvgWorkingSpaceEnviroment(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	};
	
	public double selectAvgOwnerPersonnality(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		double re = 0;
		try {
			re = sqlSession.getMapper(EvaluationMapper.class).selectAvgOwnerPersonnality(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	};
	
	public double selectAvgCoworkerPersonality(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		double re = 0;
		try {
			re = sqlSession.getMapper(EvaluationMapper.class).selectAvgCoworkerPersonality(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	};
	
	public double selectAvgWageContentment(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		double re = 0;
		try {
			re = sqlSession.getMapper(EvaluationMapper.class).selectAvgWageContentment(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	};
}
