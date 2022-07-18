package com.mss.accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {
	@Autowired
	JdbcTemplate jdbctemplate;


	public Map<String,Object> insertAccountdetails(Accountsbeanclass accountpojo){
		int accountid = accountpojo.getAccountid();
		String accountname = accountpojo.getAccountname();
		String noofemployes=accountpojo.getNoofemployes();
	Map<String,Object> Mapresponse=new HashMap<>();
		try {
			String query = "insert into account values(?,?,?)";
			int response = jdbctemplate.update(query, accountid, accountname,noofemployes);
			if (response > 0) {
				Mapresponse.put("sucessfully", "inserted");
			} else {
				Mapresponse.put("oops!", "Please enter valid data ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}
	/*	
	public List<Map<String,Object>> getingDetails(int accountid)
	{
	List<Map<String, Object>> Mapresponse = new ArrayList<Map<String, Object>>();
	List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
	try {
	String selectquerry = "select accountuser.userid,user.name,accounts.accountname,accountuser.lkstatus from"
	+ "((accountuser inner join user on accountuser.userid=?)"
	+ " accounts inner join accountuser on accounts.id=accountuser.accountid)";

	datalist = jdbctemplate.queryForList(selectquerry,accountid);
	for (Map<String, Object> row : datalist) {
	Map<String, Object> datamap = new HashMap<String, Object>();
	datamap.put("User_id", row.get("userid"));
	datamap.put("Name", row.get("name"));
	datamap.put("Company", row.get("account_name"));
	datamap.put("Status", row.get("lk_status"));
	Mapresponse.add(datamap);
	}
	}catch (Exception e) {
	e.printStackTrace();

}
	return Mapresponse;
	}*/
}
