package com.fsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsp.dao.FirstDAO;
import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.entity.UserrUpdate;
import com.fsp.entity.Student;
import com.fsp.entity.StudentUpdate;
import com.fsp.entity.Section;
import com.fsp.entity.MyClass;
import com.fsp.entity.MyClassUpdate;

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
	
	public boolean updateUserr(UserrUpdate userr) {
		return dao.updateUserr(userr);
	}

	public boolean deleteUserr(String uUsername) {
		return dao.deleteUserr(uUsername);
	}
	
	//student
	public int insertStudent(Student student) {
		return dao.insertStudent(student);
	}
	
	public List<Student> getAllStudent() {
		return dao.getAllStudent();
	}
	
	public Student searchStudent(String uStudent_id) {
		return dao.searchStudent(uStudent_id);
	}
	
	public boolean updateStudent(StudentUpdate student) {
		return dao.updateStudent(student);
	}

	public boolean deleteStudent(String uStudent_id) {
		return dao.deleteStudent(uStudent_id);
	}
	//teacherfname
	public List<Userr> getAllTeacherFname() {
		return dao.getAllTeacherFname();
	}
	public List<Student> getAllStudentName() {
		return dao.getAllStudentName();
	}
	public List<Section> getAllSectionName() {
		return dao.getAllSectionName();
	}
	
	//section
	public int insertSection(Section section) {
		return dao.insertSection(section);
	}
	
	public List<Section> getAllSection() {
		return dao.getAllSection();
	}
	
	public Section searchSection(String uSection_name) {
		return dao.searchSection(uSection_name);
	}
	
	public boolean updateSection(Section section) {
		return dao.updateSection(section);
	}

	public boolean deleteSection(String uSection_name) {
		return dao.deleteSection(uSection_name);
	}
	
	//classassignment
	public int insertClass(MyClass classassignment) {
		return dao.insertClass(classassignment);
	}
	public boolean updateMinusSection(Section uSection_name) {
		return dao.updateSectionCapacityMinus(uSection_name);
	}
	public boolean updateStudentStatusToAssigned(Student uStudent_id) {
		return dao.updateStudentStatusToAssigned(uStudent_id);
	}
	//myclass get it now
	public List<MyClass> getAllMyClass() {
		return dao.getAllMyClass();
	}
	//update classtonull
	public boolean updateClassToNull() {
		return dao.updateClassStatusToNull();
	}
	//update classtoview
	public boolean updateClassStatusToView(MyClassUpdate teacher_username) {
		return dao.updateClassStatusToView(teacher_username);
	}
}
