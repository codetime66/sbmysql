package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IPersonDAO;
import com.concretepage.entity.Person;

@Service
public class PersonService implements IPersonService {
    
	@Autowired
	private IPersonDAO personDAO;

	@Override
	public List<Person> getAllPersons(){
		return personDAO.getAllPersons();
	}
        //	public List<Person> getPersonShirts(){
	@Override
	public List<?> getPersonShirts(){
		return personDAO.getPersonShirts();
	}        
}
