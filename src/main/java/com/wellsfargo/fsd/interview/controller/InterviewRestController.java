package com.wellsfargo.fsd.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.interview.dto.InterviewDto;
import com.wellsfargo.fsd.interview.dto.UserDto;
import com.wellsfargo.fsd.interview.entity.Interview;
import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.InterviewException;
import com.wellsfargo.fsd.interview.exception.UserException;
import com.wellsfargo.fsd.interview.service.Converter;
import com.wellsfargo.fsd.interview.service.InterviewService;
import com.wellsfargo.fsd.interview.service.UserService;

@RestController
@RequestMapping("/interviews")
public class InterviewRestController {
		
	@Autowired
	private InterviewService interviewService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private Converter converter;
	
	@PostMapping
	public ResponseEntity<InterviewDto> addInterviews(@RequestBody InterviewDto interviewdto) throws InterviewException{
		
		
		Interview interview=converter.dtoToEntity_interview(interviewdto);
		InterviewDto interviewdto_returned=converter.entityToDto_interview(interviewService.add(interview)) ;
		return new ResponseEntity<InterviewDto>(interviewdto_returned,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInterviews(@PathVariable("id") int id) throws InterviewException{
		
		   if(converter.dto_is_Interview_Exists(id))
		   {
			   interviewService.deleteInterview(id); 
		   }
		   else
		   {
			   throw new InterviewException("Interview	 does not exist");
		   }
		   
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	
	
	@GetMapping("fetchbyinterview/{interviewername}/{interviewname}")
	public ResponseEntity<List<InterviewDto>> getContacts(@PathVariable("interviewername") String interviewername,@PathVariable("interviewname") String interviewname) throws InterviewException{
		
		//ResponseEntity<Interview> resp=null;
		List<Interview> interviewlist=interviewService.getAllinterviewsbyInterviewerandInterview(interviewername,interviewname);
		List<InterviewDto> interviewDtolist=converter.entityToDto_interview(interviewlist);
		
		if(interviewDtolist.size()>0)
		{
			return new ResponseEntity<>(interviewDtolist,HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<>(interviewDtolist,HttpStatus.NOT_FOUND);
		}
		  

		
	}
	
	@GetMapping
	public ResponseEntity<List<InterviewDto>> getAllInterviews() throws InterviewException{
		
		List<InterviewDto> interviewDto=converter.entityToDto_interview(interviewService.getAllinterviews());
		return new ResponseEntity<>(interviewDto,HttpStatus.OK);
		
	}
	
	@GetMapping("fetch-attendelist-interview/{interviewId}")
	public ResponseEntity<List<UserDto>> getAllAttendestoInterview(@PathVariable("interviewId") int interviewId) throws InterviewException, UserException{
		
		List<Integer> uId_List=interviewService.getallAttendeeforInterview(interviewId);
		List<User> users=userService.getAllusersByIds(uId_List);
		List<UserDto> userDto=converter.entityToDto_user(users);
		return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}
	
	@GetMapping("interviewcount")
	public ResponseEntity<String> getCountAllInterviews() throws InterviewException{
		
		long count=interviewService.getCountAllinterviews();
		
		return new ResponseEntity<>("Total Count of Interviews is :: "+count,HttpStatus.OK);
		
	}
	@PatchMapping("update/{id}/{status}")
	public ResponseEntity<InterviewDto> updateInterviewStatus(@PathVariable("id") int id, @PathVariable("status") String status) throws InterviewException{
		Interview interview=null;
		if(converter.dto_is_Interview_Exists(id))
		   {
			  
			interview=interviewService.getInterview(id);
			interview.setInterviewStatus(status);
			interviewService.save(interview);
					
		   }
		   else
		   {
			   throw new InterviewException("Interview Id does not exist");
		   }
		return new ResponseEntity<InterviewDto>(converter.entityToDto_interview(interview),HttpStatus.OK);
		
	}
				
	@PatchMapping("add-attendee/{interviewid}/{userid}")
	public ResponseEntity<InterviewDto> addUserToInterview(@PathVariable("interviewid") int interviewid, @PathVariable("userid") int userid) throws InterviewException{
		Interview interview=null;
		
		if(converter.dto_is_Attendee_For_Interview_Exists(interviewid,userid))
		{
					  
		  throw new InterviewException("Attendee already registered for the Interview");
		}
		else
		{
			interview=interviewService.getInterview(interviewid);
			interview.setuId(userid);
			interviewService.save(interview);
		}
		   
		return new ResponseEntity<InterviewDto>(converter.entityToDto_interview(interview),HttpStatus.OK);
		
	}
	
	
}
