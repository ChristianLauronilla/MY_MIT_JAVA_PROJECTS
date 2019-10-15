package com.fsp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.service.FirstService;
import com.fsp.dao.FirstDAO;
import com.fsp.entity.Certificate;
import com.fsp.entity.CertificateUpdate;
import com.fsp.entity.Order;
import com.fsp.entity.OrderUpdate;


@Controller
public class FirstController {
	
	@Autowired
	FirstService service;
	FirstDAO dao;
	
	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "/login";
	}
	
	@RequestMapping(value = { "/publicPage" }, method = RequestMethod.GET)
	public String publicPage(Model model) {
		return "/public_page";
	}
	
	@RequestMapping(value = { "/loginError" }, method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("message", "Invalid credentials...");
		return "/login";
	}
	
	@RequestMapping(value = { "/user/home" }, method = RequestMethod.GET)
	public String index(Model model) {
		String username = ((org.springframework.security.core.userdetails.User) 
				SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUsername();
		//User user = service.getUser();
		//model.addAttribute("user",  user);
		return "/home/index";
	}
	
	//start of code
	//user
	@RequestMapping(value = { "/admin/newUser" },method = RequestMethod.GET)
	public String newUser(Model model) {
		return "/home/newUser";
	}
	//insert user
	@RequestMapping(value = { "admin/insertUserr" }, method = RequestMethod.GET)
	public String insertUserr(Model model, @RequestParam("username") String username, 
			@RequestParam("password") String password, @RequestParam("name") String name, 
			@RequestParam("role") String role) {
		Userr userr = new Userr(username, password, name, role);
		if(service.insertUserr(userr) > 0) {
			model.addAttribute("message", "User is successfully added.");
		} else {
			model.addAttribute("message", "Error in adding new user.");
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/listUser";
	}
	//list of user
	@RequestMapping(value = { "admin/listUser" },method = RequestMethod.GET)
	public String listUser(Model model) {
		model.addAttribute("records", service.getAllUserr());
		return "/home/listUser";
	}
	//search userr
	@RequestMapping(value = "/userrSearch", method = RequestMethod.GET)
	public String userrSearch(Model model, @RequestParam("username") String uUsername) {
		Userr userr = service.searchUserr(uUsername);
		if(userr == null) {
			model.addAttribute("message", "Username address is not found.");
		} else {
			model.addAttribute("userr", userr);
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/listUser";
	}
	//update of user
	@RequestMapping(value = "/userrUpdate", method = RequestMethod.GET)
	public String userrUpdate(Model model, @RequestParam("username") String uUsername, @RequestParam("name") String uName,
			@RequestParam("role") String uRole) {
		Userr userr = new Userr(uUsername, uName, uRole);
		if(service.updateUserr(userr)) {
			model.addAttribute("message", "User update is successful");
		} else {
			model.addAttribute("message", "User update is not successful");
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/listUser";
	}
	//delete user
	@RequestMapping(value = "/userrDelete", method = RequestMethod.GET)
	public String userrDelete(Model model, @RequestParam("username") String uUsername) {
		if(service.deleteUserr(uUsername)) {
			model.addAttribute("message", "Delete user is successful.");
		} else {
			model.addAttribute("message", "User is not found.");
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/listUser";
	}
	//-----------------------------------------------------------------------------------
	//certificate
		//insert certificate
		@RequestMapping(value = { "admin/insertCertificate" }, method = RequestMethod.GET)
		public String insertCertificate(Model model, @RequestParam("certificate_name") String certificate_name, 
				@RequestParam("certificate_amount") double certificate_amount) {
			Certificate certificate = new Certificate(certificate_name, certificate_amount);
			if(service.insertCertificate(certificate) > 0) {
				model.addAttribute("message", "Certificate is successfully added.");
			} else {
				model.addAttribute("message", "Error in adding new certificate.");
			}
			model.addAttribute("records", service.getAllCertificate());
			return "/home/certificate";
		}
		//list of certificate
		@RequestMapping(value = { "admin/certificate" },method = RequestMethod.GET)
		public String listCertificate(Model model) {
			model.addAttribute("records", service.getAllCertificate());
			return "/home/certificate";
		}
		//search certificate
		@RequestMapping(value = "/certificateSearch", method = RequestMethod.GET)
		public String certificateSearch(Model model, @RequestParam("certificate_id") int uCertificate_id) {
			Certificate certificate = service.searchCertificate(uCertificate_id);
			if(certificate == null) {
				model.addAttribute("message", "Certificate is not found.");
			} else {
				model.addAttribute("certificate", certificate);
			}
			model.addAttribute("records", service.getAllCertificate());
			return "/home/certificate";
		}
		//update of certificate
		@RequestMapping(value = "/certificateUpdate", method = RequestMethod.GET)
		public String certificateUpdate(Model model, @RequestParam("certificate_name") String uCertificate_name, @RequestParam("certificate_amount") double uCertificate_amount, @RequestParam("certificate_id") int uCertificate_id) 
		{
			CertificateUpdate certificate= new CertificateUpdate(uCertificate_name, uCertificate_amount, uCertificate_id);
			if(service.updateCertificate(certificate)) {
				model.addAttribute("message", "Certificate update is successful");
			} else {
				model.addAttribute("message", "Certificate update is not successful");
			}
			model.addAttribute("records", service.getAllCertificate());
			return "/home/certificate";
		}
		//delete certificate
		@RequestMapping(value = "/certificateDelete", method = RequestMethod.GET)
		public String certificateDelete(Model model, @RequestParam("certificate_id") String uCertificate_id) {
			if(service.deleteCertificate(uCertificate_id)) {
				model.addAttribute("message", "Certificate user is successful.");
			} else {
				model.addAttribute("message", "Certificate is not found.");
			}
			model.addAttribute("records", service.getAllCertificate());
			return "/home/certificate";
		}
		
		//insert order
		@RequestMapping(value = { "user/insertOrder" }, method = RequestMethod.GET)
		public String insertOrder(Model model, @RequestParam("entity_name") String entity_name, 
			@RequestParam("serial_no") String serial_no, @RequestParam("fund_cluster") String fund_cluster, @RequestParam("date_encoded") String date_encoded,
			@RequestParam("payor_name") String payor_name, @RequestParam("payor_address") String payor_address, @RequestParam("certificate_name") String certificate_name,
			@RequestParam("certificate_amount") double certificate_amount, @RequestParam("prepared_by") String prepared_by) {
			Order order = new Order(entity_name, serial_no, fund_cluster, date_encoded, payor_name, payor_address, certificate_name, certificate_amount,
					prepared_by);
			if(service.insertOrder(order) > 0) {
				model.addAttribute("message", "Order is successfully added.");
			} else {
				model.addAttribute("message", "Error in adding new Order.");
			}
			return "/home/newOrder";
		}
		
		//callnewOrder page
		@RequestMapping(value = { "user/newOrder" },method = RequestMethod.GET)
		public String newOrder(Model model) {
			model.addAttribute("certificate", service.getAllCertificate());
			return "/home/newOrder";
		}
		
		@RequestMapping(value = "/certificateSearchOrder", method = RequestMethod.GET)
		public String certificateSearchOrder(Model model, @RequestParam("certificate_name_search") String uCertificate_name) {
			Certificate certificate = service.searchCertificateByName(uCertificate_name);
			if(certificate == null) {
				model.addAttribute("message", "Certificate not found.");
			} else {
				model.addAttribute("certificateorder", certificate);
			}
			model.addAttribute("certificate", service.getAllCertificate());
			return "/home/newOrder";
		}
		
		//approval order admin
		@RequestMapping(value = { "admin/forApproval" },method = RequestMethod.GET)
		public String ListOrder(Model model) {
			model.addAttribute("records", service.getAllOrderActive());
			return "/home/forApproval";
		}
		//search order
		@RequestMapping(value = "admin/orderSearch", method = RequestMethod.GET)
		public String OrderSearch(Model model, @RequestParam("entity_name") String uEntity_name) {
			Order order = service.searchOrderByEntityName(uEntity_name);
			if(order == null) {
				model.addAttribute("message", "Order not found.");
			} else {
				model.addAttribute("order", order);
			}
			model.addAttribute("records", service.getAllOrderActive());
			return "/home/forApproval";
		}
		//approve admin for the order
		@RequestMapping(value = "admin/updateApprove", method = RequestMethod.GET)
		public String orderApprove(Model model, @RequestParam("entity_name") String uEntity_name, @RequestParam("approved_by") String uApproved_by) 
		{
			OrderUpdate order= new OrderUpdate(uEntity_name, uApproved_by);
			if(service.updateOrderToApproved(order)) {
				model.addAttribute("message", "Order Approved");
			} else {
				model.addAttribute("message", "Order Approval not successful");
			}
			model.addAttribute("records", service.getAllOrderActive());
			return "/home/forApproval";
		}
		
		@RequestMapping(value = "admin/updateDecline", method = RequestMethod.GET)
		public String orderDecline(Model model, @RequestParam("entity_name") String uEntity_name) 
		{
			OrderUpdate order= new OrderUpdate(uEntity_name);
			if(service.updateOrderToDeclined(order)) {
				model.addAttribute("message", "Order Declined");
			} else {
				model.addAttribute("message", "Order Decline not successful");
			}
			model.addAttribute("records", service.getAllOrderActive());
			return "/home/forApproval";
		}
		//show all records approved and declined
		@RequestMapping(value = { "admin/allRecords" },method = RequestMethod.GET)
		public String ListOrderAll(Model model) {
			model.addAttribute("records", service.getAllOrder());
			return "/home/allRecords";
		}

	//----------------------------------------------------------------------------------------
	//location
	@RequestMapping(value = { "/admin/newLocation" },method = RequestMethod.GET)
	public String newLocation(Model model) {
		return "/home/newLocation";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String dashboardIndex() {
		return "/dashboard/index";
	}

	@RequestMapping(value = "/menu")
	public String menu() {
		return "menu";
	}

	@RequestMapping(value = "/admin/personInput", method = RequestMethod.GET)
	public String personInput(Model model) {
		model.addAttribute("records", service.getAllPerson());
		model.addAttribute("message", "Initial display of Person input.");
		return "/home/personInput";
	}

	@RequestMapping(value = "/personSave", method = RequestMethod.GET)
	@ResponseBody
	public String personSave(Model model, @RequestParam("emailAddress") String pEmailAddress, @RequestParam("name") String pName,
			@RequestParam("birthday") String pBirthday, @RequestParam("address") String pAddress) {
		Person person = new Person(pEmailAddress, "male", pName, pBirthday, pAddress);
		if(service.insertPerson(person)) {
			model.addAttribute("message", "Adding of person is successful");
		} else {
			model.addAttribute("message", "Adding of person is not successful");
		}
		model.addAttribute("records", service.getAllPerson());
		return "/home/personInput";
	}
	
	@RequestMapping(value = "/personUpdate", method = RequestMethod.GET)
	public String personUpdate(Model model, @RequestParam("emailAddress") String pEmailAddress, @RequestParam("name") String pName,
			@RequestParam("birthday") String pBirthday, @RequestParam("address") String pAddress) {
		Person person = new Person(pEmailAddress, "male", pName, pBirthday, pAddress);
		if(service.updatePerson(person)) {
			model.addAttribute("message", "Person update is successful");
		} else {
			model.addAttribute("message", "Person update is not successful");
		}
		model.addAttribute("records", service.getAllPerson());
		return "/home/personInput";
	}
	
	@RequestMapping(value = "/personDelete", method = RequestMethod.GET)
	public String personDelete(Model model, @RequestParam("emailAddress") String pEmailAddress) {
		if(service.deletePerson(pEmailAddress)) {
			model.addAttribute("message", "Delete person is successful.");
		} else {
			model.addAttribute("message", "Email address is not found.");
		}
		model.addAttribute("records", service.getAllPerson());
		return "/home/personUpdate";
	}
	
	@RequestMapping(value = "/personSearch", method = RequestMethod.GET)
	public String personSearch(Model model, @RequestParam("emailAddress") String pEmailAddress) {
		Person person = service.searchPerson(pEmailAddress);
		if(person == null) {
			model.addAttribute("message", "EMail address is not found.");
		} else {
			model.addAttribute("person", person);
		}
		model.addAttribute("records", service.getAllPerson());
		return "/home/personInput";
	}
	
	
	
	/*****************************************User Management - Start***************************************************/
	
	@RequestMapping(value = "/user/userInput", method = RequestMethod.GET)
	public String user(Model model) {
		return "/home/userHome";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(Model model, @RequestParam("emailAddress") String email, 
			@RequestParam("firstName") String fName, @RequestParam("lastName") String lName, 
			@RequestParam("gender") String gender, @RequestParam("birthday") String birthday) {
		User user = new User(email, fName, lName, gender, birthday, "");
		if(service.insertUser(user) > 0) {
			model.addAttribute("message", "User is successfully added.");
		} else {
			model.addAttribute("message", "Error in adding new user.");
		}
		return "/home/userHome";
	}
	/*****************************************User Management - End*****************************************************/
	
	
	/*****************************************Form Tags - Start*****************************************************/
	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String person(@ModelAttribute("person") Person person, Model model) {
		/*model.addAttribute("genders", getGenders());*/
		model.addAttribute("genders", service.getGenders());
		return "/tags/personInput";
	}

	@RequestMapping(value = "/personSearch2", method = RequestMethod.GET)
	public String personSearch(Model model) {
		return "/tags/personSearch";
	}
	
	private List<String> getGenders() {
		List<String> genders = new ArrayList<String>();
		genders.add("Male");
		genders.add("Female");
		genders.add("Complicated");
		genders.add("Not Sure Yet");
		genders.add("Ask my mother, please.");
		return genders;
	}

	@RequestMapping(value = "/savePerson", method = RequestMethod.POST)
	public String savePerson(@ModelAttribute("person") Person person, Model model) {
		if(service.insertPerson(person)) {
			model.addAttribute("message", "Adding of person is successful");
		} else {
			model.addAttribute("message", "Adding of person is not successful");
		}
		model.addAttribute("genders", service.getGenders());
		return "/tags/personInput";
	}
	
	
	@RequestMapping(value = "/searchPerson", method = RequestMethod.GET)
	public String searchPerson(@ModelAttribute("person") Person person, Model model) {
		person = service.searchPerson(person.getEmailAddress());
		model.addAttribute("person", person);
		return "/tags/person";
	}

	/*****************************************Form Tags - End*****************************************************/

}
