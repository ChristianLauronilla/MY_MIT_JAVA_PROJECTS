package com.fsp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.entity.UserrUpdate;
import com.fsp.entity.Student;
import com.fsp.entity.StudentUpdate;
import com.fsp.entity.Section;
import com.fsp.entity.MyClass;
import com.fsp.entity.MyClassUpdate;

public class FirstDAO {

	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcObject = new JdbcTemplate(dataSource);
	}

	public boolean insertPerson(Person person) {
		try {
			jdbcObject.update(DBPreparedStatements.INSERT_PERSON, person.getEmailAddress(), person.getName(),
					person.getGender(), person.getBirthday(), person.getAddress());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updatePerson(Person person) {
		try {
			jdbcObject.update(DBPreparedStatements.UPDATE_PERSON, person.getName(), person.getBirthday(),
					person.getAddress(), person.getEmailAddress());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deletePerson(String pEmailAddress) {
		try {
			return (jdbcObject.update(DBPreparedStatements.DELETE_PERSON, new Object[] { pEmailAddress }) > 0);
		} catch (Exception e) {
			return false;
		}
	}

	public List<Person> getAllPersons() {
		try {
			List<Person> persons = jdbcObject.query(DBPreparedStatements.GET_ALL_PERSON, new PersonMapper());
			return persons;
		} catch (Exception e) {
			return null;
		}
	}

	public Person searchPerson(String pEmailAddress) {
		try {
			Person persons = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_PERSON,
					new Object[] { pEmailAddress }, new PersonMapper());
			return persons;
		} catch (Exception e) {
			return null;
		}
	}

	public int insertUser(User user) {
		try {
			return jdbcObject.update(DBPreparedStatements.INSERT_USER, user.getEmailAddress(), user.getFirstName(),
					user.getLastName(), user.getGender(), user.getBirthday());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public List<String> getGenders() {
		try {
			List<String> genders = jdbcObject.queryForList(DBPreparedStatements.GET_ALL_GENDERS, String.class);
			return genders;
		} catch (Exception e) {
			return null;
		}
	}
	
	//start of chanix code
	//user insertttttttttttttttt
	public int insertUserr(Userr userr) {
		try {
			return jdbcObject.update(DBPreparedStatements.INSERT_USERR, userr.getUsername(), userr.getPassword(),
				userr.getFname(), userr.getLname(), userr.getEnabled() ,userr.getRole() ,userr.getMobile_no() ,userr.getDate_added() ,userr.getStatus());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	//list of user
	public List<Userr> getAllUserr() {
		try {
			List<Userr> userr= jdbcObject.query(DBPreparedStatements.GET_ALL_USERR, new UserrMapper());
			return userr;
		} catch (Exception e) {
			return null;
		}
	}
	//searchuserr
	public Userr searchUserr(String uUsername) {
		try {
			Userr userr = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_USERR,
					new Object[] { uUsername }, new UserrMapper());
			return userr;
		} catch (Exception e) {
			return null;
		}
	}
	//delete user
	public boolean deleteUserr(String uUsername) {
		try {
			return (jdbcObject.update(DBPreparedStatements.DELETE_USERR, new Object[] { uUsername }) > 0);
		} catch (Exception e) {
			return false;
		}
	}
	//updateuser
	public boolean updateUserr(UserrUpdate userr) {
		try {
			jdbcObject.update(DBPreparedStatements.UPDATE_USERR, userr.getPassword(),userr.getFname(),userr.getLname(),userr.getMobile_no(),userr.getDate_added(), userr.getRole(), userr.getUsername());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//------------------------------------student
	//student insertttttttttttttttt
		public int insertStudent(Student student) {
			try {
				return jdbcObject.update(DBPreparedStatements.INSERT_STUDENT, student.getStudent_id(), student.getStudent_fname(),
						student.getStudent_lname(), student.getStudent_mobile_no(), student.getStudent_date_added() ,student.getStudent_status());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		//list of student
		public List<Student> getAllStudent() {
			try {
				List<Student> student= jdbcObject.query(DBPreparedStatements.GET_ALL_STUDENT, new StudentMapper());
				return student;
			} catch (Exception e) {
				return null;
			}
		}
		//searchstudent
		public Student searchStudent(String uStudent_id) {
			try {
				Student student= jdbcObject.queryForObject(DBPreparedStatements.SEARCH_STUDENT,
						new Object[] { uStudent_id }, new StudentMapper());
				return student;
			} catch (Exception e) {
				return null;
			}
		}
		//delete student
		public boolean deleteStudent(String uStudent_id) {
			try {
				return (jdbcObject.update(DBPreparedStatements.DELETE_STUDENT, new Object[] { uStudent_id }) > 0);
			} catch (Exception e) {
				return false;
			}
		}
		//updatestudent
		public boolean updateStudent(StudentUpdate student) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_STUDENT, student.getStudent_fname(),student.getStudent_lname(),student.getStudent_mobile_no(),student.getStudent_date_added(),student.getStudent_status(),student.getStudent_id());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		//------------------------------section
		//section nasad  insertttttttttttttttt
				public int insertSection(Section section) {
					try {
						return jdbcObject.update(DBPreparedStatements.INSERT_SECTION, section.getSection_name(), section.getSection_capacity(), section.getSection_status());
					} catch (Exception e) {
						System.out.println(e.getMessage());
						return 0;
					}
				}
				//list of student
				public List<Section> getAllSection() {
					try {
						List<Section> section= jdbcObject.query(DBPreparedStatements.GET_ALL_SECTION, new SectionMapper());
						return section;
					} catch (Exception e) {
						return null;
					}
				}
				//searchstudent
				public Section searchSection(String uSection_name) {
					try {
						Section section= jdbcObject.queryForObject(DBPreparedStatements.SEARCH_SECTION,
								new Object[] { uSection_name }, new SectionMapper());
						return section;
					} catch (Exception e) {
						return null;
					}
				}
				//delete student
				public boolean deleteSection(String uSection_name) {
					try {
						return (jdbcObject.update(DBPreparedStatements.DELETE_SECTION, new Object[] { uSection_name }) > 0);
					} catch (Exception e) {
						return false;
					}
				}
				//updatestudent
				public boolean updateSection(Section section) {
					try {
						jdbcObject.update(DBPreparedStatements.UPDATE_SECTION, section.getSection_capacity(),section.getSection_status(),
								section.getSection_name());
						return true;
					} catch (Exception e) {
						return false;
					}
				}
				
		//-------------------------------CLASSSSSSSSSSSSS 
				public int insertClass(MyClass classassignment) {
					try {
						return jdbcObject.update(DBPreparedStatements.INSERT_CLASSASSIGNMENT, classassignment.getSection_name(), classassignment.getTeacher_username(), classassignment.getStudent_name(), classassignment.getStudent_id(), classassignment.getClass_status());
					} catch (Exception e) {
						System.out.println(e.getMessage());
						return 0;
					}
				}
				//updateminuscapacityofclass
				public boolean updateSectionCapacityMinus(Section section) {
					try {
						jdbcObject.update(DBPreparedStatements.UPDATE_SECTION_MINUSCAPACITY_CLASSASSIGNMENT, section.getSection_capacity(),
								section.getSection_name());
						return true;
					} catch (Exception e) {
						return false;
					}
				}
				//updatestudentstatustoAssigned
				public boolean updateStudentStatusToAssigned(Student student) {
					try {
						jdbcObject.update(DBPreparedStatements.UPDATE_STUDENT_ASSIGNED_CLASSASSIGNMENT, student.getStudent_id());
						return true;
					} catch (Exception e) {
						return false;
					}
				}
				
				//dropdown for classassignment
				public List<Section> getAllSectionName() {
					try {
						List<Section> section= jdbcObject.query(DBPreparedStatements.GET_ALL_SECTION_CLASSASSIGNMENT, new SectionMapper());
						return section;
					} catch (Exception e) {
						return null;
					}
				}
				public List<Student> getAllStudentName() {
					try {
						List<Student> student= jdbcObject.query(DBPreparedStatements.GET_ALL_STUDENT_CLASSASSIGNMENT, new StudentMapper());
						return student;
					} catch (Exception e) {
						return null;
					}
				}
				//list of teacherfname
				public List<Userr> getAllTeacherFname() {
					try {
						List<Userr> userr= jdbcObject.query(DBPreparedStatements.GET_ALL_TEACHERFNAME, new UserrMapper());
						return userr;
					} catch (Exception e) {
						return null;
					}
				}
				
				//view my class
				public List<MyClass> getAllMyClass() {
					try {
						List<MyClass> myclass= jdbcObject.query(DBPreparedStatements.GET_ALL_MYCLASS, new MyClassMapper());
						return myclass;
					} catch (Exception e) {
						return null;
					}
				}
				
				//updateclasstonullforviewing
				public boolean updateClassStatusToNull() {
					try {
						jdbcObject.update(DBPreparedStatements.UPDATE_STUDENT_CLASSSTATUSTONULL);
						return true;
					} catch (Exception e) {
						return false;
					}
				}
				//updateclassStatusToView
				public boolean updateClassStatusToView(MyClassUpdate teacher_username) {
					try {
						jdbcObject.update(DBPreparedStatements.UPDATE_CLASS_TO_VIEW, teacher_username.getTeacher_username());
						return true;
					} catch (Exception e) {
						return false;
					}
				}
}
