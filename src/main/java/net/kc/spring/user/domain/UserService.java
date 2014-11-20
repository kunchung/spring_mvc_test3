package net.kc.spring.user.domain;

import java.util.List;

public interface UserService {

	public Long createUser(User user);

	public User getUser(Long id);

	public List<User> findUsers(String username);
	
	public List<User> getAllUsers();
	
	public Long createUserGroup(UserGroup userGroup);
	
	public UserGroup getUserGroup(Long id);
	
	public List<UserGroup> getAllUserGroups();
}
