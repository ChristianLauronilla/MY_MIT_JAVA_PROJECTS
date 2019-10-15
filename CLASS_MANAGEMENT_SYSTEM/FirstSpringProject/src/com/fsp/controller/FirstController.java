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
import com.fsp.entity.UserrUpdate;
import com.fsp.entity.Student;
import com.fsp.entity.Section;
import com.fsp.entity.MyClass;
import com.fsp.entity.MyClassUpdate;
import com.fsp.entity.StudentUpdate;
import com.fsp.service.FirstService;
import com.fsp.dao.FirstDAO;

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
		service.updateClassToNull();
		return "/home/index";
	}
	
	@RequestMapping(value = { "/user/CMS" }, method = RequestMethod.GET)
	public String UpdateClassToNull(Model model) {
		String username = ((org.springframework.security.core.userdetails.User) 
				SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal()).getUsername();
		//User user = service.getUser();
		//model.addAttribute("user",  user);
	    service.updateClassToNull();
		return "/home/index";
	}
	
	//start of chanix code
	//user userrrrrrrrrrrrrrrr
	@RequestMapping(value = { "/admin/newUser" },method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("records", service.getAllUserr());
		return "/home/newUser";
	}
	//insert user
	@RequestMapping(value = { "admin/insertUserr" }, method = RequestMethod.GET)
	public String insertUserr(Model model, @RequestParam("username") String username, 
			@RequestParam("password") String password, @RequestParam("fname") String fname, @RequestParam("lname") String lname,
			@RequestParam("role") String role, @RequestParam("mobile_no") String mobile_no, @RequestParam("date_added") String date_added) {
		Userr userr = new Userr(username, password, fname, lname, role, mobile_no, date_added);
		if(service.insertUserr(userr) > 0) {
			model.addAttribute("message", "Teacher successfully added.");
		} else {
			model.addAttribute("message", "Error in adding new Teacher.");
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/newUser";
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
		return "/home/newUser";
	}
	//update of user
	@RequestMapping(value = "/userrUpdate", method = RequestMethod.GET)
	public String userrUpdate(Model model, @RequestParam("fname") String ufname,
			@RequestParam("password") String upassword,@RequestParam("lname") String ulname,@RequestParam("mobile_no") String umobile_no,@RequestParam("date_added") String udate_added,@RequestParam("role") String urole,@RequestParam("username") String uUsername) {
		UserrUpdate userr = new UserrUpdate(upassword,ufname,ulname,umobile_no,udate_added,urole,uUsername);
		if(service.updateUserr(userr)) {
			model.addAttribute("message", "Teacher update is successful");
		} else {
			model.addAttribute("message", "Teacher update is not successful");
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/newUser";
	}
	//delete user
	@RequestMapping(value = "/userrDelete", method = RequestMethod.GET)
	public String userrDelete(Model model, @RequestParam("username") String uUsername) {
		if(service.deleteUserr(uUsername)) {
			model.addAttribute("message", "Delete teacher is successful.");
		} else {
			model.addAttribute("message", "Teacher is not found.");
		}
		model.addAttribute("records", service.getAllUserr());
		return "/home/newUser";
	}
	//---------------------------------------------------- STUDENT INFORMATION
	@RequestMapping(value = { "/admin/newStudent" },method = RequestMethod.GET)
	public String newStudent(Model model) {
		model.addAttribute("records", service.getAllStudent());
		return "/home/newStudent";
	}
	//insert student
	@RequestMapping(value = { "admin/insertStudent" }, method = RequestMethod.GET)
	public String insertStudent(Model model, @RequestParam("student_id") String student_id, 
			@RequestParam("student_fname") String student_fname, @RequestParam("student_lname") String student_lname, @RequestParam("student_mobile_no") String student_mobile_no,
			@RequestParam("student_date_added") String student_date_added, @RequestParam("student_status") String student_status) {
		Student student = new Student(student_id, student_fname, student_lname, student_mobile_no, student_date_added, student_status);
		if(service.insertStudent(student) > 0) {
			model.addAttribute("message", "Student successfully added.");
		} else {
			model.addAttribute("message", "Error in adding new Student.");
		}
		model.addAttribute("records", service.getAllStudent());
		return "/home/newStudent";
	}
	//list of student
	@RequestMapping(value = { "admin/listStudent" },method = RequestMethod.GET)
	public String listOfStudent(Model model) {
		model.addAttribute("records", service.getAllStudent());
		return "/home/newStudent";
	}
	//search student
	@RequestMapping(value = "/studentSearch", method = RequestMethod.GET)
	public String studentSearch(Model model, @RequestParam("student_id") String uStudent_id) {
		Student student = service.searchStudent(uStudent_id);
		if(student == null) {
			model.addAttribute("message", "Student not found.");
		} else {
			model.addAttribute("student", student);
		}
		model.addAttribute("records", service.getAllStudent());
		return "/home/newStudent";
	}
	//update of student
	@RequestMapping(value = "/studentUpdate", method = RequestMethod.GET)
	public String studentUpdate(Model model, @RequestParam("student_fname") String uStudent_fname,
			@RequestParam("student_lname") String uStudent_lname,@RequestParam("student_mobile_no") String uStudent_mobile_no,@RequestParam("student_date_added") String uStudent_date_added,
			@RequestParam("student_status") String uStudent_status,@RequestParam("student_id") String uStudent_id) {
		StudentUpdate student = new StudentUpdate(uStudent_fname,uStudent_lname,uStudent_mobile_no,uStudent_date_added,uStudent_status,uStudent_id);
		if(service.updateStudent(student)) {
			model.addAttribute("message", "Student update is successful");
		} else {
			model.addAttribute("message", "Student update is not successful");
		}
		model.addAttribute("records", service.getAllStudent());
		return "/home/newStudent";
	}
	//delete student
	@RequestMapping(value = "/studentDelete", method = RequestMethod.GET)
	public String studentDelete(Model model, @RequestParam("student_id") String uStudent_id) {
		if(service.deleteStudent(uStudent_id)) {
			model.addAttribute("message", "Delete student successful.");
		} else {
			model.addAttribute("message", "Student not found.");
		}
		model.addAttribute("records", service.getAllStudent());
		return "/home/newStudent";
	}
	//---------------------------------------------------- CLASS NASAD INFORMATION
		@RequestMapping(value = { "/admin/newClass" },method = RequestMethod.GET)
		public String newClass(Model model) {
			return "/home/newClass";
		}
		//search student
		@RequestMapping(value = "/studentSearchClass", method = RequestMethod.GET)
		public String studentSearchClass(Model model, @RequestParam("student_id") String uStudent_id) {
			Student student = service.searchStudent(uStudent_id);
			if(student == null) {
				model.addAttribute("message", "Student not found.");
			} else {
				model.addAttribute("student", student);
			}
			return "/home/newClass";
		}
	//-----------------------------------------------------------------------------------
		//---------------------------------------------------- SECTIONNNNNNN INFORMATION
		@RequestMapping(value = { "/admin/newSection" },method = RequestMethod.GET)
		public String newSection(Model model) {
			model.addAttribute("records", service.getAllSection());
			return "/home/newSection";
		}
		//insert student
		@RequestMapping(value = { "admin/insertSection" }, method = RequestMethod.GET)
		public String insertSection(Model model, @RequestParam("section_name") String section_name, 
				@RequestParam("section_capacity ") int section_capacity, @RequestParam("section_status") String section_status){
			Section section= new Section(section_name,section_capacity,section_status);
			if(service.insertSection(section) > 0) {
				model.addAttribute("message", "Section successfully added.");
			} else {
				model.addAttribute("message", "Error in adding new Section.");
			}
			model.addAttribute("records", service.getAllSection());
			return "/home/newSection";
		}
		//list of student
		@RequestMapping(value = { "admin/listSection" },method = RequestMethod.GET)
		public String listSection(Model model) {
			model.addAttribute("records", service.getAllSection());
			return "/home/newSection";
		}
		//search student
		@RequestMapping(value = "/sectionSearch", method = RequestMethod.GET)
		public String sectionSearch(Model model, @RequestParam("section_name") String uSection_name) {
			Section section = service.searchSection(uSection_name);
			if(section == null) {
				model.addAttribute("message", "Section not found.");
			} else {
				model.addAttribute("section", section);
			}
			model.addAttribute("records", service.getAllSection());
			return "/home/newSection";
		}
		//update of student
		@RequestMapping(value = "/sectionUpdate", method = RequestMethod.GET)
		public String sectionUpdate(Model model, @RequestParam("section_capacity ") int uSection_capacity,
				@RequestParam("section_status") String uSection_status,@RequestParam("section_name") String uSection_name){
			Section section= new Section(uSection_capacity,uSection_status,uSection_name);
			if(service.updateSection(section)){
				model.addAttribute("message", "Section update is successful");
			} else {
				model.addAttribute("message", "Section update is not successful");
			}
			model.addAttribute("records", service.getAllSection());
			return "/home/newSection";
		}
		//delete student
		@RequestMapping(value = "/sectionDelete", method = RequestMethod.GET)
		public String sectionDelete(Model model, @RequestParam("section_name") String uSection_name) {
			if(service.deleteSection(uSection_name)) {
				model.addAttribute("message", "Delete section successful.");
			} else {
				model.addAttribute("message", "Section not found.");
			}
			model.addAttribute("records", service.getAllSection());
			return "/home/newSection";
		}
		//---------------------------------------------------- CLASS ASSIGNMENT INFORMATION
			@RequestMapping(value = { "/admin/classAssignment" },method = RequestMethod.GET)
			public String classAssignment(Model model) {
				model.addAttribute("sectionname", service.getAllSectionName());
				model.addAttribute("studentname", service.getAllStudentName());
				model.addAttribute("teachername", service.getAllTeacherFname());
				return "/home/classAssignment";
			}
			//insert class assingment
			@RequestMapping(value = { "admin/assign" }, method = RequestMethod.GET)
			public String assign(Model model, @RequestParam("section_name") String uSection_name, 
					@RequestParam("teacher_username") String uTeacher_username, @RequestParam("student_name") String uStudent_name, String student_id_name){
				MyClass classassignment= new MyClass(uSection_name,uTeacher_username,uStudent_name, student_id_name,"");
				Section section_name = new Section(uSection_name);
				Student student_id= new Student(student_id_name);
				service.updateMinusSection(section_name);
				service.updateStudentStatusToAssigned(student_id);
				if(service.insertClass(classassignment) > 0) {
					model.addAttribute("message", "Class Assignment successfully added.");
				} else {
					model.addAttribute("message", "Error in adding new Class Assignment.");
				}
				return "/home/classAssignment";
			}
			
			//search student assign
			@RequestMapping(value = "/studentSearchAssign", method = RequestMethod.GET)
			public String studentSearchAssign(Model model, @RequestParam("student_id") String uStudent_id) {
				Student student = service.searchStudent(uStudent_id);
				if(student == null) {
					model.addAttribute("message", "Student not found.");
				} else {
					model.addAttribute("student", student);
				}
				model.addAttribute("records", service.getAllStudent());
				model.addAttribute("sectionname", service.getAllSectionName());
				model.addAttribute("studentname", service.getAllStudentName());
				model.addAttribute("teachername", service.getAllTeacherFname());
				return "/home/classAssignment";
			}
			//---------------------------------------------------- VIEW CLASS INFORMATION
			@RequestMapping(value = { "/user/viewClass" },method = RequestMethod.GET)
			public String viewClass(Model model) {
				//MyClassUpdate myclass= new MyClassUpdate(uteacher_username);
				//service.updateClassStatusToView(myclass);
				model.addAttribute("records", service.getAllMyClass());
				return "/home/viewClass";
			}
			//@RequestParam("teacher_username") String uteacher_username
			
			
			@RequestMapping(value = { "/user/viewClassTeacher" },method = RequestMethod.GET)
			public String viewClassTeacher(Model model, @RequestParam("teacher_username") String uteacher_username) {
				MyClassUpdate myclass= new MyClassUpdate(uteacher_username);
				service.updateClassStatusToView(myclass);
				model.addAttribute("records", service.getAllMyClass());
				return "/home/viewClass";
			}
		//---------------------------------------------------------------------------------
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
