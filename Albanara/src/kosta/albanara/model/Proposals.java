package kosta.albanara.model;

import java.util.Date;

public class Proposals {
	private int proposalSeq;   //����seq
	private int recruitmentSeq;	//����seq
	private int employeeSeq;	//������seq
	private int isAccepted;  //��������
	private Date proposalDate; //���ȳ�¥
	
	
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
