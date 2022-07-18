package com.mss.userTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.mss.user.UserdetailsService;

@SpringBootTest
public class UserServiceTest {

	@Mock
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Mock
	JdbcTemplate jdbctemplate;
	@InjectMocks
	UserdetailsService userservice;
	@Test
	public void inserdata() {
		
	}

}
