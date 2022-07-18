 package com.example.display.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserdetailsController {

	@Autowired
	UserdetailsService user_service;

	@PostMapping("/user")
	public Map<String, Object> insertUserdetails(@RequestBody Userdetailsbeanclass user_pojo) {
		return user_service.insertUserdetails(user_pojo);
	}

	@PutMapping("/user")
	public Map<String, Object> updateUserdetails(@RequestBody Userdetailsbeanclass user_pojo) {
		return user_service.updateUserdetails(user_pojo);
	}

	@DeleteMapping("/user")//?id=2 & name="laj";
	public Map<String, Object> deleteUserdetails(@RequestParam int id) {
		return user_service.deleteUserdetails(id);
	}
	@GetMapping("/user/{id}")//    /10
	public List<Map<String,Object>> selectUserdetails(@PathVariable int id) {
		return user_service.selectUserdetails(id);
	}
/*	@GetMapping("/user")
	public Map<String,Object> retriveUserdetails() {
		return  user_service.retriveUserdetails();
	}*/

}
	

