package kosta.albanara.model;

import java.util.Date;

public class Employees {
	private int employeeSeq;   
	private int resumeSeq;  //�̷¼� ��ȣ
	private String employeeId;   //������id
	private String employeePw;   //������ pw
	private String employeeName; //�������̸�
	private Date employeeBirthday; //�����ڻ������
	private String employeeEmail;   //�������̸���
	private String employeeGender;  //����
	private String employeePhone;   //��ȭ��ȣ	
	private String employeeAddress; // �ּ�
	private int attributeCount; 	//�򰡹��� Ƚ��
	private int noshowCount; 		//���ܰ�� ��
	private int workingDayCount;  	//�ٹ��ϼ�
	private String favoriteField1;  //��������1
	private String favoriteField2; 	//��������2	
	private String favoriteField3;	//��������3
	private int activityAvg;		//�ɷ�ġ_���ؼ�
	private int collaborationAvg;	//�ɷ�ġ_���¼�
	private int diligencyAvg;		//�ɷ�ġ ���Ǽ�
	private int leadershipAvg;		//�ɷ�ġ_������
	private int comprehensionAvg;	//�ɷ�ġ_���ص�
	private int contentmentAvg;		//�ɷ�ġ_������
	
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
