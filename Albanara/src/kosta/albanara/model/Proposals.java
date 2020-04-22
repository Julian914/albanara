package kosta.albanara.model;

import java.util.Date;

public class Proposals {
	private int proposalSeq;   //제안seq
	private int recruitmentSeq;	//공고seq
	private int employeeSeq;	//구직자seq
	private int isAccepted;  //수락여부
	private Date proposalDate; //제안날짜
	
	
	public int getProposalSeq() {
		return proposalSeq;
	}
	public void setProposalSeq(int proposalSeq) {
		this.proposalSeq = proposalSeq;
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
	public int getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Date getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(Date proposalDate) {
		this.proposalDate = proposalDate;
	}
	
	
	
	
	
	
}
