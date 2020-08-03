package io.db.expo.service;

import io.db.expo.entity.User;

public interface UserService {
	
	 public void saveUser(User user);	 
	 
	 public User findByUsername(String username);	 
	 
	 public User findById(Long id);

	 public void addDefaultRoles();
	 
	
}
