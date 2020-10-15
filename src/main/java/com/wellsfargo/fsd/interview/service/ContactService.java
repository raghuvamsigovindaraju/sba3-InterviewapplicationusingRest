package com.wellsfargo.fsd.interview.service;

import java.util.List;

import com.wellsfargo.fsd.interview.entity.Contact;
import com.wellsfargo.fsd.interview.exception.ContactException;

public interface ContactService {

	Contact add(Contact contact) throws ContactException;
	Contact save(Contact contact) throws ContactException;
	
	boolean deleteContact(int contactId) throws ContactException;
	
	Contact getContact(int contactId) throws ContactException;
	
	List<Contact> getAllContacts() throws ContactException;
}
