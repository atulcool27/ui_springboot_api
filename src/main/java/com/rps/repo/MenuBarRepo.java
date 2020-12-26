package com.rps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.dao.MenuBar;

public interface MenuBarRepo extends JpaRepository<MenuBar, Integer> 
{

	public List<MenuBar> findByRole(String role);
	

}
