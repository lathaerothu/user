package com.mss.student.aop;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentdataService {
	@Autowired
	JdbcTemplate jdbc;

	public Map<String,Object>insertStudentdata(Studentdata st){
		int id=st.getId();
		String name=st.getName();
		Map<String,Object>mapresponse=new HashMap<>();
	try {
		String sql="insert into studentdata values(?,?)";
		int response=jdbc.update(sql,id,name);
		if(response>0) {
			mapresponse.put("sucessfully","inserted data");
		}
		else {
			mapresponse.put("oops!","please enter valid data");
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return mapresponse;
	}
		public Map<String,Object>updateStudentdata(Studentdata st){
			int id=st.getId();
			String name=st.getName();
			Map<String,Object>mapresponse=new HashMap<>();
		try {
			String sql="update studentdata set name=? where id=?";
			int response=jdbc.update(sql,name,id);
			if(response>0) {
				mapresponse.put("sucessfully","updated data");
			}
			else {
				mapresponse.put("oops!","please enter valid data");
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return mapresponse;
		}

		
	
		}

