package kosta.albanara.model;

import java.io.Serializable;

public class HyunMap implements Serializable {
	 private String content;
	private String latlngX;
	private String latlngY;
	
	public HyunMap() {}
	
	public HyunMap(String content, String latlngX, String latlngY) {
		super();
		this.content = content;
		this.latlngX = latlngX;
		this.latlngY = latlngY;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLatlngX() {
		return latlngX;
	}
	public void setLatlngX(String latlngX) {
		this.latlngX = latlngX;
	}
	public String getLatlngY() {
		return latlngY;
	}
	public void setLatlngY(String latlngY) {
		this.latlngY = latlngY;
	}

	@Override
	public String toString() {
		return "Map [content=" + content + ", latlngX=" + latlngX + ", latlngY=" + latlngY + "]";
	}
	
	
}
