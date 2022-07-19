package com.mss.user;

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
public class UserdetailsService {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	JdbcTemplate jdbctemplate ;

	public Map<String, Object> insertUserdetails(Userdetailsbeanclass user_pojo) {
		Map<String, Object> Mapresponse = new HashMap<>();

		String name = user_pojo.getName();
		String email = user_pojo.getEmail();
		String password = user_pojo.getPassword();
		int age = user_pojo.getAge();

		try {
			String query = "INSERT INTO user (name,email,password,age)VALUES(:Uname,:Uemail,:Upassword,:Uage)";
			SqlParameterSource response = new MapSqlParameterSource().addValue("Uname", name).addValue("Uemail", email)
					.addValue("Upassword", password).addValue("Uage", age);

			int result = namedParameterJdbcTemplate.update(query, response);

			if (result > 0) {
				Mapresponse.put("sucessfully", "inserted");
			} else {
				Mapresponse.put("message", "enter valid data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

	public Map<String, Object> updateUserdetails(Userdetailsbeanclass user_pojo) {
		Map<String, Object> Mapresponse = new HashMap<>();

		String name = user_pojo.getName();

		int accountid = user_pojo.getAccountid();

		try {
			String query = "UPDATE user SET name=:Uname WHERE id=:Uid ";

			SqlParameterSource response = new MapSqlParameterSource().addValue("Uname", name).addValue("Uaccountid", accountid);
			int result = namedParameterJdbcTemplate.update(query, response);

			if (result > 0) {
				Mapresponse.put("sucessfully", "updated");
			} else {
				Mapresponse.put("msg", "enter valid data");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

	public Map<String, Object> deleteUserdetails(int accountid) {
		Map<String, Object> Mapresponse = new HashMap<>();

		try {
			String query = "DELETE FROM user WHERE accountid=:Uaccountid";

			SqlParameterSource response = new MapSqlParameterSource().addValue("Uaccountid", accountid);
			int result = namedParameterJdbcTemplate.update(query, response);

			if (result > 0) {
				Mapresponse.put("sucessfully", "deleted");
			} else {
				Mapresponse.put("oops!", "please enter valid id ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

	public List<Map<String, Object>> selectUserdetails(int accountid) {

		String query = "SELECT * FROM user where accountid=:Uaccountid";

		SqlParameterSource response = new MapSqlParameterSource().addValue("Uaccountid", accountid);
		return namedParameterJdbcTemplate.queryForList(query, response);
	}

	/*public Map<String, Object> retriveUserdetails() {
		Map<String, Object> response = new HashMap<>();

		try {
			List<Map<String, Object>> lastList = new ArrayList<Map<String, Object>>();
			String query = "SELECT id,name,email,password,age,date FROM user where age>=80";
			List<Map<String, Object>> addressList = jdbctemplate.queryForList(query);
			for (Map<String, Object> userdata : addressList) {
				int id = (Integer) userdata.get("id");
				String name = (String) userdata.get("name");
				String email = (String) userdata.get("email");
				int password = (Integer) userdata.get("password");
				int age = (Integer) userdata.get("age");
				LocalDateTime date = (LocalDateTime) userdata.get("date");

				Map<String, Object> userMap = new HashMap<>();

				userMap.put("id", id);
				userMap.put("name", name);
				userMap.put("email", email);
				userMap.put("password", password);
				userMap.put("age", age);
				userMap.put("date", date);

				lastList.add(userMap);
				System.out.println(id + "" + name + "" + email + "" + password + "" + age + " " + date);

			}

			response.put("useraddresslist", lastList);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return response;
	}*/

}
