package net.kc.spring.user.service;

import java.util.List;

import net.kc.spring.common.utils.TransactionTemplateUtils;
import net.kc.spring.user.dao.UserDaoImpl;
import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

//@Transactional
@Service
public class UserServiceImpl implements UserService {
	private boolean testRollback = true;

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDaoImpl dao;

	@Autowired
	private PlatformTransactionManager txManager;

	public UserDaoImpl getDao() {
		return dao;
	}

	public void setDao(UserDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public Long createUser(User user) {
		return createUser2(user);
	}

	private Long createUser1(User user) {
		Long userId = dao.createUser(user);
		if (testRollback) {
			throw new RuntimeException();
		}
		return userId;
	}

	/**
	 * Create User using TransactionTemplate.
	 */
	private Long createUser2(final User user) {
		TransactionTemplate template = TransactionTemplateUtils.getDefaultTransactionTemplate(txManager);
		return template.execute(new TransactionCallback<Long>() {

			@Override
			public Long doInTransaction(TransactionStatus status) {
				try {
					Long userId = dao.createUser(user);
					if (testRollback) {
						throw new RuntimeException();
					}
					return userId;
				} catch (Exception e) {
					//cause the transaction to rollback
					status.setRollbackOnly();
					user.setId(0L);
					return 0L;
				}
			}
		});
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
