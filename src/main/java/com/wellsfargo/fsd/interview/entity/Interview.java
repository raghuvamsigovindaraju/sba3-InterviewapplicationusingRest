package com.wellsfargo.fsd.interview.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="interview")
public class Interview {
	
	@Id
	private Integer interviewId;
	
	@Column
	private Integer uId;
	
	@Column(name="interviwername")
	private String interviwerName;
	
	@Column(name="interviewname")
	private String interviewName;
	
	@Column(name="userskills")
	private String userSkills;
	
	@Column(name="date")
	private LocalDate interviewDate;
	
	@Column(name="interviewstatus")
	private String interviewStatus;
	
	@Column(name="remarks")
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

	public String getInterviwerName() {
		return interviwerName;
	}

	public void setInterviwerName(String interviwerName) {
		this.interviwerName = interviwerName;
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
	
	public Interview() {
		//left unimplemented.
	}

	
	public Interview(Integer interviewId, Integer uId, String interviwerName, String interviewName, String userSkills,
			LocalDate interviewDate, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.uId = uId;
		this.interviwerName = interviwerName;
		this.interviewName = interviewName;
		this.userSkills = userSkills;
		this.interviewDate = interviewDate;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", uId=" + uId + ", interviwerName=" + interviwerName
				+ ", interviewName=" + interviewName + ", userSkills=" + userSkills + ", interviewDate=" + interviewDate
				+ ", interviewStatus=" + interviewStatus + ", remarks=" + remarks + "]";
	}


		
}
