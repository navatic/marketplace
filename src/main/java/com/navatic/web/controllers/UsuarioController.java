package com.navatic.web.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.navatic.web.models.entity.Usuario;
import com.navatic.web.models.service.IUsuarioService;
import com.navatic.web.utils.PageRender;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page ,Model model) {
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/listar", usuarios);
		
		model.addAttribute("titulo", "Listado De Usuarios");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("page", pageRender);
		return "listar";	
	}
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo","Formulario de Usuario");
		return "form";	
	}
	
	@RequestMapping(value="/form", method = RequestMethod.POST)
	public String guardar(Usuario usuario, SessionStatus status) {
		usuarioService.save(usuario);
		status.setComplete();
		return "redirect:listar";	
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		Usuario usuario = null;
		if(id > 0) {
			usuario = usuarioService.findUsuarioById(id);
		} else {
			return "redirect:/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo","Editar Usuario");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Integer id, Map<String, Object> model) {
		if(id > 0) {
			usuarioService.delete(id);
		} 
		return "redirect:/listar";
	}
}
