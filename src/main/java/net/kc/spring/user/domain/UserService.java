package net.kc.spring.user.domain;

import java.util.List;

public interface UserService {

	public Long createUser(User user);

	public User getUser(Long id);
	
	public List<User> findUsers(String username);
}
