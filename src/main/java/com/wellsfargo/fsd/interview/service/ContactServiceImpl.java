package com.wellsfargo.fsd.interview.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.interview.dao.ContactRepository;
import com.wellsfargo.fsd.interview.entity.Contact;
import com.wellsfargo.fsd.interview.exception.ContactException;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository contactRepo;

	@Override
	@Transactional
	public Contact add(Contact contact) throws ContactException {
		if(contact!=null)
		{
			if(contactRepo.existsById(contact.getContactId())) {
				throw new ContactException("Contact Already exists");
			}
			if(contactRepo.existsByMobile(contact.getMobile())) {
				throw new ContactException("Mobile Already exists");
			}
			contactRepo.save(contact);
		}
		return contact;
	}

	@Override
	@Transactional
	public Contact save(Contact contact) throws ContactException {
		if(contact!=null)
		{
			if(!contactRepo.existsById(contact.getContactId())) {
				throw new ContactException("Contact id not found");
			}
			contactRepo.save(contact);
		}
		return contact;
	}

	@Override
	@Transactional
	public boolean deleteContact(int contactId) throws ContactException {
		
		
			if(!contactRepo.existsById(contactId)) {
				throw new ContactException("Contact id not found");
			}
			contactRepo.deleteById(contactId);
		
		return true;
	}

	@Override
	public Contact getContact(int contactId) throws ContactException {
	
		return contactRepo.findById(contactId).orElse(null);
	}

	@Override
	public List<Contact> getAllContacts() throws ContactException {
		
		return contactRepo.findAll();
	}

}
