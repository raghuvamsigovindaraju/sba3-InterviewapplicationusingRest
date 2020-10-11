package com.wellsfargo.fsd.interview.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
	
	@NotNull(message="User Id is required")
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

}
