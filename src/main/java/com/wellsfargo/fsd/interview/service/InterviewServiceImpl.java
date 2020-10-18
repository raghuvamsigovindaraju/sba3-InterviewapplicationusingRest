package com.wellsfargo.fsd.interview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.interview.dao.InterviewRepository;
import com.wellsfargo.fsd.interview.entity.Interview;
import com.wellsfargo.fsd.interview.exception.InterviewException;

@Service
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	private InterviewRepository interviewRepo;

	@Override
	@Transactional
	public Interview add(Interview interview) throws InterviewException {
		if(interview!=null)
		{
			if(interviewRepo.existsById(interview.getInterviewId())) {
				throw new InterviewException("Interview Already exists");
			}
			
			interviewRepo.save(interview);
		}
		return interview;
	}

	@Override
	@Transactional
	public Interview save(Interview interview) throws InterviewException {
		if(interview!=null)
		{
			if(!interviewRepo.existsById(interview.getInterviewId())) {
				throw new InterviewException("Interview id not found");
			}
			interviewRepo.save(interview);
		}
		return interview;
	}

	@Override
	@Transactional
	public boolean deleteInterview(int id) throws InterviewException {
		
		
			if(!interviewRepo.existsById(id)) {
				throw new InterviewException("Interview id not found");
			}
			interviewRepo.deleteById(id);
		
		return true;
	}
	

	@Override
	public Interview getInterview(int id) throws InterviewException {
	
		return interviewRepo.findById(id).orElse(null);
	}

	@Override
	public List<Interview> getAllinterviews() throws InterviewException {
		// TODO Auto-generated method stub
		return interviewRepo.findAll();
	}

	@Override
	public List<Interview> getAllinterviewsbyInterviewer(String interviewerName) throws InterviewException {
		// TODO Auto-generated method stub
		return interviewRepo.findAllByInterviewerName(interviewerName);
	}

	@Override
	public long getCountAllinterviews() throws InterviewException {
		long count=interviewRepo.countAllInterviews();
		return count;
	}

	@Override
	public long getAttendeeforInterview(int interviewId,int uId) throws InterviewException {

          long count=interviewRepo.countAllAttendeestoInterview(interviewId, uId);
		 return count;
            
	}

	@Override
	public List<Integer> getallAttendeeforInterview(int interviewId) throws InterviewException {
		
		return interviewRepo.findAllAttendeIds(interviewId);
	}

	@Override
	public List<Interview> getAllinterviewsbyInterviewerandInterview(String interviewername, String interviewname)
			throws InterviewException {
		// TODO Auto-generated method stub
		return interviewRepo.findAllByInterviewerNameandInterviewName(interviewername, interviewname);
	}

	/*
	 * @Override public int getCountAllinterviews() throws InterviewException { //
	 * TODO Auto-generated method stub return interviewRepo.countAllInterviews(); }
	 */



}
