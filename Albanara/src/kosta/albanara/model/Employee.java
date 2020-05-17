package kosta.albanara.model;

import java.io.Serializable;
import java.sql.Date;

public class Employee implements Serializable {
	private int employeeSeq;
	private int resumeSeq; // �̷¼� ��ȣ
	private String employeeId; // ������id
	private String employeePw; // ������ pw
	private String employeeName; // �������̸�
	private Date employeeBirthday; // �����ڻ������
	private String employeeEmail; // �������̸���
	private String employeeGender; // ����
	private String employeePhone; // ��ȭ��ȣ
	private String employeeAddress; // �ּ�
	private int attributeCount; // �򰡹��� Ƚ��
	private int noshowCount; // ���ܰ�� ��
	private int lateCount;
	private int workingDayCount; // �ٹ��ϼ�
	private int activityAvg; // �ɷ�ġ_���ؼ�
	private int collaborationAvg;
	private int diligencyAvg;
	private int leadershipAvg;
	private int comprehensionAvg;
	private int contentmentAvg;
	private int strengthCount;
	private int intelligenceCount;
	private int kindnessCount;
	private int patienceCount;

	public Employee() {
	};

	public Employee(String employeeId, String employeePw, String employeeName, Date employeeBirthday,
			String employeeEmail, String employeeGender, String employeePhone, String employeeAddress) {
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
	
	public int getLateCount() {
		return lateCount;
	}

	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}

	public int getWorkingDayCount() {
		return workingDayCount;
	}

	public void setWorkingDayCount(int workingDayCount) {
		this.workingDayCount = workingDayCount;
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

	public int getStrengthCount() {
		return strengthCount;
	}

	public void setStrengthCount(int strengthCount) {
		this.strengthCount = strengthCount;
	}

	public int getIntelligenceCount() {
		return intelligenceCount;
	}

	public void setIntelligenceCount(int intelligenceCount) {
		this.intelligenceCount = intelligenceCount;
	}

	public int getKindnessCount() {
		return kindnessCount;
	}

	public void setKindnessCount(int kindnessCount) {
		this.kindnessCount = kindnessCount;
	}

	public int getPatienceCount() {
		return patienceCount;
	}

	public void setPatienceCount(int patienceCount) {
		this.patienceCount = patienceCount;
	}

	public Employee(int employeeSeq, int resumeSeq, String employeeId, String employeePw, String employeeName,
			Date employeeBirthday, String employeeEmail, String employeeGender, String employeePhone,
			String employeeAddress, int attributeCount, int noshowCount, int lateCount, int workingDayCount, int activityAvg,
			int collaborationAvg, int diligencyAvg, int leadershipAvg, int comprehensionAvg, int contentmentAvg,
			int strengthCount, int intelligenceCount, int kindnessCount, int patienceCount) {
		super();
		this.employeeSeq = employeeSeq;
		this.resumeSeq = resumeSeq;
		this.employeeId = employeeId;
		this.employeePw = employeePw;
		this.employeeName = employeeName;
		this.employeeBirthday = employeeBirthday;
		this.employeeEmail = employeeEmail;
		this.employeeGender = employeeGender;
		this.employeePhone = employeePhone;
		this.employeeAddress = employeeAddress;
		this.attributeCount = attributeCount;
		this.noshowCount = noshowCount;
		this.lateCount = lateCount;
		this.workingDayCount = workingDayCount;
		this.activityAvg = activityAvg;
		this.collaborationAvg = collaborationAvg;
		this.diligencyAvg = diligencyAvg;
		this.leadershipAvg = leadershipAvg;
		this.comprehensionAvg = comprehensionAvg;
		this.contentmentAvg = contentmentAvg;
		this.strengthCount = strengthCount;
		this.intelligenceCount = intelligenceCount;
		this.kindnessCount = kindnessCount;
		this.patienceCount = patienceCount;
	}

	@Override
	public String toString() {
		return "Employees [employeeSeq=" + employeeSeq + ", resumeSeq=" + resumeSeq + ", employeeId=" + employeeId
				+ ", employeePw=" + employeePw + ", employeeName=" + employeeName + ", employeeBirthday="
				+ employeeBirthday + ", employeeEmail=" + employeeEmail + ", employeeGender=" + employeeGender
				+ ", employeePhone=" + employeePhone + ", employeeAddress=" + employeeAddress + ", attributeCount="
				+ attributeCount + ", noshowCount=" + noshowCount + ", lateCount=" + lateCount + ", workingDayCount=" + workingDayCount
				+ ", activityAvg=" + activityAvg + ", collaborationAvg=" + collaborationAvg + ", diligencyAvg="
				+ diligencyAvg + ", leadershipAvg=" + leadershipAvg + ", comprehensionAvg=" + comprehensionAvg
				+ ", contentmentAvg=" + contentmentAvg + ", strengthCount=" + strengthCount + ", intelligenceCount="
				+ intelligenceCount + ", kindnessCount=" + kindnessCount + ", patienceCount=" + patienceCount + "]";
	}

}
