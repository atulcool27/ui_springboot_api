package com.rps.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rps.dao.RaceUsers;
import com.rps.repo.RaceUsersRepo;
import com.rps.service.RaceUsersService;


@Service
public class RaceUsersServiceImpl implements RaceUsersService 
{
	@Autowired
	RaceUsersRepo ruserRepo;
	

	@Override
	public boolean insertNewUser(RaceUsers ruser) {
		
		ruser.setPassword((new BCryptPasswordEncoder()).encode(ruser.getPassword()));
		
		if(ruserRepo.findByUsernameOrEmailOrPhone(ruser.getUsername(), ruser.getEmail(), ruser.getPhone()).size() == 0)
		{
			System.out.println("Before Saving  : "+ruser.toString());
			ruserRepo.save(ruser);
			return true;
		}
		
		return false;
	}


	@Override
	public boolean usernameExist(RaceUsers ruser) {
		
		if(ruserRepo.findByUsername(ruser.getUsername()).size() > 0 )
		{
			return true;
		}
		
		return false;
	}


	@Override
	public boolean emailExist(RaceUsers ruser) {
		if(ruserRepo.findByEmail(ruser.getEmail()).size() > 0 )
		{
			return true;
		}
		return false;
	}


	@Override
	public boolean phoneExist(RaceUsers ruser) {
		if(ruserRepo.findByPhone(ruser.getPhone()).size() > 0 )
		{
			return true;
		}
		return false;
	}
	
	
	
	
	
	

}
