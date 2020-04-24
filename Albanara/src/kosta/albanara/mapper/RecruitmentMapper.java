package kosta.albanara.mapper;

import java.util.List;
import kosta.albanara.model.Recruitments;

public interface RecruitmentMapper {
	List<Recruitments> recruitmentList();
	int insertRecruitment(Recruitments recruitment);
	int applicantList(int recruitmentSeq);
}
