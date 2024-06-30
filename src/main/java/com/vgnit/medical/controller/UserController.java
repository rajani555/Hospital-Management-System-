package com.vgnit.medical.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserDetailsService userDetailsService;
	
	// Return to USER DASHBOARD !!
	@GetMapping("/user-page")   // This "/user-page" @GetMapping name will be same as given in security configuration or CustomSuccessHandler class !! 
	public String userPage(Model model, Principal principal)
	{
		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", loadUserByUsername);
		
		return "user-dashboard";
	}
}
