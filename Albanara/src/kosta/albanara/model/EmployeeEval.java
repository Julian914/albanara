package kosta.albanara.model;

import java.util.Date;

public class EmployeeEval {
	private int employeeEvalSeq;	//구직자평가번호
	private int employeeSeq;	//구직자번호
	private int employerSeq;	//기업번호
	private int activity;	//적극성 점수
	private int collaboration;	//협력성 점수
	private int leadership; 	//리더십 점수
	private int diligence; 	//성실성 점수
	private int comprehension;	//이해도 점수
	private int contentment; 	//만족도 점수
	private Date lastModifyDate; 	//마지막수정날짜
	
	
	public int getEmployeeEvalSeq() {
		return employeeEvalSeq;
	}
	public void setEmployeeEvalSeq(int employeeEvalSeq) {
		this.employeeEvalSeq = employeeEvalSeq;
	}
	public int getEmployeeSeq() {
		return employeeSeq;
	}
	public void setEmployeeSeq(int employeeSeq) {
		this.employeeSeq = employeeSeq;
	}
	public int getEmployerSeq() {
		return employerSeq;
	}
	public void setEmployerSeq(int employerSeq) {
		this.employerSeq = employerSeq;
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public int getCollaboration() {
		return collaboration;
	}
	public void setCollaboration(int collaboration) {
		this.collaboration = collaboration;
	}
	public int getLeadership() {
		return leadership;
	}
	public void setLeadership(int leadership) {
		this.leadership = leadership;
	}
	public int getDiligence() {
		return diligence;
	}
	public void setDiligence(int diligence) {
		this.diligence = diligence;
	}
	public int getComprehension() {
		return comprehension;
	}
	public void setComprehension(int comprehension) {
		this.comprehension = comprehension;
	}
	public int getContentment() {
		return contentment;
	}
	public void setContentment(int contentment) {
		this.contentment = contentment;
	}
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	
	
	
}
