package com.wellsfargo.fsd.interview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.interview.dao.UserRepository;
import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.UserException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	@Transactional
	public User add(User user) throws UserException {
		if(user!=null)
		{
			if(userRepo.existsById(user.getUserId())) {
				throw new UserException("User Already exists");
			}
			
			userRepo.save(user);
		}
		return user;
	}

	@Override
	@Transactional
	public User save(User user) throws UserException {
		if(user!=null)
		{
			if(!userRepo.existsById(user.getUserId())) {
				throw new UserException("User id not found");
			}
			userRepo.save(user);
		}
		return user;
	}

	@Override
	@Transactional
	public boolean deleteUser(int UserId) throws UserException {
		
		
			if(!userRepo.existsById(UserId)) {
				throw new UserException("User id not found");
			}
			userRepo.deleteById(UserId);
		
		return true;
	}

	@Override
	public User getUser(int UserId) throws UserException {
	
		return userRepo.findById(UserId).orElse(null);
	}

	@Override
	public List<User> getAllusers() throws UserException {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
