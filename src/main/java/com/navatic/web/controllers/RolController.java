package com.navatic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RolController {
	

	
	@RequestMapping(value="/listar2", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado De Roles");
		//model.addAttribute("roles", genericDAO.findAll());
		return "listar2";
		
	}
}
