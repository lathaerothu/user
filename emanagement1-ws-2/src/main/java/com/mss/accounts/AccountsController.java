package com.mss.accounts;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {
	@Autowired
	AccountsService accountservice;

	@PostMapping("/account")
	public Map<String, Object> insertAccountdetails(@RequestBody Accountsbeanclass accountpojo) {
		return accountservice.insertAccountdetails(accountpojo);
	}
/*
	@GetMapping("/account/{accountid}")
	public Map<String, Object> getingDetails(@PathVariable int accountid) {
		return (Map<String, Object>) accountservice.getingDetails(accountid);
	}
*/
}
