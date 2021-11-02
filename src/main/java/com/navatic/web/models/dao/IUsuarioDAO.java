package com.navatic.web.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navatic.web.models.entity.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	public Usuario findUsuarioByUsername(String username);
}
