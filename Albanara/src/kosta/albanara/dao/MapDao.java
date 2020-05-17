package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EmployerMapper;
import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.NearRecruitment;


public class MapDao {
   private static MapDao instance;

   public static MapDao getInstance() {
      if (instance == null)
         instance = new MapDao();
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

   public List<NearRecruitment> nearRecruitment() {
      SqlSession sqlSession = getSqlSessionFactory().openSession();
      List<NearRecruitment> list = null;
      try {
    	 list = sqlSession.getMapper(RecruitmentMapper.class).showNearRecruitments();
         System.out.println(list);
         System.out.println("Mapdao 안");
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