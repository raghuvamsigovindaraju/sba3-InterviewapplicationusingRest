package com.wellsfargo.fsd.interview.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import com.wellsfargo.fsd.interview.dao.UserRepository;
import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.UserException;
import com.wellsfargo.fsd.interview.service.Converter;

public class UserDto {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private User user;
	
	@Autowired
	private Converter converter;

	private Integer userId;

	@NotNull(message="First Name is required")
	@Size(min=5,max=30,message="first name should be between 5 to 30 chars")
	private String firstName;

	@NotNull(message="Last Name is required")
	@Size(min=3,max=25,message="last name should be between 3 to 25 chars")
	private String lastName;
    
	@NotNull(message="Email required")
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",message="email should be valid")
	private String email;
    
	@NotNull(message="mobile number required")
	@Pattern(regexp="[1-9][0-9]{9}",message="mobile should be of 10 digits only")
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
		this.firstName = firstName;
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
