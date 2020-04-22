package kosta.albanara.model;

import java.util.Date;

public class EmployeeEval {
	private int employeeEvalSeq;	//�������򰡹�ȣ
	private int employeeSeq;	//�����ڹ�ȣ
	private int employerSeq;	//�����ȣ
	private int activity;	//���ؼ� ����
	private int collaboration;	//���¼� ����
	private int leadership; 	//������ ����
	private int diligence; 	//���Ǽ� ����
	private int comprehension;	//���ص� ����
	private int contentment; 	//������ ����
	private Date lastModifyDate; 	//������������¥
	
	
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
