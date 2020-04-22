package kosta.albanara.model;

public class Proposals {
	private int proposalSeq;
	private int recruitmentSeq;
	private int employeeSeq;
	private boolean isAccepted;
	private String proposalDate;
	
	
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
