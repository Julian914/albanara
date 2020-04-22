package kosta.albanara.model;

public class EmployerEval {
	private int employeeEvalSeq;    //기업평가seq
	private int employerSeq;		//기업seq
	private int employeeSeq;		//구직자seq
	private int workingSpaceEnviroment;	//근무환경점수
	private int ownerPersonnality;		//대표자성격점수
	private int coworkerPersonality;	//동료성격점수
	private int wageContentment;		//시급만족도점수
	private String lastModifyDate;		//마지막수정날짜
	
	
	public int getEmployeeEvalSeq() {
		return employeeEvalSeq;
	}
	public void setEmployeeEvalSeq(int employeeEvalSeq) {
		this.employeeEvalSeq = employeeEvalSeq;
	}
	public int getEmployerSeq() {
		return employerSeq;
	}
	public void setEmployerSeq(int employerSeq) {
		this.employerSeq = employerSeq;
	}
	public int getEmployeeSeq() {
		return employeeSeq;
	}
	public void setEmployeeSeq(int employeeSeq) {
		this.employeeSeq = employeeSeq;
	}
	public int getWorkingSpaceEnviroment() {
		return workingSpaceEnviroment;
	}
	public void setWorkingSpaceEnviroment(int workingSpaceEnviroment) {
		this.workingSpaceEnviroment = workingSpaceEnviroment;
	}
	public int getOwnerPersonnality() {
		return ownerPersonnality;
	}
	public void setOwnerPersonnality(int ownerPersonnality) {
		this.ownerPersonnality = ownerPersonnality;
	}
	public int getCoworkerPersonality() {
		return coworkerPersonality;
	}
	public void setCoworkerPersonality(int coworkerPersonality) {
		this.coworkerPersonality = coworkerPersonality;
	}
	public int getWageContentment() {
		return wageContentment;
	}
	public void setWageContentment(int wageContentment) {
		this.wageContentment = wageContentment;
	}
	public String getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	
	
	
	
}
