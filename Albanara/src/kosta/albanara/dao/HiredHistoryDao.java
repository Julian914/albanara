package kosta.albanara.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.HiredHistroyMapper;
import kosta.albanara.model.HiredHistory;

public class HiredHistoryDao {
	private static HiredHistoryDao instance;

	public static HiredHistoryDao getInstance() {
		if (instance == null)
			instance = new HiredHistoryDao();
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
	
	public int insertHiredHistroy(HiredHistory hiredHistory) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int success = 0;
		try {
			success = sqlSession.getMapper(HiredHistroyMapper.class).insertHiredHistory(hiredHistory);
			if (success > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}		
		return success;
	}
}
