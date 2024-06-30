package com.vgnit.medical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.vgnit.medical.dto.UserDto;
import com.vgnit.medical.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController
{
	@Autowired
	private UserService userService;

	@Autowired
	private UserDetailsService userDetailsService;

	// Load the form !!
	@GetMapping("/registration")
	public String getRegistrationPage(Model model)
	{
		UserDto dto = new UserDto();

		model.addAttribute("user", dto);
		return "register";
	}

	// Sign up/Registration !!
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model, HttpSession session) {
		boolean checkEmail = userService.checkEmail(userDto.getEmail());
		if (checkEmail)
		{
			session.setAttribute("msg", "This email is already exsits!");
		} 
		else 
		{
			userService.save(userDto);
			session.setAttribute("msg", "User registered successfully!");
		}

		return "redirect:/registration";
	}

	// Login !!
	@GetMapping("/login")
	public String login() 
	{
		return "/login";
	}

}
