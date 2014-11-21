package net.kc.spring.user.service;

import java.util.List;

import net.kc.spring.user.dao.UserDaoImpl;
import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Component
//@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl dao;

	public UserDaoImpl getDao() {
		return dao;
	}

	public void setDao(UserDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public Long createUser(User user) {
		Long userId = dao.createUser(user);
//		if (true) {
//			throw new RuntimeException();
//		}
		return userId;
	}

	@Override
	public User getUser(Long id) {
		return dao.getUser(id);
	}

	@Override
	public List<User> findUsers(String username) {
		return dao.findUsers(username);
	}

	@Override
	public List<User> getAllUsers() {
		return dao.getAllusers();
	}

	@Override
	public Long createUserGroup(UserGroup userGroup) {
		return dao.createUserGroup(userGroup);
	}

	@Override
	public UserGroup getUserGroup(Long id) {
		return dao.getUserGroup(id);
	}

	@Override
	public List<UserGroup> getAllUserGroups() {
		return dao.getAllUserGroups();
	}

}
