package kosta.albanara.model;


import java.io.Serializable;
import java.util.Date;

public class Applications implements Serializable {
	private int applicationSeq;		//������ȣ
	private int recruitmentSeq;		//�����ȣ
	private int employeeSeq;		//�����ڹ�ȣ
	private Date applicationDate;		//������¥
	private String requirementAnswer1;	//������Ǵ亯1
	private String requirementAnswer2;	//������Ǵ亯2
	private String requirementAnswer3;	//������Ǵ亯3
	
	public Applications() {}
	
	
	public Applications(int recruitmentSeq, int employeeSeq, String requirementAnswer1,
			String requirementAnswer2, String requirementAnswer3) {
		super();
		this.recruitmentSeq = recruitmentSeq;
		this.employeeSeq = employeeSeq;
		this.requirementAnswer1 = requirementAnswer1;
		this.requirementAnswer2 = requirementAnswer2;
		this.requirementAnswer3 = requirementAnswer3;
	}




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
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
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
	
	@Override
	public String toString() {
		return "Applications [applicationSeq=" + applicationSeq + ", recruitmentSeq=" + recruitmentSeq
				+ ", employeeSeq=" + employeeSeq + ", applicationDate=" + applicationDate + ", requirementAnswer1="
				+ requirementAnswer1 + ", requirementAnswer2=" + requirementAnswer2 + ", requirementAnswer3="
				+ requirementAnswer3 + "]";
	}
	
	
	
	
	
	
}
