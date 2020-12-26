package com.rps.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rps.dao.RaceUsers;
import com.rps.repo.RaceUsersRepo;

@Service
public class MySecurityUserDetailsService implements UserDetailsService
{
	
	@Autowired
	RaceUsersRepo rurepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		List<RaceUsers> user = rurepo.findByUsername(username);
		
		if(user.size() == 0)
		{
			throw new UsernameNotFoundException("Wrong Username!");
			
			
		}
		
		return new MySecurityUserDetails(user.get(0));
	}

}
