package kosta.albanara.mapper;

import java.util.List;

import kosta.albanara.model.Employees;
import kosta.albanara.model.Recruitments;

public interface RecruitmentMapper {
	List<Recruitments> recruitmentList();

	int insertRecruitment(Recruitments recruitment);

	int updateRecruitment(Recruitments recruitment);

	Recruitments getRecruitment(int seq);

	List<Employees> applicantList(int recruitmentSeq);

	int deleteRecruitment(int seq);
}
