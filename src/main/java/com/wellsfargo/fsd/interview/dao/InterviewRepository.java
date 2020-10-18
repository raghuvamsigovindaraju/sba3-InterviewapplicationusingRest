package com.wellsfargo.fsd.interview.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.interview.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer>{

	
	List<Interview> findAllByInterviewName(String interviewName);
	
	List<Interview> findAllByInterviewerName(String interviewerName);
	
	@Query("SELECT i from Interview i WHERE i.interviewerName=:interviewerName and i.interviewName=:interviewName")
	List<Interview> findAllByInterviewerNameandInterviewName(@Param("interviewerName") String interviewerName,@Param("interviewName") String interviewName);

	@Query("select i.uId from Interview i WHERE i.interviewId=:interviewId")
	public List<Integer> findAllAttendeIds(@Param("interviewId") int interviewId);
	
     
	
	@Query("SELECT COUNT(u) FROM Interview u WHERE u.interviewId=:interviewId and u.uId=:uId")
    long countAllAttendeestoInterview(@Param("interviewId") int interviewId,@Param("uId") int uId);

	@Query("SELECT COUNT(c) FROM Interview c")
	long countAllInterviews();
}
