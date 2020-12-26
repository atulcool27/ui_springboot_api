package com.rps.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.rps.dao.MenuBar;

public interface MenuBarService 
{
	
	public List<MenuBar> getAllMenuItems();

	public String insertMenuItem(MenuBar mbaritem);

	public List<MenuBar> getValidMenuItems(String role);

}
