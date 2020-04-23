package kosta.albanara.model;

import java.util.Date;

public class Employees {
	private int employeeSeq;   
	private int resumeSeq;  //이력서 번호
	private String employeeId;   //구직자id
	private String employeePw;   //구직자 pw
	private String employeeName; //구직자이름
	private Date employeeBirthday; //구직자생년월일
	private String employeeEmail;   //구직자이메일
	private String employeeGender;  //성별
	private String employeePhone;   //전화번호	
	private String employeeAddress; // 주소
	private int attributeCount; 	//평가받은 횟수
	private int noshowCount; 		//무단결근 수
	private int workingDayCount;  	//근무일수
	private String favoriteField1;  //관심직종1
	private String favoriteField2; 	//관심직종2	
	private String favoriteField3;	//관심직종3
	private int activityAvg;		//능력치_적극성
	private int collaborationAvg;	//능력치_협력성
	private int diligencyAvg;		//능력치 성실성
	private int leadershipAvg;		//능력치_리더십
	private int comprehensionAvg;	//능력치_이해도
	private int contentmentAvg;		//능력치_만족도
	
	public Employees() {}
	
	public Employees(String employeeId, String employeePw, String employeeName,
			Date employeeBirthday, String employeeEmail, String employeeGender, String employeePhone,
			String employeeAddress) {
		super();
		this.employeeId = employeeId;
		this.employeePw = employeePw;
		this.employeeName = employeeName;
		this.employeeBirthday = employeeBirthday;
		this.employeeEmail = employeeEmail;
		this.employeeGender = employeeGender;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
	}
	
	
	public int getEmployeeSeq() {
		return employeeSeq;
	}
	public void setEmployeeSeq(int employeeSeq) {
		this.employeeSeq = employeeSeq;
	}
	public int getResumeSeq() {
		return resumeSeq;
	}
	public void setResumeSeq(int resumeSeq) {
		this.resumeSeq = resumeSeq;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeePw() {
		return employeePw;
	}
	public void setEmployeePw(String employeePw) {
		this.employeePw = employeePw;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getEmployeeBirthday() {
		return employeeBirthday;
	}
	public void setEmployeeBirthday(Date employeeBirthday) {
		this.employeeBirthday = employeeBirthday;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public int getAttributeCount() {
		return attributeCount;
	}
	public void setAttributeCount(int attributeCount) {
		this.attributeCount = attributeCount;
	}
	public int getNoshowCount() {
		return noshowCount;
	}
	public void setNoshowCount(int noshowCount) {
		this.noshowCount = noshowCount;
	}
	public int getWorkingDayCount() {
		return workingDayCount;
	}
	public void setWorkingDayCount(int workingDayCount) {
		this.workingDayCount = workingDayCount;
	}
	public String getFavoriteField1() {
		return favoriteField1;
	}
	public void setFavoriteField1(String favoriteField1) {
		this.favoriteField1 = favoriteField1;
	}
	public String getFavoriteField2() {
		return favoriteField2;
	}
	public void setFavoriteField2(String favoriteField2) {
		this.favoriteField2 = favoriteField2;
	}
	public String getFavoriteField3() {
		return favoriteField3;
	}
	public void setFavoriteField3(String favoriteField3) {
		this.favoriteField3 = favoriteField3;
	}
	public int getActivityAvg() {
		return activityAvg;
	}
	public void setActivityAvg(int activityAvg) {
		this.activityAvg = activityAvg;
	}
	public int getCollaborationAvg() {
		return collaborationAvg;
	}
	public void setCollaborationAvg(int collaborationAvg) {
		this.collaborationAvg = collaborationAvg;
	}
	public int getDiligencyAvg() {
		return diligencyAvg;
	}
	public void setDiligencyAvg(int diligencyAvg) {
		this.diligencyAvg = diligencyAvg;
	}
	public int getLeadershipAvg() {
		return leadershipAvg;
	}
	public void setLeadershipAvg(int leadershipAvg) {
		this.leadershipAvg = leadershipAvg;
	}
	public int getComprehensionAvg() {
		return comprehensionAvg;
	}
	public void setComprehensionAvg(int comprehensionAvg) {
		this.comprehensionAvg = comprehensionAvg;
	}
	public int getContentmentAvg() {
		return contentmentAvg;
	}
	public void setContentmentAvg(int contentmentAvg) {
		this.contentmentAvg = contentmentAvg;
	}
	
	
	
}
