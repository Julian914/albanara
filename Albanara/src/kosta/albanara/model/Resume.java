package kosta.albanara.model;

import java.util.Date;

public class Resume {

	private int resumeSeq;  //�̷¼���ȣ
	private String pictureFilename;	//����
	private String resumeTitle;  	//�̷¼�����
	private String resumeContents;	//�̷¼� ����
	private String desiredWorkingArea; //����ٹ�����
	private String favoriteField; //���� ����
	private Date lastModifyDate;  //������������¥
	
	public Resume() {}

	
	
	public Resume(String pictureFilename, String resumeTitle, String resumeContents, String desiredWorkingArea,
			String favoriteField) {
		super();
		this.pictureFilename = pictureFilename;
		this.resumeTitle = resumeTitle;
		this.resumeContents = resumeContents;
		this.desiredWorkingArea = desiredWorkingArea;
		this.favoriteField = favoriteField;
	}



	public int getResumeSeq() {
		return resumeSeq;
	}
	public void setResumeSeq(int resumeSeq) {
		this.resumeSeq = resumeSeq;
	}
	public String getPictureFilename() {
		return pictureFilename;
	}
	public void setPictureFilename(String pictureFilename) {
		this.pictureFilename = pictureFilename;
	}
	public String getResumeTitle() {
		return resumeTitle;
	}
	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}
	public String getResumeContents() {
		return resumeContents;
	}
	public void setResumeContents(String resumeContents) {
		this.resumeContents = resumeContents;
	}
	public String getDesiredWorkingArea() {
		return desiredWorkingArea;
	}
	public void setDesiredWorkingArea(String desiredWorkingArea) {
		this.desiredWorkingArea = desiredWorkingArea;
	}
	public String getFavoriteField() {
		return favoriteField;
	}
	public void setFavoriteField(String favoriteField) {
		this.favoriteField = favoriteField;
	}
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}



	@Override
	public String toString() {
		return "Resumes [resumeSeq=" + resumeSeq + ", pictureFilename=" + pictureFilename + ", resumeTitle="
				+ resumeTitle + ", resumeContents=" + resumeContents + ", desiredWorkingArea=" + desiredWorkingArea
				+ ", favoriteField=" + favoriteField + ", lastModifyDate=" + lastModifyDate + "]";
	}
	
	
	
	

}
