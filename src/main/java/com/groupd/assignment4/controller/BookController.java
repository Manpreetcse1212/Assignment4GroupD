package com.groupd.assignment4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupd.assignment4.beans.Book;
import com.groupd.assignment4.dao.BookDao;
/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This controller is used to handle post and get methods for creating, updating and deleting books 
 */
@Controller
public class BookController {
	@Autowired
	BookDao bookdao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/bookform")
	public String showform(Model m) {
		m.addAttribute("command", new Book());
		return "bookform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String save(@ModelAttribute("book") Book book) {
		bookdao.save(book);
		return "redirect:/viewbook";// will redirect to viewbook request mapping
	}

	/* It provides list of books in model object */
	@RequestMapping("/viewbook")
	public String viewbook(Model m) {
		List<Book> list = bookdao.getBooks();
		m.addAttribute("list", list);
		return "viewbook";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editbook/{id}")
	public String edit(@PathVariable int id, Model m) {
		Book book = bookdao.getBookById(id);
		m.addAttribute("command", book);
		return "bookeditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsavebook", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("book") Book book) {
		bookdao.update(book);
		return "redirect:/viewbook";
	}

	/* It deletes record for the given id in URL and redirects to /viewbook */
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		bookdao.delete(id);
		return "redirect:/viewbook";
	}
}
