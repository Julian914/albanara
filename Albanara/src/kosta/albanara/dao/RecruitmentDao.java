package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;
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
			System.out.println("DAO insertRecruitment 출력" + recruitment.toString());
			mapper = session.getMapper(RecruitmentMapper.class);
			resultCount = mapper.insertRecruitment(recruitment);
			System.out.println("insertRecruitment 카운트: " + resultCount);
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

	public int updateRecruitment(Recruitments recruitment) {
		int resultCount = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		RecruitmentMapper mapper = null;
		try {
			System.out.println("DAO updateRecruitment 출력" + recruitment.toString());
			mapper = session.getMapper(RecruitmentMapper.class);
			resultCount = mapper.updateRecruitment(recruitment);
			System.out.println("updateRecruitment 카운트: " + resultCount);
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

	public int deleteRecruitment(int seq) {
		int resultCount = -1;
		SqlSession session = getSqlSessionFactory().openSession();
		RecruitmentMapper mapper = null;
		try {
			mapper = session.getMapper(RecruitmentMapper.class);
			resultCount = mapper.deleteRecruitment(seq);
			System.out.println("deleteRecruitment 카운트: " + resultCount);
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
		int result = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			result = sqlSession.getMapper(RecruitmentMapper.class).insertApplication(application);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return result;
	}
	
	/*제안 받은 공고 리스트 */
	public List<Recruitments> showProposalRecruitments(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitments> list = null;
		
		try {
			list = sqlSession.getMapper(RecruitmentMapper.class).showProposalRecruitments(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	/*제안 받은 공고 수락*/
	public void acceptProposalRecruitments(String employeeSeq, String recruitmentSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(RecruitmentMapper.class).acceptProposalRecruitments(employeeSeq, recruitmentSeq);
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
	
	/*제안 받은 공고 거절*/
	public void rejectProposalRecruitments(String employeeSeq, String recruitmentSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(RecruitmentMapper.class).rejectProposalRecruitments(employeeSeq, recruitmentSeq);
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
	
	/* 공고에 지원한 남자 수 */
	public int selectRecruitmentManCount(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(RecruitmentMapper.class).selectRecruitmentManCount(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	/* 공고에 지원한 여자 수 */
	public int selectRecruitmentWomanCount(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(RecruitmentMapper.class).selectRecruitmentWomanCount(seq);
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
