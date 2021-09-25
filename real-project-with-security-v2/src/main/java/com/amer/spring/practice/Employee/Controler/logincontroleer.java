package com.amer.spring.practice.Employee.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class logincontroleer {


	@GetMapping("/showlogin")
	public String login()
	{
		return "view/login";
	}
	
	
	

	@GetMapping("/access-denied")
	public String accesdenied()
	{
		return "view/access-denied";
	}
	
	
	

}
