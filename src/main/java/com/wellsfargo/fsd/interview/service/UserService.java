package com.wellsfargo.fsd.interview.service;

import java.util.List;

import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.UserException;

public interface UserService {

	User add(User user) throws UserException;
	User save(User user) throws UserException;
	
	boolean deleteUser(int uId) throws UserException;
	
	User getUser(int uId) throws UserException;
	
	List<User> getAllusers() throws UserException;

}
