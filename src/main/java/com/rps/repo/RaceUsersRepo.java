package com.rps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.dao.RaceUsers;


public interface RaceUsersRepo extends JpaRepository<RaceUsers, Integer> 
{
	
	public List<RaceUsers> findByUsername(String username);
	
	public List<RaceUsers> findByEmail(String email);
	
	public List<RaceUsers> findByPhone(String phone);
	
	public List<RaceUsers> findByUsernameAndPassword(String username, String password);
	
	public List<RaceUsers> findByUsernameOrEmailOrPhone(String username, String email, String phone);
	

}
