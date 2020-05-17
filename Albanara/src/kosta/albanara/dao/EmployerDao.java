package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.EmployerMapper;
import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.Employee;
import kosta.albanara.model.Employer;
import kosta.albanara.model.HiredHistory;
import kosta.albanara.model.MarkerLocation;
import kosta.albanara.model.Proposal;
import kosta.albanara.model.Recruitment;

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

	public int insertEmployer(Employer employers) {

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
	
	public Employer employerLogIn(Employer employers) {
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Employer employer = new Employer();
		
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
	
	public int updateEmployer(Employer employer) {
		
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
	
public int deleteEmployer(Employer employer) {
		
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

public Employer detailEmployers(int employerSeq) {
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	Employer employer = null;
	try {
		employer = sqlSession.getMapper(EmployerMapper.class).detailEmployer(employerSeq);
		
		System.out.println("기업 id : "+employer.getEmployerId());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return employer;
	}

	/* 기업에 지원한 남자 수 */
	public int selectEmployerManCount(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(EmployerMapper.class).selectEmployerManCount(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	/* 기업에 지원한 여자 수 */
	public int selectEmployerWomanCount(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(EmployerMapper.class).selectEmployerWomanCount(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	/* 채용자들 위치 구하기 */
	public List<MarkerLocation> selectHireMap(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<MarkerLocation> list = null;
		try {
			list = sqlSession.getMapper(EmployerMapper.class).selectHireMap(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	

	
	
	//한 기업의 전체 공고 목록
	public List<Recruitment> totalRecruitmentList(int employerSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitment> list = null;
		try {
			list = sqlSession.getMapper(RecruitmentMapper.class).totalRecruitmentList(employerSeq);
			//System.out.println("dao : "+list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

		return list;
	}
	
	//한 기업의 진행중인 공고목록
	public List<Recruitment> nowRecruinmentList(int employerSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitment> nowRecruinmentList= null;
		
		try {
			nowRecruinmentList = sqlSession.getMapper(RecruitmentMapper.class).nowRecruinmentList(employerSeq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return nowRecruinmentList;
	};
	
	//한 기업의 마감된 공고목록
	public List<Recruitment> endRecruitmentList(int employerSeq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitment> endRecruitmentList = null;
		
		try {
			endRecruitmentList= sqlSession.getMapper(RecruitmentMapper.class).endRecruitmentList(employerSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}	
		return endRecruitmentList;
	};
	
	
	
	
	//추천받은 구직자에게 제안하기 proposals
	public int insertProposal(Proposal proposals) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(RecruitmentMapper.class).insertProposal(proposals);		
			if (re > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return re;
	}

	//기업이 구직자 채용하기
	public int insertHiredHistory(HiredHistory hiredHistory) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int hired = -1;
		
		try {
			hired = sqlSession.getMapper(RecruitmentMapper.class).insertHiredHistory(hiredHistory);		
			if (hired > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return hired;
	};
	
	
	
	
	
	
}