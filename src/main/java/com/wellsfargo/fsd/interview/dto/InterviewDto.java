package com.wellsfargo.fsd.interview.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InterviewDto {
	
	@NotNull(message="Interview Id is required")
	private Integer interviewId;

	private Integer uId;

	@Size(min=5,max=30,message="Interviwer Name should be between 5 to 30 chars")
	private String interviewerName;
	
	@NotNull(message="Interview Name is required")
	@Size(min=3,max=30,message="Interviw Name should be between 3 to 30 chars")
	private String interviewName;
	
	@NotNull(message="User Skill is required")
	@Size(min=5,max=30,message="User Skill should be between 5 to 30 chars")
	private String userSkills;

	private LocalDate interviewDate;

	@NotNull(message="Interview Status is required")
	@Size(min=5,max=100,message="Interview Status should be between 5 to 100 chars")
	private String interviewStatus;

	@NotNull(message="Remarks is required")
	@Size(min=5,max=100,message="Remarks should be between 5 to 100 chars")
	private String remarks;
    
	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
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

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
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
