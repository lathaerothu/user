package com.mss.userdetailstest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mss.userdetails.User1;
import com.mss.userdetails.UserRepository;
import com.mss.userdetails.UserService;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserService service;
	@MockBean
	UserRepository repository;

	@Test
	public void getUserData() {
		when(repository.findAll()).thenReturn(Stream.of(new User1(1, "madhu")).collect(Collectors.toList()));
		assertEquals(1, service.getUser().size());
	}

	@Test
	public void insertUserData() {
		User1 user = new User1(2, "naveen");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, service.insertUser(user));
	}

	@Test
	public void deleteUserData() {
		User1 user = new User1(2, "naveen");
		service.deleteUser(user.getId());
		verify(repository, times(1)).deleteById(user.getId());
	}

}
