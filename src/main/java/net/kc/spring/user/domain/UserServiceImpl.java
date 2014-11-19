package net.kc.spring.user.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;

	@Override
	public Long createUser(User user) {
		return dao.createUser(user);
	}

	@Override
	public User getUser(Long id) {
		return dao.getUser(id);
	}

	@Override
	public List<User> findUsers(String username) {
		return dao.findUsers(username);
	}

}
