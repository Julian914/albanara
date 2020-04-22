package kosta.albanara.model;

public class Applications {
	private int applicationSeq;		//지원번호
	private int recruitmentSeq;		//공고번호
	private int employeeSeq;		//구직자번호
	private String applicationDate;		//지원날짜
	private String requirementAnswer1;	//우대조건답변1
	private String requirementAnswer2;	//우대조건답변2
	private String requirementAnswer3;	//우대조건답변3
	
	
	public int getApplicationSeq() {
		return applicationSeq;
	}
	public void setApplicationSeq(int applicationSeq) {
		this.applicationSeq = applicationSeq;
	}
	public int getRecruitmentSeq() {
		return recruitmentSeq;
	}
	public void setRecruitmentSeq(int recruitmentSeq) {
		this.recruitmentSeq = recruitmentSeq;
	}
	public int getEmployeeSeq() {
		return employeeSeq;
	}
	public void setEmployeeSeq(int employeeSeq) {
		this.employeeSeq = employeeSeq;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getRequirementAnswer1() {
		return requirementAnswer1;
	}
	public void setRequirementAnswer1(String requirementAnswer1) {
		this.requirementAnswer1 = requirementAnswer1;
	}
	public String getRequirementAnswer2() {
		return requirementAnswer2;
	}
	public void setRequirementAnswer2(String requirementAnswer2) {
		this.requirementAnswer2 = requirementAnswer2;
	}
	public String getRequirementAnswer3() {
		return requirementAnswer3;
	}
	public void setRequirementAnswer3(String requirementAnswer3) {
		this.requirementAnswer3 = requirementAnswer3;
	}
	
}
