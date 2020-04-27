package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.Applications;
import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;

public class RecruitmentDao {
	private static RecruitmentDao instance;

	public static RecruitmentDao getInstance() {
		if (instance == null)
			instance = new RecruitmentDao();
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

	public List<Recruitments> totalRecruitmentList() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitments> list = null;
		try {
			list = sqlSession.getMapper(RecruitmentMapper.class).totalRecruitmentList();
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

	// 한 공고에 해당하는 지원자목록
	public List<Employees> employeeList(int recruitmentSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Employees> employeeList = null;

		try {
			employeeList = sqlSession.getMapper(RecruitmentMapper.class).employeeList(recruitmentSeq);
			System.out.println("dao: " + employeeList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return employeeList;

	}

	public int insertRecruitment(Recruitments recruitment) {
		int resultCount = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		RecruitmentMapper mapper = null;
		try {
			System.out.println("DAO 출력" + recruitment.toString());
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

	public Recruitments getRecruitment(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		RecruitmentMapper mapper = null;
		Recruitments recruitment = null;
		try {
			mapper = session.getMapper(RecruitmentMapper.class);
			System.out.println("공고수정 SEQ: " + seq);
			recruitment = mapper.getRecruitment(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return recruitment;
	}

	public List<Employees> totalEmployeeList() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Employees> employeeList = null;

		try {
			employeeList = sqlSession.getMapper(RecruitmentMapper.class).totalEmployeeList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	};

	public List<Applications> totalApplicationList() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Applications> applicationList = null;

		try {
			applicationList = sqlSession.getMapper(RecruitmentMapper.class).totalApplicationList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return applicationList;
	};

	public int insertApplication(Applications application) {
		int resultCount = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			resultCount = sqlSession.getMapper(RecruitmentMapper.class).insertApplication(application);
			if (resultCount > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return resultCount;
	}

}
