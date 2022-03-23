package com.groupd.assignment4.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupd.assignment4.beans.Publisher;
import com.groupd.assignment4.dao.PublisherDaoD;


/**
 * Date: 15.03.2022
 * Group D 
 * Member1: Manpreet kaur
 * Member2: Manpreet Kaur
 * Member3: Bhumikaben Manubhai Patel
 * Member4: Ashikkumar Nareshbhai Patel
 * Member5: Hardeep Kaur Chahal 
 * 
 *This controller is used to handle post and get methods for creating, updating publisher
 */

@Controller
public class PublisherController {
	@Autowired
	PublisherDaoD publisherdao;// will inject dao from xml file

	/*
	 * It displays a form to input data, here "command" is a reserved request
	 * attribute which is used to display object data into form
	 */
	@RequestMapping("/publisherform")
	public String showform(Model m) {
		m.addAttribute("command", new Publisher());
		return "publisherform";
	}

	/*
	 * It saves object into database. The @ModelAttribute puts request data into
	 * model object. You need to mention RequestMethod.POST method because default
	 * request is GET
	 */
	@RequestMapping(value = "/savepublisher", method = RequestMethod.POST)
	public String save(@ModelAttribute("pub") Publisher publisher) {
		publisherdao.AddPublisher(publisher);
		return "redirect:/viewpublisher";// will redirect to viewpublisher request mapping
	}

	/* It provides list of publisher in model object */
	@RequestMapping("/viewpublisher")
	public String viewborrow(Model m) {
		List<Publisher> list = publisherdao.getPublisher();
		m.addAttribute("list", list);
		return "viewpublisher";
	}

	/*
	 * It displays object data into form for the given id. The @PathVariable puts
	 * URL data into variable.
	 */
	@RequestMapping(value = "/editpublisher/{id}")
	public String edit(@PathVariable int id, Model m) {
		Publisher publisher = publisherdao.getPublisherById(id);
		m.addAttribute("command", publisher);
		return "publishereditform";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editsavepublisher", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("publisher") Publisher publisher) {
		publisherdao.UpdatePublisher(publisher);
		return "redirect:/viewpublisher";
	}

	/* It deletes record for the given id in URL and redirects to /viewpublisher */
	@RequestMapping(value = "/deletepublisher/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		publisherdao.delete(id);
		return "redirect:/viewpublisher";
	}
}
