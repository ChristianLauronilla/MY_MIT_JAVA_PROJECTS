package com.fsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsp.dao.FirstDAO;
import com.fsp.entity.Person;
import com.fsp.entity.User;
import com.fsp.entity.Userr;
import com.fsp.entity.UserrBorrower;
import com.fsp.entity.Borrower;
import com.fsp.entity.BorrowerUpdate;
import com.fsp.entity.Book;
import com.fsp.entity.BookUpdate;
import com.fsp.entity.Borrow;
import com.fsp.entity.BorrowUpdate;
import com.fsp.entity.BorrowUpdateReturn;
import com.fsp.entity.BorrowReturned;

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
	//borrower nsad
	public int insertBorrower(Borrower borrower) {
		return dao.insertBorrower(borrower);
	}
	public List<Borrower> getAllBorrower() {
		return dao.getAllBorrower();
	}
	public Borrower searchBorrower(String bBorrower) {
		return dao.searchBorrower(bBorrower);
	}
	public boolean updateBorrower(BorrowerUpdate borrower) {
		return dao.updateBorrower(borrower);
	}
	public boolean deleteBorrower(String bBorrower) {
		return dao.deleteBorrower(bBorrower);
	}
	//book nsad
	public int insertBook(Book book) {
		return dao.insertBook(book);
	}
	public List<Book> getAllBook() {
		return dao.getAllBook();
	}
	public Book searchBook(String bBook_title) {
		return dao.searchBook(bBook_title);
	}
	public boolean updateBook(BookUpdate book) {
		return dao.updateBook(book);
	}
	public boolean deleteBook(String bBook_title) {
		return dao.deleteBook(bBook_title);
	}
	//borrow huhuhu
	public int insertBorrow(Borrow borrow) {
		return dao.insertBorrow(borrow);
	}
	//borrow minus1
	public boolean updateBorrowMinus1(Borrow borrow) {
		return dao.updateBorrowBookQty(borrow);
	}
	//list borrow active only
	public List<Borrow> getAllBorrow() {
		return dao.getAllBorrow();
	}
	public Borrow searchBorrow(String bBorrower_name) {
		return dao.searchBorrow(bBorrower_name);
	}
	//borrow plus1
	public boolean updateBorrowPlus1(BorrowUpdateReturn borrow) {
		return dao.updateBorrowBookQtyReturn(borrow);
	}
	//borrow return
	public boolean updateBorrowReturn(BorrowUpdateReturn borrow) {
		return dao.updateBorrowReturn(borrow);
	}
	
	public int insertUserrBorrower(UserrBorrower userrborrower) {
		return dao.insertUserrBorrower(userrborrower);
	}
	
	//list borrow active only
	public List<BorrowReturned> getAllBorrowReturned() {
		return dao.getAllBorrowReturned();
	}
}
