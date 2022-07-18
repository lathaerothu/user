package com.mss.employedetails;

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
public class EmployedetailsController {

	@Autowired
	EmployeedetailsService employedetailservice;

	@PostMapping("/employes")

	public Map<String, Object> insertEmployedetails(@RequestBody EmployeepojoclassDetails employeepojoclassDetails) {
		return employedetailservice.insertEmployedetails(employeepojoclassDetails);
	}

	@PutMapping("/employes")

	public Map<String, Object> updateEmployedetails(@RequestBody EmployeepojoclassDetails employeepojoclassDetails) {
		return employedetailservice.updateEmployedetails(employeepojoclassDetails);
	}

	@DeleteMapping("/employes") 
	public Map<String, Object> deleteEmployedetails(@RequestParam int id) {
		return employedetailservice.deleteEmployedetails(id);
	}

	@GetMapping("/employes/{name}")
	public List<Map<String, Object>> selectEmployedetails(@PathVariable String name, @RequestParam int id) {
		return employedetailservice.selectEmployedetails(name,id);
	}
	

	
}
