package com.rps.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rps.dao.MenuBar;
import com.rps.dao.RaceUsers;
import com.rps.service.MenuBarService;
import com.rps.service.RaceUsersService;

@Controller
@RequestMapping("/app")
public class UIController 
{
	
	@Autowired
	RaceUsersService ruservice;
	
	@Autowired
	MenuBarService mbservice;
	
	@RequestMapping("/signup")
	public ModelAndView signUp()
	{
		ModelAndView mv = new ModelAndView("customer/Register");
		mv.addObject("myuser",new RaceUsers());
		return mv;
	}
	
	
	@RequestMapping("login")
	public String getLogin()
	{
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "customer/UserLogin.html";
        }
 
		return "customer/User_Dashboard.html";
	}
	
	
	@RequestMapping("/welcome")
	public ModelAndView welcomePage()
	{
		List<MenuBar> mymblist = mbservice.getValidMenuItems(getRole());
		
		//****************************************Creating a sample Map here ***************************************************
		
		Map<String,List<String>> myMap = new TreeMap<String,List<String>>();
		
		List<String> test = new ArrayList<String>();
		test.add("Pet Services");
		test.add("Home Services");
		myMap.put("Services", test);
		
		test = new ArrayList<String>();
		test.add("JAVA");
		test.add("C++");
		test.add("Kotlin");
		test.add("Spring");
		myMap.put("Languages", test);
		
		
		//*****************************************************************************************
		
		
		ModelAndView mv = new ModelAndView("customer/User_Dashboard");
		mv.addObject("mlist", mymblist);
		mv.addObject("page_name","User Dashboard");
		mv.addObject("myMap",myMap);
		
		return mv;
	}
	
	
	
	@RequestMapping(value = "/signup/register", method = RequestMethod.POST)
	public ModelAndView Register(@ModelAttribute(name = "myuser") RaceUsers ruser)
	{
		ModelAndView mv = new ModelAndView();
		List<String> msg = new ArrayList<String>();
		
		
		
		
		if(ruservice.usernameExist(ruser))
		{
			msg.add("Username already Exists.");
		}
		
		if(ruservice.emailExist(ruser))
		{
			msg.add("Email already Exists.");
		}
		
		if(ruservice.phoneExist(ruser))
		{
			msg.add("Phone number already Exists.");
		}
		
		if(ruser.getPhone().length()>10 || ruser.getPhone().length()<10) 
		{
			msg.add("Phone Number should be 10 digits.");
		}
		
		System.out.println("In UI Controller : "+ruser.toString());
		
		ruser.setRole("CUSTOMER");
		
		boolean result = false;
		
		if(msg.size()==0) 
		{
		result = ruservice.insertNewUser(ruser);
		}
		
		
		if(result) 
		{
			msg.add("Successfully Registered! go to Login.");
			mv.setViewName("customer/Register");
			mv.addObject("signup_success", true);
			mv.addObject("success_message", msg);
	    }
		else 
		{
			mv.setViewName("customer/Register");
			mv.addObject("signup_error", true);
			mv.addObject("error_message", msg);
			
		}
		return mv;
		
	}
	
	
	
	
	
	public String getRole()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		Set<String> roles = auth.getAuthorities().stream()
			     .map(r -> r.getAuthority()).collect(Collectors.toSet());
		
		String role = "";
		
		for(String s : roles)
		{
			role = s;
		}
		
		return role;
	}
	

}
