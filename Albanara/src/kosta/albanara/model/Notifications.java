package kosta.albanara.model;

public class Notifications {
	
	private int notificationSeq;
	private int receiverSeq;
	private String receiverType;
	private String notificationContents;
	private boolean isChecked;
	private String notificationDate;
	
	
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
