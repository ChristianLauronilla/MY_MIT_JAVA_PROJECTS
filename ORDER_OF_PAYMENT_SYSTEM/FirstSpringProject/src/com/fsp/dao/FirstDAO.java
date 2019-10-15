package com.fsp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.entity.Certificate;
import com.fsp.entity.CertificateUpdate;
import com.fsp.entity.Order;
import com.fsp.entity.OrderUpdate;

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
	
	//start of code
	//user
	public int insertUserr(Userr userr) {
		try {
			return jdbcObject.update(DBPreparedStatements.INSERT_USERR, userr.getUsername(), userr.getPassword(),
				userr.getName(), userr.getEnabled() ,userr.getRole());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}

	public List<Userr> getAllUserr() {
		try {
			List<Userr> userr= jdbcObject.query(DBPreparedStatements.GET_ALL_USERR, new UserrMapper());
			return userr;
		} catch (Exception e) {
			return null;
		}
	}
	
	public Userr searchUserr(String uUsername) {
		try {
			Userr userr = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_USERR,
					new Object[] { uUsername }, new UserrMapper());
			return userr;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean updateUserr(Userr userr) {
		try {
			jdbcObject.update(DBPreparedStatements.UPDATE_USERR, userr.getName(), userr.getRole(), userr.getUsername());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean deleteUserr(String uUsername) {
		try {
			return (jdbcObject.update(DBPreparedStatements.DELETE_USERR, new Object[] { uUsername }) > 0);
		} catch (Exception e) {
			return false;
		}
	}
	//certificate
		public int insertCertificate(Certificate certificate) {
			try {
				return jdbcObject.update(DBPreparedStatements.INSERT_CERTIFICATE, certificate.getCertificate_name(), certificate.getCertificate_amount());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}

		public List<Certificate> getAllCertificate() {
			try {
				List<Certificate> certificate= jdbcObject.query(DBPreparedStatements.GET_ALL_CERTIFICATE, new CertificateMapper());
				return certificate;
			} catch (Exception e) {
				return null;
			}
		}
		
		public Certificate searchCertificate(int uCertificate) {
			try {
				Certificate certificate = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_CERTIFICATE,
						new Object[] { uCertificate }, new CertificateMapper());
				return certificate;
			} catch (Exception e) {
				return null;
			}
		}
		
		public Certificate searchCertificateByName(String uCertificate) {
			try {
				Certificate certificate = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_CERTIFICATE_BY_NAME,
						new Object[] { uCertificate }, new CertificateMapper());
				return certificate;
			} catch (Exception e) {
				return null;
			}
		}
		
		public boolean updateCertificate(CertificateUpdate uCertificate) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_CERTIFICATE, uCertificate.getCertificate_name(), uCertificate.getCertificate_amount(), uCertificate.getCertificate_id());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public boolean deleteCertificate(String uCertificate) {
			try {
				return (jdbcObject.update(DBPreparedStatements.DELETE_CERTIFICATE, new Object[] { uCertificate }) > 0);
			} catch (Exception e) {
				return false;
			}
		} 
		
		//ORDER
		//INSERT
		public int insertOrder(Order order) {
			try {
				return jdbcObject.update(DBPreparedStatements.INSERT_ORDER, order.getEntity_name(), order.getSerial_no(), order.getFund_cluster(),
						order.getDate_encoded(), order.getPayor_name(), order.getPayor_address(), order.getCertificate_name(), order.getCertificate_amount(),
						order.getPrepared_by(), order.getApproved_by(), order.getStatus());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		
		public List<Order> getAllOrderActive() {
			try {
				List<Order> order= jdbcObject.query(DBPreparedStatements.GET_ALL_ORDER_ACTIVE, new OrderMapper());
				return order;
			} catch (Exception e) {
				return null;
			}
		}
		
		public Order searchOrderByEntityName(String uEntity_name) {
			try {
				Order order = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_ORDER_ACTIVE,
						new Object[] { uEntity_name }, new OrderMapper());
				return order;
			} catch (Exception e) {
				return null;
			}
		}
		
		public boolean updateOrderToApproved(OrderUpdate order) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_ORDER_APPROVE, order.getApproved_by(), order.getEntity_name());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public boolean updateOrderToDeclined(OrderUpdate order) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_ORDER_DECLINE, order.getEntity_name());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public List<OrderUpdate> getAllOrder() {
			try {
				List<OrderUpdate> order= jdbcObject.query(DBPreparedStatements.GET_ALL_ORDER, new OrderUpdateMapper());
				return order;
			} catch (Exception e) {
				return null;
			}
		}
}
