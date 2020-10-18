package com.wellsfargo.fsd.interview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.interview.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("SELECT u FROM User u WHERE u.userId =:userIds")
	List<User> findAllByUserIds(@Param("userIds") List<Integer> userIds);

}
