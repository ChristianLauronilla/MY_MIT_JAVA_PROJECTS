package com.fsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsp.dao.FirstDAO;
import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.entity.Certificate;
import com.fsp.entity.CertificateUpdate;
import com.fsp.entity.Order;
import com.fsp.entity.OrderUpdate;


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
	
	//start of code
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
	
	//certificate
		public int insertCertificate(Certificate certificate) {
			return dao.insertCertificate(certificate);
		}
		
		public List<Certificate> getAllCertificate() {
			return dao.getAllCertificate();
		}
		
		public Certificate searchCertificate(int uCertificate) {
			return dao.searchCertificate(uCertificate);
		}
		
		public Certificate searchCertificateByName(String uCertificate) {
			return dao.searchCertificateByName(uCertificate);
		}
		
		public boolean updateCertificate(CertificateUpdate uCertificate) {
			return dao.updateCertificate(uCertificate);
		}

		public boolean deleteCertificate(String uCertificate) {
			return dao.deleteCertificate(uCertificate);
		}
		//order
		public int insertOrder(Order order) {
					return dao.insertOrder(order);
				}
		
		public List<Order> getAllOrderActive() {
			return dao.getAllOrderActive();
		}
		
		public Order searchOrderByEntityName(String uEntity_name) {
			return dao.searchOrderByEntityName(uEntity_name);
		}
		
		public boolean updateOrderToApproved(OrderUpdate order) {
			return dao.updateOrderToApproved(order);
		}
		
		public boolean updateOrderToDeclined(OrderUpdate order) {
			return dao.updateOrderToDeclined(order);
		}
		
		public List<OrderUpdate> getAllOrder() {
			return dao.getAllOrder();
		}
}
