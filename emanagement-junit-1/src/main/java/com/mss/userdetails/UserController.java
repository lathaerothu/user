package com.mss.userdetails;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	UserService service;
	@PostMapping("/user1")
	public User1 inserUser(@RequestBody User1  user) {
		return service.insertUser(user);
	}
	@GetMapping("/user1")
	public List<User1>getUser(){
		return service.getUser();
	}
	@DeleteMapping("/user1/{id}")
	public void deleteUser(@PathVariable int  id) {
		service.deleteUser(id);
		
	}
}
