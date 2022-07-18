package com.mss.accountuser;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountuserService {
	@Autowired
	JdbcTemplate jdbctemplate;

	public Map<String, Object> insertAccountdetails(Accountuserbeanclass accountspojo) {
		int id = accountspojo.getId();
		int accountid = accountspojo.getAccountid();
		int userid = accountspojo.getUserid();
		String lkstatus = accountspojo.getLkstatus();

		Map<String, Object> Mapresponse = new HashMap<>();
		try 
		{
			String query = "insert into accountuser values(?,?,?,?)";

			int response = jdbctemplate.update(query, id, accountid, userid, lkstatus);
			if (response > 0) {
				Mapresponse.put("sucessfully", "inserted");
			}
			else 
			{
				Mapresponse.put("oops!", "Please enter valid data ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

}
