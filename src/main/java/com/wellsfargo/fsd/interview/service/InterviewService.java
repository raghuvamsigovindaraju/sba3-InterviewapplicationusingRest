package com.wellsfargo.fsd.interview.service;

import java.util.List;

import com.wellsfargo.fsd.interview.entity.Interview;
import com.wellsfargo.fsd.interview.exception.InterviewException;

public interface InterviewService {

	Interview add(Interview user) throws InterviewException;
	
	Interview save(Interview user) throws InterviewException;
	
	boolean deleteInterview(int uId) throws InterviewException;
	
	Interview getInterview(int uId) throws InterviewException;
	
	List<Interview> getAllinterviews() throws InterviewException;
	
	List<Interview> getAllinterviewsbyInterviewer(String interviewerName) throws InterviewException;
	
	long getCountAllinterviews() throws InterviewException;
	
	long getAttendeeforInterview(int interviewId,int uId) throws InterviewException;
	List<Integer> getallAttendeeforInterview(int interviewId) throws InterviewException;

	List<Interview> getAllinterviewsbyInterviewerandInterview(String interviewername, String interviewname) throws InterviewException;

}
