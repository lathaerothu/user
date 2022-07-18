package com.mss.employedetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeedetailsService {

	@Autowired
	JdbcTemplate jdbctemplate;

	// inserting data into employees table
	public Map<String, Object> insertEmployedetails(EmployeepojoclassDetails employeepojoclassDetails) {
		Map<String, Object> Mapresponse = new HashMap<>();
		int id = employeepojoclassDetails.getId();
		String name = employeepojoclassDetails.getName();

		try {
			String query = "insert into Employes values(?,?)";
			int response = jdbctemplate.update(query, id, name);
			if (response > 0) {
				Mapresponse.put("sucessfully", "inserted");
			} else {
				Mapresponse.put("oops!", "the result is error ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;
	}

	// updating data into employees table
	public Map<String, Object> updateEmployedetails(EmployeepojoclassDetails employeepojoclassDetails) {
		Map<String, Object> Mapresponse = new HashMap<>();
		int id = employeepojoclassDetails.getId();
		String name = employeepojoclassDetails.getName();

		try {
			String query = "update Employes set name=? where id=?";
			int response = jdbctemplate.update(query, name, id);
			if (response > 0) {
				Mapresponse.put("updated", "sucessfully");
			} else {
				Mapresponse.put("oops!", "enter the correct id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;

	}

	// delete data from employees table
	public Map<String, Object> deleteEmployedetails(int id) {
		Map<String, Object> Mapresponse = new HashMap<>();

		try {
			String query = "delete from Employes where id=?";
			int response = jdbctemplate.update(query, id);
			if (response > 0) {
				Mapresponse.put("deleted", "sucessfully");
			} else {
				Mapresponse.put("oops!", "enter the correct id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Mapresponse;

	}

	// selecting data from employees table based on name

	public List<Map<String, Object>> selectEmployedetails(String name, int id) {
		List<Map<String, Object>> data = new ArrayList<>();
		try {
			String query = "select *from Employes";
			data = jdbctemplate.queryForList(query, name, id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
}

/*
 * public List<Map<String, Object>> selectEmployedetails(String name, int id) {
 * List<Map<String, Object>> data = new ArrayList<>(); try { String query =
 * "select*from Employes where 1=1"; if (name != null) { query = query +
 * "and name='" + name + "'"; } if (id > 0) { query = query + "and id=" + id; }
 * } catch (Exception e) { e.printStackTrace();
 * 
 * } // String query="select *from employes where name=?"; // List<Map<String,
 * Object>> response = jdbctemplate.queryForList(query,name); // return
 * response; return data; }
 * 
 * }
 */
