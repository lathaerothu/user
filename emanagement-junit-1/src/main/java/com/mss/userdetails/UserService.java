package com.mss.userdetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public User1 insertUser(User1 user) {
		return repository.save(user);
	}

	public List<User1> getUser() {
		return repository.findAll();
	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}
}
