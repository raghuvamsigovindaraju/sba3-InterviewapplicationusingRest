package com.wellsfargo.fsd.interview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wellsfargo.fsd.interview.dao.UserRepository;
import com.wellsfargo.fsd.interview.dto.UserDto;
import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.UserException;

@Component
public class Converter {
	
	@Autowired
	private UserRepository userRepo;
	
public UserDto entityToDto(User user) {

		
		ModelMapper mapper =new ModelMapper();
		UserDto map = mapper.map(user, UserDto.class);
		return map;
		
	}

public  List<UserDto> entityToDto(List<User> users) {
	
	return	users.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
	
}

public User dtoToEntity(UserDto dto) throws UserException
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
		if(dto.getFirstName()==null)
		{
			exceptionlist.add("First Name cant be blank");
		}
		if(dto.getFirstName().length()<5 || dto.getFirstName().length()>30)
		{
			exceptionlist.add("First Name should be between 5 & 30 chars");
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
		/*
		 * if(dto.getUserId()!=null) { if(userRepo.existsById(dto.getUserId())) { throw
		 * new UserException("user id already exists please use different id"); } else
		 * if(dto.getFirstName()!=null){ if(dto.getFirstName().length()<5 ||
		 * dto.getFirstName().length()>30) { throw new
		 * UserException("First Name should be min 5 and max 30"); }
		 * 
		 * 
		 * // ModelMapper mapper = new ModelMapper(); // map = mapper.map(dto,
		 * User.class); }
		 * 
		 * } else { throw new UserException("user id cant be null"); }
		 */
	}
	
	return map;
}

public List<User> dtoToEntity(List<UserDto> dto)
{

	return dto.stream().map(x -> {
		try {
			return dtoToEntity(x);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}).collect(Collectors.toList());
}

}
