package net.kc.spring.user.service;

import java.util.List;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;

public interface UserService {

	public void saveUser(User user);
	
	public Long createUser(User user);

	public User getUser(Long id);

	public User getUser(String username);
	
	public List<User> getAllUsers();
	
	public Long createUserGroup(UserGroup userGroup);
	
	public UserGroup getUserGroup(Long id);
	
	public List<UserGroup> getAllUserGroups();
}
