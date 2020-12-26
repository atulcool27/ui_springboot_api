package com.rps.service;

import com.rps.dao.RaceUsers;

public interface RaceUsersService 
{
	public boolean insertNewUser(RaceUsers ruser);
	
	public boolean usernameExist(RaceUsers ruser);
	
	public boolean emailExist(RaceUsers ruser);
	
	public boolean phoneExist(RaceUsers ruser);

}
