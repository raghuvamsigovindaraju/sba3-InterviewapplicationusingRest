package com.wellsfargo.fsd.interview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.interview.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	
}
