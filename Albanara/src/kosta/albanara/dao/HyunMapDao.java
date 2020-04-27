package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.model.NearRecruitments;


public class HyunMapDao {
	private static HyunMapDao instance;

	public static HyunMapDao getInstance() {
		if (instance == null)
			instance = new HyunMapDao();
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

	public List<NearRecruitments> nearRecruitment() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<NearRecruitments> list = null;
		try {
			list = sqlSession.selectList("kosta.albanara.mapper.RecruitmentMapper.showNearRecruitments");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return list;
	}
}
