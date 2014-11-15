package net.kc.spring.user.domain;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Long createUser(User user) {
		sqlSession.insert("net.kc.spring.user.UserMapper.createUser", user);
		//Long id = 1L;
		Long id = sqlSession.selectOne("net.kc.spring.user.UserMapper.getNewId");
		user.setId(id);
		return user.getId();
	}

	@Override
	public User getUser(Long userId) {
		return (User) sqlSession.selectOne(
				"net.kc.spring.user.UserMapper.getUser", userId);
	}

}
