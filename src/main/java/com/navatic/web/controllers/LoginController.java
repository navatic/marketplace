package com.navatic.web.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login")
	public String login(@RequestParam(value="error", required=false) String error, Model model, Principal principal) {
		
		if(principal != null) {
			return "redirect:/";
		}
		
		if(error != null) {
			model.addAttribute("error", "Error: Nombre de usuario o contraseña incorrecta, vuelva a intentarlo");
		}
		return "login";
	}
}
