package kosta.albanara.model;

public class Employers {
	private int employerSeq;	//기업번호
	private String employerId;	//기업아이디
	private String employerPw;	//기업비밀번호
	private String employerName;	//기업이름
	private String employerNumber;		//사업자번호
	private String employerAddress;		//사업장주소
	private String employerHomepage;	//기업홈페이지주소
	private String employerField;	//사업장분야
	private String ownerName;	//대표자이름
	private String ownerPhone;	//대표자전화번호
	private int reportCount;	//지급누락횟수
	private int likeCount;	//좋아요 받은 횟수
	private int unlikeCount; //별로에요 받은 횟수
	private int favoriteEmployerCount;	//관심기업 받은 횟수
	
	public Employers() {}
	
	
	public Employers(String employerId, String employerPw, String employerName, String employerNumber,
			String employerAddress, String employerHomepage, String employerField, String ownerName,
			String ownerPhone) {
		super();
		this.employerId = employerId;
		this.employerPw = employerPw;
		this.employerName = employerName;
		this.employerNumber = employerNumber;
		this.employerAddress = employerAddress;
		this.employerHomepage = employerHomepage;
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
	public String getEmployerHomepage() {
		return employerHomepage;
	}
	public void setEmployerHomepage(String employerHomepage) {
		this.employerHomepage = employerHomepage;
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
	
}
