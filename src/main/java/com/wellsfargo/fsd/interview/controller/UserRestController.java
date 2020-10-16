package com.wellsfargo.fsd.interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.interview.dto.InterviewDto;
import com.wellsfargo.fsd.interview.dto.UserDto;
import com.wellsfargo.fsd.interview.entity.Contact;
import com.wellsfargo.fsd.interview.entity.Interview;
import com.wellsfargo.fsd.interview.entity.User;
import com.wellsfargo.fsd.interview.exception.ContactException;
import com.wellsfargo.fsd.interview.exception.InterviewException;
import com.wellsfargo.fsd.interview.exception.UserException;
import com.wellsfargo.fsd.interview.service.ContactService;
import com.wellsfargo.fsd.interview.service.Converter;
import com.wellsfargo.fsd.interview.service.InterviewService;
import com.wellsfargo.fsd.interview.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping
	public ResponseEntity<UserDto> addUsers(@RequestBody UserDto userdto) throws UserException{
		
		
		User user=converter.dtoToEntity_user(userdto);
		UserDto userdto_returned=converter.entityToDto_user(userService.add(user)) ;
		return new ResponseEntity<UserDto>(userdto_returned,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsers(@PathVariable("id") int uid) throws UserException{
		
		   if(converter.dto_is_User_Exists(uid))
		   {
			   userService.deleteUser(uid); 
		   }
		   else
		   {
			   throw new UserException("User id does not exist");
		   }
		   
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers() throws UserException{
		
		List<UserDto> userDto=converter.entityToDto_user(userService.getAllusers());
		return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getContacts(@PathVariable("id") int cid) throws ContactException{
		
		ResponseEntity<Contact> resp=null;
		Contact contact=contactService.getContact(cid);
		
		if(contact!=null)
		{
			resp= new ResponseEntity<Contact>(contact,HttpStatus.OK);
		}
		else 
		{
			resp= new ResponseEntity<Contact>(contact,HttpStatus.NOT_FOUND);
		}
		  
		return resp;
		
	}

	@PutMapping
	public ResponseEntity<Contact> updateContacts(@RequestBody Contact contact) throws ContactException{
		
		return new ResponseEntity<Contact>(contactService.save(contact),HttpStatus.OK);
		
	}
}
