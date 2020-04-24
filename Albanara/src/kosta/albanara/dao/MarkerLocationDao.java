package kosta.albanara.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.MarkerLocationMapper;
import kosta.albanara.model.MarkerLocation;

public class MarkerLocationDao {
	private static MarkerLocationDao instance;
	public static MarkerLocationDao getInstance() {
		if (instance == null)
			instance = new MarkerLocationDao();
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
	
	public void insertMarkerLocation(MarkerLocation markerLocation) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(MarkerLocationMapper.class).insertMarkerLocation(markerLocation);
			if(re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	public int existMarkerLocation(String road_address) {
		int re = 0;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MarkerLocationMapper.class).existMarkerLocation(road_address);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}		
		return re;
	}
	
}
