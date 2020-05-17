package kosta.albanara.mapper;

public interface EvaluationMapper {
	double selectAvgWorkingSpaceEnviroment(int seq);

	double selectAvgOwnerPersonnality(int seq);

	double selectAvgCoworkerPersonality(int seq);

	double selectAvgWageContentment(int seq);

}
