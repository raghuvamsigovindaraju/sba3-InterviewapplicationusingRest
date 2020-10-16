package com.wellsfargo.fsd.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.interview.dto.InterviewDto;
import com.wellsfargo.fsd.interview.entity.Interview;
import com.wellsfargo.fsd.interview.exception.InterviewException;
import com.wellsfargo.fsd.interview.service.Converter;
import com.wellsfargo.fsd.interview.service.InterviewService;

@RestController
@RequestMapping("/interviews")
public class InterviewRestController {
		
	@Autowired
	private InterviewService interviewService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping
	public ResponseEntity<InterviewDto> addInterviews(@RequestBody InterviewDto interviewdto) throws InterviewException{
		
		
		Interview interview=converter.dtoToEntity_interview(interviewdto);
		InterviewDto interviewdto_returned=converter.entityToDto_interview(interviewService.add(interview)) ;
		return new ResponseEntity<InterviewDto>(interviewdto_returned,HttpStatus.OK);
		
	}
	
	
	
}
