package com.mss.useraddress;

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
public class UseraddressdetailsController {
	@Autowired
	UseraddressdetailsService user_service;
	
	@PostMapping("/address")
	public Map<String,Object> insertuseraddress (@RequestBody UseraddressPojoclass user_pojo){
		return user_service.insertuseraddress (user_pojo);
	}
	@PutMapping("/address")
	public Map<String,Object> updateaddressdetails (@RequestBody UseraddressPojoclass user_pojo){
		return user_service.updateaddressdetails (user_pojo);
	}
	@DeleteMapping("/address")
	public Map<String,Object> deleteaddressdetails (@RequestParam int id){
		return user_service.deleteaddressdetails (id);
	}
	@GetMapping("/address/{id}")
	public List<Map<String, Object>> selectsddressdetails (@PathVariable int id){
		return user_service.selectsddressdetails (id);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/address")
	public Map<String, Object> retrivedata (){
		return  user_service. retrivedata();
	
}

}
