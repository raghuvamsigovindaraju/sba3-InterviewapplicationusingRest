package com.wellsfargo.fsd.interview.dto;

import java.time.LocalDate;

public class InterviewDto {
	
	private Integer interviewId;

	private Integer uId;

	private LocalDate interviewDate;
	
	private String interviewerName;
	
	private String interviewName;

	private String userSkills;

	private String interviewStatus;
	
	private String remarks;
    
	
	public Integer getInterviewId() {
		return interviewId;
	}

	
	  public void setInterviewId(Integer interviewId) { 
		if(interviewId!=null) {
	     this.interviewId = interviewId; }
		else { this.interviewId=0; }
	  
	  }

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		if(uId!=null)
		{
		  this.uId = uId;
		}
		else 
		{
			this.uId=0;
		}
		
	}

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



}
