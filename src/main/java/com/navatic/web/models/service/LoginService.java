package com.navatic.web.models.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.navatic.web.models.dao.IUsuarioDAO;
import com.navatic.web.models.entity.Rol;
import com.navatic.web.models.entity.Usuario;

@Service("LoginService")
public class LoginService implements UserDetailsService{

	@Autowired
	private IUsuarioDAO usuarioDao;

	
	private Logger logger = LoggerFactory.getLogger(LoginService.class);


	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findUsuarioByUsername(username);
		
		if(usuario == null) {
			String msg = "El usuario: '" + username + "', no son correctas";
			logger.error(msg);
			throw new UsernameNotFoundException(msg);
		}
		
		List<GrantedAuthority> autorities = new ArrayList<GrantedAuthority>();
		
		for(Rol rol : usuario.getRoles()) {
			logger.info("Rol: " + rol.getRol());
			autorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		
		if(autorities.isEmpty()) {
			String msg = "El usuario: '" + username + "', no tiene roles asignados, contacte con el administrador del sistema";
			logger.error(msg);
			throw new UsernameNotFoundException(msg);
		}
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, autorities);
	}


}
