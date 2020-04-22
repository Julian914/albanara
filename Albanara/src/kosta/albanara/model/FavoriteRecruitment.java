package kosta.albanara.model;

public class FavoriteRecruitment {
	private int favoriteRecruitmentSeq; 	//관심공고번호
	private int employeeSeq; 	//구직자번호
	private int employerSeq;	//기업번호
	
	
	public int getFavoriteRecruitmentSeq() {
		return favoriteRecruitmentSeq;
	}
	public void setFavoriteRecruitmentSeq(int favoriteRecruitmentSeq) {
		this.favoriteRecruitmentSeq = favoriteRecruitmentSeq;
	}
	public int getEmployeeSeq() {
		return employeeSeq;
	}
	public void setEmployeeSeq(int employeeSeq) {
		this.employeeSeq = employeeSeq;
	}
	public int getEmployerSeq() {
		return employerSeq;
	}
	public void setEmployerSeq(int employerSeq) {
		this.employerSeq = employerSeq;
	}
	
	
}
