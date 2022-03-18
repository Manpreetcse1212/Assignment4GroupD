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
import com.groupd.assignment4.beans.Member;
import com.groupd.assignment4.dao.BorrowDao;
import com.groupd.assignment4.dao.MemberDao;


/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 * This class is having methods for addBorrow and showBorrow to add to the borrowlist and to display the borrow list
 */

@Controller
public class MemberController {

	@Autowired
	MemberDao memberdao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/memberform")
	public String showform(Model m) {
		m.addAttribute("command", new Member());
		return "memberform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("member") Member member) {
		memberdao.save(member);
		return "redirect:/viewmember";// will redirect to viewemp request mapping
	}

	/* It provides list of employees in model object */
	@RequestMapping("/viewmember")
	public String viewborrow(Model m) {
		List<Member> list = memberdao.getMember();
		m.addAttribute("list", list);
		return "viewmember";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editmember/{id}")
	public String edit(@PathVariable int id, Model m) {
		Member member = memberdao.getMemberById(id);
		m.addAttribute("command", member);
		return "membereditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("member") Member member) {
		memberdao.update(member);
		return "redirect:/viewmember";
	}

	/* It deletes record for the given id in URL and redirects to /viewemp */
	@RequestMapping(value = "/deletemember/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		memberdao.delete(id);
		return "redirect:/viewmember";
	}
}
