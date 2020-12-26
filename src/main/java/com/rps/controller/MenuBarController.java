package com.rps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rps.dao.MenuBar;
import com.rps.service.MenuBarService;

@RestController
@RequestMapping("/mbar")
public class MenuBarController 
{
	
	@Autowired
	MenuBarService mbarserv;
	
	// Just a comment
	
	@RequestMapping("/list")
	public List<MenuBar> getList()
	{
		return mbarserv.getAllMenuItems();
		
	}
	
	
	@PostMapping("/create")
	public String createMenuItem(@RequestBody MenuBar mbaritem)
	{
		return mbarserv.insertMenuItem(mbaritem);
		
	}
	
	
	

}
