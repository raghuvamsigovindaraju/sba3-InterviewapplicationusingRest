package com.wellsfargo.fsd.interview.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InterviewDto {
	
	@NotNull(message="Interview Id is required")
	private Integer interviewId;

	private Integer uId;
	
	@NotNull(message="Interviwer Name is required")
	@Size(min=5,max=30,message="Interviwer Name should be between 5 to 30 chars")
	private String interviwerName;
	
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

}
