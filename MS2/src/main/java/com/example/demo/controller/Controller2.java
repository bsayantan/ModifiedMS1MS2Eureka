package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DataInterface;
import com.example.demo.model.User;

@RestController
public class Controller2 {
	
	@Autowired
	DataInterface d;
	
	@RequestMapping("/second")
	public String home(@RequestBody User user)
	{
		
		System.out.println("save-----------"+user);
		d.save(user);
		//System.out.println(d.findAll());
		//d.findAll();
		return "hello";
	}
	@RequestMapping("/verification")
	public String home4(@RequestBody User user)
	{
         System.out.println(""+user.toString());
		Optional<User> optional =d.findById(user.getUserid());
		if(optional.isPresent()) {
		     if(optional.get().getPassword().equals(user.getPassword()))
		     {
		    	 String s;
		    	 s=optional.get().getUserid();
			  return "Welcome "+s+ " you have successfully logged in and this is your dashboard!";
		     }
		    else {
		    
			  return "Invalid login!";
		    }
		}
		else {
		    return "Invalid login!";
		}	
		
		
	}
	

	
}
