package com.mss.accountuser;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountuserController {
	@Autowired
	AccountuserService accountservice;

	@PostMapping("/accountuser")
	public Map<String, Object> insertAccountuserdetails(@RequestBody Accountuserbeanclass accountspojo) {
return accountservice.insertAccountdetails(accountspojo);
	}
}
