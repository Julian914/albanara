package kosta.albanara.model;

import java.util.Date;

public class Resumes {

	private int resumeSeq;  //�̷¼���ȣ
	private String pictureFilename;	//����
	private String resumeTitle;  	//�̷¼�����
	private String resumeContents;	//�̷¼� ����
	private String desiredWorkingArea; //����ٹ�����
	private Date lastModifyDate;  //������������¥
	
	
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
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	
	
	
	

}
