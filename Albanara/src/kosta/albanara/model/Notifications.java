package kosta.albanara.model;

public class Notifications {
	
	private int notificationSeq;     //알림 seq
	private int receiverSeq;	     //받는사람 seq
	private String receiverType;	 //수신구분
	private String notificationContents; //알림내용
	private boolean isChecked;  	 //수신확인여부
	private String notificationDate; //알림날짜
	
	
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
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public String getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(String notificationDate) {
		this.notificationDate = notificationDate;
	}
	
	
	

	
}
