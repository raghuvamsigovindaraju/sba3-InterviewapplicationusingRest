package com.wellsfargo.fsd.interview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.interview.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer>{

	
	List<Interview> findAllByInterviewName(String interviewName);
	
	List<Interview> findAllByInterviewerName(String interviewerName);
	
}
