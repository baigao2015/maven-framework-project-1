package com.fengjing.framework.spring.data.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fengjing.framework.spring.data.jpa.repository.ContactRepository;
import com.fengjing.framework.spring.data.jpa.service.ContactService;
import com.fengjing.framework.springmvc.model.Contact;

@Service(value="contactServiceImpl")
@Transactional		
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Transactional
	@Override
	public Contact findById(int id) {
		return contactRepository.findById(id);
	}

	@Transactional
	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Transactional
	@Override
	public Contact modifyContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Transactional
	@Override
	public void delete(Contact contact) {
		contactRepository.delete(contact);
	}

	@Transactional
	@Override
	public void delete(int id) {
		contactRepository.delete(id);
	}

	@Transactional
	@Override
	public List<Contact> listAll() {
		return (List<Contact>) contactRepository.findAll();
	}

	@Transactional
	public Page<Contact> findAll(Pageable pageable){
		return contactRepository.findAll(pageable);
	}

	/**
	 * 查询年龄小于150岁 且按Id降序排列
	 * @param age
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Contact> findByAgeLessThanEqualOrderByIdDesc(int age,Pageable pageable) {
		return contactRepository.findByAgeLessThanEqualOrderByIdDesc(age, pageable);
	}
	
}
