package com.fsp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.entity.UserrBorrower;
import com.fsp.entity.Borrower;
import com.fsp.entity.Book;
import com.fsp.entity.Borrow;
import com.fsp.entity.BorrowerUpdate;
import com.fsp.entity.BookUpdate;
import com.fsp.entity.BorrowUpdate;
import com.fsp.entity.BorrowUpdateReturn;
import com.fsp.entity.BorrowReturned;

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
	
	//borrower nsad
	public int insertBorrower(Borrower borrower) {
		try {
			return jdbcObject.update(DBPreparedStatements.INSERT_BORROWER, borrower.getBorrower_name(), borrower.getBorrower_address(),
					borrower.getBorrower_type(), borrower.getBorrower_added_date() ,borrower.getBorrower_status_active());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public List<Borrower> getAllBorrower() {
		try {
			List<Borrower> borrower= jdbcObject.query(DBPreparedStatements.GET_ALL_BORROWER, new BorrowerMapper());
			return borrower;
		} catch (Exception e) {
			return null;
		}
	}
	public Borrower searchBorrower(String bBorrower) {
		try {
			Borrower borrower = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_BORROWER,
					new Object[] { bBorrower }, new BorrowerMapper());
			return borrower;
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateBorrower(BorrowerUpdate borrower) {
		try {
			jdbcObject.update(DBPreparedStatements.UPDATE_BORROWER, borrower.getBorrower_address(), borrower.getBorrower_type(), borrower.getBorrower_status(), borrower.getBorrower_name());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean deleteBorrower(String bBorrower) {
		try {
			return (jdbcObject.update(DBPreparedStatements.DELETE_BORROWER, new Object[] { bBorrower }) > 0);
		} catch (Exception e) {
			return false;
		}
	}
	//book napud
	public int insertBook(Book book) {
		try {
			return jdbcObject.update(DBPreparedStatements.INSERT_BOOK, book.getBook_title(), book.getBook_author(),
					book.getBook_price(), book.getBook_qty(), book.getBook_status());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	public List<Book> getAllBook() {
		try {
			List<Book> book= jdbcObject.query(DBPreparedStatements.GET_ALL_BOOK, new BookMapper());
			return book;
		} catch (Exception e) {
			return null;
		}
	}
	public Book searchBook(String bBook_title) {
		try {
			Book book = jdbcObject.queryForObject(DBPreparedStatements.SEARCH_BOOK,
					new Object[] { bBook_title }, new BookMapper());
			return book;
		} catch (Exception e) {
			return null;
		}
	}
	public boolean updateBook(BookUpdate book) {
		try {
			jdbcObject.update(DBPreparedStatements.UPDATE_BOOK, book.getBook_author(), book.getBook_price(), book.getBook_qty(), book.getBook_status(), book.getBook_title());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean deleteBook(String bBook_title) {
		try {
			return (jdbcObject.update(DBPreparedStatements.DELETE_BOOK, new Object[] { bBook_title }) > 0);
		} catch (Exception e) {
			return false;
		}
	}
	//borrow huhuhuhu unsaon kaha ni 
		public int insertBorrow(Borrow borrow) {
			try {
				return jdbcObject.update(DBPreparedStatements.INSERT_BORROW, borrow.getBorrower_name(), borrow.getBorrow_date(),
						borrow.getBook_title(), borrow.getBorrow_return_date(), borrow.getBorrow_status());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		public boolean updateBorrowBookQty(Borrow borrow) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_BORROW, borrow.getBook_title());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		//transaction page nani kanang naa sa ibabaw pag borrow pana ug book
		public List<Borrow> getAllBorrow() {
			try {
				List<Borrow> borrow= jdbcObject.query(DBPreparedStatements.GET_ALL_BORROW_ACTIVE, new BorrowMapper());
				return borrow;
			} catch (Exception e) {
				return null;
			}
		}
		//search borrow transaction
		public Borrow searchBorrow(String bBorrower_name) {
			try {
				Borrow borrow= jdbcObject.queryForObject(DBPreparedStatements.SEARCH_BORROW,
						new Object[] { bBorrower_name }, new BorrowMapper());
				return borrow;
			} catch (Exception e) {
				return null;
			}
		}
		//update book balik return book
		public boolean updateBorrowBookQtyReturn(BorrowUpdateReturn borrow) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_BOOKRETURN, borrow.getBook_title());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		public boolean updateBorrowReturn(BorrowUpdateReturn borrow) {
			try {
				jdbcObject.update(DBPreparedStatements.UPDATE_BORROWRETURN, borrow.getBorrow_status(), borrow.getBorrow_return_date(), borrow.getBorrower_name());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		public int insertUserrBorrower(UserrBorrower userrborrow) {
			try {
				return jdbcObject.update(DBPreparedStatements.INSERT_USERRBORROWER, userrborrow.getUsername(), userrborrow.getPassword(), userrborrow.getName(), userrborrow.getEnabled(), userrborrow.getRole());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
		}
		//returned 
		//transaction page nani kanang naa sa ibabaw pag borrow pana ug book
		public List<BorrowReturned> getAllBorrowReturned() {
			try {
				List<BorrowReturned> borrow= jdbcObject.query(DBPreparedStatements.GET_ALL_BORROW_RETURNED, new BorrowReturnedMapper());
				return borrow;
			} catch (Exception e) {
				return null;
			}
		}
}
