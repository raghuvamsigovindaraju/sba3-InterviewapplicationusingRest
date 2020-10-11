package com.wellsfargo.fsd.interview.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.interview.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer>{
	
	
}
