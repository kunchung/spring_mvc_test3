package net.kc.spring.user.domain;

public interface UserService {

	public Long createUser(User user);

	public User getUser(Long id);
}
