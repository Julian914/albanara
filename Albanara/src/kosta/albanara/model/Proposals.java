package kosta.albanara.model;

public class Proposals {
	private int proposalSeq;   //제안seq
	private int recruitmentSeq;	//공고seq
	private int employeeSeq;	//구직자seq
	private boolean isAccepted;  //수락여부
	private String proposalDate; //제안날짜
	
	
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
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public String getProposalDate() {
		return proposalDate;
	}
	public void setProposalDate(String proposalDate) {
		this.proposalDate = proposalDate;
	}
	
	
	
}
