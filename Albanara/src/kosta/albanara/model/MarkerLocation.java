package kosta.albanara.model;

public class MarkerLocation {
	private int markerLocationSeq;
	private String roadAddress;
	private String latitude;
	private String longitude;
	
	public MarkerLocation() {}
	
	public MarkerLocation(int markerLocationSeq, String roadAddress, String latitude, String longitude) {
		super();
		this.markerLocationSeq = markerLocationSeq;
		this.roadAddress = roadAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getMarkerLocationSeq() {
		return markerLocationSeq;
	}

	public void setMarkerLocationSeq(int markerLocationSeq) {
		this.markerLocationSeq = markerLocationSeq;
	}

	public String getRoadAddress() {
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
}
