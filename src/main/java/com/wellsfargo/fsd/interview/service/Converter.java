package com.wellsfargo.fsd.interview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.interview.dao.InterviewRepository;
import com.wellsfargo.fsd.interview.dao.UserRepository;
import com.wellsfargo.fsd.interview.dto.InterviewDto;
import com.wellsfargo.fsd.interview.dto.UserDto;
import com.wellsfargo.fsd.interview.entity.Interview;
import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.InterviewException;
import com.wellsfargo.fsd.interview.exception.UserException;

@Component
public class Converter {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private InterviewRepository interviewRepo;
	@Autowired
	private InterviewService interviewService;
public UserDto entityToDto_user(User user) {

		
		ModelMapper mapper =new ModelMapper();
		UserDto map = mapper.map(user, UserDto.class);
		return map;
		
	}

public InterviewDto entityToDto_interview(Interview interview) {

	
	ModelMapper mapper =new ModelMapper();
	InterviewDto map = mapper.map(interview, InterviewDto.class);
	return map;
	
}

public  List<UserDto> entityToDto_user(List<User> users) {
	
	return	users.stream().map(x -> entityToDto_user(x)).collect(Collectors.toList());
	
}

public  List<InterviewDto> entityToDto_interview(List<Interview> interviews) {
	
	return	interviews.stream().map(x -> entityToDto_interview(x)).collect(Collectors.toList());
	
}

public boolean dto_is_User_Exists(int userid) throws UserException
{
	
	if(!userRepo.existsById(userid))
	{
		
		return false;
	}
    
	return true;
}

public boolean dto_is_Interview_Exists(int id) throws InterviewException
{
	
	if(!interviewRepo.existsById(id))
	{
		
		return false;
	}
    
	return true;
}

public boolean dto_is_Attendee_For_Interview_Exists(int interviewId,int uId) throws InterviewException
{

	//Interview i=interviewService.getAttendeeforInterview(interviewId,uId);
	
	  if(interviewService.getAttendeeforInterview(interviewId,uId)!=0) 
	  {
	  
	  return true; 
	  }
	  
	  else { return false; }
	 
	
	//return true;

}

public User dtoToEntity_user(UserDto dto) throws UserException
{
	User map=null;

	List<String> exceptionlist=new ArrayList<String>();
	if(dto!=null)
	{
		if(dto.getUserId()==0) {
			exceptionlist.add("User Id is null");
		}
		
		if(userRepo.existsById(dto.getUserId()))
		{
			
			exceptionlist.add("User Id already exists");
		}
		if(dto.getFirstName().equals(""))
		{
			exceptionlist.add("First Name cant be blank");
		}
		if(dto.getFirstName().length()<5 || dto.getFirstName().length()>30)
		{
			exceptionlist.add("First Name should be between 5 & 30 chars");
		}
		if(dto.getLastName().equals(""))
		{
			exceptionlist.add("Last Name cant be blank");
		}
		if(dto.getLastName().length()<3 || dto.getLastName().length()>25)
		{
			exceptionlist.add("Last Name should be between 3 & 25 chars");
		}
		
		if(dto.getEmail().equals(""))
		{
			exceptionlist.add("Email Id cant be blank");
		}
		 
		 if(!dto.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
			 
		  exceptionlist.add("Email should be in valid format"); }
		 
		if(dto.getMobile().equals(""))
		{
			exceptionlist.add("Mobile number cant be blank");
		}
		if((dto.getMobile().length()<3 || dto.getMobile().length()>10))
		{
			exceptionlist.add("Mobile number should be between 3 to 10 chars");
		}
		
		if(exceptionlist.size()>0)
		{
			throw new UserException(exceptionlist.toString());
		}
		else
		{
			ModelMapper mapper = new ModelMapper();
			map = mapper.map(dto,User.class);
		}

	}
	
	return map;
}

public Interview dtoToEntity_interview(InterviewDto dto) throws InterviewException
{
	Interview map=null;

	List<String> exceptionlist=new ArrayList<String>();
	if(dto!=null)
	{
		if(dto.getInterviewId()==0) {
			exceptionlist.add("Interview Id is null");
		}
		
		if(interviewRepo.existsById(dto.getInterviewId()))
		{
			
			exceptionlist.add("Interview Id already exists");
		}
		if(dto.getInterviewerName().equals(""))
		{
			exceptionlist.add("Interviewer Name cant be blank");
		}
		if(dto.getInterviewerName().length()<5 || dto.getInterviewerName().length()>30)
		{
			exceptionlist.add("Interviewer Name should be between 5 & 30 chars");
		}
		if(dto.getInterviewName().equals(""))
		{
			exceptionlist.add("Interview Name cant be blank");
		}
		if(dto.getInterviewName().length()<5 || dto.getInterviewName().length()>30)
		{
			exceptionlist.add("Interview Name should be between 5 & 30 chars");
		}
		if(dto.getUserSkills().equals(""))
		{
			exceptionlist.add("User Skill cant be blank");
		}
		if(dto.getUserSkills().length()<5 || dto.getUserSkills().length()>30)
		{
			exceptionlist.add("User Skill should be between 5 & 30 chars");
		}
		if(dto.getInterviewStatus().equals(""))
		{
			exceptionlist.add("Interview Status cant be blank");
		}
		if(dto.getInterviewStatus().length()<5 || dto.getInterviewStatus().length()>100)
		{
			exceptionlist.add("Interview status should be between 5 & 100 chars");
		}
		if(dto.getRemarks().equals(""))
		{
			exceptionlist.add("Remarks cant be blank");
		}
		if(dto.getRemarks().length()<5 || dto.getRemarks().length()>100)
		{
			exceptionlist.add("Remarks 	should be between 5 & 100 chars");
		}
		if(exceptionlist.size()>0)
		{
			throw new InterviewException(exceptionlist.toString());
		}
		else
		{
			ModelMapper mapper = new ModelMapper();
			map = mapper.map(dto,Interview.class);
			//map.setInterviewerName("c");
		}

	}
	
	return map;
}

public List<User> dtoToEntity_user(List<UserDto> dto)
{

	return dto.stream().map(x -> {
		try {
			return dtoToEntity_user(x);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}).collect(Collectors.toList());
}

public List<Interview> dtoToEntity_interview(List<InterviewDto> dto)
{

	return dto.stream().map(x -> {
		try {
			return dtoToEntity_interview(x);
		} catch (InterviewException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}).collect(Collectors.toList());
}
}
