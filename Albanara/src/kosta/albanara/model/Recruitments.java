package kosta.albanara.model;

import java.util.Date;

public class Recruitments {
	private int recruitmentSeq;		//공고번호
	private int employerSeq;		//기업번호
	private Date startingWorkingDate;	//근무시작일
	private Date endingWorkingDate;	//근무종료일
	private String totalWorkingDay;	//총근무일수
	private int startingWorkingTime;	 //근무시작시간
	private int endingWorkingTime; //근무종료시간
	private int totalWorkingTime;	//총근무시간
	private int wage;	//급여
	private String wageType;	//급여타입, 일당/시급
	private String gender; 	//성별
	private int minAge;		//최소연령
	private int maxAge; 	//최대연령
	private String requirementQuestion1; 	//우대조건질문1
	private String requirementQuestion2;	 //우대조건질문2
	private String requirementQuestion3;	 //우대조건질문3
	private Date lastModifyDate; 	//마지막수정날짜
	private String workingPlaceAddress; 	//근무지주소
	private Date closingDate;		 //모집종료일
	
	
	
	public int getRecruitmentSeq() {
		return recruitmentSeq;
	}
	public void setRecruitmentSeq(int recruitmentSeq) {
		this.recruitmentSeq = recruitmentSeq;
	}
	public int getEmployerSeq() {
		return employerSeq;
	}
	public void setEmployerSeq(int employerSeq) {
		this.employerSeq = employerSeq;
	}
	public Date getStartingWorkingDate() {
		return startingWorkingDate;
	}
	public void setStartingWorkingDate(Date startingWorkingDate) {
		this.startingWorkingDate = startingWorkingDate;
	}
	public Date getEndingWorkingDate() {
		return endingWorkingDate;
	}
	public void setEndingWorkingDate(Date endingWorkingDate) {
		this.endingWorkingDate = endingWorkingDate;
	}
	public String getTotalWorkingDay() {
		return totalWorkingDay;
	}
	public void setTotalWorkingDay(String totalWorkingDay) {
		this.totalWorkingDay = totalWorkingDay;
	}
	public int getStartingWorkingTime() {
		return startingWorkingTime;
	}
	public void setStartingWorkingTime(int startingWorkingTime) {
		this.startingWorkingTime = startingWorkingTime;
	}
	public int getEndingWorkingTime() {
		return endingWorkingTime;
	}
	public void setEndingWorkingTime(int endingWorkingTime) {
		this.endingWorkingTime = endingWorkingTime;
	}
	public int getTotalWorkingTime() {
		return totalWorkingTime;
	}
	public void setTotalWorkingTime(int totalWorkingTime) {
		this.totalWorkingTime = totalWorkingTime;
	}
	public int getWage() {
		return wage;
	}
	public void setWage(int wage) {
		this.wage = wage;
	}
	public String getWageType() {
		return wageType;
	}
	public void setWageType(String wageType) {
		this.wageType = wageType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public String getRequirementQuestion1() {
		return requirementQuestion1;
	}
	public void setRequirementQuestion1(String requirementQuestion1) {
		this.requirementQuestion1 = requirementQuestion1;
	}
	public String getRequirementQuestion2() {
		return requirementQuestion2;
	}
	public void setRequirementQuestion2(String requirementQuestion2) {
		this.requirementQuestion2 = requirementQuestion2;
	}
	public String getRequirementQuestion3() {
		return requirementQuestion3;
	}
	public void setRequirementQuestion3(String requirementQuestion3) {
		this.requirementQuestion3 = requirementQuestion3;
	}
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public String getWorkingPlaceAddress() {
		return workingPlaceAddress;
	}
	public void setWorkingPlaceAddress(String workingPlaceAddress) {
		this.workingPlaceAddress = workingPlaceAddress;
	}
	public Date getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	
}
