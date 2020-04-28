package kosta.albanara.model;

public class HiredHistory {
	private int hiredHistorySeq;
	private int employeeSeq;
	private int recruitmentSeq;
	private int isCompleted;
	
	public HiredHistory() {}	
	
	@Override
	public String toString() {
		return "HiredHistory [hiredHistorySeq=" + hiredHistorySeq + ", employeeSeq=" + employeeSeq + ", recruitmentSeq="
				+ recruitmentSeq + ", isCompleted=" + isCompleted + "]";
	}


	public HiredHistory(int hiredHistorySeq, int employeeSeq, int recruitmentSeq, int isCompleted) {
		super();
		this.hiredHistorySeq = hiredHistorySeq;
		this.employeeSeq = employeeSeq;
		this.recruitmentSeq = recruitmentSeq;
		this.isCompleted = isCompleted;
	}


	public int getHiredHistorySeq() {
		return hiredHistorySeq;
	}
	public void setHiredHistorySeq(int hiredHistorySeq) {
		this.hiredHistorySeq = hiredHistorySeq;
	}
	public int getEmployeeSeq() {
		return employeeSeq;
	}
	public void setEmployeeSeq(int employeeSeq) {
		this.employeeSeq = employeeSeq;
	}
	public int getRecruitmentSeq() {
		return recruitmentSeq;
	}
	public void setRecruitmentSeq(int recruitmentSeq) {
		this.recruitmentSeq = recruitmentSeq;
	}
	public int getIsCompleted() {
		return isCompleted;
	}
	public void setIsCompleted(int isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	
}
