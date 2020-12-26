package com.rps.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rps.dao.MenuBar;
import com.rps.repo.MenuBarRepo;
import com.rps.service.MenuBarService;

@Service
public class MenuBarServiceImpl implements MenuBarService
{
	@Autowired
	MenuBarRepo mbrepo;

	@Override
	public List<MenuBar> getAllMenuItems() {
		
		return mbrepo.findAll();
	}

	@Override
	public String insertMenuItem(MenuBar mbaritem) {

		MenuBar msaved = mbrepo.save(mbaritem);
		return msaved.toString();
	}

	@Override
	public List<MenuBar> getValidMenuItems(String role) {
		
		return mbrepo.findByRole(role);
		
	}

}
