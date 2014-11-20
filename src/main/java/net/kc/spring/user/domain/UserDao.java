package net.kc.spring.user.domain;

import java.util.List;

public interface UserDao {
	public Long createUser(User user);

	public User getUser(Long id);

	public List<User> findUsers(String username);

	public List<User> getAllusers();
	
	public Long createUserGroup(UserGroup userGroup);

	public UserGroup getUserGroup(Long id);
}
