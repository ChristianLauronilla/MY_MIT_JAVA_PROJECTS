package com.fsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsp.dao.FirstDAO;
import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;

@Service("firstService")
public class FirstService {

	@Autowired
	private FirstDAO dao;

	public FirstService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean insertPerson(Person person) {
		return dao.insertPerson(person);
	}

	public boolean updatePerson(Person person) {
		return dao.updatePerson(person);
		
	}

	public boolean deletePerson(String pEmailAddress) {
		return dao.deletePerson(pEmailAddress);
	}

	public List<Person> getAllPerson() {
		return dao.getAllPersons();
	}

	public Person searchPerson(String pEmailAddress) {
		return dao.searchPerson(pEmailAddress);
	}

	public int insertUser(User user) {
		return dao.insertUser(user);
	}

	public List<String> getGenders() {
		return dao.getGenders();
	}
	
	//start of chanix code
	//user
	public int insertUserr(Userr userr) {
		return dao.insertUserr(userr);
	}
	
	public List<Userr> getAllUserr() {
		return dao.getAllUserr();
	}
	
	public Userr searchUserr(String uUsername) {
		return dao.searchUserr(uUsername);
	}
	
	public boolean updateUserr(Userr userr) {
		return dao.updateUserr(userr);
	}

	public boolean deleteUserr(String uUsername) {
		return dao.deleteUserr(uUsername);
	}

}
