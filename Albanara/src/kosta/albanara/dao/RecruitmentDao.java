package kosta.albanara.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.Recruitments;


public class RecruitmentDao {
	private static RecruitmentDao instance;

	public static RecruitmentDao getInstance() {
		if (instance == null)
			return new RecruitmentDao();
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

	
	
	public List<Recruitments> recruitmentList() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitments> list = null;
		try {
			list = sqlSession.getMapper(RecruitmentMapper.class).recruitmentList();
			System.out.println("dao :"+list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
		
	}
	

	public int insertRecruitment(Recruitments recruitment) {
		int resultCount = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		RecruitmentMapper mapper = null;
		try {
			System.out.println("DAO 출력" + recruitment.toString() );
			mapper = session.getMapper(RecruitmentMapper.class);
			resultCount = mapper.insertRecruitment(recruitment);
			System.out.println("카운트: " + resultCount);
			if (resultCount > 0)
				session.commit();
			else
				session.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return resultCount;
	}

}
