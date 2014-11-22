package net.kc.spring.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.kc.spring.user.domain.User;
import net.kc.spring.user.domain.UserGroup;
import net.kc.spring.user.domain.UserGroupItem;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
//public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	private static final String mapperNs = "net.kc.spring.user.dao.UserMapper";
	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	//@Autowired
	//private JdbcTemplate template;

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private UserMapper mapper;

	@Override
	public Long createUser(User user) {
		//getJdbcTemplate();
		mapper.insertUser(user);
		return user.getId();
	}

	@Override
	public User getUser(Long userId) {
		return mapper.getUser(userId);
	}

	@Override
	public List<User> findUsers(String username) {
		// UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		return mapper.findUsers(username);
		// return sqlSession.selectList(mapperNs + ".findUsers");
	}

	@Override
	public List<User> getAllusers() {
		List<User> userList = sqlSession.selectList(mapperNs + ".getAllUsers");
		return userList;
		//return mapper.getAllUsers();
	}

	@Override
	public UserGroup getUserGroup(Long id) {
		UserGroup group = (UserGroup) sqlSession.selectOne(mapperNs + ".getUserGroup", id);
		logger.debug("group: " + group);
		List<UserGroupItem> itemList = group.getItemList();
		logger.debug("num users: " + itemList.size());
		for (UserGroupItem item : itemList) {
			logger.debug("groupItem: " + item);
			//logger.debug("userId: " + item.getUser().getId());
		}
		return group;
	}

	@Override
	public Long createUserGroup(UserGroup userGroup) {
		Long groupId = insertUserGroup(userGroup);
		logger.debug("groupId: " + groupId + ", userGroup: " + userGroup);
		for (UserGroupItem item : userGroup.getItemList()) {
			insertUserGroupItem1(groupId, item);
		}
		return groupId;
	}

	private Long insertUserGroup(UserGroup userGroup) {
		//sqlSession.insert(mapperNs + ".insertUserGroup", userGroup);
		mapper.insertUserGroup(userGroup);
		return userGroup.getId();
	}

	private void insertUserGroupItem1(Long groupId, UserGroupItem item) {
		item.setGroupId(groupId);
		sqlSession.insert(mapperNs + ".insertUserGroupItem", item);
	}

	@SuppressWarnings("unused")
	private void insertUserGroupItem2(Long groupId, UserGroupItem item) {
		Map<String, Object> r = new HashMap<String, Object>(3);
		r.put("groupId", groupId);
		r.put("userId", item.getUser().getId());
		sqlSession.insert(mapperNs + ".insertUserGroupItem2", r);
		item.setId((Long) r.get("id"));
		logger.debug("r: " + r);
	}

	/**
	 * Insert using mapper class. It does not always work for unknown reason.
	 */
	@SuppressWarnings("unused")
	private void insertUserGroupItem3(Long groupId, UserGroupItem item) {
		item.setGroupId(groupId);
		mapper.insertUserGroupItem3(item);
	}

	@Override
	public List<UserGroup> getAllUserGroups() {
		//List<UserGroup> groupList = sqlSession.selectList(mapperNs + ".getAllUserGroups", "g.id, u.id");
		List<UserGroup> groupList = sqlSession.selectList(mapperNs + ".getAllUserGroups");
		return groupList;
	}
}
