package com.mss.useraddress;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;


@Service
public class UseraddressdetailsService{
	@Autowired
	NamedParameterJdbcTemplate namedparameterjdbctemplate;
	@Autowired
	JdbcTemplate jdbctemplate;

	public Map<String, Object> insertuseraddress(UseraddressPojoclass user_pojo) {
		Map<String, Object> Mapresponse = new HashMap<>();
		int userid = user_pojo.getUserid();
		String address = user_pojo.getAddress();
		String state = user_pojo.getState();
		int pincode = user_pojo.getPincode();

		try {
			String query = "INSERT INTO address (userid,address,state,pincode)VALUES(:Auserid,:Aaddress,:Astate,:Apincode)";
			SqlParameterSource response = new MapSqlParameterSource().addValue("Auserid", userid)
					.addValue("Aaddress", address).addValue("Astate", state).addValue("Apincode", pincode);

			int result = namedparameterjdbctemplate.update(query, response);
			if (result > 0) {
				Mapresponse.put("inserted", "sucessfully");
			} else {
				Mapresponse.put("oops!", "something went wrong please check it once");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;

	}

	public Map<String, Object> updateaddressdetails(UseraddressPojoclass user_pojo) {
		Map<String, Object> Mapresponse = new HashMap<>();

		String state = user_pojo.getState();

		int id = user_pojo.getId();

		try {
			String query = "UPDATE address SET state=:Ustate WHERE id=:Uid ";

			SqlParameterSource response = new MapSqlParameterSource().addValue("Ustate", state).addValue("Uid", id);
			int result = namedparameterjdbctemplate.update(query, response);

			if (result > 0) {
				Mapresponse.put("sucessfully", "updated");
			} else {
				Mapresponse.put("oops!", "please enter valid id ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

	public Map<String, Object> deleteaddressdetails(int id) {
		Map<String, Object> Mapresponse = new HashMap<>();

		try {
			String query = "DELETE FROM address WHERE id=:Uid";
			SqlParameterSource response = new MapSqlParameterSource().addValue("Uid", id);
			int result = namedparameterjdbctemplate.update(query, response);
			if (result > 0) {
				Mapresponse.put("sucessfully", "delected");
			} else {
				Mapresponse.put("oops!", "please check once");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

	public List<Map<String, Object>> selectsddressdetails(int id) {
		SqlParameterSource respone = new MapSqlParameterSource().addValue("Uid", id);
		String query = "SELECT * FROM address WHERE id=:Uid";
		return namedparameterjdbctemplate.queryForList(query, respone);

	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String,Object> retrivedata (){
		Map<String,Object> response=new HashMap<>();
		
		try {
			List<Map<String, Object>> lastList = new ArrayList<Map<String, Object>>();
			String query="SELECT userid,address,state,pincode,date FROM address ";
			List<Map<String,Object>>addressList=jdbctemplate.queryForList(query);
			for(Map<String,Object> userdata:addressList) {
				int userid=(Integer) userdata.get("userid");
				String address=(String) userdata.get("address");
				String state=(String)userdata.get("state");
				int pincode=(Integer)userdata.get("pincode");
				LocalDateTime date = (LocalDateTime) userdata.get("date");

				Map<String, Object> userMap = new HashMap<>();

				userMap.put("userid", userid);
				userMap.put("address", address);
				userMap.put("state", state);
				userMap.put("pincode", pincode);
				userMap.put("date", date);

			
				lastList.add(userMap);
				System.out.println(userid+""+ address +""+ state +""+ pincode +"" +date);

				}

		response.put("useraddresslist", lastList);

				} catch (Exception ex) {
				ex.printStackTrace();

			}
		return response;
	}
}

	
	
			
			
		
	
	
	
	
	
	
	
	
	

