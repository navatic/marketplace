package com.navatic.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@GetMapping({"/","/index","/home"})
	public String listar(Model model) {
		model.addAttribute("titulo", "Pagina De Inicio");
		
		
		return "index";
		
	}
	
}
