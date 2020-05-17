package kosta.albanara.model;

import java.util.Date;

public class Notification {
	
	private int notificationSeq;     //�˸� seq
	private int receiverSeq;	     //�޴»�� seq
	private String receiverType;	 //���ű���
	private String notificationContents; //�˸�����
	private int isChecked;  	 //����Ȯ�ο���
	private Date notificationDate; //�˸���¥
	
	
	public int getNotificationSeq() {
		return notificationSeq;
	}
	public void setNotificationSeq(int notificationSeq) {
		this.notificationSeq = notificationSeq;
	}
	public int getReceiverSeq() {
		return receiverSeq;
	}
	public void setReceiverSeq(int receiverSeq) {
		this.receiverSeq = receiverSeq;
	}
	public String getReceiverType() {
		return receiverType;
	}
	public void setReceiverType(String receiverType) {
		this.receiverType = receiverType;
	}
	public String getNotificationContents() {
		return notificationContents;
	}
	public void setNotificationContents(String notificationContents) {
		this.notificationContents = notificationContents;
	}
	public int getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
	
	

	
}
