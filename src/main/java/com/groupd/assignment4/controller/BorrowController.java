package com.groupd.assignment4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupd.assignment4.beans.Borrow;
import com.groupd.assignment4.dao.BorrowDao;


/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * Model class for borrow table
 */

@Controller
public class BorrowController {
	@Autowired
	BorrowDao borrowdao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/borrowform")
	public String showform(Model m) {
		m.addAttribute("command", new Borrow());
		return "borrowform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("borrow") Borrow borrow) {
		borrowdao.save(borrow);
		return "redirect:/viewborrow";// will redirect to viewborrow request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewborrow")
	public String viewborrow(Model m) {
		List<Borrow> list = borrowdao.getBorrow();
		m.addAttribute("list", list);
		return "viewborrow";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editborrow/{borrow.borrow_book_id}")
	public String edit(@PathVariable int id, Model m) {
		Borrow borrow = borrowdao.getBorrowById(id);
		m.addAttribute("command", borrow);
		return "borroweditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("borrow") Borrow borrow) {
		borrowdao.update(borrow);
		return "redirect:/viewborrow";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deleteborrow/{borrow.borrow_book_id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		borrowdao.delete(id);
		return "redirect:/viewborrow";
	}
}
