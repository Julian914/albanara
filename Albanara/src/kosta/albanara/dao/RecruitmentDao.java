package kosta.albanara.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.albanara.mapper.RecruitmentMapper;
import kosta.albanara.model.Application;
import kosta.albanara.model.Employee;
import kosta.albanara.model.HiredHistory;
import kosta.albanara.model.Proposal;
import kosta.albanara.model.Recruitment;

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



	public int insertRecruitment(Recruitment recruitment) {
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

	public int updateRecruitment(Recruitment recruitment) {
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

	public Recruitment getRecruitment(int seq) {
		SqlSession session = getSqlSessionFactory().openSession();
		RecruitmentMapper mapper = null;
		Recruitment recruitment = null;
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


	//진행중인 전체 공고목록
		public List<Recruitment> recruitmentList(){
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			List<Recruitment> list = null;
			try {
				list = sqlSession.getMapper(RecruitmentMapper.class).recruitmentList();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (sqlSession != null) {
					sqlSession.close();
				}
			}

			return list;
		}
		
	
	
	
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
	
	
	
	
	public int insertApplication(Application application) {
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

	
	public List<Application> totalApplicationList(){
		List<Application> totalApplicationList = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			totalApplicationList = sqlSession.getMapper(RecruitmentMapper.class).totalApplicationList();			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return totalApplicationList;
	};
	


	/*제안 받은 공고 리스트 */
	public List<Recruitment> showProposalRecruitments(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitment> list = null;
		
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
		int re = 0;
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
		int re = 0;
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
	
	public List<Recruitment> completeRecruitment(int seq){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitment> list = null;
		try {
			list = sqlSession.getMapper(RecruitmentMapper.class).completeRecruitment(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public List<Recruitment> applyRecruitment(int seq){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Recruitment> applyList = null;
		try {
			applyList = sqlSession.getMapper(RecruitmentMapper.class).applyRecruitment(seq);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return applyList;
	}
	

	
	
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
