package net.kc.spring.user.dao;

import java.util.List;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;

public interface UserDao {
	public Long createUser(User user);

	public User getUser(Long id);

	public List<User> findUsers(String username);

	public List<User> getAllusers();
	
	public Long createUserGroup(UserGroup userGroup);

	public UserGroup getUserGroup(Long id);

	public List<UserGroup> getAllUserGroups();
}
