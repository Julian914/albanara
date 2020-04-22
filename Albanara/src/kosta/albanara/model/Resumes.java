package kosta.albanara.model;

import java.util.Date;

public class Resumes {

	private int resumeSeq;  //이력서번호
	private String pictureFilename;	//사진
	private String resumeTitle;  	//이력서제목
	private String resumeContents;	//이력서 내용
	private String desiredWorkingArea; //희망근무지역
	private Date lastModifyDate;  //마지막수정날짜
	
	
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
