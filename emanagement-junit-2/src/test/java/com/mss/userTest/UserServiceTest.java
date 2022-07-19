package com.mss.userTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mss.user.UserdetailsService;
import com.mss.user.Userdetailsbeanclass;

@SpringBootTest
public class UserServiceTest {
	@InjectMocks
	UserdetailsService userservice;
	@Mock
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Mock
	JdbcTemplate jdbctemplate;

	@Test
	public void insertdata() {
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class)))
				.thenReturn(1);
		Map<String, Object> result = userservice.insertUserdetails(userinsertdata());
		assertEquals("inserted", result.get("sucessfully"));
	}
	@Test
	public void insertdata1() {
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class)))
				.thenReturn(0);
		Map<String, Object> result = userservice.insertUserdetails(userinsertdata());
		assertEquals("enter valid data", result.get("message"));
	}
/*	@Test
	public void insertUserException()
	{
	Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenThrow(NullPointerException.class);
	Map<String, Object> insertData = userservice.insertUserdetails(userinsertdata());
	assertTrue(result.isEmpty());
	}
*/
	private Userdetailsbeanclass userinsertdata()
	{
		Userdetailsbeanclass	 user_pojo = new  Userdetailsbeanclass();

		user_pojo.setName("latha");
		user_pojo.setEmail("l@gmail.com");
		user_pojo.setPassword("767");
		user_pojo.setAge(123);
		return user_pojo;
	}
	@Test
	public void updatedata() {
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(1);
		Map<String,Object> result=userservice.updateUserdetails(userinsertdata());
		assertEquals("updated", result.get("sucessfully"));
	}
	@Test
	public void updatedata1() {
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(0);
		Map<String,Object> result=userservice.updateUserdetails(userinsertdata());
		assertEquals("enter valid data",result.get("msg"));
	}
/*	@Test
	public void updateUserException () {
		Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenThrow(NullPointerException.class);
		Map<String, Object> insertData = userservice.insertUserdetails(userinsertdata());
		assertTrue(result.isEmpty());
		}	*/
	
	@Test
	public void deletedata() {
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any( MapSqlParameterSource.class))).thenReturn(1);
		Map<String,Object>result=userservice.deleteUserdetails(1);
		assertEquals("deleted",result.get ("sucessfully"));
		
	}
	@Test
	public void deletedata1() {
		Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),Mockito.any(MapSqlParameterSource.class))).thenReturn(0);
		Map<String,Object>result=userservice.deleteUserdetails(1);
		assertEquals("please enter valid id ", result.get("oops!"));
	}
/*	@Test
	public void updateUserException () {
		Mockito.when(jdbctemplate.update(Mockito.anyString(),Mockito.any(),Mockito.anyString(),Mockito.any())).thenThrow(NullPointerException.class);
		Map<String, Object> insertData = userservice.insertUserdetails(userinsertdata());
		assertTrue(result.isEmpty());
		}
		*/
	
	@Test
	public void selectdata() {
		Mockito.when(namedParameterJdbcTemplate.queryForList(Mockito.anyString(), Mockito.any(MapSqlParameterSource.class))).thenReturn(getDatainsert());
		List<Map<String, Object>> getDataEmployee =userservice.selectUserdetails(1);
	}
	public List<Map<String,Object>> getDatainsert()
	{
	List<Map<String,Object>> getData=new ArrayList<>();
	Map<String, Object> mapData= new HashMap<>();
	mapData.put("id", 1);
	mapData.put("name", "ABC");
	mapData.put("age", 24);
	getData.add(mapData);
	return getData;
	}
	}
	


