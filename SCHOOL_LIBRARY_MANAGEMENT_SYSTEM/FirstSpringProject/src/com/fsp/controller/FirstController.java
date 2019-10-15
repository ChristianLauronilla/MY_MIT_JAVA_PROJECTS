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
import com.fsp.entity.UserrBorrower;
import com.fsp.entity.Borrower;
import com.fsp.entity.BorrowerUpdate;
import com.fsp.entity.BookUpdate;
import com.fsp.entity.Book;
import com.fsp.entity.Borrow;
import com.fsp.entity.BorrowUpdate;
import com.fsp.entity.BorrowUpdateReturn;
import com.fsp.entity.BorrowReturned;
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
		return "/home/index";
	}
	
	//start of chanix code
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
	//borrower
	//view borrowerinsertpage(routing)
	@RequestMapping(value = { "/admin/newBorrower" },method = RequestMethod.GET)
	public String newBorrower(Model model) {
		return "/home/newBorrower";
	}
	//insert borrower
	@RequestMapping(value = { "admin/insertBorrower" }, method = RequestMethod.GET)
	public String insertBorrower(Model model, @RequestParam("borrower_name") String borrower_name, 
			@RequestParam("borrower_address") String borrower_address, @RequestParam("borrower_type") String borrower_type, 
			@RequestParam("borrower_added_date") String borrower_added_date) {
		Borrower borrower = new Borrower(borrower_name, borrower_address, borrower_type, borrower_added_date);
		UserrBorrower userrborrower = new UserrBorrower(borrower_name,borrower_name,borrower_name);
		service.insertUserrBorrower(userrborrower);
		if(service.insertBorrower(borrower) > 0) {
			model.addAttribute("message", "Borrower is successfully added.");
		} else {
			model.addAttribute("message", "Error in adding new borrower.");
		}
		return "/home/newBorrower";
	}
	//listofborrower
	@RequestMapping(value = { "admin/listBorrower" },method = RequestMethod.GET)
	public String listBorrower(Model model) {
		model.addAttribute("records", service.getAllBorrower());
		return "/home/listBorrower";
	}
	//search borrower
	@RequestMapping(value = "/borrowerSearch", method = RequestMethod.GET)
	public String borrowerSearch(Model model, @RequestParam("borrower_name") String bBorrower) {
		Borrower borrower= service.searchBorrower(bBorrower);
		if(borrower == null) {
			model.addAttribute("message", "Borrower name not found.");
		} else {
			model.addAttribute("borrower", borrower);
		}
		model.addAttribute("records", service.getAllBorrower());
		return "/home/listBorrower";
	}
	//update of borrower
	@RequestMapping(value = "/borrowerUpdate", method = RequestMethod.GET)
	public String borrowerUpdate(Model model, @RequestParam("borrower_name") String bBorrower_name, @RequestParam("borrower_address") String bBorrower_address, 
			@RequestParam("borrower_type") String bBorrower_type, @RequestParam("borrower_status") String bBorrower_status ) {
		BorrowerUpdate borrower = new BorrowerUpdate(bBorrower_name, bBorrower_address, bBorrower_type, bBorrower_status);
		if(service.updateBorrower(borrower)) {
			model.addAttribute("message", "Borrower update is successful");
		} else {
			model.addAttribute("message", "Borrower update is not successful");
		}
		model.addAttribute("records", service.getAllBorrower());
		return "/home/listBorrower";
	}
	//delete borrower
	@RequestMapping(value = "/borrowerDelete", method = RequestMethod.GET)
	public String borrowerDelete(Model model, @RequestParam("borrower_name") String bBorrower_name) {
		if(service.deleteBorrower(bBorrower_name)) {
			model.addAttribute("message", "Delete borrower successful.");
		} else {
			model.addAttribute("message", "Borrower not found.");
		}
		model.addAttribute("records", service.getAllBorrower());
		return "/home/listBorrower";
	}
	//-----------------------------------------------------------------------------------
		//book
		//view bookinsert(routing)
		@RequestMapping(value = { "/admin/newBook" },method = RequestMethod.GET)
		public String newBook(Model model) {
			return "/home/newBook";
		}
		//insert book
		@RequestMapping(value = { "admin/insertBook" }, method = RequestMethod.GET)
		public String insertBook(Model model, @RequestParam("book_title") String book_title, 
				@RequestParam("book_author") String book_author, @RequestParam("book_price") double book_price, 
				@RequestParam("book_qty") int book_qty) {
			Book book = new Book(book_title, book_author, book_price, book_qty);
			if(service.insertBook(book) > 0) {
				model.addAttribute("message", "Book is successfully added.");
			} else {
				model.addAttribute("message", "Error in adding new book.");
			}
			return "/home/newBook";
		}
		//listofbook
		@RequestMapping(value = { "admin/listBook" },method = RequestMethod.GET)
		public String listBook(Model model) {
			model.addAttribute("records", service.getAllBook());
			return "/home/listBook";
		}
		//search borrower
		@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
		public String bookSearch(Model model, @RequestParam("book_title") String bBook_title) {
			Book book= service.searchBook(bBook_title);
			if(book == null) {
				model.addAttribute("message", "Book title not found.");
			} else {
				model.addAttribute("book", book);
			}
			model.addAttribute("records", service.getAllBook());
			return "/home/listBook";
		}
		//update of borrower
		@RequestMapping(value = "/bookUpdate", method = RequestMethod.GET)
		public String bookUpdate(Model model, @RequestParam("book_title") String bBook_title, @RequestParam("book_author") String bBook_author, 
				@RequestParam("book_price") double bBook_price, @RequestParam("book_qty") int bBook_qty, @RequestParam("book_status") String bBook_status) {
			BookUpdate book = new BookUpdate(bBook_title, bBook_author, bBook_price, bBook_qty, bBook_status);
			if(service.updateBook(book)) {
				model.addAttribute("message", "Book update is successful");
			} else {
				model.addAttribute("message", "Book update is not successful");
			}
			model.addAttribute("records", service.getAllBook());
			return "/home/listBook";
		}
		//delete borrower
		@RequestMapping(value = "/bookDelete", method = RequestMethod.GET)
		public String bookDelete(Model model, @RequestParam("book_title") String bBook_title) {
			if(service.deleteBook(bBook_title)) {
				model.addAttribute("message", "Delete book successful.");
			} else {
				model.addAttribute("message", "book not found.");
			}
			model.addAttribute("records", service.getAllBook());
			return "/home/listBook";
		}
		//borrow page
		@RequestMapping(value = { "user/Borrow" },method = RequestMethod.GET)
		public String borrow(Model model) {
			model.addAttribute("records1", service.getAllBook());
			model.addAttribute("records2", service.getAllBorrower());
			return "/home/borrow";
		}
		//search borrower book selection
		@RequestMapping(value = "/bookSearchborrow", method = RequestMethod.GET)
		public String bookSearchborrow(Model model, @RequestParam("book_title") String bBook_title) {
			Book book= service.searchBook(bBook_title);
			if(book == null) {
				model.addAttribute("message", "Book title not found.");
			} else {
				model.addAttribute("book", book);
			}
			model.addAttribute("records", service.getAllBook());
			return "/home/borrow";
		}
		//insert borrow asjdfklfs
		@RequestMapping(value = { "user/insertBorrow" }, method = RequestMethod.GET)
		public String insertBorrow(Model model, @RequestParam("borrower_name") String borrower_name, 
				@RequestParam("borrow_date") String borrow_date, @RequestParam("book_title") String book_title, 
				@RequestParam("borrow_status") String borrow_status) {
			Borrow borrow = new Borrow(borrower_name, borrow_date, book_title, borrow_status);
			service.updateBorrowMinus1(borrow);
			if(service.insertBorrow(borrow) > 0) {
				model.addAttribute("message", "You borrowed a book successfully");
			} else {
				model.addAttribute("message", "Error in borrowing a book.");
			}
			return "/home/borrow";
		}
		//list of borrow Active
		@RequestMapping(value = { "admin/borrowing" },method = RequestMethod.GET)
		public String listBorrowing(Model model) {
			model.addAttribute("records", service.getAllBorrow());
			return "/home/borrowing";
		}
		//search borrow
		@RequestMapping(value = "/borrowSearch", method = RequestMethod.GET)
		public String borrowSearch(Model model, @RequestParam("borrower_name") String bBorrower_name) {
			Borrow borrow= service.searchBorrow(bBorrower_name);
			if(borrow == null) {
				model.addAttribute("message", "Borrower not found.");
			} else {
				model.addAttribute("borrow", borrow);
			}
			model.addAttribute("records", service.getAllBorrow());
			return "/home/borrowing";
		}
		//update of borrowreturn
		@RequestMapping(value = "admin/borrowReturn", method = RequestMethod.GET)
		public String borrowReturn(Model model, @RequestParam("book_title") String bBook_title, @RequestParam("borrower_name") String bBorrower_name, @RequestParam("borrow_return_date") String bBorrow_return_date) {
			BorrowUpdateReturn borrow = new BorrowUpdateReturn(bBorrower_name,bBook_title,bBorrow_return_date);
			service.updateBorrowPlus1(borrow);
			if(service.updateBorrowReturn(borrow)) {
				model.addAttribute("message", "Borrow update is successful");
			} else {
				model.addAttribute("message", "Borrow update is not successful");
			}
			model.addAttribute("records", service.getAllBorrow());
			return "/home/borrowing";
		}
		//list REPORT T TT TT T of borrow Returned
		@RequestMapping(value = { "admin/report" },method = RequestMethod.GET)
		public String listBorrowReturned(Model model) {
			model.addAttribute("records", service.getAllBorrowReturned());
			return "/home/report";
		}
	
	
	
	//-----------------------------------------------------------------------------------
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
