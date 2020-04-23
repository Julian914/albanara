package kosta.albanara.model;

import java.io.Serializable;
import java.sql.Date;

public class Recruitments implements Serializable {
	private int recruitmentSeq;
	private int employerSeq;
	private String recruitmentTitle;
	private String recruitmentType;
	private int recruitmentSize;
	private Date startingWorkingDate;
	private Date endingWorkingDate;
	private int totalWorkingDay;
	private int startingWorkingTime;
	private int endingWorkingTime;
	private int totalWorkingTime;	
	private int wage;
	private String wageType;
	private String gender;
	private int minAge;
	private int maxAge;
	private String recruitmentContents;
	private String requirementQuestion1;
	private String requirementQuestion2;
	private String requirementQuestion3;	
	private String workingPlaceAddress;
	private Date closingDate;
	private Date lastModifyDate;	

	public Recruitments() {
		super();
	}

	public Recruitments(int employerSeq, String recruitmentTitle, String recruitmentType, int recruitmentSize, Date startingWorkingDate,
			Date endingWorkingDate, int totalWorkingDay, int startingWorkingTime, int endingWorkingTime,
			int totalWorkingTime, String wageType, int wage, String gender, int minAge, int maxAge,
			String requirementQuestion1, String requirementQuestion2, String requirementQuestion3,
			String workingPlaceAddress, Date closingDate, String recruitmentContents) {
		super();
		this.employerSeq = employerSeq;
		this.recruitmentTitle = recruitmentTitle;
		this.recruitmentType = recruitmentType;
		this.recruitmentSize = recruitmentSize;
		this.startingWorkingDate = startingWorkingDate;
		this.endingWorkingDate = endingWorkingDate;
		this.totalWorkingDay = totalWorkingDay;
		this.startingWorkingTime = startingWorkingTime;
		this.endingWorkingTime = endingWorkingTime;
		this.totalWorkingTime = totalWorkingTime;
		this.wageType = wageType;
		this.wage = wage;
		this.gender = gender;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.requirementQuestion1 = requirementQuestion1;
		this.requirementQuestion2 = requirementQuestion2;
		this.requirementQuestion3 = requirementQuestion3;
		this.workingPlaceAddress = workingPlaceAddress;
		this.closingDate = closingDate;
		this.recruitmentContents = recruitmentContents;
	}

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

	public String getRecruitmentTitle() {
		return recruitmentTitle;
	}

	public void setRecruitmentTitle(String recruitmentTitle) {
		this.recruitmentTitle = recruitmentTitle;
	}

	public String getRecruitmentType() {
		return recruitmentType;
	}

	public void setRecruitmentType(String recruitmentType) {
		this.recruitmentType = recruitmentType;
	}

	public int getRecruitmentSize() {
		return recruitmentSize;
	}

	public void setRecruitmentSize(int recruitmentSize) {
		this.recruitmentSize = recruitmentSize;
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

	public int getTotalWorkingDay() {
		return totalWorkingDay;
	}

	public void setTotalWorkingDay(int totalWorkingDay) {
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

	public String getWageType() {
		return wageType;
	}

	public void setWageType(String wageType) {
		this.wageType = wageType;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
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

	public String getRecruitmentContents() {
		return recruitmentContents;
	}

	public void setRecruitmentContents(String recruitmentContents) {
		this.recruitmentContents = recruitmentContents;
	}

	@Override
	public String toString() {
		return "Recruitments [recruitmentSeq=" + recruitmentSeq + ", employerSeq=" + employerSeq + ", recruitmentTitle="
				+ recruitmentTitle + ", recruitmentType=" + recruitmentType + ", recruitmentSize=" + recruitmentSize
				+ ", startingWorkingDate=" + startingWorkingDate + ", endingWorkingDate=" + endingWorkingDate
				+ ", totalWorkingDay=" + totalWorkingDay + ", startingWorkingTime=" + startingWorkingTime
				+ ", endingWorkingTime=" + endingWorkingTime + ", totalWorkingTime=" + totalWorkingTime + ", wageType="
				+ wageType + ", wage=" + wage + ", gender=" + gender + ", minAge=" + minAge + ", maxAge=" + maxAge
				+ ", requirementQuestion1=" + requirementQuestion1 + ", requirementQuestion2=" + requirementQuestion2
				+ ", requirementQuestion3=" + requirementQuestion3 + ", lastModifyDate=" + lastModifyDate
				+ ", workingPlaceAddress=" + workingPlaceAddress + ", closingDate=" + closingDate
				+ ", recruitmentContents=" + recruitmentContents + "]";
	}

}
