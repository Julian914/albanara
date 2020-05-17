package kosta.albanara.model;

import java.io.Serializable;
import java.sql.Date;

public class NearRecruitment implements Serializable{
   private int recruitmentSeq;
   private String recruitmentTitle;
   private String recruitmentType;
   private Date startingWorkingDate;
   private Date endingWorkingDate;
   private int startingWorkingTime;
   private int endingWorkingTime;  
   private int wage;
   private String wageType;
   private String latitude;
   private String longitude;
      
   public NearRecruitment() {};

   public int getRecruitmentSeq() {
      return recruitmentSeq;
   }
   public void setRecruitmentSeq(int recruitmentSeq) {
      this.recruitmentSeq = recruitmentSeq;
   }
   public String getRecruitmentTitle() {
      return recruitmentTitle;
   }
   public void setRecruitmentTitle(String recruitmentTitle) {
      this.recruitmentTitle = recruitmentTitle;
   }
   public String getRecruitmentType() {
      return recruitmentType;
   }
   public void setRecruitmentType(String recruitmentType) {
      this.recruitmentType = recruitmentType;
   }
   public Date getStartingWorkingDate() {
      return startingWorkingDate;
   }
   public void setStartingWorkingDate(Date startingWorkingDate) {
      this.startingWorkingDate = startingWorkingDate;
   }
   public Date getEndingWorkingDate() {
      return endingWorkingDate;
   }
   public void setEndingWorkingDate(Date endingWorkingDate) {
      this.endingWorkingDate = endingWorkingDate;
   }
   public int getStartingWorkingTime() {
      return startingWorkingTime;
   }
   public void setStartingWorkingTime(int startingWorkingTime) {
      this.startingWorkingTime = startingWorkingTime;
   }
   public int getEndingWorkingTime() {
      return endingWorkingTime;
   }
   public void setEndingWorkingTime(int endingWorkingTime) {
      this.endingWorkingTime = endingWorkingTime;
   }
   public int getWage() {
      return wage;
   }
   public void setWage(int wage) {
      this.wage = wage;
   }
   public String getWageType() {
      return wageType;
   }
   public void setWageType(String wageType) {
      this.wageType = wageType;
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
   public NearRecruitment(int recruitmentSeq, String recruitmentTitle, String recruitmentType,
         Date startingWorkingDate, Date endingWorkingDate, int startingWorkingTime, int endingWorkingTime, int wage,
         String wageType, String latitude, String longitude) {
      super();
      this.recruitmentSeq = recruitmentSeq;
      this.recruitmentTitle = recruitmentTitle;
      this.recruitmentType = recruitmentType;
      this.startingWorkingDate = startingWorkingDate;
      this.endingWorkingDate = endingWorkingDate;
      this.startingWorkingTime = startingWorkingTime;
      this.endingWorkingTime = endingWorkingTime;
      this.wage = wage;
      this.wageType = wageType;
      this.latitude = latitude;
      this.longitude = longitude;
   }


}