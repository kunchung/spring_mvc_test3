package net.kc.spring.user.domain;

public interface UserDao {
	public Long createUser(User user);

	public User getUser(Long id);
}
