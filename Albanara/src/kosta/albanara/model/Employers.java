package kosta.albanara.model;

import java.io.Serializable;

public class Employers implements Serializable{
	private int employerSeq;	//�����ȣ
	private String employerId;	//������̵�
	private String employerPw;	//�����й�ȣ
	private String employerName;	//����̸�
	private String employerNumber;		//����ڹ�ȣ
	private String employerAddress;		//������ּ�
	private String employerHomePage;	//���Ȩ�������ּ�
	private String employerField;	//�����о�
	private String ownerName;	//��ǥ���̸�
	private String ownerPhone;	//��ǥ����ȭ��ȣ
	private int reportCount;	//���޴���Ƚ��
	private int likeCount;	//���ƿ� ���� Ƚ��
	private int unlikeCount; //���ο��� ���� Ƚ��
	private int favoriteEmployerCount;	//���ɱ�� ���� Ƚ��
	
	public Employers() {}
	
	
	public Employers(String employerId, String employerPw, String employerName, String employerNumber,
			String employerAddress, String employerHomePage, String employerField, String ownerName,
			String ownerPhone) {
		super();
		this.employerId = employerId;
		this.employerPw = employerPw;
		this.employerName = employerName;
		this.employerNumber = employerNumber;
		this.employerAddress = employerAddress;
		this.employerHomePage = employerHomePage;
		this.employerField = employerField;
		this.ownerName = ownerName;
		this.ownerPhone = ownerPhone;
	}


	public String getEmployerId() {
		return employerId;
	}
	public void setEmployerId(String employerId) {
		this.employerId = employerId;
	}
	public String getEmployerPw() {
		return employerPw;
	}
	public void setEmployerPw(String employerPw) {
		this.employerPw = employerPw;
	}
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	public String getEmployerNumber() {
		return employerNumber;
	}
	public void setEmployerNumber(String employerNumber) {
		this.employerNumber = employerNumber;
	}
	public String getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(String employerAddress) {
		this.employerAddress = employerAddress;
	}
	public String getEmployerHomePage() {
		return employerHomePage;
	}
	public void setEmployerHomepage(String employerHomepage) {
		this.employerHomePage = employerHomepage;
	}
	public String getEmployerField() {
		return employerField;
	}
	public void setEmployerField(String employerField) {
		this.employerField = employerField;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhone() {
		return ownerPhone;
	}
	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}
	public int getReportCount() {
		return reportCount;
	}
	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getUnlikeCount() {
		return unlikeCount;
	}
	public void setUnlikeCount(int unlikeCount) {
		this.unlikeCount = unlikeCount;
	}
	public int getFavoriteEmployerCount() {
		return favoriteEmployerCount;
	}
	public void setFavoriteEmployerCount(int favoriteEmployerCount) {
		this.favoriteEmployerCount = favoriteEmployerCount;
	}
	public int getEmployerSeq() {
		return employerSeq;
	}
	public void setEmployerSeq(int employerSeq) {
		this.employerSeq = employerSeq;
	}
	public void setEmployerHomePage(String employerHomePage) {
		this.employerHomePage = employerHomePage;
	}
}
