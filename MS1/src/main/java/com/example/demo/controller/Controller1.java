package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.User;

@RestController
public class Controller1 {
	@Autowired
	private RestTemplate rest;
	
	@RequestMapping("/login")
	public ModelAndView home1()
	{
		ModelAndView  modelAndView = new ModelAndView(); 
		  modelAndView.setViewName("Login.html");
	      return modelAndView;
	}
	
	 @RequestMapping("/login/msg")
	 public String fun(User u1)
		{
			String s="fail";
			//System.out.println(u1.toString());
			s=rest.postForObject("http://MS2/verification", u1, String.class);
			return s;
		}

	@RequestMapping("/Index")
	public ModelAndView home()
	{
		ModelAndView  modelAndView = new ModelAndView(); 
		  modelAndView.setViewName("Index.html");
	      return modelAndView;
	}
	
	@RequestMapping("/Index/registration")
	public String signup(User user)
	{
		String temp=null;
		System.out.println(temp);
		System.out.println(user);
		try {
		temp=rest.postForObject("http://MS2/second", user, String.class);
		}
		catch (HttpStatusCodeException e) {
			// TODO: handle exception
			e.getMessage();
		}
		System.out.println(temp);
		return "Registration Successful!";
		
	}
	
	
	
	
	
	
	
	

}
