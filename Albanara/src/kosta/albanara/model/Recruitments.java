package kosta.albanara.model;

public class Recruitments {
	private int recruitmentSeq;		//공고번호
	private int employerSeq;		//기업번호
	private String workingPeriod;		//근무기간
	private String dayOfWeek;		//근무요일
	private String workingTime;	 //근무시간
	private int wage;	//급여
	private String gender; 	//성별
	private int minAge;		//최소연령
	private int maxAge; 	//최대연령
	private String requirementQuestion1; 	//우대조건질문1
	private String requirementQuestion2;	 //우대조건질문2
	private String requirementQuestion3;	 //우대조건질문3
	private String lastModifyDate; 	//마지막수정날짜
	private String workingPlaceAddress; 	//근무지주소
	private String closingDate;		 //모집종료일
	private String applyingType; 	//접수방법
	
	
	
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
	public String getWorkingPeriod() {
		return workingPeriod;
	}
	public void setWorkingPeriod(String workingPeriod) {
		this.workingPeriod = workingPeriod;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getWorkingTime() {
		return workingTime;
	}
	public void setWorkingTime(String workingTime) {
		this.workingTime = workingTime;
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
	public String getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public String getWorkingPlaceAddress() {
		return workingPlaceAddress;
	}
	public void setWorkingPlaceAddress(String workingPlaceAddress) {
		this.workingPlaceAddress = workingPlaceAddress;
	}
	public String getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	public String getApplyingType() {
		return applyingType;
	}
	public void setApplyingType(String applyingType) {
		this.applyingType = applyingType;
	}
	
}
