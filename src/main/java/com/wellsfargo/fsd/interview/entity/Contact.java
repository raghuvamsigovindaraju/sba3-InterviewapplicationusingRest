package com.wellsfargo.fsd.interview.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@NotNull(message="Contact Id is required")
	@Min(value=1,message="Contact Id can not be zero or negative")
	private Integer contactId;
	
	@Column(name="fnm")
	@NotNull(message="Full name is required")
	@NotBlank(message="Full name cant be blank")
	@Size(min=5,max=25,message="full name should be between 5 to 25 chars")
	private String fullName;
	
	@Column(name="dob")
	@DateTimeFormat(iso=ISO.DATE)
	@PastOrPresent(message="DOB Cant be future Date")
	private LocalDate dateOfBirth;
	
	@Column(name="mno")
	@Pattern(regexp="[1-9][0-9]{9}",message="mobile should be of 10 digits only")
	@NotNull(message="mobile number cant be blank")
	@NotBlank(message="mobile number cant be blank")
	private String mobile;
	
	@Column(name="grp")
	private String group;
	
	@Column(name="married")
	private Boolean married;
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Boolean getMarried() {
		return married;
	}

	public void setMarried(Boolean married) {
		this.married = married;
	}

	public Contact() {
		//left unimplemented.
	}

	public Contact(Integer contactId, String fullName, LocalDate dateOfBirth, String mobile) {
		super();
		this.contactId = contactId;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fullName=" + fullName + ", dateOfBirth=" + dateOfBirth
				+ ", mobile=" + mobile + "]";
	}
	
	
}
