package com.wellsfargo.fsd.interview.dto;

import com.wellsfargo.fsd.interview.exception.UserException;

public class UserDto {
	

	private Integer userId;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

	public Integer getUserId() {
		return userId;
	}
	
	

	public void setUserId(Integer userId) throws UserException {
		
		if(userId!=null)
		{
			this.userId = userId;
		}
		else
		{
			this.userId=0;
		}
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName!=null)
		{
			this.firstName = firstName;
		}
	
		
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	} 
	
	
	
	 

}
